package model;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ParticipanteABM {
    private static ParticipanteABM instance;
    private static final String FILE_PATH = "participantes.txt";

    public static synchronized ParticipanteABM getInstance() {
        if (instance == null) {
            instance = new ParticipanteABM();
        }
        return instance;
    }

    public void agregarParticipante(Participante participante) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(participante.toFileString());
            writer.newLine();
            System.out.println("Participante agregado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

    public List<Participante> listarParticipantes() {
        List<Participante> participantes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                participantes.add(Participante.fromFileString(line));
            }
        } catch (IOException e) {
            System.err.println("Error al listar participantes: " + e.getMessage());
        }
        return participantes;
    }

    public void eliminarParticipante(int id) {
        List<Participante> participantes = listarParticipantes();
        boolean eliminado = false; 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Participante participante : participantes) {
                if (participante.getId() != id) {
                    writer.write(participante.toFileString());
                    writer.newLine();
                } else {
                    eliminado = true; 
                }
            }
            if (eliminado) {
                System.out.println("Participante eliminado con éxito.");
            } else {
                System.out.println("No se encontró el participante con ID: " + id);
            }
        } catch (IOException e) {
            System.err.println("Error al eliminar participante: " + e.getMessage());
        }
    }

    public void modificarParticipante(int id, Participante nuevoParticipante) {
        List<Participante> participantes = listarParticipantes();
        boolean encontrado = false; 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (Participante participante : participantes) {
                if (participante.getId() == id) {
                    writer.write(nuevoParticipante.toFileString()); 
                    encontrado = true; 
                } else {
                    writer.write(participante.toFileString());
                }
                writer.newLine();
            }
            if (encontrado) {
                System.out.println("Participante modificado con éxito.");
            } else {
                System.out.println("No se encontró el participante con ID: " + id);
            }
        } catch (IOException e) {
            System.err.println("Error al modificar participante: " + e.getMessage());
        }
    }
}
