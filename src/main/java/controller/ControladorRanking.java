package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import model.Participante;
import model.ABM.ParticipantesDAO;
import view.VistaRanking;

public class ControladorRanking implements ActionListener{

	private VistaRanking vista;
	private ParticipantesDAO participante;
	
	public ControladorRanking () {
		this.vista = new VistaRanking (this);
		this.vista.setVisible(true);
		this.participante = new ParticipantesDAO();
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
		this.rellenarTablas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public void rellenarTablas() {
		List<Participante> participantes = ParticipantesDAO.Ranking();
		getVista().getDefTableModel().setRowCount(0);
		
		for (Participante participante : participantes) {
			Object [] row = {participante.getId(), participante.getNombre(), participante.getVecesGanadas()};
			getVista().getDefTableModel().addRow(row);
		}
	}

	public VistaRanking getVista() {
		return vista;
	}

	public void setVista(VistaRanking vista) {
		this.vista = vista;
	}

	public ParticipantesDAO getParticipante() {
		return participante;
	}

	public void setParticipante(ParticipantesDAO participante) {
		this.participante = participante;
	}
	
	
	
}
