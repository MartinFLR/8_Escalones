package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PreguntaABM {

    // Singleton
    private static PreguntaABM instance;
    private static final String FILE_PATH = "preguntas.txt";

    public static synchronized PreguntaABM getInstance() {
        if (instance == null) {
            instance = new PreguntaABM();
        }
        return instance;
    }

    public void agregarPregunta(Pregunta pregunta) {
        if (pregunta == null || !esPreguntaValida(pregunta)) {
            System.out.println("Pregunta no válida.");
            return;
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(pregunta.toFileString());
            writer.newLine();
            System.out.println("Pregunta agregada con éxito.");
        } catch (IOException e) {
            System.err.println("Error al agregar la pregunta en agregarPregunta: " + e.getMessage());
        }
    }

    public List<Pregunta> listarPreguntas() {
        List<Pregunta> preguntas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                preguntas.add(Pregunta.fromFileString(linea));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al listar las preguntas en listarPreguntas: " + e.getMessage());
        }
        return preguntas;
    }

    public List<String> listarPreguntasConTemas() {
        List<String> preguntasConTemas = new ArrayList<>();
        TemaABM temaABM = TemaABM.getInstance();
        List<Tema> temas = temaABM.listarTemas();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                Pregunta pregunta = Pregunta.fromFileString(linea);
                // Búsqueda del tema
                Tema tema = temas.stream()
                    .filter(t -> t.getId() == pregunta.getIdTema())
                    .findFirst()
                    .orElse(null);

                String nombreTema = (tema != null) ? tema.getNombre() : "Tema desconocido";
                preguntasConTemas.add(String.format("ID: %d, Pregunta: %s, Opción A: %s, Opción B: %s, Opción C: %s, Opción D: %s, Respuesta Correcta: %s, ID_Tema: %d, Tema: %s",
                        pregunta.getId(), pregunta.getPregunta(), pregunta.getOpcionA(), pregunta.getOpcionB(),
                        pregunta.getOpcionC(), pregunta.getOpcionD(), pregunta.getRespuestaCorrecta(),
                        (tema != null) ? tema.getId() : -1, nombreTema));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Archivo no encontrado: " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Error al listar las preguntas en listarPreguntasConTemas: " + e.getMessage());
        }
        return preguntasConTemas;
    }

    public void eliminarPregunta(int id) {
        List<Pregunta> preguntas = listarPreguntas();
        boolean encontrado = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Pregunta pregunta : preguntas) {
                if (pregunta.getId() != id) {
                    writer.write(pregunta.toFileString());
                    writer.newLine();
                } else {
                    encontrado = true;
                }
            }
            if (encontrado) {
                System.out.println("Pregunta eliminada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada.");
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar la pregunta en eliminarPregunta: " + e.getMessage());
        }
    }

    public void modificarPregunta(int id, Pregunta nuevaPregunta) {
        if (nuevaPregunta == null || !esPreguntaValida(nuevaPregunta)) {
            System.out.println("Nueva pregunta no válida.");
            return;
        }
        List<Pregunta> preguntas = listarPreguntas();
        boolean encontrado = false;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Pregunta pregunta : preguntas) {
                if (pregunta.getId() == id) {
                    writer.write(nuevaPregunta.toFileString()); 
                    encontrado = true; 
                } else {
                    writer.write(pregunta.toFileString());
                }
                writer.newLine();
            }
            if (encontrado) {
                System.out.println("Pregunta modificada con éxito.");
            } else {
                System.out.println("Pregunta no encontrada para modificar.");
            }
        } catch (IOException e) {
            System.err.println("Error al modificar la pregunta en modificarPregunta: " + e.getMessage());
        }
    }

    private boolean esPreguntaValida(Pregunta pregunta) {
        return pregunta.getId() > 0 && pregunta.getPregunta() != null && !pregunta.getPregunta().isEmpty();
    }
}
