package view;

import controller.ControladorOpciones;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;

public class VistaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorOpciones c;
	private JButton btnSalir;
	private JLabel lblNewLabel;
	
	
	public VistaOpciones(ControladorOpciones c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 257, 328);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(142, 255, 89, 23);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(c);

		lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setBounds(97, 11, 46, 14);
		contentPane.add(lblNewLabel);
		
	}


	public ControladorOpciones getC() {
		return c;
	}
	public void setC(ControladorOpciones c) {
		this.c = c;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}
	
	
}
