package model.logica;

import java.util.List;

public class Ronda {
    private EstadoRonda estadoRonda;
    //Esta clase deriva la ronda de preguntas al estado (RondaNormal, RondaEmpate o RondaFinal)
    //El metodo rondaDePreguntas esta definido en la interfaz EstadoRonda
    public Ronda() {
        //Por defecto setea el estado en RondaNormal
        this.estadoRonda = new RondaNormal();
    }
    public void rondaDePreguntas(List<Participante> participantes){
        this.estadoRonda.rondaDePreguntas(this,participantes);
    }
    public void setRondaNormal(){
        this.estadoRonda = new RondaNormal();
    }
    public void setRondaDeEmpate(List<Participante> participantes){
        //recibe como parametro la lista de participantes empatados en errores.
        //El que gane no sera eliminado
        this.estadoRonda = new RondaEmpate();
    }
    public void setRondaFinal(){
        this.estadoRonda = new RondaFinal();
    }
}
