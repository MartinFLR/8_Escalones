import java.util.List;

import model.Participante;
import model.ParticipanteABM;
import model.Pregunta;
import model.PreguntaABM;
import model.Tema;
import model.TemaABM;

public class Main {
  public static void main(String[] args) {
    PreguntaABM abm = PreguntaABM.getInstance();
    ParticipanteABM abmPart = ParticipanteABM.getInstance();
    TemaABM abmTema = TemaABM.getInstance();

    

    List<Pregunta> listaPreguntas = abm.listarPreguntas();
    List<Participante> listaParticipantes = abmPart.listarParticipantes();
    List<Tema> listaTemas = abmTema.listarTemas();

    System.out.println("Temas:");
    System.out.println();
    for (Tema tema : listaTemas) {
      System.out.println(tema.getId()+" "+tema.getNombre());
    }System.out.println();

    System.out.println("Participantes:");
    System.out.println();
    for (Participante participante : listaParticipantes) {
      System.out.println(participante.getId()+" "+participante.getNombre());
    }System.out.println();


    // Crear tema
    // Listar Temas
    //abmTema.listarTemas().forEach(t -> System.out.println(t.toFileString()));


    // Crear participantes
    //Participante participante1 = new Participante(1, "Aldo", 10, "aldo@aldaso.com.aldo");
    //abmPart.agregarParticipante(participante1);

    //System.out.println("Lista Participantes");
    //abmPart.listarParticipantes().forEach(p -> System.out.println(p.toFileString()));
  }
}

