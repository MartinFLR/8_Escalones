package model.logica;

import java.util.List;

import model.Pregunta;

public class Participante implements Observer{
    private final String nombre;
    private List<Pregunta> preguntas;
    private Integer respuestaParticipante;
    private int cantIntentos;
    private int numEscalon=0;

    public Participante(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void update() {
        this.cantIntentos=0;
        this.numEscalon++;
      //deberia updatear las nuevas preguntas (?)
        
        }
    
    

    public Integer getRespuestaParticipante() {
        return respuestaParticipante;
    }

    public void setRespuestaParticipante(Integer respuestaParticipante) {
        this.respuestaParticipante = respuestaParticipante;
    }

    public void setPreguntasParticipante(Pregunta preg){
        
        this.preguntas.addFirst(preg);
    
}
    public boolean verificoCantIntentos() {
        if (this.cantIntentos>2){
            return false;} else{
                return true;}
            }
        }
        
    

    

