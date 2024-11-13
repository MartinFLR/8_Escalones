package controller;


import java.util.List;

import javax.swing.table.DefaultTableModel;

import model.Tema;
import model.ABM.TemasDAO;
import view.VistaModPadre;
import view.VistaMod;
import view.VistaModCategoria;

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
		
		vista.getBtnBorrar().addActionListener(e ->{});
		
		vista.getBtnEditar().addActionListener(e->{new VistaModCategoria(this);
		this.vista.setVisible(false);
		});
		
		vista.getBtnCrear().addActionListener(e ->{
			/*
			int selectedRow = vista.getTable().getSelectedRow();
            String temaSeleccionado = (String) vista.getTable().getValueAt(selectedRow, 1);
			*/
			new ControladorModPreguntas("fadas");});
		
		vista.getBtnSalir().addActionListener(e -> {vista.setVisible(false);});
		
		vista.getBtnBuscar().addActionListener(e ->{
			String texto = this.vista.getTextBuscador().getText();
			System.out.println(texto);
			new VistaModCategoria(this);
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

