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
		//Cambia el color del escalon en uso y apaga el resto
		this.vista.setEscalonUso(0);
		//Por default muestra el de el primer participante
		poneNombres();
		mostrarPregunta(escalon.getParticipantes().getFirst());
	}

	//Muestra la pregunta de un participante, obtiene el indice y enciende su panel correspondiente
	public void mostrarPregunta(Participante participante){
		//Podemos usar .remove() para sacar la preg y que no se repita
		PreguntaOpcion pregunta = participante.getPreguntasParticipante().getFirst();
		int nroParticipante = escalon.getParticipantes().indexOf(participante);
		PanelJugadorNormal panelParticipante = this.vista.getJugadorNormal().get(nroParticipante) ;

		panelParticipante.setRespondiendo();
		this.vista.getLblJugador().setText(participante.getNombre());
		this.vista.getLblprePregunta().setText(pregunta.getPregunta());
		this.vista.getBtnpreRespuesta1().setText(pregunta.getOpcionA());
		this.vista.getBtnpreRespuesta2().setText(pregunta.getOpcionB());
		this.vista.getBtnpreRespuesta3().setText(pregunta.getOpcionC());
		this.vista.getBtnpreRespuesta4().setText(pregunta.getOpcionD());
	}

	public void poneNombres(){
		for (int i = 0; i < 9; i++) {
			this.vista.getJugadorNormal().get(i).setNombre(escalon.getParticipantes().get(i).getNombre());
			this.vista.getJugadorNormal().get(i).setImagen(escalon.getParticipantes().get(i).getImg());
		}
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
