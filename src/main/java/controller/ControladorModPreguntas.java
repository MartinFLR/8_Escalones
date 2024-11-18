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
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ControladorModPreguntas {

    private VistaModPreguntas vista;
    private Integer id_categoria;
    private PreguntasDAO preguntasDAO;
	private int numerocategoria;

    // public ControladorModPreguntas(int id_categoria){
    //     this.vista = new VistaModPreguntas(this);

    public ControladorModPreguntas(int categoria){
        this.id_categoria=categoria;
        this.vista = new VistaModPreguntas(this);
        this.numerocategoria = id_categoria;
        this.vista.setVisible(true);
        botones();
        this.numerocategoria = categoria;
        
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
                        int idPregunta = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
                        System.out.println(idPregunta);

                        PreguntasDAO preguntasDAO = new PreguntasDAO();

                        preguntasDAO.eliminar(idPregunta);

                        dialogoEliminar.dispose();
                        JOptionPane.showMessageDialog(this.vista, "Pregunta eliminada");
                        actualizarTabla();
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
            new ControladorCreacionPreguntas(this.id_categoria,this);
            actualizarTabla();
        });

        this.vista.getBtnEditar().addActionListener(e -> {
            int filaSeleccionada = this.vista.getTable().getSelectedRow();
            int idPregunta = Integer.parseInt(this.vista.getTable().getValueAt(filaSeleccionada, 0).toString());
            System.out.println("Estoy llamando al COntroladorCreacionPreguntas con el idCategoria:"+ id_categoria +" y la idPregunta: "+idPregunta);
            new ControladorCreacionPreguntas(this.id_categoria,idPregunta);
            actualizarTabla();
        });


        this.vista.getBtnSalir().addActionListener(e->{
        	this.vista.setVisible(false);
        });
    }
    
	public void actualizarTabla() {
		// Limpiar el modelo de la tabla antes de agregar nuevas filas
		List<Preguntas> listaPreguntas = preguntasDAO.buscarTodos();

		this.vista.getTablaNueva().setRowCount(0); // Limpia las filas existentes

		// Agregar filas a la tabla desde la lista de preguntas
		for (Preguntas pregunta : listaPreguntas) {
			// Asegúrate de que los métodos getId_pregunta() y getPregunta() existan en la
			// clase Preguntas
			if(pregunta.getIdTema()==this.numerocategoria){
				Object[] row = { pregunta.getId_pregunta(), pregunta.getPregunta() };
				this.vista.getTablaNueva().addRow(row);
			}
		}

		// Establecer el modelo de la tabla actualizado
		this.vista.getTable().setModel(this.vista.getTablaNueva());
		this.vista.getTable().setDefaultEditor(Object.class, null);
		this.vista.getTable().getTableHeader().setReorderingAllowed(false);
		this.vista.getTable().getTableHeader().setResizingAllowed(false);
		this.vista.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
		this.vista.getTable().getColumnModel().getColumn(0).setMinWidth(0);
		this.vista.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
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