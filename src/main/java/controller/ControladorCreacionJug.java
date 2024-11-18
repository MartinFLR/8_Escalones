package controller;


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
		escalon.setTemas(listaTemas);
		escalon.setTema();
		vista.getBtnJugar().addActionListener(e -> creaParticipantes());
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
	private void creaParticipantes(){

		for (int i = 0; i < 9; i++) {
			Participante participante = new Participante(this.vista.getTxtJugador().get(i).getText());
			participante.setImg((ImageIcon) this.vista.getComboboxImg().get(i).getSelectedItem());
			escalon.agregaParticipante(participante);
			participante.setNombre("jugador " + i);
		}
		escalon.repartirPreguntas();
		new ControladorJuego(escalon);
	}
}
