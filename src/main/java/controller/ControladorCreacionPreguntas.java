package controller;

import view.VistaCreacionPreguntas;

public class ControladorCreacionPreguntas {

	private VistaCreacionPreguntas vista;
	
	public ControladorCreacionPreguntas(){
		this.vista = new VistaCreacionPreguntas(this);
		this.vista.setVisible(true);
		this.botones();
	}
	
	public void botones() {
		this.vista.getBtnAñadir().addActionListener(e->{
			String pregunta = getVista().getTextRespuestaCorrecta().getText();
			String respuesta = getVista().getTextRespuestaCorrecta().getText();
			String incorrecta_1 = getVista().getTextIncorrecta_1().getText();
			String incorrecta_2 = getVista().getTextIncorrecta_2().getText();
			String incorrecta_3 = getVista().getTextIncorrecta_3().getText();
			
		});
		this.vista.getBtnCancelar().addActionListener(e->{this.vista.setVisible(false);});
	}

	public VistaCreacionPreguntas getVista() {
		return vista;
	}

	public void setVista(VistaCreacionPreguntas vista) {
		this.vista = vista;
	}
}
