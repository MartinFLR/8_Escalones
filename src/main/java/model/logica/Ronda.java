package model.logica;
public class Ronda {
    private EstadoRonda estadoRonda;
    //Esta clase deriva la ronda de preguntas al estado (RondaNormal, RondaEmpate o RondaFinal)
    //El metodo rondaDePreguntas esta definido en la interfaz EstadoRonda
    public Ronda() {
        //Por defecto setea el estado en RondaNormal
        this.estadoRonda = new RondaNormal();
    }
    public void rondaDePreguntas(){
        this.estadoRonda.rondaDePreguntas(this);
    }
    public void setRondaNormal(){
        this.estadoRonda = new RondaNormal();
    }
    public void setRondaDeEmpate(){
        this.estadoRonda = new RondaEmpate();
    }
    public void setRondaFinal(){
        this.estadoRonda = new RondaFinal();
    }
}
