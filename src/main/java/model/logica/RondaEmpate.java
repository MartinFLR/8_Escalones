package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaAproximacion;


public class RondaEmpate implements EstadoRonda {
    @Override
    //deja al peor jugador en la lista AEliminar,dejando a los otros en juego.
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        PreguntaAproximacion preg;
        double respMasLejana =0;
        double diferencia;
        Participante peorParticipante = null;

        //recorre la lista de participantes y compara las respuestas de los participantes con la respuesta correcta
        for (model.Participante participante: participantes){
            preg = participante.getPregEmpate();
            Double respuestaCorrecta = Double.valueOf(preg.getRespuestaCorrecta());
            Double respuestaParticipante = participante.getRespuestaParticipanteEmpate();
            //Calcula la diferencia entre la respuesta correcta y la respuesta del participante
            diferencia = Math.abs(respuestaCorrecta-respuestaParticipante);

            //Si la diferencia es mayor a la respuesta mas lejana, se guarda la diferencia y el participante
            if (diferencia>respMasLejana){
                respMasLejana = diferencia;
                peorParticipante = participante;
            }
        }

        participantes.clear(); // vacia la lista.
        if (peorParticipante != null) {
            participantes.add(peorParticipante); 
            // Agrega al peor participante para poder eliminarlo de la lista de aprticipantes en juego dsps.
        }
        //Hay que contemplar el caso de que haya empate entre los participantes nuevamente
    }
}
