package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VistaLogin;

public class ControladorLogin implements ActionListener{

	private VistaLogin vista;
	
	public ControladorLogin () {
		this.vista = new VistaLogin(this);
		this.vista.setVisible(true);
		
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
