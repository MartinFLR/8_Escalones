package model.logica;

import java.util.List;

import model.Participante;
import model.PreguntaAproximacion;
import model.Tema;


public class RondaEmpate implements EstadoRonda {

    @Override
    public void actualizarDatos(Ronda ronda, List<Participante> participantes, Tema tema) {
        //Actualizar datos
            // Setee la cant errores
            // Setee la cant aciertos
            // Filtrar la cant participantes
        PreguntaAproximacion preguntaAproximacion = tema.getPregsAproximacion().removeFirst();
        for (Participante participante : participantes) {//reparte la pregunta de aproximacion a los participantes dados.
            participante.setPregEmpate(preguntaAproximacion);
        }
    }
}