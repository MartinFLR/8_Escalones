package model;

public class Participante {
    private int id_participante;
    private String nombre_participante;
    private int edad_participante;

    public Participante(int id, String nombre, int edad) {
        this.id_participante = id;
        this.nombre_participante = nombre;
        this.edad_participante = edad;
    }

    // Constructor sin id para agregar participantes
    public Participante(String nombre, int edad) {
        this.nombre_participante = nombre;
        this.edad_participante= edad;
    }

    // Getters y Setters
    public int getId() {
        return id_participante;
    }

    public void setId(int id) {
        this.id_participante = id;
    }

    public String getNombre() {
        return nombre_participante;
    }

    public void setNombre(String nombre) {
        this.nombre_participante = nombre;
    }

    public int getEdad() {
        return edad_participante;
    }

    public void setEdad(int edad) {
        this.edad_participante = edad;
    }

}