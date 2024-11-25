package controller;

import model.ABM.PreguntaOpcionDAO;
import model.ABM.PreguntasDAO;
import raven.toast.Notifications;
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
    private String pregunta = null;
    private String tipoPregunta = null;

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

        this.vista.getBtnSalir().addActionListener(e->{preguntas();});

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
                        Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Pregunta eliminada exitosamente");
						Notifications.getInstance().setJFrame(vista);
                        this.vista.actualizarTabla();
                    } catch (NumberFormatException ex) {
                    	Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Error al convertir el ID de la pregunta a un número");
						Notifications.getInstance().setJFrame(vista);
                    }
                } else {
                	Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Seleccione una p a eliminar");
					Notifications.getInstance().setJFrame(vista);
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
            pregunta = this.vista.getTable().getValueAt(filaSeleccionada, 1).toString();
            tipoPregunta = this.vista.getTable().getValueAt(filaSeleccionada, 2).toString();
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
    
    public void preguntas() {
        DefaultTableModel modelo = vista.getTablaNueva();
        int aproximacion = 0, opcion = 0;
        
        for (int i = 0; i < modelo.getRowCount(); i++) {
			Object tipoPregunta = modelo.getValueAt(i, 2);
			String preg = tipoPregunta.toString();

			if (preg == "Aproximacion") {
				aproximacion++;
			} else if (preg == "Opcion multiple") {
				opcion++;
			}
		}
        if (aproximacion < 18 && opcion < 2 ) { //si no cumple
			Notifications.getInstance().show(Notifications.Type.INFO, Notifications.Location.TOP_CENTER, "Tiene que tener 18 de Opcion y 2 de Aproximacion");
			Notifications.getInstance().setJFrame(vista);
		} else {
			this.vista.setVisible(false);
			new ControladorModCategoria();
		}
        
    }


    public Integer getId_categoria(){
        return this.id_categoria;
    }

	public VistaModPreguntas getVista() {
		return vista;
	}

	public String getPregunta() {
		return pregunta;
	}

	public String getTipoPregunta() {
		return tipoPregunta;
	}

}