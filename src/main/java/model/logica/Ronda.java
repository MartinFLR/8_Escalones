package model.logica;

import java.util.List;

import model.Participante;
import model.Tema;

public class Ronda {
    private EstadoRonda estadoRonda;
    //Esta clase deriva la ronda de preguntas al estado (RondaNormal, RondaEmpate o RondaFinal)
    
    public Ronda() {
        //Por defecto setea el estado en RondaNormal
        this.estadoRonda = new RondaNormal();
    }
    public void actualizarDatos(Ronda ronda,List<Participante> participantes,Escalon esc){
        this.estadoRonda.actualizarDatos(this, participantes,esc);
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

    void rondaDePreguntas(List<Participante> participantes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void rondaDePreguntas(List<Participante> participantes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    void rondaDePreguntas(List<Participante> participantes) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
