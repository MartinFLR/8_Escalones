package controlador;

import java.awt.EventQueue;

import vista.VistaPrincipal;

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ControladorPrincipal c = new ControladorPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
