package controller;

import model.ABM.PreguntasDAO;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.ABM.PreguntaOpcionDAO;
import model.Respuesta;
import view.VistaCreacionPreguntas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.awt.*;


public class ControladorCreacionPreguntas {

	private VistaCreacionPreguntas vista;
	private String id;
	private String pregunta;
	private String respuesta;
	private String incorrecta_1;
	private String incorrecta_2;
	private String incorrecta_3;
	private PreguntaOpcionDAO preguntaOpcionDAO;

	public ControladorCreacionPreguntas(String id){
		this.vista = new VistaCreacionPreguntas(this);
		this.vista.setVisible(true);
		this.botones();
		this.id = id;
		
	}
	
	public void botones() {
		this.vista.getBtnAñadir().addActionListener(e->{
			pregunta = getVista().getTxetPregunta().getText();

			Respuesta respuestaCorrecta = new Respuesta(getVista().getTextRespuestaCorrecta().getText(),true);
			Respuesta respuestaFake1 = new Respuesta(getVista().getTextIncorrecta_1().getText(),false);
			Respuesta respuestaFake2 = new Respuesta(getVista().getTextIncorrecta_2().getText(),false);
			Respuesta respuestaFake3 = new Respuesta(getVista().getTextIncorrecta_3().getText(),false);

			List<Respuesta> listaRespuestas = new ArrayList<>();
			listaRespuestas.add(respuestaCorrecta);
			listaRespuestas.add(respuestaFake1);
			listaRespuestas.add(respuestaFake2);
			listaRespuestas.add(respuestaFake3);

			Collections.shuffle(listaRespuestas);

			int id_temaoriginal = Integer.parseInt(id);
			//necesitamos un get para saber el tipo de pregunta, pongo aproximacion de prueba nomas
			this.Añadirpregunta(pregunta,id_temaoriginal,"Aproximacion",listaRespuestas);
		});
		this.vista.getBtnCancelar().addActionListener(e->{this.vista.setVisible(false);});
	}

	public VistaCreacionPreguntas getVista() {
		return vista;
	}

	public void setVista(VistaCreacionPreguntas vista) {
		this.vista = vista;
	}

	public void Añadirpregunta(String pregunta, int id_tema, String tipopregunta, List<Respuesta> listaRespuestas){
		PreguntasDAO preguntasDAO = new PreguntasDAO();
		switch (tipopregunta){
			case("Opcion Multiple"):{
				PreguntaOpcion preguntaObjeto = new PreguntaOpcion(pregunta,id_tema);
				preguntasDAO.crearPregunta(preguntaObjeto,listaRespuestas);
			}
			case ("Aproximacion"):{
				PreguntaAproximacion preguntaObjeto = new PreguntaAproximacion(pregunta,id_tema);
				preguntasDAO.crearPregunta(preguntaObjeto,listaRespuestas);
			}

        }



	}

	




}
