package model;

public class Pregunta {
    //Tema: 1 

    private int id;
    private String pregunta;
    private int id_tema;

    //Este constructor se utiliza cuando quiero crear una pregunta, el id en la base de datos es autoincremental
    public Pregunta( String pregunta, int id_tema) {
        this.pregunta = pregunta;
        this.id_tema = id_tema;
    }

    //Este constructor se utiliza cuando quiero recuperar la pregunta
    public Pregunta(int id , String pregunta, int id_tema){
        this.id = id;
        this.pregunta = pregunta;
        this.id_tema = id_tema;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPregunta() {
        return pregunta;
    }

    public void setPregunta(String pregunta) {
        this.pregunta = pregunta;
    }

    public int getIdTema() {
        return id_tema;
    }

    public void setIdTema(int id_tema) {
        this.id_tema = id_tema;
    }
}
