package view.componentes;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.GridLayout;

import model.Participante;

public class PanelJugadorFinal extends PanelJugadorPadre{

	protected ArrayList<JPanel> errores = new ArrayList<JPanel>();

	public PanelJugadorFinal () {
		setLayout(new GridLayout(1, 3, 0, 0));
		setBorder(new EmptyBorder(20, 20, 20, 20));
		setBackground(colorOriginal);		
		
		panelErrores = new JPanel();
		add(panelErrores);
		panelErrores.setBackground(colorOriginal);
		for (int i = 0; i < 10; i++) {
			this.errores.add(new JPanel());
			this.errores.get(i).setBackground(colorOriginal);
			this.errores.get(i).setBorder(new LineBorder(Color.black, 1));
			panelErrores.add(this.errores.get(i));
		}

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