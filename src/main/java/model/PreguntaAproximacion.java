package model;

public class PreguntaAproximacion extends Preguntas{
<<<<<<< HEAD

    private final String respuesta_correcta;
=======
    
    private String respuestaCorrecta;
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2

    //Constructores
    public PreguntaAproximacion(String pregunta){
        //para traer de la bd
<<<<<<< HEAD
        super(pregunta,tipoPregunta,id_tema);
        this.respuesta_correcta = respuestaCorrecta;
    }
    public PreguntaAproximacion(int id,String pregunta,String tipoPregunta,String respuesta_correcta,int id_tema){
        super(id,pregunta,tipoPregunta,id_tema);
        this.respuesta_correcta = respuesta_correcta;
=======
        super(pregunta,"Aproximacion",2);
    }
    public PreguntaAproximacion(int id,String pregunta,String respuesta_correcta,int id_tema){
        super(id,pregunta,"Aproximacion",id_tema);
        this.respuestaCorrecta = respuesta_correcta;
>>>>>>> 4139275b255ea57a5f455b048fca28030fbb90f2
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
        return this.respuesta_correcta;
    }


}
