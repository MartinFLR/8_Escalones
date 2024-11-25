package view;

import controller.ControladorCreacionJug;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.JComboBox;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Label;


public class VistaCreacionJug extends JFrame{

	private static final long serialVersionUID = 1L;
	private ControladorCreacionJug c;
	private JPanel contentPane;
	private JButton btnJugar;
	private JPanel panelCreacion;
	
	private ArrayList<JTextField> txtJugador = new ArrayList<JTextField>();
	private ArrayList<JComboBox> comboboxImg = new ArrayList<JComboBox>();
	private ArrayList <Label> info = new ArrayList<Label>();
	
	private Vector<ImageIcon> imagenes = new Vector<ImageIcon>();
	private ArrayList<JPanel> paneles = new ArrayList<>();
	
	public VistaCreacionJug (ControladorCreacionJug c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 1280, 720);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		GridLayout gridlayout = new GridLayout(3,3,20,20);
		panelCreacion = new JPanel();
		panelCreacion.setBounds(10, 11, 1244, 595);
		panelCreacion.setLayout(gridlayout);
		contentPane.add(panelCreacion);
		

		
		// LOGICA DE IMAGENES
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerBlack.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerBlue.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerCyan.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerGreen.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerOrange.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerPink.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerPurple.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerRed.png"));
		this.imagenes.add(new ImageIcon("imagenes/playericon/playerYellow.png")); 
		
		for (int i = 0; i < 9; i++) {
			this.paneles.add(new JPanel(new GridBagLayout()));
			this.paneles.get(i).setBorder(BorderFactory.createLineBorder(Color.BLACK, 2, true));
			GridBagConstraints gbc = new GridBagConstraints();
			panelCreacion.add(this.paneles.get(i));
			
			this.comboboxImg.add(new JComboBox(imagenes));
			this.comboboxImg.get(i).setPreferredSize(new Dimension(110, 90));
			this.comboboxImg.get(i).setMaximumRowCount(5);		
			this.comboboxImg.get(i).setCursor(new Cursor(HAND_CURSOR));
			gbc.gridx = 0; 
	        gbc.gridy = 0; 
	        gbc.gridwidth = 1; 
	        gbc.gridheight = 2; 		        
	        gbc.weightx = 0.2;       
	        gbc.weighty = 1.0; 		        
	        gbc.insets = new Insets(5, 5, 5, 5); 
			this.paneles.get(i).add(this.comboboxImg.get(i),gbc);
			
			this.info.add(new Label("Jugador "+(i+1)));
			this.info.get(i).setAlignment(SwingConstants.CENTER);
			this.info.get(i).setFont(new Font("Tahoma", Font.BOLD, 20));	       
	        gbc.gridx = 1;  
	        gbc.gridy = 0; 
	        gbc.gridwidth = 1; 
	        gbc.weightx = 0.6; 
	        gbc.weighty = 0.2; 
	        gbc.fill = GridBagConstraints.HORIZONTAL;
	        gbc.anchor = GridBagConstraints.NORTH; 
			this.paneles.get(i).add(this.info.get(i),gbc);
			
			this.txtJugador.add(new JTextField());
	        this.txtJugador.get(i).setPreferredSize(new Dimension(200, 50)); 
	        gbc.gridx = 1;
	        gbc.gridy = 1;
	        gbc.gridwidth = 1; 
	        gbc.weightx = 0.6; 
	        gbc.weighty = 0.8; 
	        gbc.fill = GridBagConstraints.NONE; 
	        gbc.anchor = GridBagConstraints.CENTER; 
			this.paneles.get(i).add(this.txtJugador.get(i),gbc);
			
		}
		
		
		// ........................................
		
		btnJugar = new JButton("Jugar");
		btnJugar.setFont(new Font("Tahome", Font.BOLD, 18));
		btnJugar.setCursor(new Cursor(HAND_CURSOR));
		btnJugar.putClientProperty( FlatClientProperties.BUTTON_TYPE, FlatClientProperties.BUTTON_TYPE_ROUND_RECT);
		btnJugar.setBounds(1149, 617, 105, 53);
		contentPane.add(btnJugar);
		
	}

	public ControladorCreacionJug getC() {
		return c;
	}
	public void setC(ControladorCreacionJug c) {
		this.c = c;
	}

	public JPanel getContentPane() {
		return contentPane;
		}

	public ArrayList<JTextField> getTxtJugador() {
		return txtJugador;
	}

	public ArrayList<JComboBox> getComboboxImg() {
		return comboboxImg;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}
}
