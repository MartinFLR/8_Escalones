package controller;


import java.util.List;
import java.util.Random;

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
		
		//Agrega a todos los temas todas las preguntas
		//Sirve solo para probar
		for(Tema t : listaTemas){
			t.setPreguntasOp(listaPreguntasOp);
			t.setPregsAproximacion(listaPreguntaAproximacion);
		}
		//Agrega las preguntas a los temas por id
		//Hay que usar esto cuando tengamos como minimo 18preg por tema 
		// this.agregarPreguntasATemas(listaTemas, listaPreguntasOp, listaPreguntaAproximacion);
		this.vista.setVisible(true);
		this.escalon = new Escalon();
		
		Random random = new Random();
		int index = random.nextInt(0, listaTemas.size());
		escalon.setTema(listaTemas.get(random.nextInt(index)));
		vista.getBtnJugar().addActionListener(e -> creaParticipantes());
	}

	public void agregarPreguntasATemas(List<Tema> listaTemas, List<PreguntaOpcion> listaPreguntasOp, List<PreguntaAproximacion> listaPreguntaAproximacion){
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
	public void creaParticipantes(){

		for (int i = 0; i < 9; i++) {
			Participante participante = new Participante(this.vista.getTxtJugador().get(i).getText());
			participante.setImg((ImageIcon) this.vista.getComboboxImg().get(i).getSelectedItem());
<<<<<<< HEAD
			participante.setNombre("Jugador "+i);
=======
>>>>>>> 9e44d539b6a4ac923dfd0c0455acf447d5619467
			escalon.agregaParticipante(participante);
		}
		escalon.repartirPreguntas();
		new ControladorJuego(escalon);
	}
	//Asigna un tema random a un escalon
	//se deberia llamar en cjto con subeEscalon
	public void asignarTema(List<Tema> temas){
		Random random = new Random();
		if (this.escalon.getEscalon()==8){//le asigna el tema final al ultimo escalon. (el que contiene preguntas de cada tema)
			//tiene que haber un tema final en la bd
			for (Tema t: temas){
				if(t.getNombre().equals("Final")){
					escalon.setTema(t);
				}
			}
			
		}else{
		int index = random.nextInt(0, temas.size()); 
		this.escalon.setTema(temas.remove(index));
	}}

	
	
}
