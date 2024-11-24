package view;

import controller.ControladorRanking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;


public class VistaRanking extends JFrame{
	
	private JPanel contentPane;
	private ControladorRanking c;
	private JButton btnSalir;
	private JTable table;
	private DefaultTableModel defTableModel;
	
	
	public VistaRanking (ControladorRanking c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(0, 0, 800, 550);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblRanking = new JLabel("RANKING");
		lblRanking.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblRanking.setHorizontalAlignment(SwingConstants.CENTER);
		lblRanking.setBounds(10, 11, 777, 85);
		contentPane.add(lblRanking);
		lblRanking.setIcon(new FlatSVGIcon("star_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 50, 50));
		
		btnSalir = new JButton("Volver", new FlatSVGIcon("arrow_back_ios_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20));
		btnSalir.setBounds(690, 499, 100, 40);
		btnSalir.setCursor(new Cursor(HAND_CURSOR));
		btnSalir.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnSalir);

		//--- TABLA DE RANKING ---
		String[] column = {"id","Jugador", "Veces ganadas"};
		setDefTableModel(new DefaultTableModel(null, column));
		table = new JTable(getDefTableModel());
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
		table.getColumnModel().getColumn(1).setPreferredWidth(400);
	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
	    table.setFont(new Font("Tahoma", Font.PLAIN, 16));
		table.setBounds(26, 53, 499, 255);
		
		JScrollPane sc = new JScrollPane();
		sc.setBounds(17, 87, 765, 388);
		sc.putClientProperty(FlatClientProperties.SCROLL_BAR_SHOW_BUTTONS, true);
		sc.putClientProperty(FlatClientProperties.SCROLL_PANE_SMOOTH_SCROLLING, true);
		sc.setViewportView(table);
		contentPane.add(sc);
		
	}

	public ControladorRanking getC() {
		return c;
	}
	public void setC(ControladorRanking c) {
		this.c = c;
	}

	
	public DefaultTableModel getDefTableModel() {
		return defTableModel;
	}
	
	public void setDefTableModel(DefaultTableModel defTableModel) {
		this.defTableModel = defTableModel;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}
	
	
}
