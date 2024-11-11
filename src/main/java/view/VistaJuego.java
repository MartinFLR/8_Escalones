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
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;

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
	private JTable table;
	private JLabel lblJuez;
	private JLabel lblJugador;
	
	private PanelEscalon e1, e2, e3, e4, e5, e6, e7, e8;
	private PanelJugador j1, j2, j3, j4, j5, j6 ,j7 ,j8 ,j9;

	public VistaJuego(ControladorJuego c) {
		this.setC(c);
		setTitle("8 ESCALONES");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.addKeyListener(c);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblJuez = new JLabel("Nombre JUEZ");
		lblJuez.setBounds(75, 442, 347, 56);
		contentPane.add(lblJuez);
		
		lblJugador = new JLabel("Nombre JUGADOR");
		lblJugador.setBounds(581, 442, 393, 56);
		contentPane.add(lblJugador);
		
		//
		// PANEL COLUMNAS
		//
		
		panelColumna = new JPanel();
		panelColumna.setBounds(0, 0, 65, 611);
		contentPane.add(panelColumna);
		panelColumna.setLayout(new GridLayout(8, 1, 0, 0));
		
		e8 = new PanelEscalon(8);
		panelColumna.add(e8);
		e7 = new PanelEscalon(7);
		panelColumna.add(e7);
		e6 = new PanelEscalon(6);
		panelColumna.add(e6);
		e5 = new PanelEscalon(5);
		panelColumna.add(e5);
		e4 = new PanelEscalon(4);
		panelColumna.add(e4);
		e3 = new PanelEscalon(3);
		panelColumna.add(e3);
		e2 = new PanelEscalon(2);
		panelColumna.add(e2);
		e1 = new PanelEscalon(1);
		panelColumna.add(e1);
		
		
		//
		// PANEL JUGADORES
		//
		
		panelJugadores = new JPanel();
		panelJugadores.setSize(new Dimension(5, 5));
		panelJugadores.setBounds(65, 508, 919, 103);
		contentPane.add(panelJugadores);
		panelJugadores.setBackground(Color.black);
		panelJugadores.setLayout(new GridLayout(0, 9, 0, 0));
		
		j1 = new PanelJugador();
		panelJugadores.add(j1);
		j2 = new PanelJugador();
		panelJugadores.add(j2);
		j3 = new PanelJugador();
		panelJugadores.add(j3);
		j4 = new PanelJugador();
		panelJugadores.add(j4);
		j5 = new PanelJugador();
		panelJugadores.add(j5);
		j6 = new PanelJugador();
		panelJugadores.add(j6);
		j7 = new PanelJugador();
		panelJugadores.add(j7);
		j8 = new PanelJugador();
		panelJugadores.add(j8);
		j9 = new PanelJugador();
		panelJugadores.add(j9);
		
		
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
		
		table = new JTable();
		table.setBounds(229, 209, 196, 149);
		panelAproximacion.add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(239, 368, 179, 43);
		panelAproximacion.add(lblNewLabel);
		
		
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
