package view;

import controller.ControladorCreacionJug;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.GridLayout;


public class VistaCreacionJug extends JFrame{

	private static final long serialVersionUID = 1L;
	private ControladorCreacionJug c;
	private JPanel contentPane;
	private JButton btnJugar;
	private JPanel panelCreacion;
	
	private ArrayList<JTextField> txtJugador = new ArrayList<JTextField>();
	private ArrayList<JComboBox> comboboxImg = new ArrayList<JComboBox>();
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
		
		GridLayout gridlayout = new GridLayout(3,3);
		panelCreacion = new JPanel();
		panelCreacion.setBounds(10, 11, 1244, 625);
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
			this.paneles.add(new JPanel(new GridLayout(1,2)));
			panelCreacion.add(this.paneles.get(i));
			
			this.comboboxImg.add(new JComboBox(imagenes));
			this.paneles.get(i).add(this.comboboxImg.get(i));
			
			this.txtJugador.add(new JTextField());
			setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.paneles.get(i).add(this.txtJugador.get(i));
		}
		
		
		// ........................................
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(1165, 647, 89, 23);
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
