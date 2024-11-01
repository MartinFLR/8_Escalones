package model.logica;

import java.util.ArrayList;
import java.util.List;

public class Escalon {
    private final Ronda estadoDeRonda; 
    private Tema tema;
    private int escalon=1;
    private final List<Participante> participantes = new ArrayList<>();

    public Escalon() {
        //Crea la instancia de la ronda y setea por defecto ronda normal
        this.estadoDeRonda = new Ronda();
    }

    //A cada participante le reparte dos preguntas
    
    public void repartirPreguntas(){
        for (Participante participante : participantes) {
            for (int i = 0; i <2; i++) {
            participante.setPreguntasParticipante(tema.sacarPregunta());
        }}
    }
    public void repartirPreguntasAprox(List<Participante> participantesAEliminar){ //Reparte la pregunta de aproximacion a los participantes correspondientes
        for (model.logica.Participante par: participantesAEliminar){
            par.setPregEmpate(tema.sacarPreguntaAprox());
            
        }
    }
    public void subeEscalon(){
        this.escalon++;
        if (this.escalon==8){
            this.estadoDeRonda.setRondaFinal();
        }
    }
    private List<Participante> getParticipantesAEliminar() {
        //Tiene que checkear que haya solo 1, si hay mas de 1 setea el estado en RondaEmpate
        List<Participante> participantesAEliminar = new ArrayList<>();
        for (Participante participante : participantes) {
            int errParticipante = participante.getCantErrores();
            if (errParticipante>0){
                //Si la lista no esta vacia, compara con el maximo de errores
                if(!participantesAEliminar.isEmpty()){
                    //Si el participante tiene mas errores que el maximo de errores,
                    //se limpia la lista y se agrega el participante
                    if(errParticipante>participantesAEliminar.get(0).getCantErrores()){
                        participantesAEliminar.clear();
                        participantesAEliminar.add(participante);
                    }else if(errParticipante==participantesAEliminar.get(0).getCantErrores()){
                        //Si el participante tiene la misma cantidad de errores que el maximo de errores,
                        //se agrega el participante
                        participantesAEliminar.add(participante);
                    }
                }else{
                    //Si la lista esta vacia, se agrega el participante
                    participantesAEliminar.add(participante);                
                }
            }
        }
        return participantesAEliminar;
    }

    public void filtrarParticipantes(){
        List<Participante> participantesAEliminar = getParticipantesAEliminar();
        //Si hay mas de un participante con la misma cantidad de errores, setea la ronda de empate
        if (participantesAEliminar.size()>1){
            // les envia la pregunta de aproximacion a todos los participantes empatados.
            this.repartirPreguntasAprox(participantesAEliminar);
            //Envia la lista de participantes a eliminar y sigue la la logica de la ronda de empate
            this.estadoDeRonda.setRondaDeEmpate(participantesAEliminar);
            
        }else{
            //Si solo hay uno, se elimina
            //despues de esto habria que sumar uno al numEscalon y repartir preguntas   
            this.participantes.remove(participantesAEliminar.get(0));
        }
    }

    public void eliminoParticipantes(List<Participante> participantesAEliminar,List<Participante> participantes){ 
        //Saca los participantes que perdieron de la lista de participantes que siguen en juego
        for (Participante par: participantesAEliminar){
            participantes.remove(par);
        
        }
    }

    public void agregaParticipante(model.logica.Participante participante) {
        this.participantes.add(participante);
        
    }
    public void eliminaParticipante(model.logica.Participante participante) {
        this.participantes.remove(participante);
    }
    //Getters y setters
    public void setTema(Tema tema) {
        this.tema = tema;
    }
}
