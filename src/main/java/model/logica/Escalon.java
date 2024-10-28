package model.logica;

import java.util.ArrayList;
import java.util.List;

public class Escalon implements Observable {
    @SuppressWarnings("unused")
    private String pregunta;
    private String resCorrecta;
    private Tema tema;
    private int escalon=0;

    private final List<Participante> participantes = new ArrayList<>();

    public Escalon(String pregunta, String resCorrecta) {
        this.pregunta = pregunta;
        this. resCorrecta = resCorrecta;
        this.escalon++;

    }

    public void setTema(Tema tema) {
        //Aca puede sacar info de la base de datos para setear
        this.tema = tema;
        this.notificaParticipantes(tema.getPreguntas());
    }
    
    public void repartirPreguntas(){
        for (Participante participante : participantes) {
            for (int i = 0; i <2; i++) {
            participante.setPreguntasParticipante(tema.sacarPregunta());
        }}
    }
    
    public void filtrarParticipantes(){
        for (Participante participante : participantes) {
            if (participante.verificoCantIntentos()){   
                this.participantes.remove(participante);
            }
        }
    }

    public void Ronda(){
        
    }

    @Override
    public void notificaParticipantes(List<model.Pregunta> preguntas) {
        
        for (Participante participante : participantes) {

            participante.update();
            //Actualizar el parametro que recibe update 
        }
    }

    @Override
    public void agregaParticipante(model.logica.Participante participante) {
        this.participantes.add(participante);
        
    }

    @Override
    public void eliminaParticipante(model.logica.Participante participante) {
        this.participantes.remove(participante);
    }
}
