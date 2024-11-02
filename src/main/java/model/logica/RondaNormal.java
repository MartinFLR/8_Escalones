package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaOpcion;

public class RondaNormal implements EstadoRonda {
    @Override
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes){
        //Aca va la logica para la ronda de preguntas normales
        //Le asigna Aciertos y/o Errores al participante segun corresponda.
        PreguntaOpcion preg;
        String resp;
        for (Participante par:participantes){
            for (int i = 0; i <2; i++) {
            preg=par.getPreguntasParticipante().getFirst();
            resp=par.getRespuestaParticipante();
            if (preg.getRespuestaCorrecta()==resp){
                par.setCantAciertos(1);
            }else {
                par.setCantErrores(1);
                }
            }
        }


    }

}//classbody