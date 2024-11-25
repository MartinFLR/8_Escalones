package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaOpcion;
import model.Tema;

public class RondaFinal implements EstadoRonda {

    @Override
    public void actualizarDatos(Ronda ronda, List<Participante> participantes, Tema tema) {//ingresa el tema FINAL que contiene preguntas de todos los otros temas
       //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes

            for (Participante participante : participantes) {
                
                if (!participante.getPreguntasParticipante().isEmpty()){
                    for (PreguntaOpcion p: participante.getPreguntasParticipante()){
                    participante.getPreguntasParticipante().removeFirst();
    }} }
    for (int i = 0; i < 9; i++) {
        // Sacamos una pregunta una sola vez
        PreguntaOpcion pregunta = tema.sacarPreguntaOp();

        
    for (Participante participante : participantes) {
        
        // Asignamos esa misma pregunta a ambos participantes
        participante.setPreguntasParticipante(pregunta);
    
        // Para asegurarnos de que ambos participantes reciban las mismas preguntas
        
    }}
        System.out.println("cant de preguntas: "+ participantes.get(1).getPreguntas().size());}
    
    }