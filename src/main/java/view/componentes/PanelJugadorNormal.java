package view.componentes;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Participante;
public class PanelJugadorNormal extends PanelJugadorPadre {

	private static final long serialVersionUID = 1L;
	protected JPanel panelerror1;
	protected JPanel panelerror2;
	protected boolean activo = true;
	protected Color colorPaso = new Color(167, 201, 87);

	public PanelJugadorNormal() {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setLayout(new GridLayout(0, 1, 0, 0));
		setBackground(colorActivo);

		add(lblimagenJugador);
		add(lblnombreJugador);
		
		panelErrores = new JPanel();
		add(panelErrores);
		panelErrores.setBackground(colorActivo);
		panelErrores.setLayout(new GridLayout(0, 2, 10, 10));
		panelErrores.setBorder(new EmptyBorder(10, 20, 10, 20));
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
			panelerror2.setBackground(colorError);
		} else {
			panelerror1.setBackground(colorError);
		}
	}

	@Override
	public void setAcierto(Participante par) {
		if (par.getPreguntasParticipante().size()==1)
		{panelerror2.setBackground(colorAcierto);
		} else {
			panelerror1.setBackground(colorAcierto);
		}
	}

	@Override
	public void setResetErrores () {
		setBackground(colorOriginal);
		panelErrores.setBackground(colorOriginal);
		panelerror1.setVisible(true);
		panelerror2.setVisible(true);
		panelerror1.setBackground(colorOriginal);
		panelerror2.setBackground(colorOriginal);
	}

	@Override
	public void setActivo(){
		setBackground(colorActivo);
		setForeground(colorActivo);
		panelErrores.setBackground(colorActivo);
	}
	@Override
	public void setEliminado(){
		setBackground(colorEliminado);
		panelErrores.setBackground(colorEliminado);
		this.panelerror1.setVisible(false);
		this.panelerror2.setVisible(false);
		this.activo = false;	
	}
	
	public void setPaso() {
		this.panelerror1.setVisible(false);
		this.panelerror2.setVisible(false);
		setBackground(colorPaso);
		panelErrores.setBackground(colorPaso);
	}
	
	public boolean isActivo(){
		return this.activo;
	}
}