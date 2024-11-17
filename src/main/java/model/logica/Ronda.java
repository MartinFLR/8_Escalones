package model.logica;

import java.util.List;

import model.Participante;

public class Ronda {
    private EstadoRonda estadoRonda;
    //Esta clase deriva la ronda de preguntas al estado (RondaNormal, RondaEmpate o RondaFinal)
    
    public Ronda() {
        //Por defecto setea el estado en RondaNormal
        this.estadoRonda = new RondaNormal();
    }
    public void actualizarDatos(List<Participante> participantes){
        this.estadoRonda.actualizarDatos(this, participantes);
    }
    public void setRondaNormal(){
        System.out.println("Estado: Ronda normal");
        this.estadoRonda = new RondaNormal();
    }
    public void setRondaDeEmpate(List<Participante> participantes){
        //recibe como parametro la lista de participantes empatados en errores.
        //El que gane no sera eliminado
        System.out.println("Estado: Ronda de empate");
        this.estadoRonda = new RondaEmpate();
    }
    public void setRondaFinal(){
        System.out.println("Estado: Ronda final");
        this.estadoRonda = new RondaFinal();
    }
}
