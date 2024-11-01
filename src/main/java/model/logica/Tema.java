package model.logica;

import java.util.List;

import model.Pregunta;

public class Tema {
    private String tema;
    private List<model.Pregunta> preguntas;
    private List<model.logica.PregAproximacion> pregsAproximacion;

    public Tema( List<PregAproximacion> pregsAproximacion, List<Pregunta> preguntas, String tema) {
        this.pregsAproximacion = pregsAproximacion;
        this.preguntas = preguntas;
        this.tema = tema;
    }

    //Deberiamos hacer que en vez de devolver la 1ra pregunta, devuelva una pregunta random
    public model.Pregunta sacarPregunta(){
        return this.preguntas.remove(0);
    }
    
    public model.logica.PregAproximacion sacarPreguntaAprox(){
        return this.pregsAproximacion.remove(0);
    }

    //Getters y Setters
    public String getTema() {
        return tema;
    }
    public void setTema(String tema) {
        this.tema = tema;
    }
    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPreguntas(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public List<PregAproximacion> getPregsAproximacion() {
        return pregsAproximacion;
    }

    public void setPregsAproximacion(List<PregAproximacion> pregsAproximacion) {
        this.pregsAproximacion = pregsAproximacion;
    }
}
