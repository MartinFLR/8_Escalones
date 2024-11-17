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
	private JButton btnCambioTema;
	
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
		btnSalirCreditos.setBounds(693, 540, 89, 23);
		panelCreditos.add(btnSalirCreditos);
		
		JLabel lblLogica = new JLabel("Lógica: Botha Ana, Montiel Nicolas, Rojas Axel");
		lblLogica.setBounds(10, 11, 772, 138);
		panelCreditos.add(lblLogica);
		JLabel lblABM = new JLabel("ABM: Bustamante Nicolas, Flores Martin, Titos Felix Aldo");
		lblABM.setBounds(10, 160, 772, 138);
		panelCreditos.add(lblABM);
		JLabel lblIGU = new JLabel("IGU: Arbita Rodrigo, Lopez Gabriel, Toconas Walter");
		lblIGU.setBounds(10, 308, 772, 138);
		panelCreditos.add(lblIGU);
		
		
		
		//---BOTONES PANTALLA PRINCIPAL
		btnJugar = new JButton("JUGAR");
		btnJugar.setBounds(1004, 191, 250, 60);
		contentPane.add(btnJugar);
		btnJugar.addActionListener(controlador);
		
		btnOpciones = new JButton("OPCIONES");
		FlatSVGIcon iconOpciones = new FlatSVGIcon("configuracion.svg", 30, 30);
		btnOpciones.setIcon(iconOpciones);
		btnOpciones.setBounds(1004, 262, 250, 60);		
		contentPane.add(btnOpciones);
		btnOpciones.addActionListener(controlador);
		
		btnRanking = new JButton("RANKING");
		FlatSVGIcon iconRanking = new FlatSVGIcon("ranking.svg", 30, 30);
		btnRanking.setIcon(iconRanking);
		btnRanking.setBounds(1004, 333, 120, 50);
		contentPane.add(btnRanking);
		btnRanking.addActionListener(controlador);
		
		btnAyuda = new JButton("AYUDA");
		FlatSVGIcon iconAyuda = new FlatSVGIcon("ayuda.svg", 30, 30);
		btnAyuda.setIcon(iconAyuda);
		btnAyuda.setBounds(1134, 333, 120, 50);
		contentPane.add(btnAyuda);
		btnAyuda.addActionListener(controlador);
		
		BtnSalir = new JButton("SALIR");
		BtnSalir.setBounds(1004, 394, 250, 60);
		contentPane.add(BtnSalir);
		BtnSalir.addActionListener(controlador);
		

	
		// BOTONES PEQUEÑOS
		btnLogin = new JButton();
		FlatSVGIcon iconLogin = new FlatSVGIcon("login.svg", 30, 30);
		btnLogin.setIcon(iconLogin);
		btnLogin.setBounds(1199, 610, 55, 55);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(controlador);
	
		btnCreditos = new JButton();
		FlatSVGIcon iconCreditos = new FlatSVGIcon("creditos.svg", 30, 30);
		btnCreditos.setIcon(iconCreditos);
		btnCreditos.setBounds(1134, 610, 55, 55);
		btnCreditos.addActionListener(controlador);
		contentPane.add(btnCreditos);
		
		btnModificar = new JButton();
		FlatSVGIcon iconModificar = new FlatSVGIcon("editar.svg", 30, 30);
		btnModificar.setIcon(iconModificar);
		btnModificar.setBounds(1069, 610, 55, 55);
		contentPane.add(btnModificar);
		btnModificar.addActionListener(controlador);
		
		btnCambioTema = new JButton();
		FlatSVGIcon iconCambioTema = new FlatSVGIcon("cambiotema.svg", 30, 30);
		btnCambioTema.setIcon(iconCambioTema);
		btnCambioTema.setBounds(1004, 610, 55, 55);
		contentPane.add(btnCambioTema);
		
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
	public JButton getBtnCambioTema() {
		return btnCambioTema;
	}
}
