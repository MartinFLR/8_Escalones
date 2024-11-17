package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.Tema;
import model.logica.Escalon;
import model.logica.Ronda;
import view.VistaJuego;
import view.componentes.PanelJugadorNormal;


public class ControladorJuego implements ActionListener, KeyListener {
	private final VistaJuego vista;
	private final Escalon escalon;
    private int turnoJugador = 0;
    private boolean esperandoRespuesta = false;
	
	public ControladorJuego(Escalon escalon) {
		this.escalon = escalon;
		this.vista = new VistaJuego(this);
		this.vista.setVisible(true);
        this.vista.getPanelAproximacion().setVisible(false);
		this.vista.setEscalonUso(0);
		//Por default muestra el de el primer participante
		poneNombres();
        mostrarPreguntaActual();
        inicializarActionListeners();
		//Mostrar en la vista
			// La cant errores
            // Cant aciertos
            // Filtrar participantes
		    // Subir escalon
	}

    private void inicializarActionListeners(){
        this.vista.getBtnpreRespuesta1().addActionListener(e -> {
            if (esperandoRespuesta) {
                procesarRespuesta(e.getActionCommand());
            }
        });
        this.vista.getBtnpreRespuesta2().addActionListener(e -> {
            if (esperandoRespuesta) {
                procesarRespuesta(e.getActionCommand());
            }
        });
        this.vista.getBtnpreRespuesta3().addActionListener(e -> {
            if (esperandoRespuesta) {
                procesarRespuesta(e.getActionCommand());
            }
        });
        this.vista.getBtnpreRespuesta4().addActionListener(e -> {
            if (esperandoRespuesta) {
                procesarRespuesta(e.getActionCommand());
            }
        });
    }

	//Rondas
	public void rondaDePreguntas(Ronda ronda,List<Participante> participantes){
        PreguntaOpcion preg;
        String resp;
        for (int i = 0; i <2; i++) {
            for (Participante participante:participantes){
				this.mostrarPregunta(participante);
				preg=participante.getPreguntasParticipante().get(i);
				this.getBotonPresionado(participante);
				//Si aca espera a que este la rta deberia funcionar todo bien
				resp=participante.getRespuestaParticipante();
				if (preg.getRespuestaCorrecta().equals(resp)){
					System.out.println("Respuesta correcta");
					participante.sumaAcierto();
				}else {
					System.out.println("Respuesta incorrecta");
					participante.sumaError();
				}
        	}
		}
	}
	public void rondaEmpate(Ronda ronda,List<Participante> participantes){
		PreguntaAproximacion preg = participantes.get(0).getPregEmpate();
        Double respuestaCorrecta = Double.valueOf(preg.getRespuestaCorrecta());
        double respMasLejana = 0;
        double diferencia;
        Participante peorParticipante = null;
        List<Participante> empatados = new ArrayList<>();
        preg.imprimirPregunta();

        //recorre la lista de participantes y compara las respuestas de los participantes con la respuesta correcta
        Scanner scanner = new Scanner(System.in);
        for (model.Participante participante: participantes){
            
            // Double respuestaParticipante = participante.getRespuestaParticipanteEmpate();
            System.out.println("Respuesta del participante: " + participante.getNombre());	
            Double respuestaParticipante = scanner.nextDouble();
            
            //Calcula la diferencia entre la respuesta correcta y la respuesta del participante
            diferencia = Math.abs(respuestaCorrecta-respuestaParticipante);

            //Si la diferencia es mayor a la respuesta mas lejana, se guarda la diferencia y el participante
            if (diferencia>respMasLejana){
                respMasLejana = diferencia;
                peorParticipante = participante;
                empatados.clear();
                empatados.add(participante);
            }else if (diferencia==respMasLejana){
                empatados.add(participante);
            }
        }

        participantes.clear(); // vacia la lista.

        if(empatados.size()>1){
            participantes.addAll(empatados);
            System.out.println("Empate entre");
            for (Participante participante : empatados) {
                System.out.println(participante.getNombre());
            }
        } else if (peorParticipante != null) {
            // Agrega al peor participante para poder eliminarlo de la lista de aprticipantes en juego dsps.
            peorParticipante.sumaError();
            participantes.add(peorParticipante);
            System.out.println("Participante a eliminar: "+peorParticipante.getNombre());
        }
        //Hay que contemplar el caso de que haya empate entre los participantes nuevamente
        scanner.close();
	}
	public void rondaFinal(Ronda ronda,List<Participante> participantes){
		//La base de datos deberá tener un tema llamado Final que junte todas las preguntas, para hacer preguntas de todos los temas.
        PreguntaOpcion preg;
        String resp;
        Integer cantPreguntasRestantes = 10;        
        for (int i = 0; i < 10; i++){ 
            System.out.println("Pregunta "+(i+1));
            //Esta linea se puede eliminar despues, es para mostrar la preg por consola
            participantes.getFirst().getPreguntasParticipante().get(i).imprimirPregunta();
            for (Participante participante:participantes) {
                preg=participante.getPreguntasParticipante().get(i);
                // Cuando integremos con igu sacamos el scanner
                resp=participante.getRespuestaParticipante();
                System.out.println("Participante: "+participante.getNombre() + " Ingrese la respuesta correcta: (a, b, c, d)");
                if (preg.getRespuestaCorrecta().equals(resp)){
                    participante.sumaAcierto();
                }else {
                    participante.sumaError();
                    }
                }
                cantPreguntasRestantes--;

                //Verifica si uno de los dos participantes ya no tiene posiblidad de remontar y termina la ronda final.
                if (participantes.getFirst().getCantAciertos() > participantes.getLast().getCantAciertos() + cantPreguntasRestantes
                || participantes.getLast().getCantAciertos() > participantes.getFirst().getCantAciertos() + cantPreguntasRestantes ) {
                    if(participantes.getFirst().getCantAciertos() > participantes.getLast().getCantAciertos()){
                        System.out.println("Ganador: "+participantes.getFirst().getNombre());
                    }else{
                        System.out.println("Ganador: "+participantes.getLast().getNombre());
                    }
                    break;
            }
            // Verifica si ambos participantes tienen la misma cantAciertos y no hay pregs restantes
            System.out.println("Cant aciertos participante 1: "+participantes.getFirst().getCantAciertos());
            System.out.println("Cant aciertos participante 2: "+participantes.getLast().getCantAciertos());
            if (cantPreguntasRestantes == 0 
            && participantes.getFirst().getCantAciertos() == participantes.getLast().getCantAciertos()) {
                System.out.println("Pasa a ronda de empate\n");
                //Aca esta el problema donde no se manda la pregunta de desempate
                // En caso de la rondaNormal se manda desde Escalon
                // dentro de metodo filtrarParticipantes
                ronda.setRondaDeEmpate(participantes);
                return;
            }
        }
	}
	
