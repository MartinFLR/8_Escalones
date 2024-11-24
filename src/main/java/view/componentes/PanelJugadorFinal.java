package view.componentes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;
import java.awt.Insets;

import model.Participante;

public class PanelJugadorFinal extends PanelJugadorPadre{

	protected ArrayList<JPanel> errores = new ArrayList<JPanel>();

	public PanelJugadorFinal () {
		setLayout(new GridBagLayout());
		setBackground(colorOriginal);		
		
		panelErrores = new JPanel();
		add(panelErrores);
		panelErrores.setBackground(colorOriginal);
		for (int i = 0; i < 10; i++) {
			this.errores.add(new JPanel());
			this.errores.get(i).setBackground(colorOriginal);
			this.errores.get(i).setBorder(new LineBorder(Color.black, 1));
			this.errores.get(i).setPreferredSize(new Dimension(50,50));
			panelErrores.add(this.errores.get(i));
		}
		GridBagConstraints gbc = new GridBagConstraints();

		gbc.gridx=0;
		gbc.gridy=0;
		gbc.insets= new Insets(0,5,5,5);
		add(lblimagenJugador, gbc);
		
		gbc.gridx=0;
		gbc.gridy=1;
		gbc.insets= new Insets(0,5,5,5);
		add(lblnombreJugador, gbc);

		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight=8;
		gbc.gridwidth=2;
		add(panelErrores, gbc);
		
	}

	public void setCampeon(){
		setBackground(colorActivo);
	}
	
	@Override
	public void setError(Participante par) {
		for (JPanel panel: errores) {
			if (panel.getBackground().equals(colorOriginal)) {
				panel.setBackground(colorError);
				break;
			}
		}
	}

	@Override
	public void setAcierto(Participante par) {
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