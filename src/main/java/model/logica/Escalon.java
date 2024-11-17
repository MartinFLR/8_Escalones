package model.logica;

import java.util.ArrayList;
import java.util.List;

import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Tema;

public class Escalon {
    private final Ronda estadoDeRonda; 
    private Tema tema;
    private int escalon=1;
    private final List<Participante> participantes = new ArrayList<>();

    public Escalon() {
        //Crea la instancia de la ronda y setea por defecto ronda normal
        this.estadoDeRonda = new Ronda();
    }
    public void repartirPreguntas(){
        for (Participante participante : this.getParticipantes()) {
            for (int i = 0; i < 2; i++) {
                PreguntaOpcion pregunta = this.tema.sacarPreguntaOp();
                participante.setPreguntasParticipante(pregunta);
            }
        }
    }

    private void repartirPreguntasFinal(){
        System.out.println("Reparte preguntas final");
        //Hay que ver como repartir preguntas intercaladas (ej: 2 preguntas de Literatura, 2 preguntas de Deportes, etc.)
        for (int i = 0; i < 10; i++) {
            PreguntaOpcion pregunta = this.tema.sacarPreguntaOp();
            for (Participante participante : participantes) {
                participante.setPreguntasParticipante(pregunta);
            }
        }
    }
    public void subeEscalon(){//incrementa en uno,a menos q sea el ultimo esc. Resetea los errores
        this.escalon++;
        this.resetAciertosyErrores();
        if (this.escalon==8){
            this.repartirPreguntasFinal();
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
            PreguntaAproximacion preguntaAprox = tema.sacarPreguntaAprox();
            for (Participante participante : participantesAEliminar) {
                participante.setPregEmpate(preguntaAprox);
            }
            //Envia la lista de participantes a eliminar y sigue la la logica de la ronda de empate
            this.estadoDeRonda.setRondaDeEmpate(participantesAEliminar);
            
            // Repite la ronda de desempate hasta que quede uno
            while(participantesAEliminar.size()>1){
                this.estadoDeRonda.rondaDePreguntas(participantesAEliminar);
            }
            this.participantes.remove(participantesAEliminar.getFirst());
            this.estadoDeRonda.setRondaNormal();
        }else{
            //Si solo hay uno, se elimina
            //despues de esto habria que sumar uno al numEscalon y repartir preguntas   
            this.eliminoParticipantes(participantesAEliminar, participantes);
<<<<<<< HEAD
<<<<<<< HEAD
            this.subeEscalon();
=======
>>>>>>> parent of 5b74cf1 (Se rompio todo)
=======
>>>>>>> parent of ec7ec60 (Merge branch 'ana' of https://github.com/MartinFLR/8_Escalones mergee mi branch con lo de la vista de aciertos y errores :))
        }
    }

    public void eliminoParticipantes(List<Participante> participantesAEliminar,List<Participante> participantes){ 
        //Saca los participantes que perdieron de la lista de participantes que siguen en juego
        for (Participante par: participantesAEliminar){
            participantes.remove(par);
        }
    }

    public void agregaParticipante(model.Participante participante) {
        this.participantes.add(participante);
        
    }
    public void eliminaParticipante(model.Participante participante) {
        this.participantes.remove(participante);
    }

    public void resetAciertosyErrores(){ //Resetea los aciertos y errores del participante, para cuando cambia el escalon
        for (Participante par: participantes ){
        par.setCantErrores(0);
        par.setCantAciertos(0);
    }}
    

    //Getters y setters
    public void setTema(Tema tema) {
        this.tema = tema;
    }
    public Tema getTema() {
        return this.tema;
    }
    public int getEscalon() {
        return this.escalon;
    }
    public void setEscalon(int escalon) {
        this.escalon = escalon;
        if (this.escalon==8){
            //Esto asigna a priori dos preguntas para eventuales empates
            //Estaria bueno poder asignar la lista de preguntas de empate a los participantes
            for (Participante participante : participantes) {
                participante.setPregEmpate(this.tema.sacarPreguntaAprox());
            }
            this.repartirPreguntasFinal();
            this.estadoDeRonda.setRondaFinal();
        }
    }
    public List<Participante> getParticipantes() {
        return this.participantes;
    }

    public Ronda getEstadoDeRonda() {
        return this.estadoDeRonda;
    }
}
