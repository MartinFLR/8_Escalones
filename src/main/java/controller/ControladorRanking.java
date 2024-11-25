package controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Participante;
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

		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}


	@Override
	public void actionPerformed(ActionEvent e) {
	}
	
	public void rellenarTablas() {
		List<Participante> participantes = ParticipantesDAO.Ranking();
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

}
