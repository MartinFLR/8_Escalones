package controller;

import java.awt.EventQueue;

import javax.swing.UIManager;

import com.formdev.flatlaf.FlatDarkLaf;
//?

import model.ReproductorPrincipal;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {

					UIManager.setLookAndFeel(new FlatDarkLaf()); //Tema oscuro
					ControladorPrincipal c = new ControladorPrincipal();
					ReproductorPrincipal rp = ReproductorPrincipal.getInstance();
					rp.reproducirmusica(0);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
