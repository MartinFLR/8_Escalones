package model.logica;

import java.util.List;

import model.Participante;
import model.Tema;

public class RondaNormal implements EstadoRonda {
    @Override
    public void actualizarDatos(List<Participante> participantes,Tema tema){
        //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes
        for (Participante participante:participantes){
            for (int i = 0; i <2; i++) {
            //le da dos preguntas con opcion del tema que le pasa el escalon , las saca de tema para q no se repitan habria q chequear eso.
            participante.setPreguntasParticipante(tema.sacarPreguntaOp());
            }
        }
    }
}