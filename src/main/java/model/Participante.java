package model;

import java.util.ArrayList;
import java.util.List;

public class Participante {
    private int id;
    private final String nombre;
    @SuppressWarnings("FieldMayBeFinal")
<<<<<<< HEAD
    private List<PreguntaOpciones> preguntas = new ArrayList<>();
    private char respuestaParticipante;
    private PregAproximacion pregEmpate;
=======
    private List<PreguntaOpcion> preguntas = new ArrayList<>();
    private String respuestaParticipante;
    private PreguntaAproximacion pregEmpate;
>>>>>>> main
    private double respuestaParticipanteEmpate;
    private int cantErrores=0;
    private int cantAciertos = 0;//Puede ser util para la ronda final
    private int numEscalon=1;

    public Participante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
    }

    // Constructor sin id para agregar participantes
    public Participante(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
<<<<<<< HEAD
    public char getRespuestaParticipante() {
        return respuestaParticipante;
    }
    public void setRespuestaParticipante(char respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }
    public List<PreguntaOpciones> getPreguntasParticipante(){
        return this.preguntas;
    } 
    public void setPreguntasParticipante(PreguntaOpciones preg){
=======
    public String getRespuestaParticipante() {
        return respuestaParticipante;
    }
    public void setRespuestaParticipante(String respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }
    public List<PreguntaOpcion> getPreguntasParticipante(){
        return this.preguntas;
    } 
    public void setPreguntasParticipante(PreguntaOpcion preg){
>>>>>>> main
        this.preguntas.add(preg);
    }
    public int getCantErrores(){
        return this.cantErrores;
    }
    public void setCantErrores(int cantErrores){ //le agrega errores a los ya existentes
        this.cantErrores += cantErrores;
    }
    public int getCantAciertos(){
        return this.cantAciertos;
    }
    public void setCantAciertos(int cantAciertos){//le agrega aciertos a los ya existentes
        this.cantAciertos += cantAciertos;
    }
    public void sumaAcierto(){
        this.cantAciertos++;
    }
    public void sumaError(){
        this.cantErrores++;
    }
    public void subeEscalon(){
        this.numEscalon++;
    }

    public double getRespuestaParticipanteEmpate() {
        return respuestaParticipanteEmpate;
    }

    public void setRespuestaParticipanteEmpate(double respuestaParticipanteEmpate) {
        this.respuestaParticipanteEmpate = respuestaParticipanteEmpate;
    }

<<<<<<< HEAD
    public PregAproximacion getPregEmpate() {
        return pregEmpate;
    }

    public void setPregEmpate(PregAproximacion pregEmpate) {
=======
    public PreguntaAproximacion getPregEmpate() {
        return pregEmpate;
    }

    public void setPregEmpate(PreguntaAproximacion pregEmpate) {
>>>>>>> main
        this.pregEmpate = pregEmpate;
    }

    public int getNumEscalon() {
        return numEscalon;
    }

    public int getId() {
        return id;
    }
        public void setId(int id) {
        this.id = id;
    }
}

