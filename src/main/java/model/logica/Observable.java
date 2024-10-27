package model.logica;

import java.util.List;

public interface Observable {   
    public void agregaParticipante(model.logica.Participante participante);

    public void eliminaParticipante(model.logica.Participante participante);

    public void notificaParticipantes(List<model.Pregunta> preguntas);

}
