package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControladorLogin;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPasswordField;
import javax.swing.JTextPane;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;

import com.formdev.flatlaf.FlatClientProperties;

public class VistaLogin extends JFrame{
	
	private JPanel contentPane;
	private ControladorLogin c;
	private JButton btnSalir;
	private JTextField txtCuenta;
	private JPasswordField txtContrasenia;
	private JButton btnLogin;
	private JButton btnCambioContrasenia;

	public VistaLogin (ControladorLogin c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 393, 363);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		JLabel lblLogin = new JLabel("LOGIN ");
		lblLogin.setBounds(154, 34, 46, 14);
		contentPane.add(lblLogin);
		
		JLabel lblCuenta = new JLabel("Cuenta: ");
		lblCuenta.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCuenta.setBounds(60, 97, 64, 14);
		contentPane.add(lblCuenta);
		
		JLabel lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setHorizontalAlignment(SwingConstants.RIGHT);
		lblContrasenia.setBounds(60, 141, 64, 14);
		contentPane.add(lblContrasenia);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(278, 290, 89, 23);
		contentPane.add(btnSalir);
		
		// -- TEXTFIELDS DE DATOS
		txtCuenta = new JTextField();
		txtCuenta.setBounds(134, 94, 150, 20);
		contentPane.add(txtCuenta);
		txtCuenta.setColumns(10);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "INGRESE LA CONTRASEÑA");
		txtContrasenia.setBounds(134, 138, 150, 20);
		contentPane.add(txtContrasenia);
	
		btnLogin = new JButton("Logearse");
		btnLogin.setBounds(111, 188, 89, 23);
		contentPane.add(btnLogin);
		
		btnCambioContrasenia = new JButton("Contrasenia");
		btnCambioContrasenia.setBounds(210, 188, 89, 23);
		contentPane.add(btnCambioContrasenia);
	}

	public ControladorLogin getC() {
		return c;
	}
	public void setC(ControladorLogin c) {
		this.c = c;
	}

	public JButton getBtnSalir() {
		return btnSalir;
	}
	public JTextField getTxtCuenta() {
		return txtCuenta;
	}
	public JPasswordField getTxtContrasenia() {
		return txtContrasenia;
	}
	public JButton getBtnNewButton() {
		return btnLogin;
	}
}
