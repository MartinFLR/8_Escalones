package controller;

import view.VistaModPreguntas;

public class ControladorModPreguntas {

	private VistaModPreguntas vista;
	
	public ControladorModPreguntas(String tema){
		this.vista = new VistaModPreguntas(this);
		this.vista.getLblTema().setText("Tema: "+ tema);
		this.vista.setVisible(true);
		this.botones();
	}
	
	public void botones() {
		this.vista.getBtnAñadir().addActionListener(e->{});
		this.vista.getBtnCancelar().addActionListener(e->{this.vista.setVisible(false);});
	}

	public VistaModPreguntas getVista() {
		return vista;
	}

	public void setVista(VistaModPreguntas vista) {
		this.vista = vista;
	}
}
