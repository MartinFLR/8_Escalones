package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Respuesta;

public class PreguntasDAO implements DAOPreguntas<Preguntas>{

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

    public void insertar(Preguntas preguntaObj, List<Respuesta> listaRespuestas) {
        String tipoPreg = preguntaObj.getTipo_preg();
        switch (tipoPreg) {
            case "Aproximacion": {
                PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();
                preguntaAproximacionDAO.insertar((PreguntaAproximacion) preguntaObj, listaRespuestas);
                break;
            }
            case "Opcion multiple": {
                PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
                preguntaOpcionDAO.insertar((PreguntaOpcion) preguntaObj, listaRespuestas);
                break;
            }
            default: {
                System.out.println("Tipo de pregunta no reconocido: " + tipoPreg);
            }
        }
    }

    public void modificar(int id, Preguntas preguntaObj, List<Respuesta> listaRespuestas) {

        switch (preguntaObj.getTipo_preg()) {
            case "Aproximacion": {
                PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();
                preguntaAproximacionDAO.modificar(id,(PreguntaAproximacion) preguntaObj,listaRespuestas);
                break;
            }
            case "Opcion multiple": {
                PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
                preguntaOpcionDAO.modificar(id,(PreguntaOpcion) preguntaObj, listaRespuestas);
                break;
            }
            default: {
                System.out.println("Tipo de pregunta no reconocido: " );
            }
        }

    }

    @Override
    public List<Preguntas> busqueda(String palabra, int id_tema) {

        PreguntaOpcionDAO preguntaOpcionDAO = new PreguntaOpcionDAO();
        PreguntaAproximacionDAO preguntaAproximacionDAO = new PreguntaAproximacionDAO();

        List<PreguntaAproximacion> listaPreguntaAproximacion = preguntaAproximacionDAO.busqueda(palabra, id_tema);
        List<PreguntaOpcion> listaPreguntaOp = preguntaOpcionDAO.busqueda(palabra, id_tema);
        List<Preguntas> listaPreguntas = new ArrayList<>();

        listaPreguntas.addAll(listaPreguntaOp);
        listaPreguntas.addAll(listaPreguntaAproximacion);

        eliminarRepetidos(listaPreguntas);

        return listaPreguntas;
    }

    private void eliminarRepetidos(List<Preguntas> listaPreguntas) {
        Set<Integer> seenIds = new HashSet<>();
        List<Preguntas> listaSinDuplicados = listaPreguntas.stream()
                .filter(pregunta -> seenIds.add(pregunta.getId_pregunta()))
                .collect(Collectors.toList());
        listaPreguntas.clear();
        listaPreguntas.addAll(listaSinDuplicados);
    }


}
