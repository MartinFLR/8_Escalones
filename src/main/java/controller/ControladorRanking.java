package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.VistaRanking;

public class ControladorRanking implements ActionListener{

	private VistaRanking vista;
	
	public ControladorRanking () {
		this.vista = new VistaRanking (this);
		this.vista.setVisible(true);
		
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
