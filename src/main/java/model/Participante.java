package model;

public class Participante {
    private int id;
    private String nombre;
    private int edad;

    public Participante(int id, String nombre, int edad) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
    }

    // Constructor sin id para agregar participantes
    public Participante(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
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


    public String toFileString() {
        return this.id + "," + this.nombre + "," + this.edad + ",";
    }

    // Método estático para convertir una línea de texto a un Participante
    public static Participante fromFileString(String line) {
        String[] parts = line.split(",");
        return new Participante(Integer.parseInt(parts[0]), parts[1], Integer.parseInt(parts[2]));
    }
}