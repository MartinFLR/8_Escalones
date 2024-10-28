package controlador;

import vista.VistaCreacionJug;

public class ControladorCreacionJug {

	private VistaCreacionJug vista;
	
	public ControladorCreacionJug () {
		this.vista = new VistaCreacionJug(this);
		this.vista.setVisible(true);
	}
	
	
	
}
