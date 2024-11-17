package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import model.Participante;
import model.PreguntaOpcion;
import model.logica.Escalon;
import view.VistaJuego;
import view.componentes.PanelJugadorNormal;


public class ControladorJuego implements ActionListener, KeyListener {
	private VistaJuego vista;
	private Escalon escalon;
	
	public ControladorJuego(Escalon escalon) {
		this.escalon = escalon;
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
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	
	
}
