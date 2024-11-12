package controller;


import java.util.List;

import model.Tema;
import model.ABM.TemasDAO;
import view.VistaMod;

public class ControladorMod {

	private VistaMod vista;
	private TemasDAO temasDAO;
	
	public ControladorMod() {
		this.vista = new VistaMod(this);
		this.vista.setVisible(true);
		this.temasDAO = new TemasDAO();
		this.cargarTemasTablas();
	}

	
	public void cargarTemasTablas() {
	List<Tema> temas = getTemasDAO().obtenerTemasConCantidadPreguntas();
	getVista().getT().setRowCount(0);
	for (Tema tema : temas) {
		Object [] row = { tema.getId(), tema.getNombre(), tema.getCantidadPreguntas()};
		getVista().getT().addRow(row);
	}
	
	}
	

	
	
	
	public VistaMod getVista() {
		return vista;
	}

	public TemasDAO getTemasDAO() {
		return temasDAO;
	}
	
	
}
