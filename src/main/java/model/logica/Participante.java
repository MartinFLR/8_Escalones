package model.logica;

import java.util.ArrayList;
import java.util.List;

import model.Pregunta;

public class Participante {
    private final String nombre;
    @SuppressWarnings("FieldMayBeFinal")
    private List<Pregunta> preguntas = new ArrayList<>();
    private Integer respuestaParticipante;
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
    public Integer getRespuestaParticipante() {
        return respuestaParticipante;
    }
    public void setRespuestaParticipante(Integer respuestaParticipante) {
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
    public void setCantErrores(int cantErrores){
        this.cantErrores = cantErrores;
    }
    public int getCantAciertos(){
        return this.cantAciertos;
    }
    public void setCantAciertos(int cantAciertos){
        this.cantAciertos = cantAciertos;
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
}

