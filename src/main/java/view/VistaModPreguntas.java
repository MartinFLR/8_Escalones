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
	private PreguntasDAO preguntasDAO = new PreguntasDAO();

	public VistaModPreguntas(ControladorModPreguntas c) {
		this.numerocategoria=c.getId_categoria();
		setVisible(true);
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