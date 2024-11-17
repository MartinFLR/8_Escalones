package view;

import controller.ControladorModCategoria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;


public abstract class VistaModPadre extends JFrame{

	protected ControladorModCategoria c;
	protected JPanel contentPane;
	protected JButton btnSalir;
	protected JButton btnCrear;
	protected JButton btnEditar;
	protected JButton btnBorrar;
	protected JButton btnBuscar;
	protected JTextField textBuscador;
	protected JTable table;
	protected DefaultTableModel t;
	
	public VistaModPadre () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(434, 358, 89, 23);
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 513, 36);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(10, 11, 141, 20);
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setBounds(424, 10, 89, 23);
		btnBorrar.setEnabled(false);
		panel.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(325, 10, 89, 23);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(226, 10, 89, 23);
		panel.add(btnCrear);
		
		btnBuscar = new JButton("");
		btnBuscar.setBounds(154, 10, 35, 21);
		panel.add(btnBuscar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 58, 513, 292);
		contentPane.add(panel_1);
		
		String cabeza [] = {"ID", "Categoria", "Cantidad de preguntas"};
		t = new DefaultTableModel(null, cabeza);
		table = new JTable(t);
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		table.getSelectionModel();
		table.setBounds(10, 58, 513, 292);
		panel_1.add(table);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(10, 58, 513, 292);
		sp.setViewportView(table);
		panel_1.add(sp);

		
	}

	public ControladorModCategoria getC() {
		return c;
	}
	public void setC(ControladorModCategoria c) {
		this.c = c;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JButton getBtnCrear() {
		return btnCrear;
	}

	public JButton getBtnEditar() {
		return btnEditar;
	}

	public JButton getBtnBorrar() {
		return btnBorrar;
	}

	public DefaultTableModel getT() {
		return t;
	}

	public void setT(DefaultTableModel t) {
		this.t = t;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnBuscar() {
		return btnBuscar;
	}

	public void setBtnBuscar(JButton btnBuscar) {
		this.btnBuscar = btnBuscar;
	}

	public JTextField getTextBuscador() {
		return textBuscador;
	}

}
