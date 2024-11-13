package model;

public abstract class Preguntas {
    
    protected final  String pregunta;
    protected String tipo_preg;
    protected int id_pregunta;
    protected final int idTema;
    protected String respuesta_correcta;

    //Para traer de la bd
    public Preguntas(int id,String pregunta,String tipo_preg, int id_tema) {
        this.id_pregunta = id;
        this.pregunta = pregunta;
        this.tipo_preg = tipo_preg;
        this.idTema = id_tema;
    }
    public abstract void imprimirPregunta();
    
    public Preguntas(String pregunta,String tipo_preg, int id_tema) {
        this.pregunta = pregunta;
        this.tipo_preg = tipo_preg;
        this.idTema = id_tema;
    }

    public String getPregunta() {
        return pregunta;
    }

    public String getTipo_preg() {
        return tipo_preg;
    }

    public void setTipo_preg(String tipo_preg) {
        this.tipo_preg = tipo_preg;
    }

    public int getId_pregunta() {
        return id_pregunta;
    }

    public int getIdTema() {
        return idTema;
    }
    public abstract String getRespuestaCorrecta();
    
}
