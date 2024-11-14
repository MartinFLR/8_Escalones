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
            preg=participante.getPreguntasParticipante().get(i);
            // resp=participante.getRespuestaParticipante();
            System.out.println("Participante: "+participante.getNombre());
            resp=this.getRespuestaPorTeclado(preg);
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
    //El metodo getRespuestaPorTeclado sirve para probar las rondas con la consola
    //Toma el caracter y usa un switch con getOpcionA, getOpcionB,etc
    private String getRespuestaPorTeclado(PreguntaOpcion pregunta) {
        // imprimirPregunta es un método abstracto de la clase Preguntas
        pregunta.imprimirPregunta();
        System.out.println("Ingrese la respuesta correcta: (a, b, c, d)");

        Scanner scanner = new Scanner(System.in);
        char respuesta = scanner.next().charAt(0);
        switch (respuesta) {
            case 'a' -> {
                return pregunta.getOpcionA();
            }
            case 'b' -> {
                return pregunta.getOpcionB();
            }
            case 'c' -> {
                return pregunta.getOpcionC();
            }
            case 'd' -> {
                return pregunta.getOpcionD();
            }
            default -> {
                System.out.println("Respuesta incorrecta, ingrese una respuesta válida");
                return getRespuestaPorTeclado(pregunta);
            }
        }
    }
}