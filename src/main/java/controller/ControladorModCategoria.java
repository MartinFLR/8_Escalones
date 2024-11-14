package controller;


import java.awt.GridLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.Tema;
import model.ABM.TemasDAO;
import view.VistaModPadre;
import view.VistaMod;
import view.VistaModPreguntas;

public class ControladorModCategoria {

	protected VistaModPadre vista;
	protected TemasDAO temasDAO;
	
	public ControladorModCategoria() {
		this.vista = new VistaMod(this);
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
		
		vista.getBtnBorrar().addActionListener(e ->{
			JDialog dialogoEliminar = new JDialog();
			dialogoEliminar.setSize(300, 150);
			dialogoEliminar.setLayout(new GridLayout(3, 1));
			dialogoEliminar.setLocationRelativeTo(null);
			dialogoEliminar.setModal(true);
			
			JLabel lblEliminar = new JLabel("¿Esta seguro de eliminar la categoria?");
			JButton btnAceptar = new JButton("Aceptar");
			JButton btnSalir = new JButton("Salir");
			
			btnAceptar.addActionListener(ev->{
				dialogoEliminar.dispose();
	            JOptionPane.showMessageDialog(dialogoEliminar, "Categoria eliminada");
			});
			
			btnSalir.addActionListener(ev -> {
				dialogoEliminar.setVisible(false);
			});
			
			dialogoEliminar.add(lblEliminar);
			dialogoEliminar.add(btnAceptar);
			dialogoEliminar.add(btnSalir);
			dialogoEliminar.setVisible(true);
		});
		
		vista.getBtnEditar().addActionListener(e->{new VistaModPreguntas(this);
		this.vista.setVisible(false);
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
		            dialogoCategoria.dispose(); 
		        } else {
		            JOptionPane.showMessageDialog(dialogoCategoria, "Por favor, ingrese una categoría válida.");
		        }
		    });
		    
		    dialogoCategoria.add(lblCategoria);
		    dialogoCategoria.add(txtCategoria);
		    dialogoCategoria.add(btnAceptar);
		    dialogoCategoria.setVisible(true);
			});
		
		vista.getBtnSalir().addActionListener(e -> {vista.setVisible(false);});
		
		vista.getBtnBuscar().addActionListener(e ->{
			String texto = this.vista.getTextBuscador().getText();
			System.out.println(texto);
			new VistaModPreguntas(this);
		});
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

