package view;

import controller.ControladorModCategoria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.Dimension;
import java.awt.Font;

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
	protected JTextField textBuscador;
	protected JTable table;
	protected DefaultTableModel t;
	
	public VistaModPadre () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(690, 499, 100, 40);
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 11, 775, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(0, 1, 345, 40);
		textBuscador.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		
		FlatSVGIcon iconEliminar = new FlatSVGIcon("eliminar.svg", 20, 20);
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setBounds(672, 1, 100, 40);
		btnBorrar.setEnabled(false);
		panel.add(btnBorrar);
		
		FlatSVGIcon iconEditar= new FlatSVGIcon("editar.svg", 20, 20);
		btnEditar = new JButton("Editar");
		btnEditar.setBounds(562, 1, 100, 40);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		FlatSVGIcon iconCrear = new FlatSVGIcon("crear.svg", 20, 20);
		btnCrear = new JButton("Crear");
		btnCrear.setBounds(452, 1, 100, 40);
		panel.add(btnCrear);
		
		
		String cabeza [] = {"ID", "Categoria", "Cantidad de preguntas"};
		t = new DefaultTableModel(null, cabeza);
		table = new JTable(t);
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		table.getSelectionModel();
		table.setBounds(10, 58, 513, 292);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setRowHeight(25);
		
		JScrollPane sp = new JScrollPane();
		sp.setBounds(12, 58, 775, 430);
		sp.setViewportView(table);
		contentPane.add(sp);

		
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

	public JTextField getTextBuscador() {
		return textBuscador;
	}

}
