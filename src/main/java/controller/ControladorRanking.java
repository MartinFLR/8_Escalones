package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Participante;
import model.Tema;
import model.ABM.ManagerSession;
import model.ABM.ParticipantesDAO;
import raven.toast.Notifications;
import view.VistaRanking;

import javax.swing.*;

public class ControladorRanking implements ActionListener{

	private VistaRanking vista;
	private ParticipantesDAO participantesDAO;
	
	public ControladorRanking () {
		this.vista = new VistaRanking (this);
		this.vista.setVisible(true);
		this.participantesDAO = new ParticipantesDAO();
		if (!ManagerSession.estaLogueado()) {
            this.vista.getBtnEliminarRanking().setEnabled(false);
            this.vista.getBtnModificarRanking().setEnabled(false);
        }
		this.rellenarTablas();
		inicializarBotones();
	}

	private void inicializarBotones(){

		this.vista.getBtnEliminarRanking().addActionListener(e -> {
			JDialog dialogoEliminar = new JDialog();
			dialogoEliminar.setSize(300, 150);
			dialogoEliminar.setLayout(new GridLayout(3, 1));
			dialogoEliminar.setLocationRelativeTo(null);
			dialogoEliminar.setModal(true);

			JLabel lblEliminar = new JLabel("¿Esta seguro de eliminar el participante?");
			JButton btnAceptar = new JButton("Aceptar");
			JButton btnSalir = new JButton("Salir");

			btnAceptar.addActionListener(ev -> {
				int filaSeleccionada = this.vista.getTable().getSelectedRow();
				if (filaSeleccionada != -1) {
					try {
						int idParticipante = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
						System.out.println(idParticipante);

						participantesDAO.eliminar(idParticipante);

						dialogoEliminar.dispose();
						Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Categoría eliminada exitosamente");
						Notifications.getInstance().setJFrame(vista);

						// Actualiza la tabla para reflejar los cambios
						this.rellenarTablas();
					} catch (NumberFormatException ex) {
						Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al convertir el ID de la categoría a un número");
						Notifications.getInstance().setJFrame(vista);
					}
				} else {
					Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Seleccione una categoría a eliminar");
					Notifications.getInstance().setJFrame(vista);
				}
			});


			btnSalir.addActionListener(ev -> {
				dialogoEliminar.setVisible(false);
			});

			dialogoEliminar.add(lblEliminar);
			dialogoEliminar.add(btnAceptar);
			dialogoEliminar.add(btnSalir);
			dialogoEliminar.setVisible(true);
		});

		vista.getBtnModificarRanking().addActionListener(e -> {
			int filaSeleccionada = vista.getTable().getSelectedRow();
			if (filaSeleccionada != -1) {
				int idParticipante = Integer.parseInt(vista.getTable().getValueAt(filaSeleccionada, 0).toString());
				String nombreActual = vista.getTable().getValueAt(filaSeleccionada, 1).toString();

				JDialog dialogoEditar = new JDialog();
				dialogoEditar.setSize(400, 200);
				dialogoEditar.setLayout(new GridLayout(4, 1));
				dialogoEditar.setLocationRelativeTo(null);
				dialogoEditar.setModal(true);

				JLabel lblNombre = new JLabel("Editar nombre de el participante:");
				JTextField txtNombre = new JTextField(nombreActual);
				JButton btnAceptar = new JButton("Aceptar");
				JButton btnCancelar = new JButton("Cancelar");

				btnAceptar.addActionListener(ev -> {
					String nuevoNombre = txtNombre.getText().trim();
					if (validarTexto(nuevoNombre)) {
						Participante participante = new Participante(nuevoNombre);
						participantesDAO.modificar(idParticipante,participante);
						Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Categoría editada exitosamente");
						Notifications.getInstance().setJFrame(vista);
						this.rellenarTablas();
						dialogoEditar.dispose();
					} else {
						Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ingrese un nombre de Participante valido");
						Notifications.getInstance().setJFrame(vista);
					}
				});

				btnCancelar.addActionListener(ev -> dialogoEditar.dispose());

				dialogoEditar.add(lblNombre);
				dialogoEditar.add(txtNombre);
				dialogoEditar.add(btnAceptar);
				dialogoEditar.add(btnCancelar);
				dialogoEditar.setVisible(true);
			} else {
				Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Seleccione una Participante a editar");
				Notifications.getInstance().setJFrame(vista);
			}
		});


		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}

	


	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public void rellenarTablas() {
		List<Participante> participantes = participantesDAO.ranking();
		getVista().getDefTableModel().setRowCount(0);


		for (Participante participante : participantes) {
			Object [] row = {participante.getId(), participante.getNombre(), participante.getVecesGanadas()};
			getVista().getDefTableModel().addRow(row);
		}

		this.vista.getTable().setDefaultEditor(Object.class, null);
		this.vista.getTable().getTableHeader().setReorderingAllowed(false);
		this.vista.getTable().getTableHeader().setResizingAllowed(false);
		this.vista.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTable().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
		this.vista.getTable().getColumnModel().getColumn(1).setPreferredWidth(580);
	}

	public VistaRanking getVista() {
		return vista;
	}

	public void setVista(VistaRanking vista) {
		this.vista = vista;
	}

	private boolean validarTexto(String texto) {
		return texto != null && !texto.isEmpty() && texto.matches("[a-zA-Z ]+");
	}

}
