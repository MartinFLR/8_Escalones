package model.logica;

import java.util.ArrayList;
import java.util.List;

public class Escalon implements Observable {
    @SuppressWarnings("unused")
    private String pregunta;
    private String resCorrecta;
    private Tema tema;
    private final List<Participante> participantes = new ArrayList<>();

    public Escalon(String pregunta, String resCorrecta) {
        this.pregunta = pregunta;
        this. resCorrecta = resCorrecta;
    }

    public void setTema(Tema tema) {
        //Aca puede sacar info de la base de datos para setear
        this.tema = tema;
        this.notificaParticipantes(tema.getPreguntas());
    }
    
    public void repartirPreguntas(){
        //
        for (Participante participante : participantes) {
            participante.setPreguntas();
        }
    }
    
    @Override
    public void notificaParticipantes(List<model.Pregunta> preguntas) {
        // Aca hay que sacar dos preguntas del List y pasarlas al update 
        for (Participante participante : participantes) {
            participante.update();
            //Actualizar el parametro que recibe update para recibir dos preguntas
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
