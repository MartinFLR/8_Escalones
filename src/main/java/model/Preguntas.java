package model;

public abstract class Preguntas {
<<<<<<< HEAD
    private String tipo_preg;
    private int id_pregunta;
    private int id_tema;
    
    public Preguntas(String tipo_preg, int id_pregunta, int id_tema) {
        this.tipo_preg = tipo_preg;
        this.id_pregunta = id_pregunta;
        this.id_tema = id_tema;
=======
    private String pregunta;
    private String tipo_preg;
    private int id;
    private int idTema;

    //Para traer de la bd
    public Preguntas(int id,String pregunta,String tipo_preg, int id_tema) {
        this.pregunta = pregunta;
        this.tipo_preg = tipo_preg;
        this.idTema = id_tema;
    }
    //para
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
>>>>>>> main
    }

    public String getTipo_preg() {
        return tipo_preg;
    }

    public void setTipo_preg(String tipo_preg) {
        this.tipo_preg = tipo_preg;
    }

    public int getId_pregunta() {
<<<<<<< HEAD
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
=======
        return id;
    }

    public int getIdTema() {
        return idTema;
>>>>>>> main
    }

}
