package model.logica;

import java.util.List;

import controller.ControladorPrincipal;
import model.ABM.ParticipantesDAO;
import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
public class TestJuego {
    @SuppressWarnings({ "unused", "unchecked" })
    public static void main(String[] args) {
        PreguntaOpcionDAO abmPregOp = new PreguntaOpcionDAO();
        TemasDAO abmTemas = new TemasDAO();
        ParticipantesDAO abmPart = new ParticipantesDAO();
        PreguntaAproximacionDAO abmPregAprox = new PreguntaAproximacionDAO();
        List<Participante> listaParticipantes = abmPart.buscarTodos();
        List<PreguntaOpcion> listaPreguntasOp = abmPregOp.buscarTodos();
        List<model.Tema> listaTemas = abmTemas.buscarTodos();
        List<PreguntaAproximacion> listaPreguntaAproximacion = abmPregAprox.buscarTodos();
        
        model.Tema tema = new model.Tema (listaPreguntaAproximacion, listaPreguntasOp, "Tema 1");
        Escalon escalon = new Escalon();
        escalon.setTema(tema);
        //escalon.agregaParticipante(new Participante("Participante 1")); 
        //escalon.agregaParticipante(new Participante("Participante 2")); 
        //escalon.agregaParticipante(new Participante("Participante 3")); 
        // for (model.Participante participante : listaParticipantes) {
        //     escalon.agregaParticipante(new model.Participante(participante.getNombre()));
        // }

        // Estado de la ronda
        Ronda estado = escalon.getEstadoDeRonda();

        //Inicia el juego
        escalon.repartirPreguntas();
        estado.rondaDePreguntas(escalon.getParticipantes());

        //Elimina un participante o cambia el estado de la ronda a empate
        escalon.filtrarParticipantes();
        System.out.println("Participantes que suben escalon");
        for (Participante participante : escalon.getParticipantes()) {
            System.out.println(participante.getNombre());
        }

        // Salta al escalon 8 para probar la ronda final
        escalon.setEscalon(8);
        estado.rondaDePreguntas(escalon.getParticipantes());
        escalon.filtrarParticipantes();
        if(escalon.getParticipantes().isEmpty()){
            System.out.println("No se elimina el participante correctamente");
        }else{
            System.out.println("\nGanador: "+ escalon.getParticipantes().getFirst().getNombre());
        }
        // Para arreglar:
        // Funciona la ronda de empate en la final pero el perdedor no se esta eliminando
        // Capaz falta manejar los err en rondaEmpate
        ControladorPrincipal cont = new ControladorPrincipal();
        cont.setVista(null);
    }
}
