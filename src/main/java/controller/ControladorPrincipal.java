package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import model.ReproductorPrincipal;
import model.ABM.ManagerSession;
import raven.toast.Notifications;
import view.VistaPrincipal;

public class ControladorPrincipal implements ActionListener{
	private VistaPrincipal vista;
	
	public ControladorPrincipal() {
		this.vista = new VistaPrincipal(this);
		vista.setVisible(true);
		vista.getBtnJugar().addActionListener(e -> {
			new ControladorCreacionJug();
			this.vista.setVisible(false);});
		vista.getBtnOpciones().addActionListener(e -> {new ControladorOpciones();});
		vista.getBtnRanking().addActionListener(e -> {new ControladorRanking();});
		vista.getBtnSalir().addActionListener(e -> {System.exit(0);});
		
		vista.getBtnLogin().addActionListener(e -> {new ControladorLogin(this);});
		vista.getBtnModificar().addActionListener(e -> {new ControladorModCategoria();});
		
		vista.getBtnAyuda().addActionListener(e -> {
			vista.getPanelAyuda().setVisible(true);
			btnHabilitar(false);});
		vista.getBtnSalirAyuda().addActionListener(e -> {
			vista.getPanelAyuda().setVisible(false);
			btnHabilitar(true);});
		
		vista.getBtnCreditos().addActionListener(e -> {
			vista.getPanelCreditos().setVisible(true);
			btnHabilitar(false);});
		vista.getBtnSalirCreditos().addActionListener(e -> {
			vista.getPanelCreditos().setVisible(false);
			btnHabilitar(true);});
		
		verificarEstadoSesion();
	}

	private void btnHabilitar(Boolean booleano) {
		vista.getBtnJugar().setEnabled(booleano);
		vista.getBtnOpciones().setEnabled(booleano);
		vista.getBtnRanking().setEnabled(booleano);
		vista.getBtnAyuda().setEnabled(booleano);
		vista.getBtnSalir().setEnabled(booleano);
		vista.getBtnCreditos().setEnabled(booleano);
		vista.getBtnModificar().setEnabled(booleano);
	}
	
	public VistaPrincipal getVista() {
		return vista;
	}

	public void setVista(VistaPrincipal vista) {
		this.vista = vista;
	}

	private void actualizarEstadoModificar() {
		vista.getBtnModificar().setVisible(ManagerSession.estaLogueado());
	}

	public void verificarEstadoSesion() {
		actualizarEstadoModificar();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


}
