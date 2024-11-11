package view;

import controller.ControladorCreacionJug;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class VistaCreacionJug extends JFrame{

	private ControladorCreacionJug c;
	private JPanel contentPane;
	private JButton btnJugar;
	private JTextField txtJugador1;
	private JTextField txtJugador2;
	private JTextField txtJugador3;
	private JTextField txtJugador4;
	private JTextField txtJugador5;
	private JTextField txtJugador6;
	private JTextField txtJugador7;
	private JTextField txtJugador8;
	private JTextField txtJugador9;
	
	public VistaCreacionJug (ControladorCreacionJug c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 781, 511);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(668, 441, 89, 23);
		contentPane.add(btnJugar);
		
		txtJugador1 = new JTextField();
		txtJugador1.setBounds(133, 85, 96, 19);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		txtJugador2 = new JTextField();
		txtJugador2.setBounds(133, 130, 96, 19);
		contentPane.add(txtJugador2);
		txtJugador2.setColumns(10);
		
		txtJugador3 = new JTextField();
		txtJugador3.setBounds(133, 175, 96, 19);
		contentPane.add(txtJugador3);
		txtJugador3.setColumns(10);
		
		txtJugador4 = new JTextField();
		txtJugador4.setBounds(133, 217, 96, 19);
		contentPane.add(txtJugador4);
		txtJugador4.setColumns(10);
		
		txtJugador5 = new JTextField();
		txtJugador5.setBounds(133, 263, 96, 19);
		contentPane.add(txtJugador5);
		txtJugador5.setColumns(10);
		
		txtJugador6 = new JTextField();
		txtJugador6.setBounds(133, 308, 96, 19);
		contentPane.add(txtJugador6);
		txtJugador6.setColumns(10);
		
		txtJugador7 = new JTextField();
		txtJugador7.setBounds(339, 85, 96, 19);
		contentPane.add(txtJugador7);
		txtJugador7.setColumns(10);
		
		txtJugador8 = new JTextField();
		txtJugador8.setBounds(339, 130, 96, 19);
		contentPane.add(txtJugador8);
		txtJugador8.setColumns(10);
		
		txtJugador9 = new JTextField();
		txtJugador9.setBounds(339, 175, 96, 19);
		contentPane.add(txtJugador9);
		txtJugador9.setColumns(10);
		
	}

	public ControladorCreacionJug getC() {
		return c;
	}
	public void setC(ControladorCreacionJug c) {
		this.c = c;
	}

	public JButton getBtnJugar() {
		return btnJugar;
	}
}
