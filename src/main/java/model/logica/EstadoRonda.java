package model.logica;


public interface EstadoRonda {
    //Capaz tengamos que agregar List[Participante] como parametro
    //para que el estado pueda manejar la ronda de preguntas
    public void rondaDePreguntas(Ronda ronda);
}
