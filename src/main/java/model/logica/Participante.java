package model.logica;

import java.util.ArrayList;
import java.util.List;

import model.Pregunta;

public class Participante {
    private final String nombre;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Pregunta> preguntas = new ArrayList<>();
    private char respuestaParticipante;
    private double respuestaParticipanteEmpate;
    private PregAproximacion pregEmpate;
    private int cantErrores=0;
    private int cantAciertos = 0;//Puede ser util para la ronda final
    private int numEscalon=1;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    //Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public char getRespuestaParticipante() {
        return respuestaParticipante;
    }
    public void setRespuestaParticipante(char respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }
    public List<Pregunta> getPreguntasParticipante(){
        return this.preguntas;
    } 
    public void setPreguntasParticipante(Pregunta preg){
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

    public PregAproximacion getPregEmpate() {
        return pregEmpate;
    }

    public void setPregEmpate(PregAproximacion pregEmpate) {
        this.pregEmpate = pregEmpate;
    }
}

