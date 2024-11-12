package view;

import controller.ControladorRanking;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;


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
		setBounds(300, 200, 567, 403);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JLabel lblRanking = new JLabel("RANKING");
		lblRanking.setBounds(255, 11, 100, 22);
		contentPane.add(lblRanking);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(452, 330, 89, 23);
		contentPane.add(btnSalir);

		//--- TABLA DE RANKING ---
		String[] column = {"id","Jugador", "Veces ganadas"};
		setDefTableModel(new DefaultTableModel(null,column));
		table = new JTable(getDefTableModel());
		table.setDefaultEditor(Object.class, null);
		table.getColumnModel().getColumn(0).setMaxWidth(0);
		table.getColumnModel().getColumn(0).setMinWidth(0);
		table.getColumnModel().getColumn(0).setPreferredWidth(0);
	    table.getTableHeader().setReorderingAllowed(false);
	    table.getTableHeader().setResizingAllowed(false);
		table.setBounds(26, 53, 499, 255);
		contentPane.add(table);
		
		JScrollPane sc = new JScrollPane();
		sc.setBounds(26, 53, 499, 255);
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
}
