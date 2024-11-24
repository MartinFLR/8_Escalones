package view;

import controller.ControladorModCategoria;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.Cursor;
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
		
		btnSalir = new JButton("Volver", new FlatSVGIcon("arrow_back_ios_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20));
		btnSalir.setBounds(690, 499, 100, 40);
		btnSalir.setCursor(new Cursor(HAND_CURSOR));
		btnSalir.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnSalir);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 11, 775, 50);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textBuscador = new JTextField();
		textBuscador.setBounds(0, 1, 345, 40);
		textBuscador.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Buscar");
		textBuscador.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("search_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg"));

		panel.add(textBuscador);
		textBuscador.setColumns(10);
		
		FlatSVGIcon iconEliminar = new FlatSVGIcon("delete_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20);
		btnBorrar = new JButton("Eliminar");
		btnBorrar.setIcon(iconEliminar);
		btnBorrar.setBounds(672, 1, 100, 40);
		btnBorrar.setCursor(new Cursor(HAND_CURSOR));
		btnBorrar.setEnabled(false);
		panel.add(btnBorrar);
		
		FlatSVGIcon iconEditar= new FlatSVGIcon("edit_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20);
		btnEditar = new JButton("Editar");
		btnEditar.setIcon(iconEditar);
		btnEditar.setCursor(new Cursor(HAND_CURSOR));
		btnEditar.setBounds(562, 1, 100, 40);
		btnEditar.setEnabled(false);
		panel.add(btnEditar);
		
		FlatSVGIcon iconCrear = new FlatSVGIcon("add_circle_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20);
		btnCrear = new JButton("Crear");
		btnCrear.setIcon(iconCrear);
		btnCrear.setBounds(452, 1, 100, 40);
		btnCrear.setCursor(new Cursor(HAND_CURSOR));
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
		sp.putClientProperty(FlatClientProperties.SCROLL_BAR_SHOW_BUTTONS, true);
		sp.putClientProperty(FlatClientProperties.SCROLL_PANE_SMOOTH_SCROLLING, true);
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
