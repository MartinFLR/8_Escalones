package controller;

import view.VistaOpciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorOpciones implements ActionListener{
	
	private VistaOpciones vista;
	
	public ControladorOpciones() {
		this.vista = new VistaOpciones(this);
		this.vista.setVisible(true);
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public VistaOpciones getVista () {
		return vista;
	}
	

}
