package controller;


import java.util.List;

import model.Tema;
import view.VistaMod;
import model.ABM.TemasDAO;


public class ControladorMod {
	private TemasDAO temasDAO;

	private VistaMod vista;

	
	public ControladorMod() {
		this.vista = new VistaMod(this);
		this.vista.setVisible(true);
		this.cargarTemasEnTabla();

	}

	public void cargarTemasEnTabla() {
        List<Tema> temas = temasDAO.obtenerTemasConCantidadPreguntas();
        vista.actualizarTablaTemas(temas);
    }


	
	
}
