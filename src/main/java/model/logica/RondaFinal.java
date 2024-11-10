package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaOpcion;

public class RondaFinal implements EstadoRonda {
    @Override
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        //La base de datos deberá tener un tema llamado Final que junte todas las preguntas, para hacer preguntas de todos los temas.
        PreguntaOpcion preg;
        String resp;
        Integer cantPreguntasRestantes = 10;
        
        System.out.println("Ronda de preguntas Final");
        
        for (int i = 0; i < 10; i++){ 
            for (Participante participante:participantes) {
            preg=participante.getPreguntasParticipante().get(i);
            resp=participante.getRespuestaParticipante();
            if (preg.getRespuestaCorrecta().equals(resp)){
                participante.sumaAcierto();
            }else {
                participante.sumaError();
                }
            }
            
            cantPreguntasRestantes--;
            
            //Verifica si uno de los dos participantes ya no tiene posiblidad de remontar y termina la ronda final.
            if (participantes.getFirst().getCantAciertos() > participantes.getLast().getCantAciertos() + cantPreguntasRestantes
            || participantes.getLast().getCantAciertos() > participantes.getFirst().getCantAciertos() + cantPreguntasRestantes ) {
                // Capaz falta un estado para cuando termina el juego
                // Lo podemos manejar desde el controlador igual
                break;
            }
            // Verifica si ambos participantes tienen la misma cantAciertos y no hay pregs restantes
            if (cantPreguntasRestantes == 0 
            && participantes.getFirst().getCantAciertos() == participantes.getLast().getCantAciertos()) {
                System.out.println("Pasa a ronda de empate");
                ronda.setRondaDeEmpate(participantes);
                break;
            }
        }
    }
}