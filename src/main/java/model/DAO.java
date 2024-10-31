package model;
import java.util.List;


public interface DAO<T> {
    void insertar(T entidad);
    void modificar(int id, T entidad);
    void eliminar(int id);
    //T buscarPorId(int id);
    List<T> buscarTodos();
    List<T> buscarObjeto(String nombreColumna, Object tipo);
}
