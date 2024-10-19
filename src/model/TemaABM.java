package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TemaABM {
    //Singleton
    private static TemaABM instance;
    private static final String FILE_PATH = "temas.txt";

    public static synchronized TemaABM getInstance() {
        if (instance == null) {
            instance = new TemaABM();
        }
        return instance;
    }

    public void agregarTema(Tema tema) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(tema.toFileString());
            writer.newLine();
            System.out.println("Tema agregado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public List<Tema> listarTemas() {
        List<Tema> temas = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                temas.add(Tema.fromFileString(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return temas;
    }


    public void eliminarTema(int id) {
        List<Tema> temas = listarTemas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Tema tema : temas) {
                if (tema.getId() != id) {
                    writer.write(tema.toFileString());
                    writer.newLine();
                }
            }
            System.out.println("Tema eliminado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void modificarTema(int id, Tema nuevoTema) {
        List<Tema> temas = listarTemas();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Tema tema : temas) {
                if (tema.getId() == id) {
                    writer.write(nuevoTema.toFileString()); // Escribir el nuevo tema
                } else {
                    writer.write(tema.toFileString());
                }
                writer.newLine();
            }
            System.out.println("Tema modificado con éxito.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
