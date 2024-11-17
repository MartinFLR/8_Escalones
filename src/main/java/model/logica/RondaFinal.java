package model.logica;

import java.util.List;

import model.Participante;
import model.Tema;

public class RondaFinal implements EstadoRonda {

    @Override
    public void actualizarDatos(Ronda ronda, List<Participante> participantes,Escalon esc) {//ingresa el tema FINAL que contiene preguntas de todos los otros temas
       //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes
            Tema tema= esc.getTema();
            for (Participante participante : participantes) {
                for (int i=0;i<10;i++){//le asigna 20 preguntas a los participantes
                participante.setPreguntasParticipante(tema.sacarPreguntaOp());
                }
        }
    }
}