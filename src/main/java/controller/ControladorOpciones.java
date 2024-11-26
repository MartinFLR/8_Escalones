package controller;

import view.VistaOpciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ReproductorPrincipal;


public class ControladorOpciones implements ActionListener{
	
	private VistaOpciones vista;
	private ReproductorPrincipal r;
	
	public ControladorOpciones(ReproductorPrincipal r) {
		this.vista = new VistaOpciones(this);
		this.r = r;
		this.vista.setVisible(true);
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
		this.volumen();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	
	public VistaOpciones getVista () {
		return vista;
	}
	
	public void volumen () {
		this.vista.getSliderMusica().addChangeListener(e->{r.setVolume(this.vista.getSliderMusica().getValue());});
	}
	
	

}
