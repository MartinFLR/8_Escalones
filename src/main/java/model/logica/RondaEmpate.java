package model.logica;

import java.util.ArrayList;
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
        List<Participante> peoresParticipantes= new ArrayList();
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
            }else if(diferencia==respMasLejana){//si dos participantes tienen la misma respuesta, la cual es la mas lejana se agregan a una lista de peores participantes y se llama a otra ronda empate entre los peores
                peoresParticipantes.add(participante);
                peoresParticipantes.add(peorParticipante);
                peorParticipante=null;//para que no se dispare el caso base
        }
        }

        participantes.clear(); // vacia la lista.
        if (peorParticipante != null) {
            participantes.add(peorParticipante); 
            // Agrega al peor participante para poder eliminarlo de la lista de aprticipantes en juego dsps.
        }
        if (!peoresParticipantes.isEmpty()){//si tiene 
            rondaDePreguntas(ronda, peoresParticipantes);
        }
        //Hay que contemplar el caso de que haya empate entre los participantes nuevamente
    }
}
