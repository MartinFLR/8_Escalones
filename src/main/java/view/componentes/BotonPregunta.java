package view.componentes;

import java.awt.Color;

import javax.swing.JButton;

public class BotonPregunta extends JButton{

	private Color colorAcierto = new Color(56, 176, 0),colorError = new Color(193, 18, 31), colorOriginal = new Color(222, 226, 230);
	private boolean rta;
	
	public BotonPregunta () {
		setOriginal();
	}
	
	public void setRespuestaTexto(String rta) {
		setBackground(colorOriginal);
		setText(rta);
	}
	
	public void setOriginal() {
		setBackground(colorOriginal);
	}
	
	public void setError() {
		setBackground(colorError);
	}
	
	public void setAcierto() {
		setBackground(colorAcierto);
	}
	
	// COLOCA SI LA RESPUESTA ES CORRECTA O INCORRECTA
	public void setRespuesta(Boolean rta) {
		this.rta = rta;
	}
	
	
}
