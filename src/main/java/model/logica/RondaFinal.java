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
                }}
                
                for (int i=0;i<10;i++){//le asigna 20 preguntas a los participantes
                participante.setPreguntasParticipante(tema.sacarPreguntaOp());
                }
        }
    }
}