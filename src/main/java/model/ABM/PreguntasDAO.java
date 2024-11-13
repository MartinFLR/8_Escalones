package model.ABM;

import java.util.ArrayList;
import java.util.List;

import model.PreguntaOpcion;
import model.Preguntas;

public abstract class PreguntasDAO implements DAO<Preguntas>{

    private ArrayList<Preguntas> preguntas = new ArrayList<>();
    
    public void agregaPreguntas(Preguntas p){
        this.preguntas.add(p);
    }

    public void recorrePreguntas(){
        for (Preguntas p : preguntas) {
            p.imprimirPregunta();
        }
    }

    @Override
    public List<Preguntas> buscarTodos() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void eliminar(int id) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void insertar(Preguntas entidad) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void modificar(int id, Preguntas entidad) {
        // TODO Auto-generated method stub
        
    }

    

}
