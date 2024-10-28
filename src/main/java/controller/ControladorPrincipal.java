package controller;

import view.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


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
			System.exit(0);
		} else if (e.getSource().equals(getVista().getCreditos())) {
			new ControladorCreditos();
		} else if (e.getSource().equals(getVista().getModificar())){
			new ControladorMod();
		}
	}

	public VistaPrincipal getVista() {
		return vista;
	}

	public void setVista(VistaPrincipal vista) {
		this.vista = vista;
	}
	

}
