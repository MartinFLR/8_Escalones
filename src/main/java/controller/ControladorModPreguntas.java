package controller;

import model.ABM.PreguntaOpcionDAO;
import model.ABM.PreguntasDAO;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Respuesta;
import view.VistaCreacionPreguntas;
import view.VistaModPreguntas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorModPreguntas {

    private VistaModPreguntas vista;
    private int id_categoria;

    public ControladorModPreguntas(){
        this.vista = new VistaModPreguntas(this,"gdfgdf");
        this.vista.setVisible(true);

    }


    public void setId_pregunta(int id_categoria) {
        this.id_categoria = id_categoria;
        System.out.println("Hola soy controladorMod Preguntas "+id_categoria);
    }
}
