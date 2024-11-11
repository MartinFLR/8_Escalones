package model.logica;

import java.util.List;

import model.ABM.ParticipantesDAO;
import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
import model.Participante;
import model.PreguntaOpcion;
public class TestJuego {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PreguntaOpcionDAO abmPreg = PreguntaOpcionDAO.getInstance();
        TemasDAO abmTemas = TemasDAO.getInstance();
        ParticipantesDAO abmPart = ParticipantesDAO.getInstance();
        PreguntaAproximacionDAO abmPregAprox = PreguntaAproximacionDAO.getInstance();
        List<Participante> listaParticipantes = abmPart.buscarTodos();
        List<PreguntaOpcion> listaPreguntas = abmPreg.buscarTodos();
        List<model.Tema> listaTemas = abmTemas.buscarTodos();
        List<model.PreguntaAproximacion> listaPreguntaAproximacion = abmPregAprox.buscarTodos();
        
        model.Tema tema = new model.Tema (listaPreguntaAproximacion, listaPreguntas, "Tema 1");
        Escalon escalon = new Escalon();
        escalon.setTema(tema);
        escalon.agregaParticipante(new Participante("Participante 1")); 
        escalon.agregaParticipante(new Participante("Participante 2")); 
        escalon.agregaParticipante(new Participante("Participante 3")); 
        // for (model.Participante participante : listaParticipantes) {
        //     escalon.agregaParticipante(new model.Participante(participante.getNombre()));
        // }
        
        System.out.println("Lista preguntas tema: " + tema.getPreguntas().size());
        System.out.println("Lista pregAprox " + listaPreguntaAproximacion.size());
        
        // Estado de la ronda
        Ronda estado = escalon.getEstadoDeRonda();

        //Inicia el juego
        escalon.repartirPreguntas();
        estado.rondaDePreguntas(escalon.getParticipantes());
        //Elimina un participante o cambia el estado de la ronda a empate
        escalon.filtrarParticipantes();
    }
}
