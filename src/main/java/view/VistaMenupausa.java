package view;

import controller.ControladorMenupausa;
import view.componentes.FuentePersonalizada;

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
		setBounds(200, 200, 300,400);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnReanudar = new JButton("Reanudar");
		btnReanudar.addActionListener(c);
		btnReanudar.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 20f));
		btnReanudar.setBounds(60, 69, 180, 80);
		contentPane.add(btnReanudar);
		
		btnOpciones = new JButton("Opciones");
		btnOpciones.addActionListener(c);
		btnOpciones.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 20f));
		btnOpciones.setBounds(60, 160, 180, 80);
		contentPane.add(btnOpciones);
		
		btnSalirmenu = new JButton("Salir al menu");
		btnSalirmenu.addActionListener(c);
		btnSalirmenu.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 20f));
		btnSalirmenu.setBounds(60, 251, 180, 80);
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
