package view;

import controller.ControladorPrincipal;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;

import java.awt.Font;
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
		/* */
		panelAyuda = new JPanel();
		panelAyuda.setBounds(80, 11, 663, 408);
		contentPane.add(panelAyuda);
		panelAyuda.setLayout(null);
		panelAyuda.setVisible(false);
		
		btnSalirAyuda = new JButton("Volver");
		btnSalirAyuda.setBounds(564, 374, 89, 23);
		panelAyuda.add(btnSalirAyuda);
		 
		
		panelCreditos = new JPanel();
		panelCreditos.setBounds(80, 11, 663, 408);
		contentPane.add(panelCreditos);
		panelCreditos.setLayout(null);
		panelCreditos.setVisible(false);
		
		btnSalirCreditos = new JButton("Volver");
		btnSalirCreditos.setBounds(564, 374, 89, 23);
		panelCreditos.add(btnSalirCreditos);
	
		
		//---BOTONES PANTALLA PRINCIPAL
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(593, 111, 200, 50);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(controlador);
		
		btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBounds(593, 172, 200, 50);		
		contentPane.add(btnOpciones);
		btnOpciones.addActionListener(controlador);
		
		BtnSalir = new JButton("SALIR");
		BtnSalir.setBounds(593, 274, 200, 50);
		contentPane.add(BtnSalir);
		BtnSalir.addActionListener(controlador);
		
		btnCreditos = new JButton("C");
		btnCreditos.setBounds(653, 379, 40, 40);
		btnCreditos.addActionListener(controlador);
		contentPane.add(btnCreditos);
		
		btnLogin = new JButton("L");
		btnLogin.setBounds(703, 379, 40, 40);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(controlador);
		
		btnRanking = new JButton("RANKING");
		btnRanking.setBounds(593, 233, 95, 30);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(controlador);
		
		btnAyuda = new JButton("AYUDA");
		btnAyuda.setBounds(698, 233, 95, 30);
		contentPane.add(btnAyuda);
		btnAyuda.addActionListener(controlador);
		
		btnModificar = new JButton("M");
		btnModificar.setBounds(753, 379, 40, 40);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(controlador);
		
		JLabel lblTitutlo = new JLabel("8 ESCALONES");
		lblTitutlo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitutlo.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
		lblTitutlo.setForeground(Color.CYAN);
		lblTitutlo.setBounds(10, 11, 783, 89);
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
