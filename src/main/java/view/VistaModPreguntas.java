package view;

import javax.swing.table.DefaultTableModel;

import controller.ControladorModCategoria;
import controller.ControladorCreacionPreguntas;

public class VistaModPreguntas extends VistaModPadre{
	private String encabezado [] = {"ID", "Preguntas"};
	private DefaultTableModel tablaNueva = new DefaultTableModel(null, encabezado);

	public VistaModPreguntas(ControladorModCategoria c) {
		super(c);
		setVisible(true);
		actuailizarTabla();
		botones();
	}

	
	public void actuailizarTabla() {
		this.getTable().setModel(tablaNueva);
        this.getTable().setDefaultEditor(Object.class, null);
        this.getTable().getTableHeader().setReorderingAllowed(false);
        this.getTable().getTableHeader().setResizingAllowed(false);
        this.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
        this.getTable().getColumnModel().getColumn(0).setMinWidth(0);
        this.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	}
	
	public void botones() {
		this.getTable().getSelectionModel().addListSelectionListener(e->{
			getBtnEditar().setEnabled(true);
			getBtnBorrar().setEnabled(true);	
		});
		
		this.getBtnBorrar().addActionListener(null);
		this.getBtnCrear().addActionListener(e->{
			new ControladorCreacionPreguntas();
		});
		this.getBtnEditar().addActionListener(null);
		this.getBtnSalir().addActionListener(e-> {
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
}
