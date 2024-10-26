package model;

public interface DAO<T> {
    void insertar(T entidad);
    void actualizar(T entidad);
    void eliminar(int id);
    T buscarPorId(int id);
    List<T> buscarTodos();
}
