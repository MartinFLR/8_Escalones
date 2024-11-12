package model;

@SuppressWarnings("FieldMayBeFinal")
public class PreguntaOpcion extends Preguntas {
    private String opcion_a;
    private String opcion_b;
    private String opcion_c;
    private String opcion_d;
    private String respuesta_correcta;

    //Constructores
    public PreguntaOpcion(String pregunta,int id_tema ,String tipoPregunta,String opcion_a, String opcion_b,
    String opcion_c, String opcion_d, String respuestaCorrecta){
        super(pregunta,tipoPregunta,id_tema);
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuesta_correcta = respuestaCorrecta;
    }

    public PreguntaOpcion(String pregunta, String tipoPregunta ,String opcion_a, String opcion_b,
    String opcion_c, String opcion_d, String respuestaCorrecta, int id_tema){
        super(pregunta,tipoPregunta,id_tema);
        this.opcion_a = opcion_a;
        this.opcion_b = opcion_b;
        this.opcion_c = opcion_c;
        this.opcion_d = opcion_d;
        this.respuesta_correcta = respuestaCorrecta;
    }

    public PreguntaOpcion(String preguntaTexto, String tipoPregunta, String opcion_a2, String opcion_b2,
            String opcion_c2, String opcion_d2, int idTema) {
        super( preguntaTexto, tipoPregunta, idTema);
        this.opcion_a = opcion_a2;
        this.opcion_b = opcion_b2;
        this.opcion_c = opcion_c2;
        this.opcion_d = opcion_d2;
        
    }
    //Constructor usado en ABM
    public PreguntaOpcion(int idPregunta, String preguntaTexto, String string, String string0, String string1, String string2, String string3, Object object, int idTema) {
        super(idPregunta, preguntaTexto, string, idTema);
        this.opcion_a = string0;
        this.opcion_b = string1;
        this.opcion_c = string2;
        this.opcion_d = string3;
        this.respuesta_correcta = (String) object;
    }

    //Metodos
    @Override
    public void imprimirPregunta(){
        System.out.println("\tId: "+this.getId());
        System.out.println("\tPregunta: "+this.getPregunta());
        System.out.println("\tOpcion A: "+this.opcion_a);
        System.out.println("\tOpcion B: "+this.opcion_b);
        System.out.println("\tOpcion C: "+this.opcion_c);
        System.out.println("\tOpcion D: "+this.opcion_d);
        System.out.println("\tRespuesta correcta: "+this.respuesta_correcta);
    }
    //Getters y Setters
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

    public void setOpcionA(String opcion) {
        this.opcion_a = opcion;
    }

    public void setOpcionB(String opcion) {
        this.opcion_b = opcion;
    }

    public void setOpcionC(String opcion) {
        this.opcion_c = opcion;
    }

    public void setOpcionD(String opcion) {
        this.opcion_d = opcion;
    }

    public String getRespuestaCorrecta(){
        return this.respuesta_correcta;
    }

    public void setRespuestaCorrecta(String respuestaCorrecta){
        this.respuesta_correcta = respuestaCorrecta;
    }

}
