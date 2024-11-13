package controller;


import java.util.List;

import model.Tema;
import model.ABM.TemasDAO;
import view.VistaMod;

public class ControladorMod {

	protected VistaMod vista;
	protected TemasDAO temasDAO;
	
	public ControladorMod() {
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
	
	public void inicializarBotones() {
		vista.getBtnBorrar().addActionListener(e ->{new ControladorModCategoria();
		});
		vista.getBtnEditar().addActionListener(e->{new ControladorModCategoria();});
		
		vista.getTable().getSelectionModel().addListSelectionListener(e->{ this.vista.getBtnCrear().setEnabled(true);});
		
		vista.getBtnCrear().addActionListener(e ->{
			int selectedRow = vista.getTable().getSelectedRow();
            String temaSeleccionado = (String) vista.getTable().getValueAt(selectedRow, 1);
			new ControladorModPreguntas(temaSeleccionado);});
		
		vista.getBtnSalir().addActionListener(e -> {vista.setVisible(false);});
	}
	
	
	public VistaMod getVista() {
		return vista;
	}

	public TemasDAO getTemasDAO() {
		return temasDAO;
	}
	
	
}