	//Metodos para filtrar y eliminar participantes
	private List<Participante> getParticipantesAEliminar() {
        //Tiene que checkear que haya solo 1, si hay mas de 1 setea el estado en RondaEmpate
        List<Participante> participantesAEliminar = new ArrayList<>();
        for (Participante participante : escalon.getParticipantes()) {
            int errParticipante = participante.getCantErrores();
            if (errParticipante>0){
                //Si la lista no esta vacia, compara con el maximo de errores
                if(!participantesAEliminar.isEmpty()){
                    //Si el participante tiene mas errores que el maximo de errores,
                    //se limpia la lista y se agrega el participante
                    if(errParticipante>participantesAEliminar.get(0).getCantErrores()){
                        participantesAEliminar.clear();
                        participantesAEliminar.add(participante);
                    }else if(errParticipante==participantesAEliminar.get(0).getCantErrores()){
                        //Si el participante tiene la misma cantidad de errores que el maximo de errores,
                        //se agrega el participante
                        participantesAEliminar.add(participante);
                    }
                }else{
                    //Si la lista esta vacia, se agrega el participante
                    participantesAEliminar.add(participante);                
                }
            }
        }
        return participantesAEliminar;
    }
    public void filtrarParticipantes(){
        List<Participante> participantesAEliminar = getParticipantesAEliminar();
        //Si hay mas de un participante con la misma cantidad de errores, setea la ronda de empate
        if (participantesAEliminar.size()>1){
            // les envia la pregunta de aproximacion a todos los participantes empatados.
			Tema tema = this.escalon.getTema();
            PreguntaAproximacion preguntaAprox = tema.sacarPreguntaAprox();
            for (Participante participante : participantesAEliminar) {
                participante.setPregEmpate(preguntaAprox);
            }
			Ronda ronda = this.escalon.getEstadoDeRonda();
            //Envia la lista de participantes a eliminar y sigue la la logica de la ronda de empate
            ronda.setRondaDeEmpate(participantesAEliminar);
            
            // Repite la ronda de desempate hasta que quede uno
            while(participantesAEliminar.size()>1){
				this.rondaEmpate(ronda, participantesAEliminar);
                ronda.actualizarDatos(participantesAEliminar);
            }
            this.escalon.getParticipantes().remove(participantesAEliminar.getFirst());
            ronda.setRondaNormal();
        }else{
            //Si solo hay uno, se elimina
            //despues de esto habria que sumar uno al numEscalon y repartir preguntas   
            this.escalon.eliminoParticipantes(participantesAEliminar, this.escalon.getParticipantes());
        }
    }

    //Procesar preguntas y respuestas
    private void mostrarPreguntaActual(){
        Participante participante = escalon.getParticipantes().get(turnoJugador);
        mostrarPregunta(participante);
        esperandoRespuesta = true;  // Estamos esperando la respuesta
    }
    private void procesarRespuesta(String respuesta){
        // Cambiar al siguiente jugador
        Participante participante = escalon.getParticipantes().get(turnoJugador);
        participante.setRespuestaParticipante(respuesta);
        turnoJugador++;
        if (turnoJugador >= escalon.getParticipantes().size()) {
            turnoJugador = 0;  // Reiniciamos si hemos llegado al final
        }
        esperandoRespuesta = false;  // Ya no estamos esperando respuesta del jugador
        mostrarPreguntaActual();  // Muestra la siguiente pregunta
    }
	private void mostrarPregunta(Participante participante){
		//Podemos usar .remove() para sacar la preg y que no se repita
		PreguntaOpcion pregunta = participante.getPreguntasParticipante().getFirst();
		int nroParticipante = escalon.getParticipantes().indexOf(participante);
		PanelJugadorNormal panelParticipante = this.vista.getJugadorNormal().get(nroParticipante) ;

		panelParticipante.setRespondiendo();
		this.vista.getLblprePregunta().setText(pregunta.getPregunta());
		this.vista.getBtnpreRespuesta1().setText(pregunta.getOpcionA());
		this.vista.getBtnpreRespuesta2().setText(pregunta.getOpcionB());
		this.vista.getBtnpreRespuesta3().setText(pregunta.getOpcionC());
		this.vista.getBtnpreRespuesta4().setText(pregunta.getOpcionD());
	}
	private void poneNombres(){
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
