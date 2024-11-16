package controller;

import view.VistaCreacionPreguntas;

public class ControladorCreacionPreguntas {

	private VistaCreacionPreguntas vista;
	private String pregunta;
	private String resCorrecta;
	private String incorrecta_1;
	private String incorrecta_2;
	private String incorrecta_3;
	private String resAproximacion;
	
	
	public ControladorCreacionPreguntas(){
		this.vista = new VistaCreacionPreguntas(this);
		this.vista.setVisible(true);
		this.botones();
	}
	
	public void botones() {
		this.vista.getBtnAñadir().addActionListener(e->{
			pregunta = getVista().getTxetPregunta().getText();
			resCorrecta= getVista().getTextRespuestaCorrecta().getText();
			incorrecta_1 = getVista().getTextIncorrecta_1().getText();
			incorrecta_2 = getVista().getTextIncorrecta_2().getText();
			incorrecta_3 = getVista().getTextIncorrecta_3().getText();
			this.vista.setVisible(false);
		});
		this.vista.getBtnCancelar().addActionListener(e->{
			this.vista.setVisible(false);
			
		});
		
		this.vista.getBtnAñadirAproximacion().addActionListener(e->{
			pregunta = getVista().getTextPregunta().getText();
			resAproximacion = getVista().getTextRespuestaAproximacion().getText();
			this.vista.setVisible(false);
		});
		
		this.vista.getBtnVolverAproximacion().addActionListener(e->{
			this.vista.setVisible(false);
		});
	}

	public VistaCreacionPreguntas getVista() {
		return vista;
	}

	public void setVista(VistaCreacionPreguntas vista) {
		this.vista = vista;
	}
}
