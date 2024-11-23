package view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.text.NumberFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.NumberFormatter;

import com.formdev.flatlaf.FlatClientProperties;

import controller.ControladorCreacionPreguntas;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JTabbedPane;

public class VistaCreacionPreguntas extends JFrame{

	private JPanel contentPane;
	private JTextField txetPregunta;
	private JTextField textRespuestaCorrecta;
	private JTextField textIncorrecta_1;
	private JTextField textIncorrecta_3;
	private JTextField textIncorrecta_2;
	private JLabel lblTema;
	private ControladorCreacionPreguntas c;
	private JButton btnAñadirOpcion;
	private JButton btnVolverOpcion;
	private JTabbedPane tabbedPane;
	private JPanel panelOpcion;
	private JPanel panelAproximacion;
	private JTextField textPregunta;
	private JFormattedTextField textRespuestaAproximacion;
	private JButton btnVolverAproximacion;
	private JButton btnAñadirAproximacion;


	public VistaCreacionPreguntas(ControladorCreacionPreguntas c) {
		this.setC(c);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 250, 444, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 444, 297);
		contentPane.add(tabbedPane);

		panelOpcion = new JPanel();
		tabbedPane.addTab("Opcion", null, panelOpcion, null);

		panelAproximacion = new JPanel();
		tabbedPane.addTab("Aproximacion", null, panelAproximacion, null);
		panelAproximacion.setLayout(null);

		//REGUNTA APROXIMACION

		JLabel lblPreguntaAprox = new JLabel("Pregunta:");
		lblPreguntaAprox.setBounds(10, 9, 228, 14);
		panelAproximacion.add(lblPreguntaAprox);

		textPregunta = new JTextField();
		textPregunta.setBounds(10, 27, 410, 30);
		textPregunta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la pregunta de aproximación");
		panelAproximacion.add(textPregunta);
		textPregunta.setColumns(10);

		JLabel lblRespuestaAproximacion = new JLabel("Respuesta:");
		lblRespuestaAproximacion.setBounds(10, 72, 176, 14);
		panelAproximacion.add(lblRespuestaAproximacion);

		NumberFormat formatoNumero = NumberFormat.getIntegerInstance();
        NumberFormatter formateador = new NumberFormatter(formatoNumero);
        formateador.setAllowsInvalid(false);
        formateador.setMinimum(0);
        formateador.setMaximum(10000000); 
		textRespuestaAproximacion = new JFormattedTextField(formateador);
		textRespuestaAproximacion.setBounds(10, 88, 230, 30);
		textRespuestaAproximacion.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la respuesta numérica");
		panelAproximacion.add(textRespuestaAproximacion);
		textRespuestaAproximacion.setColumns(10);

		btnVolverAproximacion = new JButton("Volver");
		btnVolverAproximacion.setBounds(354, 235, 75, 23);
		btnVolverAproximacion.setCursor(new Cursor(HAND_CURSOR));
		panelAproximacion.add(btnVolverAproximacion);

		btnAñadirAproximacion = new JButton("Añadir");
		btnAñadirAproximacion.setBounds(273, 235, 75, 23);
		btnAñadirAproximacion.setCursor(new Cursor(HAND_CURSOR));
		panelAproximacion.add(btnAñadirAproximacion);
		panelOpcion.setLayout(null);

		//PREGUNTA OPCION

		JLabel lblPregunta = new JLabel("Pregunta:");
		lblPregunta.setBounds(10, 8, 186, 14);
		panelOpcion.add(lblPregunta);

		txetPregunta = new JTextField();
		txetPregunta.setBounds(10, 27, 410, 30);
		txetPregunta.setColumns(10);
		txetPregunta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la pregunta de opciones");
		panelOpcion.add(txetPregunta);


		JLabel lblRespuestaCorrecta = new JLabel("Respuesta correcta:");
		lblRespuestaCorrecta.setBounds(10, 68, 186, 20);
		panelOpcion.add(lblRespuestaCorrecta);

		textRespuestaCorrecta = new JTextField();
		textRespuestaCorrecta.setBounds(10, 88, 230, 30);
		textRespuestaCorrecta.setColumns(10);
		textRespuestaCorrecta.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la respuesta correcta");
		panelOpcion.add(textRespuestaCorrecta);


		JLabel lblRespuestaIncorrecta = new JLabel("Respuestas incorrectas");
		lblRespuestaIncorrecta.setBounds(10, 129, 268, 14);
		panelOpcion.add(lblRespuestaIncorrecta);

		textIncorrecta_1 = new JTextField();
		textIncorrecta_1.setBounds(10, 144, 230, 30);
		textIncorrecta_1.setColumns(10);
		textIncorrecta_1.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la respuesta incorrecta");
		panelOpcion.add(textIncorrecta_1);
		
		textIncorrecta_2 = new JTextField();
		textIncorrecta_2.setBounds(10, 226, 230, 30);
		textIncorrecta_2.setColumns(10);
		textIncorrecta_2.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la respuesta incorrecta");
		panelOpcion.add(textIncorrecta_2);

		textIncorrecta_3 = new JTextField();
		textIncorrecta_3.setBounds(10, 185, 230, 30);
		textIncorrecta_3.setColumns(10);
		textIncorrecta_3.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Ingrese la respuesta incorrecta");
		panelOpcion.add(textIncorrecta_3);
		

		btnAñadirOpcion = new JButton("Añadir");
		btnAñadirOpcion.setBounds(273, 235, 75, 23);
		btnAñadirOpcion.setCursor(new Cursor(HAND_CURSOR));
		panelOpcion.add(btnAñadirOpcion);

		btnVolverOpcion = new JButton("Volver");
		btnVolverOpcion.setBounds(354, 235, 75, 23);
		btnVolverOpcion.setCursor(new Cursor(HAND_CURSOR));
		panelOpcion.add(btnVolverOpcion);

	}
	public ControladorCreacionPreguntas getC() {
		return c;
	}
	public void setC(ControladorCreacionPreguntas c) {
		this.c = c;
	}
	public JLabel getLblTema() {
		return lblTema;
	}
	public void setLblTema(JLabel lblTema) {
		this.lblTema = lblTema;
	}
	public JButton getBtnAñadir() {
		return btnAñadirOpcion;
	}
	public JButton getBtnCancelar() {
		return btnVolverOpcion;
	}
	public JTextField getTxetPregunta() {
		return txetPregunta;
	}
	public JTextField getTextRespuestaCorrecta() {
		return textRespuestaCorrecta;
	}
	public JTextField getTextIncorrecta_1() {
		return textIncorrecta_1;
	}
	public JTextField getTextIncorrecta_3() {
		return textIncorrecta_3;
	}
	public JTextField getTextIncorrecta_2() {
		return textIncorrecta_2;
	}
	public JTextField getTextPregunta() {
		return textPregunta;
	}
	public JTextField getTextRespuestaAproximacion() {
		return textRespuestaAproximacion;
	}
	public JButton getBtnVolverAproximacion() {
		return btnVolverAproximacion;
	}
	public JButton getBtnAñadirAproximacion() {
		return btnAñadirAproximacion;
	}


}