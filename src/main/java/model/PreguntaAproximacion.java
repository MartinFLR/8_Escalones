package model;

public class PreguntaAproximacion extends Preguntas{
    
    private String respuestaCorrecta;

    //para traer de la bd
    public PreguntaAproximacion(String pregunta,String tipoPregunta,int id_tema,String respuestaCorrecta){
        super(pregunta,tipoPregunta,id_tema);
        this.respuestaCorrecta = respuestaCorrecta;
    }

    public PreguntaAproximacion(int id,String pregunta,String tipoPregunta,String respuesta_correcta,int id_tema){
        super(id,pregunta,tipoPregunta,id_tema);
        this.respuestaCorrecta = respuesta_correcta;
    }

    public String getRespuestaCorrecta(){
        return this.respuestaCorrecta;
    }


}
