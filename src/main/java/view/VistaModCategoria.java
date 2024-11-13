package view;

import javax.swing.table.DefaultTableModel;

import controller.ControladorModCategoria;

public class VistaModCategoria extends VistaModPadre{

	public VistaModCategoria(ControladorModCategoria c) {
		super(c);
		setVisible(true);
		actuailizarTabla();
		botones();
	}

	
	public void actuailizarTabla() {
		String encabezado [] = {"ID", "Preguntas"};
		DefaultTableModel tablaNueva = new DefaultTableModel(null, encabezado);
		this.getTable().setModel(tablaNueva);
        this.getTable().setDefaultEditor(Object.class, null);
        this.getTable().getTableHeader().setReorderingAllowed(false);
        this.getTable().getTableHeader().setResizingAllowed(false);
        this.getTable().getColumnModel().getColumn(0).setMaxWidth(0);
        this.getTable().getColumnModel().getColumn(0).setMinWidth(0);
        this.getTable().getColumnModel().getColumn(0).setPreferredWidth(0);
	}
	
	public void botones() {
		this.getBtnBorrar().addActionListener(null);
		this.getBtnCrear().addActionListener(null);
		this.getBtnEditar().addActionListener(null);
		this.getBtnSalir().addActionListener(e-> {
			setVisible(false);
		c.getVista().setVisible(true);	
		});
	}
}
