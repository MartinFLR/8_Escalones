package controller;

import model.PreguntaOpcion;
import model.ABM.PreguntaOpcionDAO;
import view.VistaCreacionPreguntas;


public class ControladorCreacionPreguntas {

	private VistaCreacionPreguntas vista;
	private String id;
	private String pregunta;
	private String respuesta;
	private String incorrecta_1;
	private String incorrecta_2;
	private String incorrecta_3;

	public ControladorCreacionPreguntas(String id){
		this.vista = new VistaCreacionPreguntas(this);
		this.vista.setVisible(true);
		this.botones();
		this.id = id;
		
	}
	
	public void botones() {
		this.vista.getBtnAñadir().addActionListener(e->{
			pregunta = getVista().getTxetPregunta().getText();
			respuesta = getVista().getTextRespuestaCorrecta().getText();
			incorrecta_1 = getVista().getTextIncorrecta_1().getText();
			incorrecta_2 = getVista().getTextIncorrecta_2().getText();
			incorrecta_3 = getVista().getTextIncorrecta_3().getText();
			int id_temaoriginal = Integer.parseInt(id);
			this.Añadirpregunta(pregunta,id_temaoriginal,1);
		});
		this.vista.getBtnCancelar().addActionListener(e->{this.vista.setVisible(false);});
	}

	public VistaCreacionPreguntas getVista() {
		return vista;
	}

	public void setVista(VistaCreacionPreguntas vista) {
		this.vista = vista;
	}

	public void Añadirpregunta(String pregunta, int id_tema, int tipopregunta){
		PreguntaOpcionDAO po = new PreguntaOpcionDAO();
		po.crearPregunta(pregunta,id_tema,tipopregunta);
	}

	




}
