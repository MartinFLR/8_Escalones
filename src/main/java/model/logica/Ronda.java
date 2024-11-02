package model.logica;

import java.util.List;

import model.Participante;

public class Ronda {
    private EstadoRonda estadoRonda;
    //Esta clase deriva la ronda de preguntas al estado (RondaNormal, RondaEmpate o RondaFinal)
    //El metodo rondaDePreguntas esta definido en la interfaz EstadoRonda
    public Ronda() {
        //Por defecto setea el estado en RondaNormal
        this.estadoRonda = new RondaNormal();
    }
    public void rondaDePreguntas(List<Participante> participantes){
        this.estadoRonda.rondaDePreguntas(this, participantes);
    }
    public void setRondaNormal(){
        System.out.println("Estado: Ronda normal");
        this.estadoRonda = new RondaNormal();
    }
    public void setRondaDeEmpate(List<Participante> participantes){
        //recibe como parametro la lista de participantes empatados en errores.
        //El que gane no sera eliminado
        System.out.println("Estado: Ronda de empate");
        System.out.println("Empate entre los participantes:");
        for (Participante participante : participantes) {
            System.out.println(participante.getNombre());
            System.out.println("Errores: "+participante.getCantErrores() + "\n");
        }
        
        this.estadoRonda = new RondaEmpate();
    }
    public void setRondaFinal(){
        System.out.println("Estado: Ronda final");
        this.estadoRonda = new RondaFinal();
    }
}
