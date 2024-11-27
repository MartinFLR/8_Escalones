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

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

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
        this.vista.setLocationRelativeTo(null);
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
        this.vista.setLocationRelativeTo(null);
        this.botones();
        System.out.println("Hola soy ControladorCreacionPreguntas, mi idTema es: "+ idTema+ "y mi idPregunta es: "+idPregunta);
        this.c = c;
        this.mostrarCampos();
    }


    public void botones() {
    	
    this.vista.getBtnAñadir().addActionListener(e -> {
        // Obtener texto de los campos
        pregunta = getVista().getTextPreguntaOpcion().getText();
        String respuestaCorrectaTexto = getVista().getTextRespuestaCorrecta().getText();
        String respuestaFake1Texto = getVista().getTextIncorrecta_1().getText();
        String respuestaFake2Texto = getVista().getTextIncorrecta_2().getText();
        String respuestaFake3Texto = getVista().getTextIncorrecta_3().getText();

        // Validar campos vacíos
        if (pregunta.trim().isEmpty() || respuestaCorrectaTexto.trim().isEmpty() ||
            respuestaFake1Texto.trim().isEmpty() || respuestaFake2Texto.trim().isEmpty() ||
            respuestaFake3Texto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear objetos de respuesta
        Respuesta respuestaCorrecta = new Respuesta(respuestaCorrectaTexto, true);
        Respuesta respuestaFake1 = new Respuesta(respuestaFake1Texto, false);
        Respuesta respuestaFake2 = new Respuesta(respuestaFake2Texto, false);
        Respuesta respuestaFake3 = new Respuesta(respuestaFake3Texto, false);

        List<Respuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuestaCorrecta);
        listaRespuestas.add(respuestaFake1);
        listaRespuestas.add(respuestaFake2);
        listaRespuestas.add(respuestaFake3);
        Collections.shuffle(listaRespuestas);

        PreguntaOpcion preguntaOpcion = new PreguntaOpcion(pregunta, idTema);
        PreguntasDAO preguntasDAO = new PreguntasDAO();

        // Insertar o modificar pregunta
        if (idPregunta == null) {
            preguntasDAO.insertar(preguntaOpcion, listaRespuestas);
        } else {
            preguntasDAO.modificar(idPregunta, preguntaOpcion, listaRespuestas);
        }
        this.vista.dispose();
        c.getVista().actualizarTabla();
    });

    this.vista.getBtnCancelar().addActionListener(e -> this.vista.setVisible(false));

    this.vista.getBtnAñadirAproximacion().addActionListener(e -> {
        pregunta = getVista().getTextPreguntaAproximacion().getText();
        String respuestaCorrectaTexto = getVista().getTextRespuestaAproximacion().getText();

        // Validar campos vacíos
        if (pregunta.trim().isEmpty() || respuestaCorrectaTexto.trim().isEmpty()) {
            JOptionPane.showMessageDialog(vista, "Todos los campos deben estar completos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        PreguntaAproximacion preguntaAproximacion = new PreguntaAproximacion(pregunta, idTema);
        PreguntasDAO preguntasDAO = new PreguntasDAO();
        Respuesta respuestaCorrecta = new Respuesta(respuestaCorrectaTexto, true);

        List<Respuesta> listaRespuestas = new ArrayList<>();
        listaRespuestas.add(respuestaCorrecta);

        if (idPregunta == null) {
            preguntasDAO.insertar(preguntaAproximacion, listaRespuestas);
        } else {
            preguntasDAO.modificar(idPregunta, preguntaAproximacion, listaRespuestas);
        }
        this.vista.dispose();
        c.getVista().actualizarTabla();
        });
    this.vista.getBtnVolverAproximacion().addActionListener(e -> this.vista.setVisible(false));

    }
    
    
    public void mostrarCampos() {    	
    	if ( getC().getTipoPregunta() == "Aproximacion") {
            getVista().getTabbedPane().setSelectedComponent(getVista().getPanelAproximacion()); 
    		getVista().getTextPreguntaAproximacion().setText(getC().getPregunta());
		} else if (getC().getTipoPregunta() == "Opcion multiple") {
			 getVista().getTabbedPane().setSelectedComponent(getVista().getPanelOpcion()); 
			getVista().getTextPreguntaOpcion().setText(getC().getPregunta());
		}
    }

    


    public VistaCreacionPreguntas getVista() {
        return vista;
    }

    public void setVista(VistaCreacionPreguntas vista) {
        this.vista = vista;
    }
	public ControladorModPreguntas getC() {
		return c;
	}

}