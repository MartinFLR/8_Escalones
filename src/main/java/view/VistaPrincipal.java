package view;

import controller.ControladorPrincipal;

import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.extras.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JInternalFrame;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class VistaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorPrincipal controlador;
	
	private JButton btnJugar;
	private JButton btnOpciones;
	private JButton BtnSalir;
	private JButton btnCreditos;
	private JButton btnLogin;
	private JButton btnAyuda;
	private JButton btnRanking;
	private JButton btnModificar;
	
	private JPanel panelAyuda;
	private JPanel panelCreditos;
	private JButton btnSalirAyuda;
	private JButton btnSalirCreditos;
	
	public VistaPrincipal(ControladorPrincipal controlador) {
		this.setControlador(controlador);
		setTitle("8 ESCALONES");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 0, 0));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		
		//---PANELES (VENTANAS EXTRAS)
		
		panelAyuda = new JPanel();
		panelAyuda.setBounds(236, 53, 792, 574);
		contentPane.add(panelAyuda);
		panelAyuda.setLayout(null);
		panelAyuda.setVisible(false);
		
		btnSalirAyuda = new JButton("Volver");
		btnSalirAyuda.setBounds(564, 374, 89, 23);
		panelAyuda.add(btnSalirAyuda);

		
		panelCreditos = new JPanel();
		panelCreditos.setBounds(236, 53, 792, 574);
		contentPane.add(panelCreditos);
		panelCreditos.setLayout(null);
		panelCreditos.setVisible(false);
		
		btnSalirCreditos = new JButton("Volver");
		btnSalirCreditos.setBounds(564, 374, 89, 23);
		panelCreditos.add(btnSalirCreditos);
		
		
		//---BOTONES PANTALLA PRINCIPAL
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(1004, 191, 250, 60);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(controlador);
		
		btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBounds(1004, 262, 250, 60);		
		contentPane.add(btnOpciones);
		btnOpciones.addActionListener(controlador);
		
		BtnSalir = new JButton("SALIR");
		BtnSalir.setBounds(1004, 394, 250, 60);
		contentPane.add(BtnSalir);
		BtnSalir.addActionListener(controlador);
		
		btnCreditos = new JButton("C");
		btnCreditos.setBounds(1134, 610, 55, 55);
		btnCreditos.addActionListener(controlador);
		contentPane.add(btnCreditos);
		
		
		
		
		btnLogin = new JButton();
		btnLogin.setBounds(1199, 610, 55, 55);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(controlador);
		
		btnRanking = new JButton("RANKING");
		btnRanking.setBounds(1004, 333, 120, 50);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(controlador);
		
		btnAyuda = new JButton("AYUDA");
		btnAyuda.setBounds(1134, 333, 120, 50);
		contentPane.add(btnAyuda);
		btnAyuda.addActionListener(controlador);
		
		btnModificar = new JButton("M");
		btnModificar.setBounds(1069, 610, 55, 55);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(controlador);
		
		JLabel lblTitutlo = new JLabel("8 ESCALONES");
		lblTitutlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitutlo.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		lblTitutlo.setForeground(Color.CYAN);
		lblTitutlo.setBounds(10, 11, 1244, 169);
		contentPane.add(lblTitutlo);

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
	public JButton getBtnCreditos() {
		return btnCreditos;
	}
	public JButton getBtnLogin() {
		return btnLogin;
	}
	public JButton getBtnAyuda() {
		return btnAyuda;
	}
	public JButton getBtnRanking() {
		return btnRanking;
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JPanel getPanelAyuda() {
		return panelAyuda;
	}
	public JPanel getPanelCreditos() {
		return panelCreditos;
	}
	public JButton getBtnSalirCreditos() {
		return btnSalirCreditos;
	}
	public JButton getBtnSalirAyuda() {
		return btnSalirAyuda;
	}
}
