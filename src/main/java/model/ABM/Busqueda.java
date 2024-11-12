// package model.ABM;

// import java.lang.reflect.Field;
// import java.sql.Connection;
// import java.sql.PreparedStatement;
// import java.sql.ResultSet;
// import java.sql.SQLException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.List;
// import java.util.Map;

// import model.PreguntaOpcion;
// import model.Tema;

// public class Busqueda {


//     // public List<Object> busqueda (Object palabra){
//     //     Object[] clases = {TemasDAO.getInstance(), PreguntaAproximacionDAO.getInstance(), PreguntaOpcionDAO.getInstance(), ParticipantesDAO.getInstance() };
//     //     for (Object o : clases) {
            
        
//     //     return switch (o) {
//     //         case TemasDAO: List<Temas> temas = new ArrayList<>();
                      
                
//     //             break;
        
//     //         default:
//     //             break;
//     //     }
//     // }
//     // }



//     // public List<Tema> buscarObjeto(String nombreColumna, Object tipo) {
//     //     List<Tema> temas = new ArrayList<>();
//     //     String query = DAO.setQuery(nombreColumna, tipo);

//     //     try (Connection conn = Database.getInstance().getConnection();
//     //             PreparedStatement pstmt = conn.prepareStatement(query)) {
//     //         if (tipo instanceof String) {
//     //             pstmt.setString(1, "%" +  tipo + "%");
//     //         } else if (tipo instanceof Integer) {
//     //             pstmt.setInt(1, (Integer) tipo);
//     //         } else {
//     //             throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo.getClass());
//     //         }

//     //         System.out.println("Consulta ejecutada: " + query);
//     //         try (ResultSet resultSet = pstmt.executeQuery()) {

//     //             while (resultSet.next()) {
//     //                 Tema tema = new Tema(
//     //                         resultSet.getInt("id_tema"),
//     //                         resultSet.getString("nombre_tema"));
//     //                 temas.add(tema);
//     //             }
//     //         }

//     //     } catch (SQLException e) {
//     //         System.err.println("Error al listar temas: " + e.getMessage());

//     //     } catch (IllegalArgumentException e) {
//     //         System.out.println(e.getMessage());
//     //     }

//     //     return temas;
//     // }\\


//     import java.sql.*;
// import java.util.ArrayList;
// import java.util.List;

// public class BuscarEnColumnasConTipos {

//     private static final String URL = "jdbc:postgresql://localhost:5432/tu_base_de_datos";
//     private static final String USUARIO = "tu_usuario";
//     private static final String CONTRASENA = "tu_contraseña";

//     public static void main(String[] args) {
//         Object datoABuscar = 123; // Puede ser String, Integer, Double, etc.
//         buscarEnTodasLasColumnas(datoABuscar, "mi_tabla");
//     }

//     public static void buscarEnTodasLasColumnas(Object dato, String nombreTabla) {
//         if (dato == null) {
//             System.out.println("El valor de búsqueda no puede ser null.");
//             return;
//         }

//         try (Connection conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA)) {
//             // Obtiene los nombres y tipos de las columnas
//             List<ColumnaInfo> columnas = obtenerNombresYTiposDeColumnas(conexion, nombreTabla);
//             if (columnas.isEmpty()) {
//                 System.out.println("No se encontraron columnas en la tabla.");
//                 return;
//             }

//             // Construye la consulta SQL dinámicamente según el tipo de cada columna
//             StringBuilder consultaBuilder = new StringBuilder("SELECT * FROM " + nombreTabla + " WHERE ");
//             for (int i = 0; i < columnas.size(); i++) {
//                 ColumnaInfo columna = columnas.get(i);

//                 // Usamos LIKE para texto y = para tipos numéricos
//                 if (columna.tipo.equals("CHAR") || columna.tipo.equals("VARCHAR") || columna.tipo.equals("TEXT")) {
//                     consultaBuilder.append(columna.nombre).append(" LIKE ?");
//                 } else {
//                     consultaBuilder.append(columna.nombre).append(" = ?");
//                 }

//                 if (i < columnas.size() - 1) {
//                     consultaBuilder.append(" OR ");
//                 }
//             }

//             String consulta = consultaBuilder.toString();

//             try (PreparedStatement sentencia = conexion.prepareStatement(consulta)) {
//                 // Asigna el parámetro de búsqueda en cada posición, según el tipo de columna
//                 for (int i = 0; i < columnas.size(); i++) {
//                     ColumnaInfo columna = columnas.get(i);
                    
//                     if (columna.tipo.equals("CHAR") || columna.tipo.equals("VARCHAR") || columna.tipo.equals("TEXT")) {
//                         sentencia.setString(i + 1, "%" + dato.toString() + "%");
//                     } else if (dato instanceof Number) {
//                         sentencia.setObject(i + 1, dato);
//                     } else {
//                         // Si el tipo de dato es incompatible con el tipo de columna, establece null
//                         sentencia.setNull(i + 1, Types.NULL);
//                     }
//                 }

//                 // Ejecuta la consulta y muestra los resultados
//                 try (ResultSet resultados = sentencia.executeQuery()) {
//                     while (resultados.next()) {
//                         System.out.println("Resultado encontrado:");
//                         for (ColumnaInfo columna : columnas) {
//                             System.out.print(columna.nombre + ": " + resultados.getString(columna.nombre) + " | ");
//                         }
//                         System.out.println();
//                     }
//                 }
//             }
//         } catch (SQLException e) {
//             System.out.println("Error al buscar en la base de datos: " + e.getMessage());
//         }
//     }

//     // Método para obtener nombres y tipos de columnas de una tabla
//     private static List<ColumnaInfo> obtenerNombresYTiposDeColumnas(Connection conexion, String nombreTabla) throws SQLException {
//         List<ColumnaInfo> columnas = new ArrayList<>();
//         DatabaseMetaData metaData = conexion.getMetaData();
//         try (ResultSet columnasResult = metaData.getColumns(null, null, nombreTabla, null)) {
//             while (columnasResult.next()) {
//                 String nombreColumna = columnasResult.getString("COLUMN_NAME");
//                 String tipoColumna = columnasResult.getString("TYPE_NAME").toUpperCase();
//                 columnas.add(new ColumnaInfo(nombreColumna, tipoColumna));
//             }
//         }
//         return columnas;
//     }

//     // Clase auxiliar para almacenar información de columnas
//     static class ColumnaInfo {
//         String nombre;
//         String tipo;

//         ColumnaInfo(String nombre, String tipo) {
//             this.nombre = nombre;
//             this.tipo = tipo;
//         }
//     }
// }




// }
