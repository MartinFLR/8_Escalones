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

public class PanelJugadorNormal extends PanelJugadorPadre {

	protected JPanel panelerror1;
	protected JPanel panelerror2;

	public PanelJugadorNormal(String url) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(colorActivo);
		
		ImageIcon imgJugador = new ImageIcon(url);
		lblimagenJugador = new JLabel(imgJugador);
		add(lblimagenJugador);
		
		lblnombreJugador = new JLabel("NOMBRE");
		lblnombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblnombreJugador);
		
		panelErrores = new JPanel();
		add(panelErrores);
		panelErrores.setBackground(colorActivo);
		panelErrores.setLayout(new GridLayout(0, 2, 20, 20));
		panelErrores.setBorder(new EmptyBorder(20, 20, 20, 20));
		panelerror1 = new JPanel();
		panelerror1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelerror1.setBackground(colorOriginal);
		panelErrores.add(panelerror1);
		panelerror2 = new JPanel();
		panelerror2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panelerror2.setBackground(colorOriginal);
		panelErrores.add(panelerror2);
		
	}

	// SETEAR COLORES DE VIDA 
	@Override
	public void setError () {
		if (panelerror1.getBackground().equals(colorOriginal)) {
			panelerror1.setBackground(colorError);
		} else {
			panelerror2.setBackground(colorError);
		}
	}
	
	@Override
	public void setAcierto() {
		if (panelerror2.getBackground().equals(colorOriginal)) {
			panelerror1.setBackground(colorAcierto);
		} else {
			panelerror2.setBackground(colorAcierto);
		}
	}
	
	@Override
	public void setResetErrores () {
		panelerror1.setBackground(colorOriginal);
		panelerror2.setBackground(colorOriginal);
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



