package view;

import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.ControladorModCategoria;
import controller.ControladorCreacionPreguntas;
import controller.ControladorModPreguntas;
import model.ABM.PreguntasDAO;
import model.Preguntas;

public class VistaModPreguntas extends VistaModPadre {
	private String encabezado[] = { "ID", "Preguntas", "Tipo pregunta" };
	private DefaultTableModel tablaNueva = new DefaultTableModel(null, encabezado);
	private int numerocategoria;
	private PreguntasDAO preguntasDAO = new PreguntasDAO();;

	public VistaModPreguntas(ControladorModPreguntas c) {
		this.numerocategoria=c.getId_categoria();
		actualizarTabla();
		setVisible(true);
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
				Object[] row = { pregunta.getId_pregunta(), pregunta.getPregunta(), pregunta.getTipo_preg() };
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
		this.getTable().getColumnModel().getColumn(1).setPreferredWidth(580);
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