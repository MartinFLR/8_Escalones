package view.componentes;

import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Participante;

import javax.swing.SwingConstants;
public class PanelJugadorNormal extends PanelJugadorPadre {

	protected JPanel panelerror1;
	protected JPanel panelerror2;

	public PanelJugadorNormal() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(colorActivo);
		
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
	public void setError (Participante par) {
			if (par.getPreguntasParticipante().size()==1)//si es tu primera respuesta respondida,osea que te queds responder otra (por eso el =1)setea e color del primer boton
			{
			panelerror1.setBackground(colorError);
		} else {
			panelerror2.setBackground(colorError);
		}
	}
	
	@Override
	public void setAcierto(Participante par) {
		if (par.getPreguntasParticipante().size()==1)
{panelerror1.setBackground(colorAcierto);
		} else {
			panelerror2.setBackground(colorAcierto);
		}
	}
	
	@Override
	public void setResetErrores () {
		panelerror1.setBackground(colorOriginal);
		panelerror2.setBackground(colorOriginal);
	}
	
        @Override
	public void setActivo(){
		setBackground(colorActivo);
	}
	
}



