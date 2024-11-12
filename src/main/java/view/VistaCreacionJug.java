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
		setBounds(300, 200, 363, 431);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(140, 342, 89, 23);
		contentPane.add(btnJugar);
		
		txtJugador1 = new JTextField();
		txtJugador1.setBounds(133, 36, 96, 19);
		contentPane.add(txtJugador1);
		txtJugador1.setColumns(10);
		
		txtJugador2 = new JTextField();
		txtJugador2.setBounds(133, 61, 96, 19);
		contentPane.add(txtJugador2);
		txtJugador2.setColumns(10);
		
		txtJugador3 = new JTextField();
		txtJugador3.setBounds(133, 89, 96, 19);
		contentPane.add(txtJugador3);
		txtJugador3.setColumns(10);
		
		txtJugador4 = new JTextField();
		txtJugador4.setBounds(133, 119, 96, 19);
		contentPane.add(txtJugador4);
		txtJugador4.setColumns(10);
		
		txtJugador5 = new JTextField();
		txtJugador5.setBounds(133, 149, 96, 19);
		contentPane.add(txtJugador5);
		txtJugador5.setColumns(10);
		
		txtJugador6 = new JTextField();
		txtJugador6.setBounds(133, 175, 96, 19);
		contentPane.add(txtJugador6);
		txtJugador6.setColumns(10);
		
		txtJugador7 = new JTextField();
		txtJugador7.setBounds(133, 205, 96, 19);
		contentPane.add(txtJugador7);
		txtJugador7.setColumns(10);
		
		txtJugador8 = new JTextField();
		txtJugador8.setBounds(133, 236, 96, 19);
		contentPane.add(txtJugador8);
		txtJugador8.setColumns(10);
		
		txtJugador9 = new JTextField();
		txtJugador9.setBounds(133, 266, 96, 19);
		contentPane.add(txtJugador9);
		txtJugador9.setColumns(10);
		
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
	
	public JTextField getTxtJugador1() {return txtJugador1;}
	public JTextField getTxtJugador2() {return txtJugador2;}
	public JTextField getTxtJugador3() {return txtJugador3;}
	public JTextField getTxtJugador4() {return txtJugador4;}
	public JTextField getTxtJugador5() {return txtJugador5;}
	public JTextField getTxtJugador6() {return txtJugador6;}
	public JTextField getTxtJugador7() {return txtJugador7;}
	public JTextField getTxtJugador8() {return txtJugador8;}
	public JTextField getTxtJugador9() {return txtJugador9;}
	

	public JButton getBtnJugar() {
		return btnJugar;
	}
}
