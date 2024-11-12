package model;

import java.util.List;
import java.util.Random;


public class Tema {
    private int id;
    private String nombre;
    private List<model.PreguntaOpcion> preguntas;
    private List<model.PreguntaAproximacion> pregsAproximacion;
    private int CantidadPreguntas;

    public Tema(){
        
    }

    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntas = preguntas;
        this.nombre = tema;
    }
    public Tema(){};

    public Tema(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    
    public Tema(int id, String nombre, int cantidadPreguntas) {
        this.id = id;
        this.nombre = nombre;
        CantidadPreguntas = cantidadPreguntas;
    }

    // devuelve una pregunta random
    public model.PreguntaOpcion sacarPregunta(){
        Random random= new Random();
        return this.preguntas.remove(random.nextInt(0, this.preguntas.size()));
        
    }
    
    public model.PreguntaAproximacion sacarPreguntaAprox(){
        Random random= new Random();
        return this.pregsAproximacion.remove(random.nextInt(0, this.pregsAproximacion.size()));
    }

    //Getters y Setters
    public String getTema() {
        return this.nombre;
    }
    public void setNombre(String nombreTema) {
        this.nombre = nombreTema;
    }
    public List<PreguntaOpcion> getPreguntas() {
        return preguntas;
    }
    public void setPreguntas(List<PreguntaOpcion> preguntas) {
        this.preguntas = preguntas;
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
