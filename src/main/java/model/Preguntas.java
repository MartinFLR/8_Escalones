package model;

public abstract class Preguntas {
    private final  String pregunta;
    private String tipo_preg;
    private int id;
    private final int idTema;

    //Para traer de la bd
    public Preguntas(int id,String pregunta,String tipo_preg, int id_tema) {
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

    public int getId() {
        return id;
    }

    public String getTipo_preg() {
        return tipo_preg;
    }

    public void setTipo_preg(String tipo_preg) {
        this.tipo_preg = tipo_preg;
    }

    public int getId_pregunta() {
        return id;
    }

    public int getIdTema() {
        return idTema;
    }
    
}
