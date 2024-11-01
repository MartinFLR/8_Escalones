package model.logica;

import java.util.List;

public class RondaEmpate implements EstadoRonda {
    @Override
        //deja al peor jugador en la lista AEliminar,dejando a los otros en juego.
        public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
            /*Aca va la logica para las preguntas por aproximacion*/
            PregAproximacion preg;
            double respMasLejana=Double.MAX_VALUE;//el valor max
            double diferencia=0.0;
            Participante peorParticipante = null;
                for (model.logica.Participante par: participantes){
                    preg=par.getPregEmpate();
                    diferencia=this.compara(preg.getRespuestaCorrecta(),par.getRespuestaParticipanteEmpate());
                    if (diferencia>respMasLejana){//si la dif es mayor a la resp Lejana , esta pasa a ser la resp Lejana! (mas Lejana a la correcta)
                        respMasLejana=diferencia;
                        peorParticipante=par;
                    }
                    }
                    participantes.clear(); // vacia la lista.
                    if (peorParticipante != null) {
                        participantes.add(peorParticipante); // Agrega al peor participante para poder eliminarlo de la lista de aprticipantes en juegodsps.
                    }
            }

    public double compara(double respCorrecta, double respParticipante){//devuelve la diferencia entre la respuesta dada y la respuesta correcta
        return Math.abs(respCorrecta-respParticipante);
    }


    
            
}
