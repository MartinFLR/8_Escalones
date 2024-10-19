package model;

public class Participante {
    private int id;
    private String nombre;
    private int edad;
    private String email;

    public Participante(int id, String nombre, int edad, String email) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.email = email;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toFileString() {
        return this.id + "," + this.nombre + "," + this.edad + "," + this.email;
    }

    // Método estático para convertir una línea de texto a un Participante
    public static Participante fromFileString(String line) {
        String[] parts = line.split(",");
        return new Participante(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]), parts[3]);
    }
}