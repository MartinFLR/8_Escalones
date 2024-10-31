package model.logica;

import java.util.List;

public interface EstadoRonda {
    //Capaz tengamos que agregar List[Participante] como parametro
    //para que el estado pueda manejar la ronda de preguntas
    public void rondaDePreguntas(Ronda ronda,List<Participante> participantes);
}
