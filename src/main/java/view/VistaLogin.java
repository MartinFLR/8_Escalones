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

public class VistaLogin extends JFrame{
	
	private JPanel contentPane;
	private ControladorLogin c;
	private JButton btnSalir;
	private JTextField txtCuenta;
	private JPasswordField txtContrasenia;
	private JButton btnNewButton;

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
		
		JLabel lblNewLabel = new JLabel("Cuenta: ");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(60, 97, 64, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(60, 141, 64, 14);
		contentPane.add(lblNewLabel_1);
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(278, 290, 89, 23);
		contentPane.add(btnSalir);
		
		// -- TEXTFIELDS DE DATOS
		txtCuenta = new JTextField();
		txtCuenta.setBounds(134, 94, 150, 20);
		contentPane.add(txtCuenta);
		txtCuenta.setColumns(10);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(134, 138, 150, 20);
		contentPane.add(txtContrasenia);
	
		btnNewButton = new JButton("Logearse");
		btnNewButton.setBounds(111, 189, 89, 23);
		contentPane.add(btnNewButton);
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
		return btnNewButton;
	}
	
	
}
