package model;

public class Pregunta {
    //Tema: 1 

    private int id;
    private String pregunta;
    private String opcion_a;
    private String opcion_b;
    private String opcion_c;
    private String opcion_d;
    private char respuestaCorrecta;
    private int id_tema;

    //Este constructor se utiliza cuando quiero crear una pregunta, el id en la base de datos es autoincremental
    public Pregunta( String pregunta, String opcion_a, String opcion_b,
                    String opcion_c, String opcion_d, char respuestaCorrecta, int id_tema) {
        this.pregunta = pregunta;
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuestaCorrecta = respuestaCorrecta;
        this.id_tema = id_tema;
    }

    //Este constructor se utiliza cuando quiero recuperar la pregunta
    public Pregunta(int id , String pregunta, String opcion_a, String opcion_b,
                    String opcion_c, String opcion_d, char respuestaCorrecta, int id_tema){
        this.id = id;
        this.pregunta = pregunta;
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuestaCorrecta = respuestaCorrecta;
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

    public String getOpcionA() {
        return opcion_a;
    }

    public void setOpcionA(String opcion_a) {
        this.opcion_a = opcion_a;
    }

    public String getOpcionB() {
        return opcion_b;
    }

    public void setOpcionB(String opcion_b) {
        this.opcion_b = opcion_b;
    }

    public String getOpcionC() {
        return opcion_c;
    }

    public void setOpcionC(String opcion_c) {
        this.opcion_c = opcion_c;
    }

    public String getOpcionD() {
        return opcion_d;
    }

    public void setOpcionD(String opcion_d) {
        this.opcion_d = opcion_d;
    }

    public char getRespuestaCorrecta() {
        return respuestaCorrecta;
    }

    public void setRespuestaCorrecta(char respuestaCorrecta) {
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public int getIdTema() {
        return id_tema;
    }

    public void setIdTema(int id_tema) {
        this.id_tema = id_tema;
    }
}
