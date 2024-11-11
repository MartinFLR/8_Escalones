package model.ABM;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import model.PreguntaOpcion;

public class PreguntaOpcionDAO implements DAO<PreguntaOpcion> {

    private static PreguntaOpcionDAO instance;

    public static synchronized PreguntaOpcionDAO getInstance() {
        if (instance == null) {
            instance = new PreguntaOpcionDAO();
        }
        return instance;
    }

    @Override
    public void insertar(PreguntaOpcion pregunta) {
        String sql = "INSERT INTO preguntas (pregunta, id_tema, id_tipopregunta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, pregunta.getPregunta());
            pstmt.setInt(2, pregunta.getIdTema());
            pstmt.setInt(3, 1); // Suponiendo que el id_tipopregunta es 1 para preguntas de opción, ajusta esto
                                // según sea necesario

            pstmt.executeUpdate();
            
            
            System.out.println("Pregunta agregada exitosamente.");

        } catch (SQLException e) {
            System.out.println("Error al agregar la pregunta: " + e.getMessage());
        }
    }

<<<<<<< .merge_file_HtJ7Tp
    public void insertarRespuestas(int idPregunta, String opcionA, String opcionB, String opcionC, String opcionD, String respuestaCorrecta) {
        String query = "INSERT INTO respuestas (respuesta, id_pregunta, respuesta_correcta) VALUES (?, ?, ?)";
    
        try (Connection connection = Database.getInstance().getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {
    
            // Insertar cada opción de respuesta
            insertarOpcion(statement, opcionA, idPregunta, opcionA.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionB, idPregunta, opcionB.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionC, idPregunta, opcionC.equals(respuestaCorrecta));
            insertarOpcion(statement, opcionD, idPregunta, opcionD.equals(respuestaCorrecta));
    
            System.out.println("Opciones de respuesta insertadas correctamente.");
    
=======
    private void insertarOpciones(int idPregunta, PreguntaOpcion pregunta) {
        String sql = "INSERT INTO respuestas (id_pregunta, respuesta, respuesta_correcta) VALUES (?, ?, ?)";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(sql)) {

            pstmt.setInt(1, idPregunta);
            pstmt.setString(2, pregunta.getOpcionA());
            pstmt.setBoolean(3, pregunta.getRespuestaCorrecta().equals(pregunta.getOpcionA())); // Ajusta esto según sea
                                                                                                // necesario

            pstmt.executeUpdate();
            // Repite para las otras opciones B, C y D
            // Aquí también puedes marcar la respuesta correcta, dependiendo de cómo quieras
            // almacenar esta información.
>>>>>>> .merge_file_H7Fl6N
        } catch (SQLException e) {
            System.err.println("Error al insertar las respuestas: " + e.getMessage());
        }
    }
<<<<<<< .merge_file_HtJ7Tp
    
    // Método auxiliar para insertar una opción de respuesta
    private void insertarOpcion(PreparedStatement statement, String opcion, int idPregunta, boolean esCorrecta) throws SQLException {
        statement.setString(1, opcion);
        statement.setInt(2, idPregunta);
        statement.setBoolean(3, esCorrecta);
        statement.executeUpdate();
    }
    
=======
>>>>>>> .merge_file_H7Fl6N

    @Override
    public List<PreguntaOpcion> buscarTodos() {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
        String query = "SELECT p.id_pregunta, p.pregunta, p.id_tema, r.respuesta, r.respuesta_correcta " +
<<<<<<< .merge_file_HtJ7Tp
                       "FROM preguntas p " +
                       "JOIN respuestas r ON p.id_pregunta = r.id_pregunta " +
                       "WHERE p.id_tipopregunta = 1 " +
                       "ORDER BY p.id_pregunta, r.id_respuesta";  // Ordenamos por pregunta y respuesta para agrupar correctamente
        
=======
                "FROM preguntas p " +
                "LEFT JOIN respuestas r ON p.id_pregunta = r.id_pregunta " +
                "WHERE p.id_tipopregunta = 1";

>>>>>>> .merge_file_H7Fl6N
        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement pstmt = connection.prepareStatement(query);
                ResultSet resultSet = pstmt.executeQuery()) {

            Map<Integer, PreguntaOpcion> preguntaMap = new HashMap<>();

            while (resultSet.next()) {
                int idPregunta = resultSet.getInt("id_pregunta");
                String preguntaTexto = resultSet.getString("pregunta");
                int idTema = resultSet.getInt("id_tema");
<<<<<<< .merge_file_HtJ7Tp
                String respuesta = resultSet.getString("respuesta");
                boolean esCorrecta = resultSet.getBoolean("respuesta_correcta");
    
                // Obtener o crear la pregunta en el mapa
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta, 
                    new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "","", null, idTema));
    
                // Asignar cada respuesta a una de las opciones A, B, C o D
                if (pregunta.getOpcionA().isEmpty()) {
                    pregunta.setOpcionA(respuesta);
                } else if (pregunta.getOpcionB().isEmpty()) {
                    pregunta.setOpcionB(respuesta);
                } else if (pregunta.getOpcionC().isEmpty()) {
                    pregunta.setOpcionC(respuesta);
                } else if (pregunta.getOpcionD().isEmpty()) {
                    pregunta.setOpcionD(respuesta);
                }
    
                // Si es la respuesta correcta, almacenarla
                if (esCorrecta) {
                    pregunta.setRespuestaCorrecta(respuesta);
                }
    
                // Guardar o actualizar en el mapa
                preguntaMap.put(idPregunta, pregunta);
            }
    
            // Convertir el mapa en una lista
=======

                // Crear o recuperar la pregunta del mapa
                PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta,
                        new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "", "", idTema));

                // Obtener la respuesta y ver si es la correcta
                String respuesta = resultSet.getString("respuesta");
                boolean respuestaCorrecta = resultSet.getBoolean("respuesta_correcta");

                // Si la respuesta es correcta, la agregamos a la pregunta
                if (respuestaCorrecta) {
                    // Almacenamos la respuesta correcta en la pregunta
                    pregunta.setRespuestaCorrecta(respuesta); // Implementa este método en la clase PreguntaOpcion
                }

                // Almacenar la pregunta en el mapa
                preguntaMap.put(idPregunta, pregunta);
            }

            // Agregar todas las preguntas al listado
