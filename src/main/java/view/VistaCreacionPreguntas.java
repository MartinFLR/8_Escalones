package view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorCreacionPreguntas;

import javax.swing.JTextField;
import javax.swing.JButton;
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
	private JTextField textRespuestaAproximacion;
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
		tabbedPane.setBounds(0, 0, 428, 258);
		contentPane.add(tabbedPane);

		panelOpcion = new JPanel();
		tabbedPane.addTab("Opcion", null, panelOpcion, null);

		panelAproximacion = new JPanel();
		tabbedPane.addTab("Aproximacion", null, panelAproximacion, null);
		panelAproximacion.setLayout(null);

		//REGUNTA APROXIMACION

		JLabel lblPreguntaAprox = new JLabel("Ingrese la pregunta de aproximacion:");
		lblPreguntaAprox.setBounds(10, 11, 228, 14);
		panelAproximacion.add(lblPreguntaAprox);

		textPregunta = new JTextField();
		textPregunta.setBounds(10, 36, 361, 20);
		panelAproximacion.add(textPregunta);
		textPregunta.setColumns(10);

		JLabel lblRespuestaAproximacion = new JLabel("Ingrese la respuesta:");
		lblRespuestaAproximacion.setBounds(10, 67, 176, 14);
		panelAproximacion.add(lblRespuestaAproximacion);

		textRespuestaAproximacion = new JTextField();
		textRespuestaAproximacion.setBounds(10, 92, 86, 20);
		panelAproximacion.add(textRespuestaAproximacion);
		textRespuestaAproximacion.setColumns(10);

		btnVolverAproximacion = new JButton("Volver");
		btnVolverAproximacion.setBounds(334, 200, 89, 23);
		panelAproximacion.add(btnVolverAproximacion);

		btnAñadirAproximacion = new JButton("Añadir");
		btnAñadirAproximacion.setBounds(244, 200, 89, 23);
		panelAproximacion.add(btnAñadirAproximacion);
		panelOpcion.setLayout(null);

		//PREGUNTA OPCION

		JLabel lblPregunta = new JLabel("Ingrese la pregunta:");
		lblPregunta.setBounds(10, 8, 186, 14);
		panelOpcion.add(lblPregunta);

		txetPregunta = new JTextField();
		txetPregunta.setBounds(10, 22, 328, 20);
		txetPregunta.setColumns(10);
		panelOpcion.add(txetPregunta);


		JLabel lblRespuestaCorrecta = new JLabel("Ingrese la respuesta correcta:");
		lblRespuestaCorrecta.setBounds(10, 53, 186, 14);
		panelOpcion.add(lblRespuestaCorrecta);

		textRespuestaCorrecta = new JTextField();
		textRespuestaCorrecta.setBounds(10, 67, 169, 20);
		textRespuestaCorrecta.setColumns(10);
		panelOpcion.add(textRespuestaCorrecta);


		JLabel lblRespuestaIncorrecta = new JLabel("Ingrese las respuestas incorrectas:");
		lblRespuestaIncorrecta.setBounds(10, 98, 268, 14);
		panelOpcion.add(lblRespuestaIncorrecta);

		textIncorrecta_1 = new JTextField();
		textIncorrecta_1.setBounds(10, 112, 169, 20);
		textIncorrecta_1.setColumns(10);
		panelOpcion.add(textIncorrecta_1);

		textIncorrecta_3 = new JTextField();
		textIncorrecta_3.setBounds(10, 143, 169, 20);
		textIncorrecta_3.setColumns(10);
		panelOpcion.add(textIncorrecta_3);


		textIncorrecta_2 = new JTextField();
		textIncorrecta_2.setBounds(10, 174, 169, 20);
		textIncorrecta_2.setColumns(10);
		panelOpcion.add(textIncorrecta_2);

		btnAñadirOpcion = new JButton("Añadir");
		btnAñadirOpcion.setBounds(271, 200, 75, 23);
		panelOpcion.add(btnAñadirOpcion);

		btnVolverOpcion = new JButton("Volver");
		btnVolverOpcion.setBounds(348, 200, 75, 23);
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