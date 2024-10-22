package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vista.VistaOpciones;

public class ControladorOpciones implements ActionListener{
	private VistaOpciones vista;
	
	public ControladorOpciones() {
		this.vista = new VistaOpciones(this);
		this.vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public VistaOpciones getVista () {
		return vista;
	}
	

}
