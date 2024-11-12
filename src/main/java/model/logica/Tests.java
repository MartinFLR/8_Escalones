package model.logica;

import java.util.List;

import model.*;
import model.ABM.*;

public class Tests {
    @SuppressWarnings("unused")
    public static void main(String[] args) {
        PreguntaOpcionDAO abmPreg = new PreguntaOpcionDAO();
        TemasDAO abmTemas = new TemasDAO();
        ParticipantesDAO abmPart = new ParticipantesDAO();
        abmPart.insertar(new Participante("Martin"));
        abmPart.modificarVecesGanadas("Martin",2);
        PreguntaAproximacionDAO abmPregAprox = new PreguntaAproximacionDAO();
        PreguntaOpcionDAO abmPregOpcion = new PreguntaOpcionDAO();
        List<Participante> listaParticipantes = abmPart.buscarTodos();
        List<PreguntaOpcion> listaPreguntas = abmPreg.buscarTodos();
        List<model.Tema> listaTemas = abmTemas.buscarTodos();
        List<model.PreguntaAproximacion> listaPreguntaAproximacion = abmPregAprox.buscarTodos();
        List<model.PreguntaOpcion> listaPreguntaOp = abmPregOpcion.buscarTodos();

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin("aldo","pancho");
        adminDAO.modificar(admin);

        Admin aldito = adminDAO.buscarAdmin();
        System.out.println(aldito.getNombre()+" "+aldito.getContrasenia());

        for (Tema tema : listaTemas) {
            System.out.println(tema.getId()+" "+tema.getTema());
        }

        model.Tema tema = new model.Tema (listaPreguntaAproximacion, listaPreguntas, "Tema 1");
        Escalon escalon = new Escalon();
        escalon.setTema(tema);
        for (model.Participante participante : listaParticipantes) {
            escalon.agregaParticipante(new model.Participante(participante.getNombre()));
        }

        for(Participante p : listaParticipantes){
            System.out.println("Participante: " + p.getNombre());
            System.out.println("Veces ganadas: " + p.getVecesGanadas());
        }

        for (PreguntaAproximacion preguntaAproximacion : listaPreguntaAproximacion) {
            preguntaAproximacion.imprimirPregunta();
        }

        for (PreguntaOpcion preguntaOpcion : listaPreguntaOp) {
            preguntaOpcion.imprimirPregunta();
        }

        // listarPreguntasOpcion(listaPreguntas);        
        //  listarPreguntasAproximacion(listaPreguntaAproximacion);        
        
        // testClaseTema(tema);
        // testClaseEscalon(tema, listaParticipantes, escalon);
        // Dentro de testClaseEscalon hay tests opcionales como: 
            // testEstadoRondaFinal
            // testEstadoRondaEmpate
    }
    // Tests
    public static void listarPreguntasOpcion(List<PreguntaOpcion> listaPreguntas){
        System.out.println("\nListando preguntas de opcion multiple\n");
        for (PreguntaOpcion pregunta : listaPreguntas) {
            pregunta.imprimirPregunta();
        }
    }
    public static void listarPreguntasAproximacion(List<PreguntaAproximacion> listaPreguntas){
        System.out.println("\nListando preguntas de aproximacion\n");
        for (PreguntaAproximacion pregunta : listaPreguntas) {
            pregunta.imprimirPregunta();
        }
    }
    public static void testClaseTema(Tema tema){
        System.out.println("\nProbando sacar una pregunta de aproximacion\n");
        List<PreguntaAproximacion> pregsAprox=tema.getPregsAproximacion();
        PreguntaAproximacion preguntaAprox = tema.sacarPreguntaAprox();
        preguntaAprox.imprimirPregunta();
        
        System.out.println("\nProbando sacar una pregunta de opcion multiple\n");
        PreguntaOpcion pregunta = tema.sacarPregunta();
        pregunta.imprimirPregunta();

        //Verifica que las pregs sacadas no esten en la lista de pregs original
        if(!pregsAprox.contains(preguntaAprox)){
            System.out.println("\n[X] La pregunta de aproximacion fue eliminada correctamente");
        }
        if(!tema.getPreguntas().contains(pregunta)){
            System.out.println("[X] La pregunta fue eliminada correctamente");
        }
    }
    public static void testClaseEscalon(Tema tema,List<Participante> listaParticipantes,Escalon escalon){
        System.out.println("\nProbando clase Escalon\n");
        //Prueba repartir preguntas, suma errores a un participante y prubea la funcion de filtrar participantes
        escalon.setTema(tema);
        for (Participante participante : listaParticipantes) {
            escalon.agregaParticipante(new Participante(participante.getNombre()));
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
        System.out.println("Escalon: "+ escalon.getEscalon());
        for (int i = 1; i < 8; i++) {
            escalon.subeEscalon();
            System.out.println("Subió al escalon: " + escalon.getEscalon());
        }
    }
    public static void testEstadoRondaEmpate(Escalon escalon){
        System.out.println("---------Prueba situacion de empate---------");
        escalon.getParticipantes().get(0).setCantErrores(2);
        escalon.getParticipantes().get(1).setCantErrores(2);
        escalon.filtrarParticipantes();
    }
    
    //Metodos para imprimir datos y probar los metodos 
    public static void imprimirDatosEscalon(Escalon escalon){
        System.out.println("Escalon: "+escalon.getEscalon());
        for (Participante participante : escalon.getParticipantes()) {
            imprimirDatosParticipante(participante);
        }
    }
    public static void imprimirDatosParticipante(Participante participante){
        System.out.println("Participante: "+participante.getNombre());
        System.out.println("Cantidad de preguntas asignadas:" + participante.getPreguntasParticipante().size());
        System.out.println("Cantidad de errores: "+participante.getCantErrores());
        System.out.println("-----------");
    }
}
