package model;

public class PreguntaAproximacion extends Pregunta{
    
    private String respuestaCorrecta;

    public PreguntaAproximacion(String pregunta,int id_tema,String respuestaCorrecta){
        super(pregunta,id_tema);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public PreguntaAproximacion(int id,String pregunta,String respuesta_correcta,int id_tema){
        super(id,pregunta,id_tema);
        this.respuestaCorrecta = respuesta_correcta;
    }

    public String getRespuestaCorrecta(){
        return this.respuestaCorrecta;
    }


}
