package model.ABM;
import java.util.List;


public interface DAO<T> {
    void insertar(T entidad);
    void modificar(int id, T entidad);
    void eliminar(int id);
    //T buscarPorId(int id);
    List<T> buscarTodos();
    List<T> buscarObjeto(String nombreColumna, Object tipo);
    
    static String setQuery(String nombreColumna, Object tipo){

        if (tipo instanceof String) {
            return "SELECT * FROM tema WHERE " + nombreColumna + " LIKE ?";
        } else if (tipo instanceof Integer) {
            return "SELECT * FROM tema WHERE " + nombreColumna + " = ? ";
        } else {
            throw new IllegalArgumentException("Tipo de dato no soportado: " + tipo.getClass());
        }
    }

}
