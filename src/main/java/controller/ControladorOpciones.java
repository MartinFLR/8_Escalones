package controller;

import view.VistaOpciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorOpciones implements ActionListener{
	
	private VistaOpciones vista;
	
	public ControladorOpciones() {
		this.vista = new VistaOpciones(this);
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public VistaOpciones getVista () {
		return vista;
	}
	

}
