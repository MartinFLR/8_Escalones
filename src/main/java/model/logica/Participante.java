package model.logica;

import java.util.List;

import model.Pregunta;

public class Participante implements Observer{
    private final String nombre;
    private List<Pregunta> preguntas;
    private Integer respuestaParticipante;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update() {
        
    }

    public Integer getRespuestaParticipante() {
        return respuestaParticipante;
    }

    public void setRespuestaParticipante(Integer respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }

    public void setPreguntas(){
        //
    }
}
