package model.logica;

import java.util.List;

import model.Participante;
import model.Tema;


public class RondaEmpate implements EstadoRonda {

    @Override
    public void actualizarDatos(Ronda ronda, List<Participante> participantes, Escalon esc) {
        //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes
        Tema tema= esc.getTema();
        for (Participante participante : participantes) {//reparte la pregunta de aproximacion a los participantes dados.
            participante.setPregEmpate(tema.sacarPreguntaAprox());
}
    }
}