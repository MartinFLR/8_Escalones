package model.ABM;

import model.Respuesta;

import java.util.List;

public interface DAOPreguntas<T> {
    void insertar(T entidad,List<Respuesta> lista);
    void modificar(int id, T entidad,List<Respuesta> lista);
    void eliminar(int id);
    List<T> buscarTodos();
    List<T> busqueda(String palabra,int id_tema);
}
