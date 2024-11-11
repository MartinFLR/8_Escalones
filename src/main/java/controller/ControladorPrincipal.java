package controller;

import view.VistaPrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControladorPrincipal implements ActionListener{
	private VistaPrincipal vista;
	
	public ControladorPrincipal() {
		this.vista = new VistaPrincipal(this);
		vista.setVisible(true);
		vista.getBtnJugar().addActionListener(e -> {
			new ControladorJuego();
			this.vista.setVisible(false);});
		vista.getBtnOpciones().addActionListener(e -> {new ControladorOpciones();});
		vista.getBtnRanking().addActionListener(e -> {new ControladorRanking();});
		vista.getBtnSalir().addActionListener(e -> {System.exit(0);});
		
		vista.getBtnLogin().addActionListener(e -> {new ControladorLogin();});
		vista.getBtnModificar().addActionListener(e -> {new ControladorMod();});
		
		vista.getBtnAyuda().addActionListener(e -> {vista.getPanelAyuda().setVisible(true);});
		vista.getBtnSalirAyuda().addActionListener(e -> {vista.getPanelAyuda().setVisible(false);});
		vista.getBtnCreditos().addActionListener(e -> {vista.getPanelCreditos().setVisible(true);});
		vista.getBtnSalirCreditos().addActionListener(e -> {vista.getPanelCreditos().setVisible(false);});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	public VistaPrincipal getVista() {
		return vista;
	}

	public void setVista(VistaPrincipal vista) {
		this.vista = vista;
	}
	

}