>>>>>>> .merge_file_H7Fl6N
            preguntas.addAll(preguntaMap.values());
    
        } catch (SQLException e) {
            System.err.println("Error al listar las preguntas: " + e.getMessage());
        }
    
        return preguntas;
    }
<<<<<<< .merge_file_HtJ7Tp
    
    
    
    
    
    
=======

>>>>>>> .merge_file_H7Fl6N
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
<<<<<<< .merge_file_HtJ7Tp
    
=======

>>>>>>> .merge_file_H7Fl6N
    @Override
    public void modificar(int id, PreguntaOpcion nuevaPregunta) {
        String query = "UPDATE preguntas SET pregunta = ?, id_tema = ? WHERE id_pregunta = ?";

        try (Connection connection = Database.getInstance().getConnection();
                PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, nuevaPregunta.getPregunta());
            statement.setInt(2, nuevaPregunta.getIdTema());
            statement.setInt(3, id);

            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Pregunta modificada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada para modificar.");
            }
        } catch (SQLException e) {
            System.err.println("Error al modificar la pregunta: " + e.getMessage());
        }
    }

    @Override
    public List<PreguntaOpcion> buscarObjeto(Object palabra) throws SQLException {
        List<PreguntaOpcion> preguntas = new ArrayList<>();
        try (Connection conn = Database.getInstance().getConnection()) {
            // columnas guardael nombre de las columnas de la base de datos de nombreTabla
            List<String> columnas = DAO.obtenerNombresColumnas(conn, "preguntas");
            StringBuilder sqlb = new StringBuilder("SELECT * FROM preguntas WHERE ");
            // append para ir agregando mas columnas en el condicional where
            for (int i = 0; i < columnas.size(); i++) {
                sqlb.append(columnas.get(i)).append(" = ?");
                if (i < columnas.size() - 1) {
                    sqlb.append(" OR ");
                }
            }
            String sql = sqlb.toString();
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                for (int i = 1; i <= columnas.size(); i++) {
                    pstmt.setObject(i, "%" + palabra + "%");
                }
                try (ResultSet rs = pstmt.executeQuery()) {
                    Map<Integer, PreguntaOpcion> preguntaMap = new HashMap<>();

                    while (rs.next()) {
                        int idPregunta = rs.getInt("id_pregunta");
                        String preguntaTexto = rs.getString("pregunta");
                        int idTema = rs.getInt("id_tema");

                        // Crear o recuperar la pregunta del mapa
                        PreguntaOpcion pregunta = preguntaMap.getOrDefault(idPregunta,
                                new PreguntaOpcion(idPregunta, preguntaTexto, "", "", "", "", "", idTema));

                        // Obtener la respuesta y ver si es la correcta
                        String respuesta = rs.getString("respuesta");
                        boolean respuestaCorrecta = rs.getBoolean("respuesta_correcta");

                        // Si la respuesta es correcta, la agregamos a la pregunta
                        if (respuestaCorrecta) {
                            // Almacenamos la respuesta correcta en la pregunta
                            pregunta.setRespuestaCorrecta(respuesta); // Implementa este método en la clase
                                                                      // PreguntaOpcion
                        }

                        // Almacenar la pregunta en el mapa
                        preguntaMap.put(idPregunta, pregunta);
                    }

                    // Agregar todas las preguntas al listado
                    preguntas.addAll(preguntaMap.values());
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar en la base de datos: " + e.getMessage());
        }
        return preguntas;
    }
}