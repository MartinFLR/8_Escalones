
import java.util.List;

import model.ABM.ParticipantesDAO;
import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Tema;


public class Main {
  public static void main(String[] args) {
    PreguntaOpcionDAO abmPreg = new PreguntaOpcionDAO();
    PreguntaAproximacionDAO abmPregAprox = new PreguntaAproximacionDAO();
    TemasDAO abmTemas = new TemasDAO();
    ParticipantesDAO abmPart = new ParticipantesDAO();

    List<Participante> listaParticipantes = abmPart.buscarTodos();
    List<PreguntaOpcion> listaPreguntasOpcion = abmPreg.buscarTodos();
    List<Tema> listaTemas = abmTemas.buscarTodos();
    List<PreguntaAproximacion> listaPreguntasAproximacion = abmPregAprox.buscarTodos();

    List<Preguntas> listaTodas = new ArrayList<>();
    listaTodas.addAll(listaPreguntasOpcion);
    listaTodas.addAll(listaPreguntasAproximacion);

    for (Preguntas todas : listaTodas) {
      System.out.println(todas.getId_pregunta() +" "+todas.getPregunta()+" "+ todas.getTipo_preg());
    }


    System.out.println("Lista de Participantes:");
    for (Participante participante : listaParticipantes) {
      System.out.println(participante.getNombre()+", ");
    }

    System.out.println("Lista de Preguntas:");
    for (Preguntas pregunta : listaPreguntasOpcion) {

      System.out.println("Id pregunta "+pregunta.getId_pregunta() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    }
  
    System.out.println("Lista de Preguntas de aproximacion:");
    for (Preguntas pregunta : listaPreguntasAproximacion) {

      System.out.println("Id pregunta "+pregunta.getId_pregunta() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    }


    System.out.println("Lista de Temas:");
    for (Tema tema : listaTemas) {
      System.out.println(tema.getNombre()+", Id: "+ tema.getId());
    }


    //ASI SE ELIMINAN LAS PREGUNTAS
    abmPreg.eliminar(4);
  }
}


