package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class PanelJugador extends JPanel {
	private JLabel lblimagenJugador;
	private JLabel lblnombreJugador;
	private ImageIcon imgJugador;
	private JPanel panelvida1;
	private JPanel panelvida2;

	public PanelJugador() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		lblimagenJugador = new JLabel("New label");
		add(lblimagenJugador);
		
		lblnombreJugador = new JLabel("New label");
		add(lblnombreJugador);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		panelvida1 = new JPanel();
		panelvida1.setBackground(Color.GREEN);
		panel.add(panelvida1);
		
		panelvida2 = new JPanel();
		panelvida2.setBackground(Color.RED);
		panel.add(panelvida2);
		
		
		
		
	}

	// ----------------- setear vida de los jugadores con los colores
	public void vidaJugador () {
		
	}

	// ------------------ setear la vida al estado normal
	public void vidadefault () {
		panelvida1.setBackground(null);
		panelvida2.setBackground(null);
	}
	
	public JLabel getLblimagenJugador() {
		return lblimagenJugador;
	}
	public void setLblimagenJugador(JLabel lblimagenJugador) {
		this.lblimagenJugador = lblimagenJugador;
	}
	public JLabel getLblnombreJugador() {
		return lblnombreJugador;
	}
	public void setLblnombreJugador(JLabel lblnombreJugador) {
		this.lblnombreJugador = lblnombreJugador;
	}
	public JPanel getPanelvida2() {
		return panelvida2;
	}
	public void setPanelvida2(JPanel panelvida2) {
		this.panelvida2 = panelvida2;
	}
	public JPanel getPanelvida1() {
		return panelvida1;
	}
	public void setPanelvida1(JPanel panelvida1) {
		this.panelvida1 = panelvida1;
	}
	public ImageIcon getImgJugador() {
		return imgJugador;
	}
	public void setImgJugador(ImageIcon imgJugador) {
		this.imgJugador = imgJugador;
	}
	
	

}



