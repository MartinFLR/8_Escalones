package model.logica;

import java.util.List;

import model.Participante;
import model.Tema;

public interface EstadoRonda {
    //para que el estado pueda manejar la ronda de preguntas
    public void actualizarDatos(Ronda ronda,List<Participante> participantes,Tema tema);
}
