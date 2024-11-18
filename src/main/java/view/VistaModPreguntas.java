package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.ControladorModCategoria;
import controller.ControladorCreacionPreguntas;
import controller.ControladorModPreguntas;
import model.ABM.PreguntasDAO;
import model.Preguntas;

public class VistaModPreguntas extends VistaModPadre {
	private String encabezado[] = { "ID", "Preguntas" };
	private DefaultTableModel tablaNueva = new DefaultTableModel(null, encabezado);
	private int numerocategoria;
	private PreguntasDAO preguntasDAO = new PreguntasDAO();;

	public VistaModPreguntas(ControladorModPreguntas c) {
		this.numerocategoria=c.getId_categoria();
		actualizarTabla();
		setVisible(true);
		botones();
	}

	public void actualizarTabla() {
		// Limpiar el modelo de la tabla antes de agregar nuevas filas
		List<Preguntas> listaPreguntas = preguntasDAO.buscarTodos();

		tablaNueva.setRowCount(0); // Limpia las filas existentes

		// Agregar filas a la tabla desde la lista de preguntas
		for (Preguntas pregunta : listaPreguntas) {
			// Asegúrate de que los métodos getId_pregunta() y getPregunta() existan en la
			// clase Preguntas
			if(pregunta.getIdTema()==this.numerocategoria){
				Object[] row = { pregunta.getId_pregunta(), pregunta.getPregunta() };
				tablaNueva.addRow(row);
			}
		}

		// Establecer el modelo de la tabla actualizado
		this.getTable().setModel(tablaNueva);
		this.getTable().setDefaultEditor(Object.class, null);
		this.getTable().getTableHeader().setReorderingAllowed(false);
		this.getTable().getTableHeader().setResizingAllowed(false);
		this.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
		this.getTable().getColumnModel().getColumn(0).setMinWidth(0);
		this.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	}

	public void botones() {
		// Si no vas a usar los ActionListeners de los botones de Borrar y Editar,
		// quítalos o agrégales funcionalidad
		this.getBtnBorrar().addActionListener(null);
		this.getBtnCrear().addActionListener(e -> {
			int filaSeleccionada = this.getTable().getSelectedRow();
			if (filaSeleccionada != -1) { // Verifica que haya una fila seleccionada
				// Obtén el ID o cualquier otro dato necesario de la fila seleccionada
				Integer idPregunta = (Integer) this.getTable().getValueAt(filaSeleccionada, 0); // Asumiendo que la
																								// columna 0 tiene el ID

				// Pasa el ID o datos al controlador
				new ControladorCreacionPreguntas(idPregunta);
			} else {
				// Muestra un mensaje si no se ha seleccionado ninguna fila
				javax.swing.JOptionPane.showMessageDialog(this, "Por favor, selecciona una pregunta de la tabla.");
			}
		});
		this.getBtnEditar().addActionListener(null);
		this.getBtnSalir().addActionListener(e -> {
			setVisible(false);
			c.getVista().setVisible(true);
		});
	}

	public DefaultTableModel getTablaNueva() {
		return tablaNueva;
	}

	public void setTablaNueva(DefaultTableModel tablaNueva) {
		this.tablaNueva = tablaNueva;
	}

	public Integer getNumcategoria() {
		return this.numerocategoria;
	}

	public void setNumCategoria(int cat){
		this.numerocategoria=cat;
	}
}