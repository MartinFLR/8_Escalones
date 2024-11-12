package model.logica;

import java.util.List;
import java.util.Scanner;

import model.Participante;
import model.PreguntaOpcion;

public class RondaFinal implements EstadoRonda {
    @Override
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes) {
        //La base de datos deberá tener un tema llamado Final que junte todas las preguntas, para hacer preguntas de todos los temas.
        PreguntaOpcion preg;
        String resp;
        Integer cantPreguntasRestantes = 10;        
        for (int i = 0; i < 10; i++){ 
            System.out.println("Pregunta "+(i+1));
            //Esta linea se puede eliminar despues, es para mostrar la preg por consola
            participantes.getFirst().getPreguntasParticipante().get(i).imprimirPregunta();
            
            for (Participante participante:participantes) {
                preg=participante.getPreguntasParticipante().get(i);
                // Cuando integremos con igu sacamos el scanner
                // resp=participante.getRespuestaParticipante();
                System.out.println("Participante: "+participante.getNombre() + " Ingrese la respuesta correcta: (a, b, c, d)");
                resp = this.getRespuestaPorTeclado(preg);
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
                    if(participantes.getFirst().getCantAciertos() > participantes.getLast().getCantAciertos()){
                        System.out.println("Ganador: "+participantes.getFirst().getNombre());
                    }else{
                        System.out.println("Ganador: "+participantes.getLast().getNombre());
                    }
                    break;
            }
            // Verifica si ambos participantes tienen la misma cantAciertos y no hay pregs restantes
            System.out.println("Cant aciertos participante 1: "+participantes.getFirst().getCantAciertos());
            System.out.println("Cant aciertos participante 2: "+participantes.getLast().getCantAciertos());
            if (cantPreguntasRestantes == 0 
            && participantes.getFirst().getCantAciertos() == participantes.getLast().getCantAciertos()) {
                System.out.println("Pasa a ronda de empate");
                //Aca esta el problema donde no se manda la pregunta de desempate
                // En caso de la rondaNormal se manda desde Escalon
                // dentro de metodo filtrarParticipantes
                ronda.setRondaDeEmpate(participantes);
                return;
            }
        }
    }
    //El metodo getRespuestaPorTeclado sirve para probar las rondas con la consola
    //Toma el caracter y usa un switch con getOpcionA, getOpcionB,etc
    private String getRespuestaPorTeclado(PreguntaOpcion pregunta) {
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