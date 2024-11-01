package model.logica;

import java.util.List;

import model.ParticipantesABM;
import model.Pregunta;
import model.PreguntasABM;
import model.TemasABM;

public class Tests {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PreguntasABM abmPreg = PreguntasABM.getInstance();
        TemasABM abmTemas = TemasABM.getInstance();
        ParticipantesABM abmPart = ParticipantesABM.getInstance();
        List<model.Participante> listaParticipantes = abmPart.buscarTodos();
        List<Pregunta> listaPreguntas = abmPreg.buscarTodos();
        List<model.Tema> listaTemas = abmTemas.buscarTodos();
        
        model.logica.Tema tema = new model.logica.Tema (null, listaPreguntas, "Tema 1");
        Escalon escalon = new Escalon();
        // Para que funcionen los tests tenemos que pasar la respuesta de String a char donde la usemos y en el ABM
        // testClaseTema(tema);
        // testClaseEscalon(tema, listaParticipantes, escalon);
        // Dentro de testClaseEscalon hay tests opcionales como: 
            // testEstadoRondaFinal
            // testEstadoRondaEmpate
    }
    // Tests
    public static void testClaseTema(Tema tema){
        System.out.println("\nProbando clase Tema\n");
        //Prueba si se eliminaron las preguntas y las devuelve en las variables pregunta y pregunta2
        //Hay que filtrar las preguntas por el id del tema y crear cada tema con sus preguntas
        System.out.println("\nProbando sacar 2 preguntas\n");
        Pregunta pregunta = tema.sacarPregunta();
        Pregunta pregunta2 = tema.sacarPregunta();
        imprimirPregunta(pregunta);
        imprimirPregunta(pregunta2);
        System.out.println("\nPrueba si se eliminaron las preguntas de la lista general\n");
        for(model.Pregunta preg : tema.getPreguntas()){
            imprimirPregunta(preg);
        }
    }
    public static void testClaseEscalon(Tema tema,List<model.Participante> listaParticipantes,Escalon escalon){
        System.out.println("\nProbando clase Escalon\n");
        //Prueba repartir preguntas, suma errores a un participante y prubea la funcion de filtrar participantes
        escalon.setTema(tema);
        //Hay que unir las dos clases participante que tenemos para ahorrarnos esto
        for (model.Participante participante : listaParticipantes) {
            model.logica.Participante participanteEscalon = new model.logica.Participante(participante.getNombre());
            escalon.agregaParticipante(participanteEscalon);
        }

        System.out.println("---------Datos originales---------");
        escalon.getParticipantes().get(0).setCantErrores(2);
        imprimirDatosEscalon(escalon);

        System.out.println("---------Reparto preguntas---------");
        escalon.repartirPreguntas();
        imprimirDatosEscalon(escalon);

        System.out.println("---------Filtro participante con 2 errores---------");
        escalon.filtrarParticipantes();
        imprimirDatosEscalon(escalon);
        //Pruebas opcionales
        // testEstadoRondaFinal(escalon);
        // testEstadoRondaEmpate(escalon);
    }
    public static void testEstadoRondaFinal(Escalon escalon){
        System.out.println("---------Prueba de cambio a ronda final---------");
        System.out.println(escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
        System.out.println("Subió al escalon: "+escalon.getEscalon());
        escalon.subeEscalon();
    }
    public static void testEstadoRondaEmpate(Escalon escalon){
        System.out.println("---------Prueba situacion de empate---------");
        escalon.getParticipantes().get(0).setCantErrores(2);
        escalon.getParticipantes().get(1).setCantErrores(2);
        escalon.filtrarParticipantes();
    }
    
    //Metodos para imprimir datos y probar los metodos
    public static void imprimirPregunta(Pregunta pregunta){
        System.out.println("Id pregunta "+pregunta.getId() +", "+pregunta.getPregunta()+", Respuesta Correcta: "+pregunta.getRespuestaCorrecta()+", Tema ID: "+ pregunta.getIdTema());
    } 
    public static void imprimirDatosEscalon(Escalon escalon){
        System.out.println("Escalon: "+escalon.getEscalon());
        for (model.logica.Participante participante : escalon.getParticipantes()) {
            imprimirDatosParticipante(participante);
        }
    }
    public static void imprimirDatosParticipante(model.logica.Participante participante){
        System.out.println("Participante: "+participante.getNombre());
        System.out.println("Cantidad de preguntas asignadas:" + participante.getPreguntasParticipante().size());
        System.out.println("Cantidad de errores: "+participante.getCantErrores());
        System.out.println("-----------");
    }
}
