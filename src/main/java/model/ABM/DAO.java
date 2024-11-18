package model.ABM;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public interface DAO<T> {
    void insertar(T entidad);
    void modificar(int id, T entidad);
    void eliminar(int id);
    //T buscarPorId(int id);
    List<T> buscarTodos();
    List<T> busqueda(String palabra,int id_tema);

    //  static List<String> obtenerNombresColumnas(Connection conexion, String nombreTabla) throws SQLException {
    //     List<String> columnas = new ArrayList<>();
    //     DatabaseMetaData md = conexion.getMetaData();
    //     try (ResultSet cr = md.getColumns(null, null, nombreTabla, null)) {
    //         while (cr.next()) {
    //             String nombreColumna = cr.getString("COLUMN_NAME");
    //             columnas.add(nombreColumna);
    //         }
    //         if (columnas.isEmpty()) {
    //             System.out.println("No se encontraron columnas en la tabla.");
                
    //         }
    //     }
    //     return columnas;
    // }

    // static String setQuery(String nombreColumna, Object tipo, String entidad){

    //     if (tipo instanceof String) {
    //         return "SELECT * FROM " + entidad + " WHERE " + nombreColumna + " LIKE ?";
    //     } else if (tipo instanceof Integer) {
    //         return "SELECT * FROM " + entidad + " WHERE " + nombreColumna + " = ? ";
    //     } else {
    //         throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo.getClass());
    //     }
    // }

}
