package model;

import java.util.List;
import java.util.Random;
import model.*;

public class Tema {
    private int id_tema;
    private String nombre_tema;
    private List<PreguntaOpcion> preguntasOp;
    private List<PreguntaAproximacion> pregsAproximacion;
    private List<Preguntas> preguntas;
    private int CantidadPreguntas;

    public Tema(){
        
    }

    

    public Tema(String nombre, List<Preguntas> preguntas) {
        this.nombre_tema = nombre;
        this.preguntas = preguntas;
    }



    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntasOp = preguntas;
        this.nombre_tema = tema;
    }

    public Tema(int id, String nombre) {
        this.id_tema = id;
        this.nombre_tema = nombre;
        this.CantidadPreguntas = 0;
    }
    
    public Tema(int id, String nombre, int cantidadPreguntas) {
        this.id_tema = id;
        this.nombre_tema = nombre;
        CantidadPreguntas = cantidadPreguntas;
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
    public String getTema() {
        return this.nombre_tema;
    }
    public void setNombre(String nombreTema) {
        this.nombre_tema = nombreTema;
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
        return id_tema;
    }
    public String getNombre() {
        return nombre_tema;
    }
    public void setId(Integer id){
        this.id_tema = id;
    }

    public void setCantidadPreguntas(Integer Cantidad){
        this.CantidadPreguntas = Cantidad;
    }

    public int getCantidadPreguntas(){
        return this.CantidadPreguntas;
    }
}
