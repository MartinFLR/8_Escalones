package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.ControladorModCategoria;
import controller.ControladorCreacionPreguntas;
import model.ABM.PreguntasDAO;
import model.Preguntas;

public class VistaModPreguntas extends VistaModPadre {
	private String encabezado[] = {"ID", "Preguntas"};
	private DefaultTableModel tablaNueva = new DefaultTableModel(null, encabezado);
	private String numerocategoria;
	private PreguntasDAO preguntasDAO = new PreguntasDAO();;

	public VistaModPreguntas(ControladorModCategoria c, String id) {
		super(c);
		this.numerocategoria = id;
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
			// Asegúrate de que los métodos getId_pregunta() y getPregunta() existan en la clase Preguntas
			Object[] row = {pregunta.getId_pregunta(), pregunta.getPregunta()};
			tablaNueva.addRow(row);
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
		// Si no vas a usar los ActionListeners de los botones de Borrar y Editar, quítalos o agrégales funcionalidad
		this.getBtnBorrar().addActionListener(null);
		this.getBtnCrear().addActionListener(e -> {
			new ControladorCreacionPreguntas(numerocategoria);
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

	public String getNumcategoria() {
		return this.numerocategoria;
	}
}
