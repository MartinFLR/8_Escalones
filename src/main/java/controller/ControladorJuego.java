package controller;

import view.VistaJuego;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class ControladorJuego implements ActionListener, KeyListener {
	private VistaJuego vista;
	
	public ControladorJuego() {
		this.vista = new VistaJuego(this);
		this.vista.setVisible(true);
	}
	

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getExtendedKeyCode() == KeyEvent.VK_ESCAPE) {
			new ControladorMenupausa();
		}
		if (e.getExtendedKeyCode() == KeyEvent.VK_ENTER) {
			getVista().getPanelPreguntas().setVisible(true);
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	public VistaJuego getVista() {
		return vista;
	}


	public void setVista(VistaJuego vista) {
		this.vista = vista;
	}
}
