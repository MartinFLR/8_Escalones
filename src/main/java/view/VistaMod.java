package view;

import controller.ControladorMod;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTable;


public class VistaMod extends JFrame{

	private ControladorMod c;
	private JPanel contentPane;
	private JButton btnSalir;
	private JButton btnCrear;
	private JButton btnEditar;
	private JButton btnBorrar;
	private JTextField busqueda;
	private JTable table;
	private DefaultTableModel t;
	
	public VistaMod (ControladorMod c) {
		this.setC(c);
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
		
		busqueda = new JTextField();
		busqueda.setBounds(10, 11, 141, 20);
		panel.add(busqueda);
		busqueda.setColumns(10);
		
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setBounds(424, 10, 89, 23);
		panel.add(btnBorrar);
		
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(325, 10, 89, 23);
		panel.add(btnEditar);
		
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(226, 10, 89, 23);
		btnCrear.setEnabled(false); // para q no se pueda seleccionar sin que elija una categoria o tema 
		panel.add(btnCrear);
		
		JPanel panelTabla = new JPanel();
		panelTabla.setBounds(10, 58, 513, 292);
		contentPane.add(panelTabla);
		
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
		panelTabla.add(table);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(10, 58, 513, 292);
		sp.setViewportView(table);
		panelTabla.add(sp);

		
	}

	public ControladorMod getC() {
		return c;
	}
	public void setC(ControladorMod c) {
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
	
}
