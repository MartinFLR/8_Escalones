package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tema {
    private int id_tema;
    private String nombre_tema;
    private List<PreguntaOpcion> preguntasOp = new ArrayList<>();
    private List<PreguntaAproximacion> pregsAproximacion = new ArrayList<>();
    private List<Preguntas> preguntas;
    private int CantidadPreguntas;


    public Tema(String nombre, List<Preguntas> preguntas) {
        this.nombre_tema = nombre;
        this.preguntas = preguntas;
    }

    //Constructor que usa team ABM para generar un nuevo tema de manera local
    public Tema(String nombre){
        this.nombre_tema = nombre;
    }

    //Constructor que usa team ABM para traer de la bd un tema
    public Tema(int id, String nombre) {
        this.id_tema = id;
        this.nombre_tema = nombre;
        this.CantidadPreguntas = 0;
    }

    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntasOp = preguntas;
        this.nombre_tema = tema;
    }


    // devuelve una pregunta random
    public PreguntaOpcion sacarPreguntaOp(){
        if (this.preguntasOp.isEmpty()) {
            throw new IllegalArgumentException("No hay mas preguntas disponibles");
        }
        Random random = new Random();
        return this.preguntasOp.remove(random.nextInt(0, this.preguntasOp.size()));
        
    }
    
    //public PreguntaAproximacion sacarPreguntaAprox(){
    //    Random random= new Random();
    //    return this.pregsAproximacion.remove(random.nextInt(0, this.pregsAproximacion.size()));
    //}

    public PreguntaAproximacion sacarPreguntaAprox() {
        if (this.pregsAproximacion.isEmpty()) {
            throw new IllegalStateException("No hay más preguntas de aproximación disponibles.");
        }
        Random random = new Random();
        return this.pregsAproximacion.remove(random.nextInt(0, this.pregsAproximacion.size()));
    }

    //Getters y Setters
    public void setNombre(String nombreTema) {
        this.nombre_tema = nombreTema;
    }
    public List<Preguntas> getPreguntas() {
        return this.preguntas;
    }
    public void setPreguntasOp(List<PreguntaOpcion> preguntas) {
        this.preguntasOp = preguntas;
    }
    public void agregarPreguntaOp(PreguntaOpcion pregunta){
        this.preguntasOp.add(pregunta);
    }
    public List<PreguntaOpcion> getPreguntasOp() {
        return this.preguntasOp;
    }
    public List<PreguntaAproximacion> getPregsAproximacion() {
        return pregsAproximacion;
    }
    public void setPregsAproximacion(List<PreguntaAproximacion> pregsAproximacion) {
        this.pregsAproximacion = pregsAproximacion;
    }
    public void agregarPreguntasAproximacion(PreguntaAproximacion pregunta){
        this.pregsAproximacion.add(pregunta);
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
