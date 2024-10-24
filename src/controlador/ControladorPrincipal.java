package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import vista.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{
	private VistaPrincipal vista;
	
	public ControladorPrincipal() {
		this.vista = new VistaPrincipal(this);
		vista.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(getVista().getBtnJugar())) {
			new ControladorJuego();
			this.vista.setVisible(false);
		} else if(e.getSource().equals(getVista().getBtnOpciones())) {
			new ControladorOpciones();
		} else if (e.getSource().equals(getVista().getBtnSalir())) {
			this.vista.setVisible(false);
		}
		
	}

	public VistaPrincipal getVista() {
		return vista;
	}

	public void setVista(VistaPrincipal vista) {
		this.vista = vista;
	}
	

}
