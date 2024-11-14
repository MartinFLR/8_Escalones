package view.componentes;

import java.awt.Color;

import javax.swing.JButton;

public class BotonPregunta extends JButton{

	private Color colorAcierto = Color.GREEN,colorError = Color.RED, colorOriginal = Color.white;
	private boolean rta;
	
	public BotonPregunta () {
		
	}
	
	public void setRespuestaTexto(String rta) {
		setBackground(colorOriginal);
		setText(rta);
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
