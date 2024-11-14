package model;

public class Admin {
    int id_admin;
    String nombre_admin;
    String contrasenia_admin;

    public Admin(String nombre, String contrasenia) {
        this.id_admin = 1;
        this.nombre_admin = nombre;
        this.contrasenia_admin = contrasenia;
    }

    public int getId() {
        return id_admin;
    }

    public String getNombre() {
        return nombre_admin;
    }

    public String getContrasenia() {
        return contrasenia_admin;
    }
}
