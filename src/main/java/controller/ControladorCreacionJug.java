package controller;


import java.awt.Color;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import javax.swing.ImageIcon;

import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Tema;
import model.logica.Escalon;
import view.VistaCreacionJug;

public class ControladorCreacionJug {

	private final VistaCreacionJug vista;
	private final Escalon escalon;
	private HashMap<Integer, Color> colorEscalon = new HashMap<Integer, Color>();
	
	public ControladorCreacionJug () {
		this.vista = new VistaCreacionJug(this);
		PreguntaOpcionDAO abmPregOp = new PreguntaOpcionDAO();
		List<PreguntaOpcion> listaPreguntasOp = abmPregOp.buscarTodos();
		
		PreguntaAproximacionDAO abmPregAprox = new PreguntaAproximacionDAO();
		List<PreguntaAproximacion> listaPreguntaAproximacion = abmPregAprox.buscarTodos();
		
		TemasDAO abmTemas = new TemasDAO();
		List<Tema> listaTemas = abmTemas.buscarTodos();

		//Agrega las preguntas a los temas por id
		//Hay que usar esto cuando tengamos como minimo 18preg por tema 
		this.agregarPreguntasATemas(listaTemas, listaPreguntasOp, listaPreguntaAproximacion);
		this.vista.setVisible(true);
		this.escalon = new Escalon();
		Collections.shuffle((listaTemas));
		this.escalon.setTemas(listaTemas);
		System.out.println("temas: " + escalon.getTemas().size());
		this.escalon.setTema();
		vista.getBtnJugar().addActionListener(e -> creaParticipantes());
		
		colorEscalon.put(0, new Color(138, 43, 226));
		colorEscalon.put(1, new Color(0, 150, 75));
		colorEscalon.put(2, new Color(30, 144,255));
		colorEscalon.put(3, new Color(30, 144, 255));
		colorEscalon.put(4, new Color(255, 105, 180));
		colorEscalon.put(5, new Color(255, 140, 0));
		colorEscalon.put(6, new Color(255, 69, 0));
		colorEscalon.put(7, new Color(255, 215, 0));

	}

	private void agregarPreguntasATemas(List<Tema> listaTemas, List<PreguntaOpcion> listaPreguntasOp, List<PreguntaAproximacion> listaPreguntaAproximacion){
		for(Tema t : listaTemas){
			for(PreguntaOpcion pregunta : listaPreguntasOp){
				if(pregunta.getIdTema() == t.getId()){
					t.agregarPreguntaOp(pregunta);
				}
			}
			for(PreguntaAproximacion pregunta : listaPreguntaAproximacion){
				if(pregunta.getIdTema() == t.getId()){
					t.agregarPreguntasAproximacion(pregunta);
				}
			}
		}
	}
	private void creaParticipantes() {
		for (int i = 0; i < 9; i++) {
			String nombreJugador = this.vista.getTxtJugador().get(i).getText();
			// Si el texto es nulo o está vacío, asignar nombre predeterminado
			if (nombreJugador == null || nombreJugador.trim().isEmpty()) {
				nombreJugador = "jugador " + (i + 1);
			}
	
			Participante participante = new Participante(nombreJugador);
			participante.setImg((ImageIcon) this.vista.getComboboxImg().get(i).getSelectedItem());
			escalon.agregaParticipante(participante);
		}
	
		escalon.repartirPreguntas();
		new ControladorJuego(this.escalon);
	}

}
