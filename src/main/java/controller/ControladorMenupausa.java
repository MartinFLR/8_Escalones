package controller;


import view.VistaMenupausa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ReproductorPrincipal;


public class ControladorMenupausa implements ActionListener {

	private final VistaMenupausa vista;
	private ControladorJuego cj;
	
	public ControladorMenupausa (ControladorJuego cj) {
		this.vista = new VistaMenupausa(this);
		this.cj = cj;
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(vista.getBtnReanudar())) {
			this.vista.dispose();
		} else if (e.getSource().equals(vista.getBtnOpciones())) {
			new ControladorOpciones();
		} else if (e.getSource().equals(vista.getBtnSalirmenu())){
			this.vista.dispose();
			cj.getVista().dispose();
			new ControladorPrincipal();
		};

	}
	
}
