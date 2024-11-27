package controller;

import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;

import model.*;
import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
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
		listaTemas.removeIf(tema -> !esValidoTema(tema));

		this.vista.setVisible(true);
		this.escalon = new Escalon();
		Collections.shuffle((listaTemas));
		this.escalon.setTemas(listaTemas);
		int indice = 0;
		for(Tema t : listaTemas){
			System.out.println(t.getNombre()+ indice);
			indice++;
		}
		this.escalon.setTema();
		vista.getBtnJugar().addActionListener(e -> creaParticipantes());
	}
	
	private Boolean esValidoTema(Tema temas){
		int contOpcion = 0;
		int contAprox = 0;
		int total;
		for (PreguntaOpcion preguntaOpcion: temas.getPreguntasOp()) {
			contOpcion++;
		}
		for (PreguntaAproximacion preguntaAprox: temas.getPregsAproximacion()) {
			contAprox++;
		}
		total = contAprox + contOpcion;

        return total >= 18;

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
			participante.setImg((ImageIcon) this.vista.getImagenes().get(this.vista.getComboboxImg().get(i).getSelectedItem()) );
			escalon.agregaParticipante(participante);
		}
	
		escalon.repartirPreguntas();
		new ControladorJuego(this.escalon);
		vista.dispose();
	}

}
