package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import controller.ControladorPrincipal;

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
		panelAyuda.setBounds(153, 40, 958, 601);
		contentPane.add(panelAyuda);
		panelAyuda.setLayout(null);
		panelAyuda.setVisible(false);
		
		btnSalirAyuda = new JButton("Volver");
		btnSalirAyuda.setBounds(848, 550, 100, 40);
		panelAyuda.add(btnSalirAyuda); 

		
		panelCreditos = new JPanel();
		panelCreditos.setBounds(153, 40, 958, 601);
		contentPane.add(panelCreditos);
		panelCreditos.setLayout(null);
		panelCreditos.setVisible(false);
		
		btnSalirCreditos = new JButton("Volver");
		btnSalirCreditos.setBounds(851, 552, 100, 40);
		panelCreditos.add(btnSalirCreditos);

		JLabel lblLogica = new JLabel("<html>Botha, Ana<br>Montiel, Nicolas<br>Rojas, Axel</html>");
		lblLogica.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogica.setVerticalAlignment(SwingConstants.TOP);
		lblLogica.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblLogica.setBounds(330, 151, 300, 399);
		panelCreditos.add(lblLogica);
		JLabel lblABM = new JLabel("<html>Bustamante, Nicolas<br>Flores, Martin<br>Titos, Felix Aldo</html>");
		lblABM.setHorizontalAlignment(SwingConstants.CENTER);
		lblABM.setVerticalAlignment(SwingConstants.TOP);
		lblABM.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblABM.setBounds(20, 151, 300, 399);
		panelCreditos.add(lblABM);
		JLabel lblIGU = new JLabel("<html>Arbita, Rodrigo<br>Lopez, Gabriel<br>Toconas, Walter</html>");
		lblIGU.setHorizontalAlignment(SwingConstants.CENTER);
		lblIGU.setVerticalAlignment(SwingConstants.TOP);
		lblIGU.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblIGU.setBounds(648, 151, 300, 390);
		panelCreditos.add(lblIGU);
		JLabel lblCreditos = new JLabel("CREDITOS");
		lblCreditos.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblCreditos.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreditos.setBounds(10, 11, 938, 72);
		panelCreditos.add(lblCreditos);
		lblCreditos.setIcon(new FlatSVGIcon("creditos.svg", 50, 50));
		
		
		//---BOTONES PANTALLA PRINCIPAL
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(52, 196, 250, 60);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(controlador);
		btnJugar.setFont(new Font("Tahoma", Font.BOLD, 15));
		

		btnOpciones = new JButton("OPCIONES");
		btnOpciones.setBounds(52, 267, 250, 60);		
		contentPane.add(btnOpciones);
		btnOpciones.addActionListener(controlador);
		btnOpciones.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		btnRanking = new JButton("RANKING");		
		btnRanking.setBounds(52, 338, 120, 50);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(controlador);
		btnRanking.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		btnAyuda = new JButton("AYUDA");
		btnAyuda.setBounds(182, 338, 120, 50);
		contentPane.add(btnAyuda);
		btnAyuda.addActionListener(controlador);
		btnAyuda.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		BtnSalir = new JButton("SALIR");
		BtnSalir.setBounds(52, 399, 250, 60);
		contentPane.add(BtnSalir);
		BtnSalir.addActionListener(controlador);
		BtnSalir.setFont(new Font("Tahoma", Font.BOLD, 15));

	
		// BOTONES PEQUEÑOS
		btnLogin = new JButton();
		FlatSVGIcon iconLogin = new FlatSVGIcon("login.svg", 30, 30);
		btnLogin.setIcon(iconLogin);
		btnLogin.setBounds(52, 615, 55, 55);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(controlador);
	
		btnCreditos = new JButton();
		FlatSVGIcon iconCreditos = new FlatSVGIcon("creditos.svg", 30, 30);
		btnCreditos.setIcon(iconCreditos);
		btnCreditos.setBounds(117, 615, 55, 55);
		btnCreditos.addActionListener(controlador);
		contentPane.add(btnCreditos);
		
		btnModificar = new JButton();
		FlatSVGIcon iconModificar = new FlatSVGIcon("editar.svg", 30, 30);
		btnModificar.setIcon(iconModificar);
		btnModificar.setBounds(182, 615, 55, 55);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(controlador);
		
		JLabel lblTitutlo = new JLabel("8 ESCALONES");
		lblTitutlo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTitutlo.setFont(new Font("Comic Sans MS", Font.BOLD, 80));
		lblTitutlo.setForeground(Color.CYAN);
		lblTitutlo.setBounds(20, 16, 1244, 169);
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

	public void actualizarEstadoLogin(boolean logueado) {
		if (logueado) {
			btnLogin.setEnabled(false); // Deshabilita el botón
		} 
	}
	

	}
	



