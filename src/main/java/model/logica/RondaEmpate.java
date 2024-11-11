package model.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Participante;
import model.PreguntaAproximacion;


public class RondaEmpate implements EstadoRonda {
    @Override
    //deja al peor jugador en la lista AEliminar,dejando a los otros en juego.
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        PreguntaAproximacion preg = participantes.get(0).getPregEmpate();
        Double respuestaCorrecta = Double.valueOf(preg.getRespuestaCorrecta());
        double respMasLejana = 0;
        double diferencia;
        Participante peorParticipante = null;
        List<Participante> empatados = new ArrayList<>();
        preg.imprimirPregunta();

        //recorre la lista de participantes y compara las respuestas de los participantes con la respuesta correcta
        Scanner scanner = new Scanner(System.in);
        for (model.Participante participante: participantes){
            
            // Double respuestaParticipante = participante.getRespuestaParticipanteEmpate();
            System.out.println("Respuesta del participante: " + participante.getNombre());	
            Double respuestaParticipante = scanner.nextDouble();
            
            //Calcula la diferencia entre la respuesta correcta y la respuesta del participante
            diferencia = Math.abs(respuestaCorrecta-respuestaParticipante);

            //Si la diferencia es mayor a la respuesta mas lejana, se guarda la diferencia y el participante
            if (diferencia>respMasLejana){
                respMasLejana = diferencia;
                peorParticipante = participante;
                empatados.clear();
                empatados.add(participante);
            }else if (diferencia==respMasLejana){
                empatados.add(participante);
            }
        }

        participantes.clear(); // vacia la lista.

        if(empatados.size()>1){
            participantes.addAll(empatados);
            System.out.println("Empate entre");
            for (Participante participante : empatados) {
                System.out.println(participante.getNombre());
            }
        } else if (peorParticipante != null) {
            // Agrega al peor participante para poder eliminarlo de la lista de aprticipantes en juego dsps.
            participantes.add(peorParticipante);
            System.out.println("Participante a eliminar"+peorParticipante.getNombre());
        }
        //Hay que contemplar el caso de que haya empate entre los participantes nuevamente
        scanner.close();
    }
}
