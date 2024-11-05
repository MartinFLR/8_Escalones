package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaOpcion;

public class RondaFinal implements EstadoRonda {
    @Override
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        //Hay que ver como es la logica de la ronda final.
        //Hay que manejar los errores y aciertos de los participantes.
        //La base de datos deberá tener un tema llamado Final que junte todas las preguntas, para hacer preguntas de todos los temas.
        PreguntaOpcion preg;
        String resp;
        Integer cantPreguntasRestantes = 10;
        
        System.out.println("Ronda de preguntas Final");
         
        for (int i = 0; i < 10; i++){ 
            for (Participante par:participantes) {
            preg=par.getPreguntasParticipante().get(i);
            resp=par.getRespuestaParticipante();
            if (preg.getRespuestaCorrecta()==resp){
                par.setCantAciertos(1);
            }else {
                par.setCantErrores(1);
                }
            }
            
            cantPreguntasRestantes -= i;
            
            //Verifica si uno de los dos participantes ya no tiene posiblidad de remontar y termina la ronda final.
            if (participantes.getFirst().getCantAciertos() > participantes.getLast().getCantAciertos() + cantPreguntasRestantes
             || participantes.getLast().getCantAciertos() > participantes.getFirst().getCantAciertos() + cantPreguntasRestantes ) {
                break;
            }

        }

    }
    
}
