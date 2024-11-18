package controller;


import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import model.Tema;
import model.ABM.TemasDAO;
import view.VistaModPadre;
import view.VistaModCategoria;
import view.VistaModPreguntas;

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
							//controlador.setId_pregunta(idCategoria);

							System.out.println("hola");
						} catch (NumberFormatException ex) {
							JOptionPane.showMessageDialog(vista, "Error al convertir el ID de la categoría a un número.", "Error", JOptionPane.ERROR_MESSAGE);
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
						JOptionPane.showMessageDialog(this.vista, "Categoria eliminada");

						// Actualiza la tabla para reflejar los cambios
						cargarTemasTablas();
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(this.vista, "Error al convertir el ID de la categoría a un número.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(this.vista, "Por favor, seleccione una fila para eliminar.");
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
					if (!nuevoNombre.isEmpty()) {
						Tema tema = new Tema(nuevoNombre);
						temasDAO.modificar(idCategoria,tema);
						JOptionPane.showMessageDialog(dialogoEditar, "Categoria editada!");
						cargarTemasTablas();
						dialogoEditar.dispose();
					} else {
						JOptionPane.showMessageDialog(dialogoEditar, "El nombre no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
					}
				});

				btnCancelar.addActionListener(ev -> dialogoEditar.dispose());

				dialogoEditar.add(lblNombre);
				dialogoEditar.add(txtNombre);
				dialogoEditar.add(btnAceptar);
				dialogoEditar.add(btnCancelar);
				dialogoEditar.setVisible(true);
			} else {
				JOptionPane.showMessageDialog(vista, "Seleccione una categoría para editar.", "Advertencia", JOptionPane.WARNING_MESSAGE);
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
		        if (!categoria.isEmpty()) {
		            System.out.println("Categoría ingresada: " + categoria);
					Tema tema = new Tema(categoria);
					temasDAO.insertar(tema);
					JOptionPane.showMessageDialog(dialogoCategoria, "Categoria creada!");
		            dialogoCategoria.dispose(); 
		        } else {
		            JOptionPane.showMessageDialog(dialogoCategoria, "Por favor, ingrese una categoría válida.");
		        }
				cargarTemasTablas();
		    });
		    
		    dialogoCategoria.add(lblCategoria);
		    dialogoCategoria.add(txtCategoria);
		    dialogoCategoria.add(btnAceptar);
		    dialogoCategoria.setVisible(true);
			});
		
		vista.getBtnSalir().addActionListener(e -> {vista.setVisible(false);});
		
		// vista.getBtnBuscar().addActionListener(e ->{
		// 	String texto = this.vista.getTextBuscador().getText();
		// 	System.out.println(texto);
		// 	ControladorModPreguntas controlador = new ControladorModPreguntas();

		// });
	}
	
	//TABLA --capaz sirva para abtraccion 
	/*
	public void tablaueva() { //aca pondria el las lista pregunta
		DefaultTableModel modeloNuevo = new DefaultTableModel();
		modeloNuevo.addColumn("ID");
		modeloNuevo.addColumn("Pregunta");
		this.vista.getTable().setModel(modeloNuevo);
	}
	*/ // posiblemente se tenga que usar
	
	public VistaModPadre getVista() {
		return vista;
	}

	public TemasDAO getTemasDAO() {
		return temasDAO;
	}
	
	
}

