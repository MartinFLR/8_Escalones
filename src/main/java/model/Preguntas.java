package model;

public abstract class Preguntas {
    private String tipo_preg;
    private int id_pregunta;
    private int id_tema;
    
    public Preguntas(String tipo_preg, int id_pregunta, int id_tema) {
        this.tipo_preg = tipo_preg;
        this.id_pregunta = id_pregunta;
        this.id_tema = id_tema;
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

    public void setId_pregunta(int id_pregunta) {
        this.id_pregunta = id_pregunta;
    }

    public int getId_tema() {
        return id_tema;
    }

    public void setId_tema(int id_tema) {
        this.id_tema = id_tema;
    }

}
