package view;

import controller.ControladorCreacionJug;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class VistaCreacionJug extends JFrame{

	private ControladorCreacionJug c;
	private JPanel contentPane;
	private JButton btnJugar;
	
	public VistaCreacionJug (ControladorCreacionJug c) {
		this.setC(c);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(300, 200, 393, 363);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnJugar = new JButton("Jugar");
		btnJugar.setBounds(335, 227, 89, 23);
		contentPane.add(btnJugar);
		
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
