package controller;

import view.VistaOpciones;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.ReproductorPrincipal;
import model.Sonido;


public class ControladorOpciones implements ActionListener{
	
	private VistaOpciones vista;
	private ReproductorPrincipal r;
	private Sonido s;
	
	public ControladorOpciones() {
		this.vista = new VistaOpciones(this);
		this.r = ReproductorPrincipal.getInstance();
		this.s = Sonido.getInstance();
		this.vista.setVisible(true);
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
		this.volumen();
		this.sonido();
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
	
	public void sonido() {
		this.vista.getSliderSonido().addChangeListener(e->{s.setNumero(this.vista.getSliderSonido().getValue());});
	}
	

}
