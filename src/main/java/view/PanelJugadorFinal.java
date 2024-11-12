package view;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

public class PanelJugadorFinal extends PanelJugadorPadre{

	protected ArrayList<JPanel> errores = new ArrayList<JPanel>();
	
	public PanelJugadorFinal (String url) {
	setLayout(new GridLayout(1, 3, 0, 0));
	setBorder(new EmptyBorder(20, 20, 20, 20));
	
	ImageIcon imgJugador = new ImageIcon(url);
	lblimagenJugador = new JLabel(imgJugador);
	add(lblimagenJugador);
	
	lblnombreJugador = new JLabel("New label");
	add(lblnombreJugador);
	
	panelErrores = new JPanel();
	add(panelErrores);
	for (int i = 0; i < 10; i++) {
		this.errores.add(new JPanel());
		this.errores.get(i).setBackground(colorOriginal);
		panelErrores.add(this.errores.get(i));
		}
	
	}

	@Override
	public void setError() {
		for (JPanel panel: errores) {
			if (panel.getBackground().equals(colorOriginal)) {
				panel.setBackground(colorError);
				break;
			}
		}
	}

	@Override
	public void setAcierto() {
		for (JPanel panel: errores) {
			if (panel.getBackground().equals(colorOriginal)) {
				panel.setBackground(colorAcierto);
				break;
			}
		}
	}

	@Override
	public void setResetErrores() {
		for (JPanel panel: errores) {
			panel.setBackground(colorOriginal);
			}
		}
	}

