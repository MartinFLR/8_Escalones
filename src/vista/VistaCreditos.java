package vista;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controlador.ControladorCreditos;

import java.awt.Color;

public class VistaCreditos extends JFrame{

	private ControladorCreditos c;
	private JPanel contentPane;
	
	public VistaCreditos(ControladorCreditos c) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
	}
	
}
