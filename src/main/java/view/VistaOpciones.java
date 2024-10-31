package view;

import controller.ControladorOpciones;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSlider;
import javax.swing.JButton;

public class VistaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorOpciones c;
	private JSlider slider;
	private JButton btnAyuda;
	private JButton btnCreditos;
	
	
	public VistaOpciones(ControladorOpciones c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 200, 450, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("OPCIONES");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(174, 11, 137, 14);
		contentPane.add(lblNewLabel);
		
		slider = new JSlider();
		slider.setBounds(10, 80, 200, 26);
		contentPane.add(slider);
		
		JLabel lblNewLabel_1 = new JLabel("volumen");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(10, 55, 122, 14);
		contentPane.add(lblNewLabel_1);
		
		btnAyuda = new JButton("AYUDA");
		btnAyuda.setBounds(152, 137, 114, 39);
		contentPane.add(btnAyuda);
		
		btnCreditos = new JButton("Creditos");
		btnCreditos.setBounds(152, 206, 111, 44);
		contentPane.add(btnCreditos);
	}


	public ControladorOpciones getC() {
		return c;
	}


	public void setC(ControladorOpciones c) {
		this.c = c;
	}
}
