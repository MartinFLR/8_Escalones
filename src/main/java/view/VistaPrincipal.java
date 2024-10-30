package view;

import controller.ControladorPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnJugar;
	private JButton btnOpciones;
	private JButton BtnSalir;
	private ControladorPrincipal controlador;
	private JButton btnCreditos;
	private JButton btnModificar;
	
	public VistaPrincipal(ControladorPrincipal controlador) {
		this.setControlador(controlador);
		setTitle("8 ESCALONES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 469);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(15, 15, 783, 94);
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("8 ESCALONES");
		lblNewLabel.setForeground(new Color(255, 255, 0));
		lblNewLabel.setFont(new Font("Viner Hand ITC", Font.PLAIN, 60));
		panel.add(lblNewLabel);
		
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(598, 120, 195, 76);
		btnJugar.setBackground(Color.CYAN);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(controlador);
		
		btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBounds(598, 207, 195, 76);
		btnOpciones.setBackground(Color.CYAN);
		contentPane.add(btnOpciones);
		btnOpciones.addActionListener(controlador);
		
		BtnSalir = new JButton("SALIR");
		BtnSalir.setBounds(598, 294, 195, 76);
		BtnSalir.setBackground(Color.CYAN);
		contentPane.add(BtnSalir);
		BtnSalir.addActionListener(controlador);
		
		btnCreditos = new JButton("New button");
		btnCreditos.setBounds(709, 396, 89, 23);
		btnCreditos.addActionListener(controlador);
		contentPane.add(btnCreditos);
		
		btnModificar = new JButton("New button");
		btnModificar.setBounds(610, 396, 89, 23);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(controlador);
		
	}
	
	public JButton getModificar() {
		return btnModificar;
	}
	
	public JButton getCreditos() {
		return btnCreditos;
	}
	
	public ControladorPrincipal getControlador() {
		return controlador;
	}

	public void setControlador(ControladorPrincipal controlador) {
		this.controlador = controlador;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}

	public JButton getBtnOpciones() {
		return btnOpciones;
	}

	public JButton getBtnSalir() {
		return BtnSalir;
	}
}