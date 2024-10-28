package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import controlador.ControladorJuego;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_aproximacion;
	private JPanel panelPreguntas;
	private ControladorJuego c;
	private JButton btnUno;
	private JButton btnDos;
	private JButton btnTres;
	private JButton btnCuatro;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JPanel panel;
	private JTextField textField;
	private JButton btnEnviar;


	public VistaJuego(ControladorJuego c) {
		this.setC(c);
		setTitle("8 ESCALONES");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 819, 469);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.addKeyListener(c);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//
		// panel columnas
		//
		
		
		
		//
		// panel participantes
		//
		
		
		//---------------------Panel Principal----------------------------------
		//
		// panel aproximacion
		//
		
		panel_aproximacion = new JPanel();
		panel_aproximacion.setBounds(0, 260, 803, 170);
		panel_aproximacion.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_aproximacion.setBackground(new Color(0, 0, 139));
		contentPane.add(panel_aproximacion);
		panel_aproximacion.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(0, 255, 255));
		panel.setBounds(82, 48, 369, 52);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_aproximacion.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("preguntas de aproximacion");
		panel.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(82, 124, 128, 35);
		panel_aproximacion.add(textField);
		textField.setColumns(10);
		
		btnEnviar = new JButton("New button");
		btnEnviar.setBounds(323, 124, 128, 35);
		btnEnviar.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnEnviar.setBackground(new Color(0, 255, 255));
		panel_aproximacion.add(btnEnviar);
		panel_aproximacion.setVisible(false);
		
		panel_aproximacion.setVisible(false);
		panel_aproximacion.addKeyListener(c);
		
		
		//
		// panel preguntas
		//
		
		panelPreguntas = new JPanel();
		panelPreguntas.setBounds(0, 260, 803, 170);
		panelPreguntas.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelPreguntas.setBackground(new Color(0, 0, 139));
		panelPreguntas.setLayout(null);
		contentPane.add(panelPreguntas);
		
		btnUno = new JButton("Respuesta 1");
		btnUno.setForeground(new Color(0, 0, 0));
		btnUno.setBackground(new Color(0, 255, 255));
		btnUno.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		btnUno.setBounds(10, 58, 382, 45);
		panelPreguntas.add(btnUno);
		
		btnDos = new JButton("Respuesta 2");
		btnDos.setBackground(new Color(0, 255, 255));
		btnDos.setBounds(10, 114, 382, 45);
		btnDos.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelPreguntas.add(btnDos);
		
		btnTres = new JButton("Respuesta 3");
		btnTres.setBackground(new Color(0, 255, 255));
		btnTres.setBounds(411, 58, 382, 45);
		btnTres.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelPreguntas.add(btnTres);
		
		btnCuatro = new JButton("Respuesta 4");
		btnCuatro.setBackground(new Color(0, 255, 255));
		btnCuatro.setBounds(411, 114, 382, 45);
		btnCuatro.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panelPreguntas.add(btnCuatro);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.CYAN);
		panel_1.setBounds(199, 11, 402, 36);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		panel_1.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Preguntas...");
		panel_1.add(lblNewLabel, BorderLayout.CENTER);
		panelPreguntas.add(panel_1);
		panelPreguntas.setVisible(false);
		panelPreguntas.addKeyListener(c);
		
		//-------------Panel informativo nombre y juez---------------------
		
		
		addKeyListener(c);
		setFocusable(true);
	}

	public ControladorJuego getC() {
		return c;
	}

	public void setC(ControladorJuego c) {
		this.c = c;
	}

	public JButton getBtnUno() {
		return btnUno;
	}

	public void setBtnUno(JButton btnUno) {
		this.btnUno = btnUno;
	}

	public JPanel getPanel_aproximacion() {
		return panel_aproximacion;
	}

	public void setPanel_aproximacion(JPanel panel_aproximacion) {
		this.panel_aproximacion = panel_aproximacion;
	}

	public JPanel getPanelPreguntas() {
		return panelPreguntas;
	}

	public void setPanelPreguntas(JPanel panelPreguntas) {
		this.panelPreguntas = panelPreguntas;
	}
}
