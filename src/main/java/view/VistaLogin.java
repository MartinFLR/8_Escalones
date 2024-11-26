package view;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.ControladorLogin;
import view.componentes.FuentePersonalizada;

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
import com.formdev.flatlaf.extras.FlatSVGIcon;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Color;

public class VistaLogin extends JFrame{
	
	private JPanel contentPane;
	private JButton btnSalir;
	private JTextField txtCuenta;
	private JPasswordField txtContrasenia;
	private JButton btnLogin;
	private JTextField txtCambioCuenta;
	private JButton btnCambioSalir;
	private JButton btnCambioAceptar;
	private JPasswordField txtContraseniaNueva1;
	private JPasswordField txtContraseniaNueva2;
	private JPanel panelCambio;
	private JButton btnOlvidoContrasenia;
	
	public VistaLogin () {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 450, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		
		
		// -- PANEL DE CAMBIO DE CONTRASEÑA
		panelCambio = new JPanel();
		panelCambio.setBounds(0, 0, 450, 400);
		contentPane.add(panelCambio);
		panelCambio.setLayout(null);
		
		txtCambioCuenta = new JTextField();
		txtCambioCuenta.setBounds(65, 95, 320, 40);
		txtCambioCuenta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Usuario");
		txtCambioCuenta.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("account_circle_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg", 18, 18));
		panelCambio.add(txtCambioCuenta);
		txtCambioCuenta.setColumns(10);
	
		txtContraseniaNueva1 = new JPasswordField();
		txtContraseniaNueva1.setBounds(65, 165, 320, 40);
		txtContraseniaNueva1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Nueva contraseña");
		txtContraseniaNueva1.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("lock_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg", 18, 18));
		panelCambio.add(txtContraseniaNueva1);
		
		txtContraseniaNueva2 = new JPasswordField();
		txtContraseniaNueva2.setBounds(65, 212, 320, 40);
		txtContraseniaNueva2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Confirmar nueva contraseña");
		txtContraseniaNueva2.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("lock_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg", 18, 18));
		panelCambio.add(txtContraseniaNueva2);
		
		btnCambioAceptar = new JButton("Cambiar contraseña");
		btnCambioAceptar.setBounds(65, 283, 320, 40);
		btnCambioAceptar.setCursor(new Cursor(HAND_CURSOR));
		panelCambio.add(btnCambioAceptar);
		
		btnCambioSalir = new JButton("Volver", new FlatSVGIcon("arrow_back_ios_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20));
		btnCambioSalir.setBounds(340, 349, 100, 40);
		btnCambioSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCambioSalir.setCursor(new Cursor(HAND_CURSOR));
		btnCambioSalir.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		panelCambio.add(btnCambioSalir);
		
		JLabel lblCambioContrasenia = new JLabel("Cambio contraseña");
		lblCambioContrasenia.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 30f));
		lblCambioContrasenia.setBounds(65, 11, 320, 68);
		panelCambio.add(lblCambioContrasenia);
		
		JLabel lblCambioCuenta = new JLabel("Cuenta: ");
		lblCambioCuenta.setBounds(65, 80, 100, 14);
		lblCambioCuenta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCambioCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		panelCambio.add(lblCambioCuenta);
		
		JLabel lblNuevaContrasenia = new JLabel("Nueva contraseña: ");
		lblNuevaContrasenia.setBounds(65, 150, 130, 14);
		lblNuevaContrasenia.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNuevaContrasenia.setHorizontalAlignment(SwingConstants.LEFT);
		panelCambio.add(lblNuevaContrasenia);
		
		panelCambio.setVisible(false);
		
		// -- LOGIN 
		JLabel lblLogin = new JLabel("LOG IN ");
		lblLogin.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 30f));
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setBounds(65, 11, 375, 107);
		contentPane.add(lblLogin);
		
		JLabel lblCuenta = new JLabel("Cuenta: ");
		lblCuenta.setVerticalAlignment(SwingConstants.BOTTOM);
		lblCuenta.setHorizontalAlignment(SwingConstants.LEFT);
		lblCuenta.setBounds(65, 91, 80, 20);
		contentPane.add(lblCuenta);
		
		JLabel lblContrasenia = new JLabel("Contraseña: ");
		lblContrasenia.setVerticalAlignment(SwingConstants.BOTTOM);
		lblContrasenia.setHorizontalAlignment(SwingConstants.LEFT);
		lblContrasenia.setBounds(65, 167, 80, 21);
		contentPane.add(lblContrasenia);
		
		btnSalir = new JButton("Volver", new FlatSVGIcon("arrow_back_ios_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20));
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSalir.setCursor(new Cursor(HAND_CURSOR));
		btnSalir.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		btnSalir.setBounds(340, 349, 100, 40);
		contentPane.add(btnSalir);
		
		btnLogin = new JButton("Logearse");
		btnLogin.setBounds(65, 284, 320, 40);
		btnLogin.setCursor(new Cursor(HAND_CURSOR));
		contentPane.add(btnLogin);
		
		btnOlvidoContrasenia = new JButton("Olvide mi contraseña");
		btnOlvidoContrasenia.setForeground(new Color(0, 150, 199));
		btnOlvidoContrasenia.setCursor(new Cursor(HAND_CURSOR));
		btnOlvidoContrasenia.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnOlvidoContrasenia.setHorizontalAlignment(SwingConstants.LEADING);
		btnOlvidoContrasenia.setBounds(52, 235, 150, 20);
		btnOlvidoContrasenia.putClientProperty(FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		contentPane.add(btnOlvidoContrasenia);
		
		
		// -- TEXTFIELDS DE DATOS
		txtCuenta = new JTextField();
		txtCuenta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su usuario");
		txtCuenta.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("account_circle_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg", 18, 18));
		txtCuenta.setBounds(65, 116, 320, 40);
		contentPane.add(txtCuenta);
		txtCuenta.setColumns(10);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese su contraseña");
		txtContrasenia.putClientProperty(FlatClientProperties.TEXT_FIELD_LEADING_ICON, new FlatSVGIcon("lock_24dp_999999_FILL0_wght400_GRAD0_opsz24.svg", 18, 18));
		txtContrasenia.setBounds(65, 192, 320, 40);
		contentPane.add(txtContrasenia);

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

	public JButton getBtnLogin(){
		return btnLogin;
	}

	public JButton getBtnCambioSalir() {
		return btnCambioSalir;
	}

	public JButton getBtnCambioAceptar() {
		return btnCambioAceptar;
	}

	public JTextField getTxtCambioCuenta() {
		return txtCambioCuenta;
	}

	public JPasswordField getTxtContraseniaNueva1() {
		return txtContraseniaNueva1;
	}

	public JPasswordField getTxtContraseniaNueva2() {
		return txtContraseniaNueva2;
	}

	public JButton getBtnOlvidoContrasenia() {
		return btnOlvidoContrasenia;
	}

	public JPanel getPanelCambio() {
		return panelCambio;
	}
	
	
}
