import java.util.ArrayList;
import java.util.List;

import model.*;


public class Main {
  public static void main(String[] args) {
    PreguntaOpcionDAO abmPreg = PreguntaOpcionDAO.getInstance();
    PreguntaAproximacionDAO abmPregAprox = PreguntaAproximacionDAO.getInstance();
    TemasABM abmTemas = TemasABM.getInstance();
    ParticipantesABM abmPart = ParticipantesABM.getInstance();

    List<Participante> listaParticipantes = abmPart.buscarTodos();
    List<PreguntaOpcion> listaPreguntas = abmPreg.buscarTodos();
    List<Tema> listaTemas = abmTemas.buscarTodos();
    List<PreguntaAproximacion> listaPreguntasAproximacion = abmPregAprox.buscarTodos();

    System.out.println("Lista de Participantes:");
    for (Participante participante : listaParticipantes) {
      System.out.println(participante.getNombre()+", "+participante.getEdad());
    }

    System.out.println("Lista de Preguntas con Opciones:");
    for (PreguntaOpcion pregunta : listaPreguntas) {

      System.out.println("Id pregunta "+pregunta.getId() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    }

    System.out.println("Lista de Preguntas de Aproximacion:");
    for (PreguntaAproximacion pregunta : listaPreguntasAproximacion) {

      System.out.println("Id pregunta "+pregunta.getId() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    }
  


    System.out.println("Lista de Temas:");
    for (Tema tema : listaTemas) {
      System.out.println(tema.getNombre()+", Id: "+ tema.getId());
    }


  }}


