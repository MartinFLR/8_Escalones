package model.ABM;

import java.util.ArrayList;
import java.util.List;
import model.Preguntas;

public abstract class PreguntasDAO  {

    private ArrayList<Preguntas> preguntas = new ArrayList<>();
    
    public void agregaPreguntas(Preguntas p){
        this.preguntas.add(p);
    }

    public void recorrePreguntas(){
        for (Preguntas p : preguntas) {
            p.imprimirPregunta();
        }
    }

}
