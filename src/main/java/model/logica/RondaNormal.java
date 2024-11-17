package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaOpcion;

public class RondaNormal implements EstadoRonda {
    @Override
    public void actualizarDatos(Ronda ronda,List<Participante> participantes){
        //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes
        PreguntaOpcion preg;
        String resp;
        for (Participante participante:participantes){
            for (int i = 0; i <2; i++) {
            preg=participante.getPreguntasParticipante().get(i);
            //Si aca espera a que este la rta deberia funcionar todo 
            resp=participante.getRespuestaParticipante();
            if (preg.getRespuestaCorrecta().equals(resp)){
                System.out.println("Respuesta correcta");
                participante.sumaAcierto();
            }else {
                System.out.println("Respuesta incorrecta");
                participante.sumaError();
            }
        }
    }
}
}