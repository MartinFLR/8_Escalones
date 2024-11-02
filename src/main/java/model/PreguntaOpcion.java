package model;

public class PreguntaOpcion extends Preguntas {
    
    private String opcion_a;
    private String opcion_b;
    private String opcion_c;
    private String opcion_d;
    private String respuesta_correcta;

    public PreguntaOpcion(String pregunta,int id_tema ,String tipoPregunta,String opcion_a, String opcion_b,
    String opcion_c, String opcion_d, String respuestaCorrecta){
        super(pregunta,tipoPregunta,id_tema);
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuesta_correcta = respuestaCorrecta;
    }

    public PreguntaOpcion(int id,String pregunta, String tipoPregunta ,String opcion_a, String opcion_b,
    String opcion_c, String opcion_d, String respuestaCorrecta, int id_tema){
        super(pregunta,tipoPregunta,id_tema);
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuesta_correcta = respuestaCorrecta;
    }

    public String getOpcionA(){
        return this.opcion_a;
    }

    public String getOpcionB(){
        return this.opcion_b;
    }

    public String getOpcionC(){
        return this.opcion_c;
    }

    public String getOpcionD(){
        return this.opcion_d;
    }

    public String getRespuestaCorrecta(){
        return this.respuesta_correcta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta){
        this.respuesta_correcta = respuestaCorrecta;
    }

}
