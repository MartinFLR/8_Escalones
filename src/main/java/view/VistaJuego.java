package view;

import controller.ControladorJuego;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;


import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorJuego c;

	private JPanel panelPregunta;
	private JLabel lblprePregunta;
	private JButton btnpreRespuesta2;
	private JButton btnpreRespuesta1;
	private JButton btnpreRespuesta3;
	private JButton btnpreRespuesta4;
	
	private JPanel panelAproximacion;
	private JLabel lblaproxPregunta;
	private JButton btnaproxEnviar;
	private JFormattedTextField txtaproxRespuesta;
	
	private JPanel panelColumna;
	private JPanel panelJugadores;


	public VistaJuego(ControladorJuego c) {
		this.setC(c);
		setTitle("8 ESCALONES");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 650);
		contentPane = new JPanel();
		contentPane.addKeyListener(c);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		//
		// PANEL COLUMNAS
		//
		
		panelColumna = new JPanel();
		panelColumna.setBounds(0, 0, 65, 611);
		contentPane.add(panelColumna);
		
		
		//
		// PANEL JUGADORES
		//
		
		panelJugadores = new JPanel();
		panelJugadores.setBounds(65, 506, 919, 105);
		contentPane.add(panelJugadores);
		
		//
		// PANEL INFORMATIVOS
		//
		
		
		
		//---------------------Panel Principal----------------------------------
		//
		// PANEL APROXIMACION
		//

		panelAproximacion = new JPanel();
		panelAproximacion.setBounds(525, 11, 449, 421);
		contentPane.add(panelAproximacion);
		panelAproximacion.setLayout(null);
		
		btnaproxEnviar = new JButton("ENVIAR");
		btnaproxEnviar.setBounds(48, 316, 142, 47);
		panelAproximacion.add(btnaproxEnviar);
		
		txtaproxRespuesta = new JFormattedTextField();
		txtaproxRespuesta.setBounds(48, 257, 142, 48);
		panelAproximacion.add(txtaproxRespuesta);
		
		lblaproxPregunta = new JLabel("New label");
		lblaproxPregunta.setBounds(48, 35, 370, 164);
		panelAproximacion.add(lblaproxPregunta);
		
		
		
		//
		// PANEL PREGUNTA
		//

		panelPregunta = new JPanel();
		panelPregunta.setBounds(75, 11, 440, 421);
		contentPane.add(panelPregunta);
		panelPregunta.setLayout(null);
		
		btnpreRespuesta1 = new JButton("New button");
		btnpreRespuesta1.setBounds(10, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta1);
		
		btnpreRespuesta2 = new JButton("New button");
		btnpreRespuesta2.setBounds(243, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta2);
		
		btnpreRespuesta3 = new JButton("New button");
		btnpreRespuesta3.setBounds(10, 313, 187, 55);
		panelPregunta.add(btnpreRespuesta3);
		
		btnpreRespuesta4 = new JButton("New button");
		btnpreRespuesta4.setBounds(243, 313, 187, 55);
		panelPregunta.add(btnpreRespuesta4);
		
		lblprePregunta = new JLabel("New label");
		lblprePregunta.setBounds(10, 97, 420, 131);
		panelPregunta.add(lblprePregunta);
		
	}
	public ControladorJuego getC() {
		return c;
	}
	public void setC(ControladorJuego c) {
		this.c = c;
	}
	
	public JLabel getLblprePregunta() {
		return lblprePregunta;
	}
	public JLabel getLblaproxPregunta() {
		return lblaproxPregunta;
	}
	public JPanel getPanelPregunta() {
		return panelPregunta;
	}
	public JButton getBtnpreRespuesta2() {
		return btnpreRespuesta2;
	}
	public JButton getBtnpreRespuesta1() {
		return btnpreRespuesta1;
	}
	public JButton getBtnpreRespuesta3() {
		return btnpreRespuesta3;
	}
	public JButton getBtnpreRespuesta4() {
		return btnpreRespuesta4;
	}
	public JPanel getPanelAproximacion() {
		return panelAproximacion;
	}
	public JButton getBtnaproxEnviar() {
		return btnaproxEnviar;
	}
	public JFormattedTextField getTxtaproxRespuesta() {
		return txtaproxRespuesta;
	}
	public JPanel getPanelColumna() {
		return panelColumna;
	}
	public JPanel getPanelJugadores() {
		return panelJugadores;
	}

	
	
	
}
