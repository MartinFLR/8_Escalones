package model.logica;

import java.util.ArrayList;
import java.util.List;

import model.*;
import model.ABM.*;

import model.ABM.ParticipantesDAO;
import model.ABM.PreguntaAproximacionDAO;
import model.ABM.PreguntaOpcionDAO;
import model.ABM.TemasDAO;
import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;

public class Tests {
    @SuppressWarnings({ "unchecked" })//unchecked pq en pregOpcionDao y pregAproxDao uso list generico que devuelve un elemento generico
    public static void main(String[] args) {
        TemasDAO abmTemas = new TemasDAO();
        ParticipantesDAO abmPart = new ParticipantesDAO();
        //inserta participante y modifica, martin ya esta en la bdd
        //abmPart.insertar(new Participante("Martin"));
        //abmPart.modificarVecesGanadas("Martin",2);
        PreguntaAproximacionDAO abmPregAprox = new PreguntaAproximacionDAO();
        PreguntaOpcionDAO abmPregOpcion = new PreguntaOpcionDAO();

        List<Participante> listaParticipantes = abmPart.buscarTodos();

        List<Tema> listaTemas = abmTemas.buscarTodos();
        //preguntas por tipo y general, se puede usar la general directamente con addAll que agrega las dos listas en una, despues si quieren ver de un tipo hacen un if o switch
        List<PreguntaAproximacion> listaPreguntaAproximacion = abmPregAprox.buscarTodos();
        List<PreguntaOpcion> listaPreguntaOp = abmPregOpcion.buscarTodos();
        List<Preguntas> listaPreguntas = new ArrayList<>();
        List<Participante> top10 = ParticipantesDAO.Ranking();

        listaPreguntas.addAll(listaPreguntaAproximacion);
        listaPreguntas.addAll(listaPreguntaOp);

        AdminDAO adminDAO = new AdminDAO();
        Admin admin = new Admin("aldo","pancho");
        adminDAO.modificar(admin);

        Admin aldito = adminDAO.buscarAdmin();
        System.out.println(aldito.getNombre()+" "+aldito.getContrasenia());

        for (Tema tema : listaTemas) {
            System.out.println(tema.getId()+" "+tema.getNombre());
        }

        model.Tema tema = new Tema (listaPreguntaAproximacion, listaPreguntaOp, "Tema 1");
        Escalon escalon = new Escalon();
        escalon.setTemas(listaTemas);
        escalon.setTema();
        for (model.Participante participante : listaParticipantes) {
            //escalon.agregaParticipante(new model.Participante(participante.getNombre()));
        }

        for(Participante p : listaParticipantes){
            System.out.println("Participante: " + p.getNombre());
            System.out.println("Veces ganadas: " + p.getVecesGanadas());
        }

        System.out.println("Top 10 participantes: ");
        System.out.println("Nombre            Veces Ganadas");
        for (Participante participante : top10) {
            System.out.println(participante.getNombre()+ "       " + participante.getVecesGanadas());

        }



        // aca pueden probar cada uno y funcionan(con la bdv6)


        // System.out.println("preguntas aproximacion: ");
        // for (Preguntas preguntaAproximacion : listaPreguntaAproximacion) {
        //     preguntaAproximacion.imprimirPregunta();
        // }

        // System.out.println("Preguntas opciones: ");

        // for (Preguntas preguntaOpcion : listaPreguntaOp) {
        //     preguntaOpcion.imprimirPregunta();
        // }

        // System.out.println("Preguntas todas: ");
        // for (Preguntas preguntas : listaPreguntas) {
        //     preguntas.imprimirPregunta();
        // }

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
        PreguntaOpcion pregunta = tema.sacarPreguntaOp();
        pregunta.imprimirPregunta();

        //Verifica que las pregs sacadas no esten en la lista de pregs original
        if(!pregsAprox.contains(preguntaAprox)){
            System.out.println("\n[X] La pregunta de aproximacion fue eliminada correctamente");
        }
        if(!tema.getPreguntas().contains(pregunta)){
            System.out.println("[X] La pregunta fue eliminada correctamente");
        }
    }
    /*public static void testClaseEscalon(Tema tema,List<Participante> listaParticipantes,Escalon escalon){
        System.out.println("\nProbando clase Escalon\n");
        //Prueba repartir preguntas, suma errores a un participante y prubea la funcion de filtrar participantes
        escalon.setTema(tema);
        for (Participante participante : listaParticipantes) {
            escalon.agregaParticipante(//new Participante(participante.getNombre()));
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
    }*/
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
        //escalon.filtrarParticipantes();
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
