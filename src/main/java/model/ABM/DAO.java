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
}
