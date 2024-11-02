import java.util.List;

import model.ABM.ParticipantesABM;
import model.ABM.PreguntasABM;
import model.ABM.TemasABM;
import model.Participante;
import model.PreguntaOpciones;
import model.Tema;


public class Main {
  public static void main(String[] args) {
    PreguntasABM abmPreg = PreguntasABM.getInstance();
    TemasABM abmTemas = TemasABM.getInstance();
    ParticipantesABM abmPart = ParticipantesABM.getInstance();

    List<Participante> listaParticipantes = abmPart.buscarTodos();
    List<PreguntaOpciones> listaPreguntas = abmPreg.buscarTodos();
    List<Tema> listaTemas = abmTemas.buscarTodos();


    System.out.println("Lista de Participantes:");
    for (Participante participante : listaParticipantes) {
      System.out.println(participante.getNombre()+", "+participante.getEdad());
    }

    System.out.println("Lista de Preguntas:");
    for (PreguntaOpciones pregunta : listaPreguntas) {

      System.out.println("Id pregunta "+pregunta.getId() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    }


    System.out.println("Lista de Temas:");
    for (Tema tema : listaTemas) {
      System.out.println(tema.getNombre()+", Id: "+ tema.getId());
    }


  }}


