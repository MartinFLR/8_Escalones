package model;

public class Admin {
    int id;
    String nombre;
    String contrasenia;

    public Admin(String nombre, String contrasenia) {
        this.id = 1;
        this.nombre = nombre;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getContrasenia() {
        return contrasenia;
    }
}
