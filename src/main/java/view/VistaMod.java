package view;

import controller.ControladorMod;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;


public class VistaMod extends JFrame{

	private ControladorMod c;
	private JPanel contentPane;
	private JButton btnSalir;
	
	public VistaMod (ControladorMod c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(335, 227, 89, 23);
		contentPane.add(btnSalir);
	}

	public ControladorMod getC() {
		return c;
	}
	public void setC(ControladorMod c) {
		this.c = c;
	}
	
	
}
