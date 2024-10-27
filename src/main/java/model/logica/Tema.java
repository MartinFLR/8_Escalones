package model.logica;

import java.util.List;

import model.Pregunta;

public class Tema {
    private String tema;
    private List<model.Pregunta> preguntas;
    private List<model.logica.PregAproximacion> pregsAproximacion;
    private Juez juez;

    public Tema(Juez juez, List<PregAproximacion> pregsAproximacion, List<Pregunta> preguntas, String tema) {
        this.juez = juez;
        this.pregsAproximacion = pregsAproximacion;
        this.preguntas = preguntas;
        this.tema = tema;
    }

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
