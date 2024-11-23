package controller;

import model.ABM.PreguntasDAO;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.ABM.PreguntaOpcionDAO;
import model.Respuesta;
import view.VistaCreacionPreguntas;
import view.VistaModPreguntas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import java.awt.*;


public class ControladorCreacionPreguntas{

    private VistaCreacionPreguntas vista;
    private Integer idTema;
    private Integer idPregunta;
    private String pregunta;
    private String respuesta;
    private String incorrecta_1;
    private String incorrecta_2;
    private String incorrecta_3;
    private PreguntaOpcionDAO preguntaOpcionDAO;
    private ControladorModPreguntas c;

    public ControladorCreacionPreguntas(Integer idTema, ControladorModPreguntas c) {
        this.vista = new VistaCreacionPreguntas(this);
        this.vista.setVisible(true);
        this.botones();
        this.idTema = idTema;
        System.out.println("Hola soy ControladorCreacionPreguntas, mi idTema es: "+ idTema);
        this.c = c;
    }
    public ControladorCreacionPreguntas( int idTema, Integer idPregunta, ControladorModPreguntas c) {
        this.vista = new VistaCreacionPreguntas(this);
        this.idPregunta = idPregunta;
        this.idTema = idTema;
        this.vista.setVisible(true);
        this.botones();
        System.out.println("Hola soy ControladorCreacionPreguntas, mi idTema es: "+ idTema+ "y mi idPregunta es: "+idPregunta);
        this.c = c;
    }


    public void botones() {
        this.vista.getBtnAñadir().addActionListener(e -> {
            pregunta = getVista().getTxetPregunta().getText();

            Respuesta respuestaCorrecta = new Respuesta(getVista().getTextRespuestaCorrecta().getText(), true);
            Respuesta respuestaFake1 = new Respuesta(getVista().getTextIncorrecta_1().getText(), false);
            Respuesta respuestaFake2 = new Respuesta(getVista().getTextIncorrecta_2().getText(), false);
            Respuesta respuestaFake3 = new Respuesta(getVista().getTextIncorrecta_3().getText(), false);

            List<Respuesta> listaRespuestas = new ArrayList<>();
            listaRespuestas.add(respuestaCorrecta);
            listaRespuestas.add(respuestaFake1);
            listaRespuestas.add(respuestaFake2);
            listaRespuestas.add(respuestaFake3);
            Collections.shuffle(listaRespuestas);

            PreguntaOpcion preguntaOpcion = new PreguntaOpcion(pregunta,idTema);

            PreguntasDAO preguntasDAO = new PreguntasDAO();

            if(idPregunta == null) {
                System.out.println(preguntaOpcion.getPregunta());
                preguntasDAO.insertar(preguntaOpcion,listaRespuestas);
            }else{
                System.out.println(preguntaOpcion.getPregunta());
                preguntasDAO.modificar(idPregunta,preguntaOpcion,listaRespuestas);
            }
            this.vista.dispose();
            c.getVista().actualizarTabla();
        });

        this.vista.getBtnCancelar().addActionListener(e -> {
            this.vista.setVisible(false);
        });


        this.vista.getBtnAñadirAproximacion().addActionListener(e -> {
            pregunta = getVista().getTextPregunta().getText();
            PreguntaAproximacion preguntaAproximacion = new PreguntaAproximacion(pregunta,idTema);

            PreguntasDAO preguntasDAO = new PreguntasDAO();
            Respuesta respuestaCorrecta = new Respuesta(getVista().getTextRespuestaAproximacion().getText(), true);
            List<Respuesta> listaRespuestas = new ArrayList<>();
            listaRespuestas.add(respuestaCorrecta);

            if(idPregunta == null) {
                System.out.println(preguntaAproximacion.getPregunta());
                preguntasDAO.insertar(preguntaAproximacion,listaRespuestas);
            }else{
                System.out.println(preguntaAproximacion.getPregunta());
                preguntasDAO.modificar(idPregunta,preguntaAproximacion,listaRespuestas);
                System.out.println("Este es mi idPregunta"+ idPregunta);
            }
            this.vista.dispose();
            c.getVista().actualizarTabla();
        });
        this.vista.getBtnVolverAproximacion().addActionListener(e->{
            this.vista.setVisible(false);
        });
    }

    public VistaCreacionPreguntas getVista() {
        return vista;
    }

    public void setVista(VistaCreacionPreguntas vista) {
        this.vista = vista;
    }

}