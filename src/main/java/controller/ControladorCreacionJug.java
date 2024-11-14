package controller;


import javax.swing.ImageIcon;

import model.Participante;
import model.logica.Escalon;
import view.VistaCreacionJug;

public class ControladorCreacionJug {

	private VistaCreacionJug vista;
	private Escalon escalon;
	
	public ControladorCreacionJug () {
		this.vista = new VistaCreacionJug(this);
		this.escalon = new Escalon();
		this.vista.setVisible(true);
		
		vista.getBtnJugar().addActionListener(e -> creaParticiapantes());
	}

	public void creaParticiapantes(){

		for (int i = 0; i < 9; i++) {
			Participante participante = new Participante(this.vista.getTxtJugador().get(i).getText());
			participante.setImg((ImageIcon) this.vista.getComboboxImg().get(i).getSelectedItem());
			escalon.agregaParticipante(participante);
		}

		new ControladorJuego(escalon);

	}



	
	
}
