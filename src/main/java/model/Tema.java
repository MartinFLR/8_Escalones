package model;

import java.util.List;

public class Tema {
    private int id;
    private String nombre;
    private List<model.PreguntaOpcion> preguntas;
    private List<model.PreguntaAproximacion> pregsAproximacion;

    public Tema( List<PreguntaAproximacion> pregsAproximacion, List<PreguntaOpcion> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntas = preguntas;
        this.nombre = tema;
    }
    public Tema(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }
    //Deberiamos hacer que en vez de devolver la 1ra pregunta, devuelva una pregunta random
    public model.PreguntaOpcion sacarPregunta(){

        return this.preguntas.remove(0);
    }
    
    public model.PreguntaAproximacion sacarPreguntaAprox(){
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
}
