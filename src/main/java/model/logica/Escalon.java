package model.logica;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import model.Participante;
import model.PreguntaOpcion;
import model.Tema;

public class Escalon {
    private final Ronda estadoDeRonda; 
    private Tema tema;
    private int escalon=0;
    private final List<Participante> participantes = new ArrayList<>();
    private List<Tema> temas = new ArrayList<>(); 

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
    public void subeEscalon(){//incrementa en uno,a menos q sea el ultimo esc. Resetea los errores y aciertos
        //faltaria que cambie el tema automaticamente,capaz cn la lista de temas.
        this.escalon++;
        this.resetAciertosyErrores();
        if (this.escalon==8){
            this.repartirPreguntasFinal();
            this.estadoDeRonda.setRondaFinal();
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

    }
    

    //Getters y setters
    public void setTema() {
        Random random = new Random();
        int indice = random.nextInt(0, this.getTemas().size());
        this.tema = this.getTemas().remove(indice);
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
    public List<Tema> getTemas() {
        return this.temas;
    }
    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }
}