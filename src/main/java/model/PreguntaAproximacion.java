package model;

public class PreguntaAproximacion extends Preguntas{
    
    private final String respuestaCorrecta;

    //Constructores
    public PreguntaAproximacion(String pregunta,String tipoPregunta,int id_tema,String respuestaCorrecta){
        //para traer de la bd
        super(pregunta,tipoPregunta,id_tema);
        this.respuestaCorrecta = respuestaCorrecta;
    }
    public PreguntaAproximacion(int id,String pregunta,String tipoPregunta,String respuesta_correcta,int id_tema){
        super(id,pregunta,tipoPregunta,id_tema);
        this.respuestaCorrecta = respuesta_correcta;
    }
    
    //Metodos
    @Override
    public void imprimirPregunta(){
        System.out.println("\tId: "+this.getId_pregunta());
        System.out.println("\tPregunta: "+this.getPregunta());
        System.out.println("\tTipo Pregunta: "+this.getTipo_preg());
        System.out.println("\tRespuesta correcta: "+this.getRespuestaCorrecta());
    }

    //Getters y Setters
    public String getRespuestaCorrecta(){
        return this.respuestaCorrecta;
    }


}
