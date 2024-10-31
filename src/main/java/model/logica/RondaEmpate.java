package model.logica;

import java.util.List;



public class RondaEmpate implements EstadoRonda {
    @Override
    //deja al mejor participante. el que continua participando. puede cambiarse
    //habria que ver que hace con ese participante luego.
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        //Aca va la logica para las preguntas por aproximacion
        PregAproximacion preg;
        double respMasProxima=Double.MAX_VALUE;//el valor max
        double diferencia=0.0;
        Participante MejorParticipante;
            for (model.logica.Participante par: participantes){
                preg=par.getPregEmpate();
                diferencia=this.compara(preg.getRespuestaCorrecta(),par.getRespuestaParticipanteEmpate());
                if (diferencia<respMasProxima){//si la dif es menor a la resp mas proxima, esta pasa a ser la resp mas proxima!
                    respMasProxima=diferencia;
                    MejorParticipante=par;
                } else{
                    participantes.remove(par); //si no es el mejor participante lo saca.
                }
        }
    }

    public double compara(double respCorrecta, double respParticipante){//devuelve la diferencia entre la respuesta dada y la respuesta correcta
        return Math.abs(respCorrecta-respParticipante);
    }
}