package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import controller.ControladorModPreguntas;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Respuesta;

public class PreguntasDAO implements DAO<Preguntas>{

    private ArrayList<Preguntas> preguntas = new ArrayList<>();
    private ControladorModPreguntas c;

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

            PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
            PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();

            List<PreguntaAproximacion> listaPreguntaAproximacion = preguntaAproximacionDAO.buscarTodos();
            List<PreguntaOpcion> listaPreguntaOp = preguntaOpcionDAO.buscarTodos();
            List<Preguntas> listaPreguntas = new ArrayList<>();

            listaPreguntas.addAll(listaPreguntaOp);
            listaPreguntas.addAll(listaPreguntaAproximacion);

            return listaPreguntas;
    }

    @Override
    public void eliminar(int id) {
        String query = "DELETE FROM preguntas WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta eliminada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada.");
            }
        } catch (SQLException e) {
            System.err.println("Error al eliminar la pregunta: " + e.getMessage());
        }
        
    }

    @Override
    public void insertar(Preguntas entidad) {


        
    }

    public void crearPregunta(Preguntas preguntaObj, List<Respuesta> listaRespuestas) {
        String tipoPreg = preguntaObj.getTipo_preg();
        switch (tipoPreg) {
            case "Aproximacion": {
                PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();
                preguntaAproximacionDAO.crearPregunta((PreguntaAproximacion) preguntaObj, listaRespuestas);
                break;
            }
            case "Opcion multiple": {
                PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
                preguntaOpcionDAO.crearPregunta((PreguntaOpcion) preguntaObj, listaRespuestas);
                break;
            }
            default: {
                System.out.println("Tipo de pregunta no reconocido: " + tipoPreg);
            }
        }
    }


    @Override
    public void modificar(int id, Preguntas preguntaObj) {

        switch (preguntaObj.getTipo_preg()) {
            case "Aproximacion": {
                PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();

                break;
            }
            case "Opcion multiple": {
                PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();

                break;
            }
            default: {
                System.out.println("Tipo de pregunta no reconocido: " );
            }
        }
        
    }

    public void modificarPregunta(int id, Preguntas preguntaObj, List<Respuesta> listaRespuestas) {

        switch (preguntaObj.getTipo_preg()) {
            case "Aproximacion": {
                PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();
                preguntaAproximacionDAO.modificarPregunta(id,(PreguntaAproximacion) preguntaObj,listaRespuestas);
                break;
            }
            case "Opcion multiple": {
                PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
                preguntaOpcionDAO.modificarPregunta(id,(PreguntaOpcion) preguntaObj, listaRespuestas);
                break;
            }
            default: {
                System.out.println("Tipo de pregunta no reconocido: " );
            }
        }

    }

    @Override
    public List<Preguntas> busqueda(String palabra) {

        PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
        PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();

        List<PreguntaAproximacion> listaPreguntaAproximacion = preguntaAproximacionDAO.busqueda(palabra);
        List<PreguntaOpcion> listaPreguntaOp = preguntaOpcionDAO.busqueda(palabra);
        List<Preguntas> listaPreguntas = new ArrayList<>();

        listaPreguntas.addAll(listaPreguntaOp);
        listaPreguntas.addAll(listaPreguntaAproximacion);

        return listaPreguntas;
    }


    

}
