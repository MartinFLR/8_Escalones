package controller;

import model.ABM.PreguntaOpcionDAO;
import model.ABM.PreguntasDAO;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Preguntas;
import model.Respuesta;
import view.VistaCreacionPreguntas;
import view.VistaModPreguntas;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorModPreguntas {

    private VistaModPreguntas vista;
    private Integer id_categoria;

    // public ControladorModPreguntas(int id_categoria){
    //     this.vista = new VistaModPreguntas(this);

    public ControladorModPreguntas(int categoria){
        this.id_categoria=categoria;
        this.vista = new VistaModPreguntas(this);
        this.vista.setVisible(true);
        botones();
    }

    public void botones() {

        vista.getTable().getSelectionModel().addListSelectionListener(e->{
            this.vista.getBtnEditar().setEnabled(true);
            this.vista.getBtnBorrar().setEnabled(true);
        });

        this.vista.getBtnSalir().addActionListener(e->{
            this.vista.setVisible(false);
        });;

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
                        int idPregunta = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
                        System.out.println(idPregunta);

                        PreguntasDAO preguntasDAO = new PreguntasDAO();

                        preguntasDAO.eliminar(idPregunta);

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
            System.out.println("Estoy llamando al COntroladorCreacionPreguntas con el idCategoria:"+ id_categoria);
            new ControladorCreacionPreguntas(this.id_categoria, this);
            this.vista.actualizarTabla();
        });

        this.vista.getBtnEditar().addActionListener(e -> {
            int filaSeleccionada = this.vista.getTable().getSelectedRow();
            int idPregunta = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
            System.out.println("Estoy llamando al COntroladorCreacionPreguntas con el idCategoria:"+ id_categoria +" y la idPregunta: "+idPregunta);
            new ControladorCreacionPreguntas(this.id_categoria,idPregunta, this);
            this.vista.actualizarTabla();
        });
        
        this.vista.getTextBuscador().getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBusqueda();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBusqueda();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                actualizarBusqueda();
            }

            private void actualizarBusqueda() {
                String texto = vista.getTextBuscador().getText().trim();
                buscarEnBaseDeDatos(texto);;
            }

            private void buscarEnBaseDeDatos(String texto) {
                PreguntasDAO preg = new PreguntasDAO();
                List<Preguntas> resultados = preg.busqueda(texto,id_categoria);

                // Obtener el modelo de la tabla y limpiar las filas existentes
                DefaultTableModel modeloTabla = (DefaultTableModel) getVista().getTable().getModel();
                modeloTabla.setRowCount(0);

                // Agregar las filas de los resultados
                for (Preguntas pregunta : resultados) {
                    Object[] fila = { pregunta.getId_pregunta(), pregunta.getPregunta(),pregunta.getTipo_preg(),pregunta.getIdTema() };
                    modeloTabla.addRow(fila);
                }
            }
        });
    }

    public void setId_pregunta(int id_categoria) {
        this.id_categoria = id_categoria;
        System.out.println("Hola soy controladorMod Preguntas "+id_categoria);
    }

    public Integer getId_categoria(){
        return this.id_categoria;
    }

	public VistaModPreguntas getVista() {
		return vista;
	}
}