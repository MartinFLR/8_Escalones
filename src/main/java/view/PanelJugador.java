package view;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;

public class PanelJugador extends JPanel {

	private JLabel lblimagenJugador;
	private JLabel lblnombreJugador;
	private JPanel panelerrores;
	private JPanel panelerror1;
	private JPanel panelerror2;
	private Color colorOriginal = Color.WHITE, colorAcierto = Color.GREEN, colorError = Color.RED;
	private Color colorActivo = Color.WHITE,colorEliminado = Color.GRAY;

	public PanelJugador(String url) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(colorActivo);
		
		ImageIcon imgJugador = new ImageIcon(url);
		lblimagenJugador = new JLabel(imgJugador);
		add(lblimagenJugador);
		
		lblnombreJugador = new JLabel("NOMBRE");
		lblnombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblnombreJugador);
		
		panelerrores = new JPanel();
		add(panelerrores);
		panelerrores.setBackground(colorActivo);
		panelerrores.setLayout(new GridLayout(0, 2, 20, 20));
		panelerrores.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelerror1 = new JPanel();
		panelerror1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelerror1.setBackground(colorOriginal);
		panelerrores.add(panelerror1);
		panelerror2 = new JPanel();
		panelerror2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelerror2.setBackground(colorOriginal);
		panelerrores.add(panelerror2);
		
	}

	// SETEAR COLORES DE VIDA 
	public void setError () {
		if (panelerror1.getBackground().equals(colorOriginal)) {
			panelerror1.setBackground(colorError);
		} else {
			panelerror2.setBackground(colorError);
		}
	}
	
	public void setAcierto() {
		if (panelerror2.getBackground().equals(colorOriginal)) {
			panelerror1.setBackground(colorAcierto);
		} else {
			panelerror2.setBackground(colorAcierto);
		}
	}
	
	public void setResetErrores () {
		panelerror1.setBackground(colorOriginal);
		panelerror2.setBackground(colorOriginal);
	}
	
	// SETEAR COLOR DE JUGADOR ACTIVO O ELIMINADO
	public void setJugando() {
		setBackground(colorActivo);
		panelerrores.setBackground(colorActivo);
	}
	
	public void setEliminado() {
		setBackground(colorEliminado);
		panelerrores.setBackground(colorEliminado);
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

}



