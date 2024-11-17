package view.componentes;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.Participante;

public abstract class PanelJugadorPadre extends JPanel{
	
	protected ImageIcon imgJugador;
	protected String nombreJugador;
	
	protected JLabel lblimagenJugador;
	protected JLabel lblnombreJugador;
	protected JPanel panelErrores;
	protected Color colorOriginal = Color.WHITE, colorAcierto = Color.GREEN, colorError = Color.RED;
	protected Color colorRespondiendo = Color.ORANGE, colorActivo = Color.WHITE, colorEliminado = Color.GRAY;
	
	public PanelJugadorPadre() {
		lblimagenJugador = new JLabel(imgJugador);
		add(lblimagenJugador);
		
		lblnombreJugador = new JLabel("NOMBRE");
		lblnombreJugador.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblnombreJugador);
	}


	public abstract void setError (Participante par);
	public abstract void setAcierto(Participante par);

	public abstract void setResetErrores(); 

	//SETEAR COLORES ACTIVO, RESPONDIENDO, ELIMINANDO 
	public void setRespondiendo() {
		setBackground(colorRespondiendo);
		panelErrores.setBackground(colorRespondiendo);
		//Cambie el color de la letra para mejorar el contraste
		//Capaz cuando pase a responder otro, haya que revertir esto
		this.lblnombreJugador.setForeground(Color.BLACK);
	}
	
	public void setActivo() {
		setBackground(colorActivo);
		panelErrores.setBackground(colorActivo);
	}
	
	public void setEliminado() {
		setBackground(colorEliminado);
		panelErrores.setBackground(colorEliminado);
	}
	
	public void setNombre (String nombre) {
		this.lblnombreJugador.setText(nombre);
	}

	public void setImagen (ImageIcon img){
		this.lblimagenJugador.setIcon(img);
	}
	
	
	
}
