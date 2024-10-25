package controlador;

import vista.VistaCreditos;

public class ControladorCreditos {

	private VistaCreditos vista;
	
	public ControladorCreditos() {
		this.vista = new VistaCreditos(this);
		this.vista.setVisible(true);
	}
	
	
}

