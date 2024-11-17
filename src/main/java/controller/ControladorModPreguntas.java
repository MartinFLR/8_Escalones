package controller;

import model.ABM.PreguntaOpcionDAO;
import model.ABM.PreguntasDAO;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Respuesta;
import view.VistaCreacionPreguntas;
import view.VistaModPreguntas;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorModPreguntas {

    private VistaModPreguntas vista;
    private Integer id_categoria;
    private Integer id_pregunta;

    public ControladorModPreguntas(){
        this.vista = new VistaModPreguntas(this);
        this.vista.setVisible(true);
        botones();
    }

    public void botones() {

        vista.getTable().getSelectionModel().addListSelectionListener(e->{
            this.vista.getBtnEditar().setEnabled(true);
            this.vista.getBtnBorrar().setEnabled(true);
        });

// Si no vas a usar los ActionListeners de los botones de Borrar y Editar, quítalos o agrégales funcionalidad
        this.vista.getBtnBorrar().addActionListener(e -> {
            JDialog dialogoEliminar = new JDialog();
            dialogoEliminar.setSize(300, 150);
            dialogoEliminar.setLayout(new GridLayout(3, 1));
            dialogoEliminar.setLocationRelativeTo(null);
            dialogoEliminar.setModal(true);

            JLabel lblEliminar = new JLabel("¿Esta seguro de eliminar la Pregunta?");
            JButton btnAceptar = new JButton("Aceptar");
            JButton btnSalir = new JButton("Salir");

            btnAceptar.addActionListener(ev -> {
                int filaSeleccionada = this.vista.getTable().getSelectedRow();
                if (filaSeleccionada != -1) {
                    try {
                        int idCategoria = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
                        System.out.println(idCategoria);

                        PreguntasDAO preguntasDAO = new PreguntasDAO();

                        preguntasDAO.eliminar(idCategoria);

                        dialogoEliminar.dispose();
                        JOptionPane.showMessageDialog(this.vista, "Pregunta eliminada");
                        this.vista.actualizarTabla();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this.vista, "Error al convertir el ID de la pregunta a un número.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(this.vista, "Por favor, seleccione una fila para eliminar.");
                }
            });


            btnSalir.addActionListener(ev -> {
                dialogoEliminar.setVisible(false);
            });

            dialogoEliminar.add(lblEliminar);
            dialogoEliminar.add(btnAceptar);
            dialogoEliminar.add(btnSalir);
            dialogoEliminar.setVisible(true);
        });


        this.vista.getBtnCrear().addActionListener(e -> {
            new ControladorCreacionPreguntas(id_categoria);
        });

        this.vista.getBtnEditar().addActionListener(e -> {
            int filaSeleccionada = this.vista.getTable().getSelectedRow();
            int idPregunta = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());

            new ControladorCreacionPreguntas(id_categoria,idPregunta);
        });


    }



    public void setId_pregunta(int id_categoria) {
        this.id_categoria = id_categoria;
        System.out.println("Hola soy controladorMod Preguntas "+id_categoria);
    }
}