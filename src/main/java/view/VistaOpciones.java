package view;

import controller.ControladorOpciones;
import view.componentes.FuentePersonalizada;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.JLabel;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.util.Vector;

import javax.swing.JSlider;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;

public class VistaOpciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorOpciones c;
	private JButton btnSalir;
	private JSlider sliderSonido;
	private JSlider sliderMusica;
	
	
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
		
		sliderMusica = new JSlider();
		sliderMusica.setBounds(41, 147, 218, 51);
	    sliderMusica.setMinimum(-50);        
	    sliderMusica.setMaximum(6);          
	    sliderMusica.setValue(0);            
	    sliderMusica.setMajorTickSpacing(10);
		contentPane.add(sliderMusica);
		
		sliderSonido = new JSlider();
		sliderSonido.setBounds(41, 225, 218, 51);
	    sliderSonido.setMinimum(-50);        
	    sliderSonido.setMaximum(6);          
	    sliderSonido.setValue(0);            
	    sliderSonido.setMajorTickSpacing(10);
		contentPane.add(sliderSonido);
		
		btnSalir = new JButton("Volver", new FlatSVGIcon("arrow_back_ios_24dp_EFEFEF_FILL0_wght400_GRAD0_opsz24.svg", 20, 20));
		btnSalir.setBounds(190, 349, 100, 40);
		btnSalir.setCursor(new Cursor(HAND_CURSOR));
		btnSalir.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_BORDERLESS);
		btnSalir.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.add(btnSalir);
		btnSalir.addActionListener(c);
		
		JLabel lblNewLabel = new JLabel("Opciones");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 30f));
		lblNewLabel.setBounds(10, 24, 280, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Musica");
		lblNewLabel_1.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 14f));
		lblNewLabel_1.setBounds(41, 116, 46, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Sonido");
		lblNewLabel_2.setFont(new FuentePersonalizada().getFuente("fonts/Helvetica Bold Condensed.otf", 14f));
		lblNewLabel_2.setBounds(41, 194, 46, 20);
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


	public JSlider getSliderSonido() {
		return sliderSonido;
	}


	public JSlider getSliderMusica() {
		return sliderMusica;
	}
}
