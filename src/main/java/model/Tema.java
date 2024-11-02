package model;

import java.util.List;

public class Tema {
    private int id;
    private String nombre;
<<<<<<< HEAD
    private List<model.PreguntaOpciones> preguntas;
    private List<model.PregAproximacion> pregsAproximacion;

    public Tema( List<PregAproximacion> pregsAproximacion, List<PreguntaOpciones> preguntas, String tema) {
=======
    private List<model.PreguntaOpcion> preguntas;
    private List<model.PreguntaAproximacion> pregsAproximacion;

    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
>>>>>>> main
        this.pregsAproximacion = pregsAproximacion;
        this.preguntas = preguntas;
        this.nombre = tema;
    }
    public Tema(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    //Deberiamos hacer que en vez de devolver la 1ra pregunta, devuelva una pregunta random
<<<<<<< HEAD
    public model.PreguntaOpciones sacarPregunta(){
        return this.preguntas.remove(0);
    }
    
    public model.PregAproximacion sacarPreguntaAprox(){
=======
    public model.PreguntaOpcion sacarPregunta(){
        return this.preguntas.remove(0);
    }
    
    public model.PreguntaAproximacion sacarPreguntaAprox(){
>>>>>>> main
        return this.pregsAproximacion.remove(0);
    }

        // Conversion de un tema a una línea de texto
    public String toFileString() {
        return this.id + "," + this.nombre;
    }
    // Conversion de una línea de texto a un tema
    public static Tema fromFileString(String line) {
        String[] parts = line.split(",");
        return new Tema(Integer.parseInt(parts[0]), parts[1]);
    }
    
    //Getters y Setters
    public String getTema() {
        return this.nombre;
    }
    public void setNombre(String nombreTema) {
        this.nombre = nombreTema;
    }
<<<<<<< HEAD
    public List<PreguntaOpciones> getPreguntas() {
        return preguntas;
    }
    public void setPreguntas(List<PreguntaOpciones> preguntas) {
        this.preguntas = preguntas;
    }
    public List<PregAproximacion> getPregsAproximacion() {
        return pregsAproximacion;
    }
    public void setPregsAproximacion(List<PregAproximacion> pregsAproximacion) {
=======
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
>>>>>>> main
        this.pregsAproximacion = pregsAproximacion;
    }
    public int getId() {
        return id;
    }
    public String getNombre() {
        return nombre;
    }
}
