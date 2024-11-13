package view;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import controller.ControladorModPreguntas;

import javax.swing.JTextField;
import javax.swing.JButton;

public class VistaModPreguntas extends JFrame{
	
	private JPanel contentPane;
	private JTextField txetPregunta;
	private JTextField textRespuestaCorrecta;
	private JTextField textIncorrecta_1;
	private JTextField textIncorrecta_3;
	private JTextField textIncorrecta_2;
	private JLabel lblTema;
	private ControladorModPreguntas c;
	private JButton btnAñadir;
	private JButton btnCancelar;
	
	
	public VistaModPreguntas(ControladorModPreguntas c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 444, 297);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setUndecorated(true);
		
		lblTema = new JLabel("Tema: ");
		lblTema.setBounds(0, 0, 434, 14);
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTema);
		
		JLabel lblPregunta = new JLabel("Ingrese la pregunta:");
		lblPregunta.setBounds(10, 40, 371, 14);
		contentPane.add(lblPregunta);
		
		txetPregunta = new JTextField();
		txetPregunta.setBounds(10, 65, 371, 20);
		contentPane.add(txetPregunta);
		txetPregunta.setColumns(10);
		
		JLabel lblRespuestaCorrecta = new JLabel("Ingrese la respuesta correcta:");
		lblRespuestaCorrecta.setBounds(10, 96, 371, 14);
		contentPane.add(lblRespuestaCorrecta);
		
		textRespuestaCorrecta = new JTextField();
		textRespuestaCorrecta.setBounds(10, 121, 203, 20);
		contentPane.add(textRespuestaCorrecta);
		textRespuestaCorrecta.setColumns(10);
		
		JLabel lblRespuestaIncorrecta = new JLabel("Ingrese unas respuesta incorrectas:");
		lblRespuestaIncorrecta.setBounds(10, 152, 371, 14);
		contentPane.add(lblRespuestaIncorrecta);
		
		textIncorrecta_1 = new JTextField();
		textIncorrecta_1.setBounds(10, 173, 203, 20);
		contentPane.add(textIncorrecta_1);
		textIncorrecta_1.setColumns(10);
		
		textIncorrecta_3 = new JTextField();
		textIncorrecta_3.setBounds(10, 230, 203, 20);
		contentPane.add(textIncorrecta_3);
		textIncorrecta_3.setColumns(10);
		
		textIncorrecta_2 = new JTextField();
		textIncorrecta_2.setBounds(10, 199, 203, 20);
		contentPane.add(textIncorrecta_2);
		textIncorrecta_2.setColumns(10);
		
		btnAñadir = new JButton("Añadir");
		btnAñadir.setBounds(335, 198, 89, 23);
		contentPane.add(btnAñadir);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(335, 229, 89, 23);
		contentPane.add(btnCancelar);
	}
	public ControladorModPreguntas getC() {
		return c;
	}
	public void setC(ControladorModPreguntas c) {
		this.c = c;
	}
	public JLabel getLblTema() {
		return lblTema;
	}
	public void setLblTema(JLabel lblTema) {
		this.lblTema = lblTema;
	}
	public JButton getBtnAñadir() {
		return btnAñadir;
	}
	public JButton getBtnCancelar() {
		return btnCancelar;
	}
}
