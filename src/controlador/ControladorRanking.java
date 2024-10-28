package controlador;

import vista.VistaRanking;

public class ControladorRanking {

	private VistaRanking vista;
	
	public ControladorRanking () {
		this.vista = new VistaRanking (this);
		this.vista.setVisible(true);
	}
	
}
