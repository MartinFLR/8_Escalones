package model;

public class Tema {
    private int id_tema;
    private String nombre_tema;

    public Tema(int id, String nombre) {
        this.id_tema = id;
        this.nombre_tema = nombre;
    }

    // Getters y Setters
    public int getId() {
        return id_tema;
    }

    public void setId(int id) {
        this.id_tema = id;
    }

    public String getNombre() {
        return nombre_tema;
    }

    public void setNombre(String nombre) {
        this.nombre_tema = nombre;
    }

    // Conversion de un tema a una línea de texto
    public String toFileString() {
        return this.id_tema + "," + this.nombre_tema;
    }

    // Conversion de una línea de texto a un tema
    public static Tema fromFileString(String line) {
        String[] parts = line.split(",");
        return new Tema(Integer.parseInt(parts[0]), parts[1]);
    }
}
