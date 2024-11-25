package controller;


import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Tema;
import model.ABM.TemasDAO;
import raven.toast.Notifications;
import view.VistaModPadre;
import view.VistaModCategoria;

public class ControladorModCategoria {

	protected VistaModPadre vista;
	protected TemasDAO temasDAO;
	
	public ControladorModCategoria() {
		this.vista = new VistaModCategoria(this);
		this.vista.setVisible(true);
		this.temasDAO = new TemasDAO();
		this.cargarTemasTablas();
		this.inicializarBotones();
	}

	
	public void cargarTemasTablas() {
		List<Tema> temas = getTemasDAO().obtenerTemasConCantidadPreguntas();
		getVista().getT().setRowCount(0);
		
		for (Tema tema : temas) {
			Object [] row = { tema.getId(), tema.getNombre(), tema.getCantidadPreguntas()};
			getVista().getT().addRow(row); 
		}
	}
	
	//TODOS LOS BOTONES 
	public void inicializarBotones() {
		
		vista.getTable().getSelectionModel().addListSelectionListener(e->{
			this.vista.getBtnEditar().setEnabled(true);
			this.vista.getBtnBorrar().setEnabled(true);	
		});

		vista.getTable().addMouseListener(new java.awt.event.MouseAdapter() {
			@Override
			public void mouseClicked(java.awt.event.MouseEvent e) {
				// Verificar si fue un doble clic
				if (e.getClickCount() == 2) {
					int filaSeleccionada = vista.getTable().getSelectedRow();
					if (filaSeleccionada != -1) {
						// Aquí puedes obtener el ID de la categoría
						try {
							int idCategoria = Integer.parseInt(vista.getTable().getValueAt(filaSeleccionada, 0).toString());
							System.out.println("Doble clic en la fila: " + filaSeleccionada + ", ID: " + idCategoria);

							// Acción para editar la categoría
							// En este caso, llamamos al método de editar categoría
							 new ControladorModPreguntas(idCategoria);
							 vista.setVisible(false);
							//controlador.setId_pregunta(idCategoria);

							System.out.println("hola");
						} catch (NumberFormatException ex) {
							Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Error al convertir el ID de la categoría a un número");
							Notifications.getInstance().setJFrame(vista);
						}
					}
				}
			}
		});
		
		vista.getBtnBorrar().addActionListener(e ->{
			JDialog dialogoEliminar = new JDialog();
			dialogoEliminar.setSize(300, 150);
			dialogoEliminar.setLayout(new GridLayout(3, 1));
			dialogoEliminar.setLocationRelativeTo(null);
			dialogoEliminar.setModal(true);
			
			JLabel lblEliminar = new JLabel("¿Esta seguro de eliminar la categoria?");
			JButton btnAceptar = new JButton("Aceptar");
			JButton btnSalir = new JButton("Salir");

			btnAceptar.addActionListener(ev -> {
				int filaSeleccionada = this.vista.getTable().getSelectedRow();
				if (filaSeleccionada != -1) {
					try {
						int idCategoria = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
						System.out.println(idCategoria);

						temasDAO.eliminar(idCategoria);

						dialogoEliminar.dispose();
						Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Categoría eliminada exitosamente");
						Notifications.getInstance().setJFrame(vista);

						// Actualiza la tabla para reflejar los cambios
						cargarTemasTablas();
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

		vista.getBtnEditar().addActionListener(e -> {
			int filaSeleccionada = vista.getTable().getSelectedRow();
			if (filaSeleccionada != -1) {
				int idCategoria = Integer.parseInt(vista.getTable().getValueAt(filaSeleccionada, 0).toString());
				String nombreActual = vista.getTable().getValueAt(filaSeleccionada, 1).toString();

				JDialog dialogoEditar = new JDialog();
				dialogoEditar.setSize(400, 200);
				dialogoEditar.setLayout(new GridLayout(4, 1));
				dialogoEditar.setLocationRelativeTo(null);
				dialogoEditar.setModal(true);

				JLabel lblNombre = new JLabel("Editar nombre de la categoría:");
				JTextField txtNombre = new JTextField(nombreActual);
				JButton btnAceptar = new JButton("Aceptar");
				JButton btnCancelar = new JButton("Cancelar");

				btnAceptar.addActionListener(ev -> {
					String nuevoNombre = txtNombre.getText().trim();
					if (validarTexto(nuevoNombre)) {
						Tema tema = new Tema(nuevoNombre);
						temasDAO.modificar(idCategoria,tema);
						Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Categoría editada exitosamente");
						Notifications.getInstance().setJFrame(vista);
						cargarTemasTablas();
						dialogoEditar.dispose();
					} else {
						Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ingrese un nombre de categoría valida");
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
				Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Seleccione una categoría a editar");
				Notifications.getInstance().setJFrame(vista);
			}
		});
		
		vista.getBtnCrear().addActionListener(e ->{
		    JDialog dialogoCategoria = new JDialog();
		    dialogoCategoria.setTitle("Creacion de la categoria");
		    dialogoCategoria.setSize(300, 150);
		    dialogoCategoria.setLayout(new GridLayout(3, 1));
		    dialogoCategoria.setLocationRelativeTo(null);
		    dialogoCategoria.setModal(true);

		    JLabel lblCategoria = new JLabel("Ingrese la categoría:");
		    JTextField txtCategoria = new JTextField();
		    JButton btnAceptar = new JButton("Aceptar");

		    btnAceptar.addActionListener(ev -> {
		        String categoria = txtCategoria.getText();
		        if (validarTexto(categoria)) {
		            System.out.println("Categoría ingresada: " + categoria);
					Tema tema = new Tema(categoria);
					temasDAO.insertar(tema);
					Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Categoría creada exitosamente");
					Notifications.getInstance().setJFrame(vista);
		            dialogoCategoria.dispose(); 
		        } else {
		        	Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Ingrese un nombre de categoría valida");
		        	Notifications.getInstance().setJFrame(vista);
		        }
				cargarTemasTablas();
		    });
		    
		    dialogoCategoria.add(lblCategoria);
		    dialogoCategoria.add(txtCategoria);
		    dialogoCategoria.add(btnAceptar);
		    dialogoCategoria.setVisible(true);
			});
		
		vista.getBtnSalir().addActionListener(e -> {todasCategoriasCon20Preguntas();});
	}
	
	public void todasCategoriasCon20Preguntas() {
        DefaultTableModel modelo = vista.getT();
        boolean cumplen = true;

        for (int i = 0; i < modelo.getRowCount(); i++) {
            Object valor = modelo.getValueAt(i, 2); 
            int cantidadPreguntas;
            try {
                cantidadPreguntas = Integer.parseInt(valor.toString());
            } catch (NumberFormatException e) {
                cantidadPreguntas = 0; //
            }
            if (cantidadPreguntas < 20) {
				cumplen = false;
            } 
        } 
        
        if (cumplen) {
			vista.setVisible(false);
		} else {
			Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Todas la categoria deben tener 20 preguntas");
			Notifications.getInstance().setJFrame(vista);
		}
    }
	
	
	private boolean validarTexto(String texto) {
		return texto != null && !texto.isEmpty() && texto.matches("[a-zA-Z ]+");
	}

	
	public VistaModPadre getVista() {
		return vista;
	}

	public TemasDAO getTemasDAO() {
		return temasDAO;
	}
	
	
}

