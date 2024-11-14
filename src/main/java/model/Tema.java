package model;

import java.util.List;
import java.util.Random;
import model.*;

public class Tema {
    private int id;
    private String nombre;
    private List<PreguntaOpcion> preguntasOp;
    private List<PreguntaAproximacion> pregsAproximacion;
    private List<Preguntas> preguntas;
    private int CantidadPreguntas;


    public Tema(String nombre, List<Preguntas> preguntas) {
        this.nombre = nombre;
        this.preguntas = preguntas;
    }

    //Constructor que usa team ABM para generar un nuevo tema de manera local
    public Tema(String nombre){
        this.nombre = nombre;
    }

    //Constructor que usa team ABM para traer de la bd un tema
    public Tema(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.CantidadPreguntas = 0;
    }

    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntasOp = preguntas;
        this.nombre = tema;
    }


    // devuelve una pregunta random
    public PreguntaOpcion sacarPreguntaOp(){
        Random random= new Random();
        return this.preguntasOp.remove(random.nextInt(0, this.preguntasOp.size()));
        
    }
    
    public PreguntaAproximacion sacarPreguntaAprox(){
        Random random= new Random();
        return this.pregsAproximacion.remove(random.nextInt(0, this.pregsAproximacion.size()));
    }

    //Getters y Setters
    public void setNombre(String nombreTema) {
        this.nombre = nombreTema;
    }
    public List<Preguntas> getPreguntas() {
        return preguntas;
    }
    public void setPreguntasOp(List<PreguntaOpcion> preguntas) {
        this.preguntasOp = preguntas;
    }
    public List<PreguntaAproximacion> getPregsAproximacion() {
        return pregsAproximacion;
    }
    public void setPregsAproximacion(List<PreguntaAproximacion> pregsAproximacion) {
        this.pregsAproximacion = pregsAproximacion;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setId(Integer id){
        this.id = id;
    }

    public void setCantidadPreguntas(Integer Cantidad){
        this.CantidadPreguntas = Cantidad;
    }

    public int getCantidadPreguntas(){
        return this.CantidadPreguntas;
    }
}
