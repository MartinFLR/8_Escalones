package view;

import controller.ControladorOpciones;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class VistaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorOpciones c;
	private JButton btnSalir;
	private JSlider sliderMusica;
	private JSlider sliderSonido;
	
	
	public VistaOpciones(ControladorOpciones c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 300, 400);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setResizable(false);
		
		sliderSonido = new JSlider();
		sliderSonido.setBounds(41, 147, 218, 30);
		contentPane.add(sliderSonido);
		
		sliderMusica = new JSlider();
		sliderMusica.setBounds(41, 225, 218, 30);
		contentPane.add(sliderMusica);
		
		
		btnSalir = new JButton("Volver");
		btnSalir.setBounds(200, 359, 90, 30);
		contentPane.add(btnSalir);
		btnSalir.addActionListener(c);

		
		JLabel lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(10, 24, 280, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Musica");
		lblNewLabel_1.setBounds(41, 122, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sonido");
		lblNewLabel_2.setBounds(41, 200, 46, 14);
		contentPane.add(lblNewLabel_2);
		
	}


	public ControladorOpciones getC() {
		return c;
	}
	public void setC(ControladorOpciones c) {
		this.c = c;
	}


	public JButton getBtnSalir() {
		return btnSalir;
	}
}
