package view;

import controller.ControladorMenupausa;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JButton;

public class VistaMenupausa extends JFrame {

	private ControladorMenupausa c;
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnReanudar;
	private JButton btnSalirmenu;
	private JButton btnOpciones;
	
	public VistaMenupausa(ControladorMenupausa c) {
		setLocationRelativeTo(null);
		setResizable(false);
		setBounds(200, 200, 200, 300);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnReanudar = new JButton("Reanudar");
		btnReanudar.addActionListener(c);
		btnReanudar.setBounds(40, 50, 100, 40);
		contentPane.add(btnReanudar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(c);
		btnOpciones.setBounds(40, 102, 100, 40);
		contentPane.add(btnOpciones);
		
		btnSalirmenu = new JButton("Salir");
		btnSalirmenu.addActionListener(c);
		btnSalirmenu.setBounds(40, 153, 100, 40);
		contentPane.add(btnSalirmenu);

	}

	public JButton getBtnReanudar() {
		return btnReanudar;
	}

	public JButton getBtnSalirmenu() {
		return btnSalirmenu;
	}

	public JButton getBtnOpciones() {
		return btnOpciones;
	}
}
