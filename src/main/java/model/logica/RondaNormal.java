package model.logica;

import java.util.List;
import java.util.Scanner;

import model.Participante;
import model.PreguntaOpcion;

public class RondaNormal implements EstadoRonda {
    @Override
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes){
        PreguntaOpcion preg;
        String resp;
        for (Participante participante:participantes){
            for (int i = 0; i <2; i++) {
            preg=participante.getPreguntasParticipante().getFirst();
            // resp=participante.getRespuestaParticipante();
            resp=this.getRespuestaPorTeclado(preg);
            if (preg.getRespuestaCorrecta().equals(resp)){
                participante.sumaAcierto();
            }else {
                participante.sumaError();
            }
        }
    }
}
    //El metodo getRespuestaPorTeclado sirve para probar las rondas con la consola
    private String getRespuestaPorTeclado(PreguntaOpcion pregunta){
        //imprimirPregunta es un metodo abstracto de la clase Preguntas
        pregunta.imprimirPregunta();
        System.out.println("Ingrese la respuesta correcta:(a,b,c,d)");
        try (Scanner sc = new Scanner(System.in)) {
            String respuesta = sc.nextLine().toLowerCase();
            switch (respuesta) {
                case "a" -> {
                    respuesta = pregunta.getOpcionA();
                    break;
                }
                case "b" -> {
                    respuesta = pregunta.getOpcionB();
                    break;
                }
                case "c" -> {
                    respuesta = pregunta.getOpcionC();
                    break;
                }
                case "d" -> {
                    respuesta = pregunta.getOpcionD();
                    break;
                }
            }
            return respuesta;
        }
    }

}