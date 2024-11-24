package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import model.Participante;
import model.PreguntaAproximacion;
import model.PreguntaOpcion;
import model.logica.Escalon;
import model.logica.Ronda;
import view.VistaJuego;
import view.componentes.PanelJugadorFinal;
import view.componentes.PanelJugadorNormal;


public class ControladorJuego implements ActionListener, KeyListener {
	private final VistaJuego vista;
	private final Escalon escalon;
    private int indiceEmpate = 0;
    private int turnoJugador = 0;
    private boolean esperandoRespuesta = false;
    private int  indiceActualPar=0;
    private boolean huboEmpate=false;

	public ControladorJuego(Escalon escalon) {
		this.escalon = escalon;
		this.vista = new VistaJuego(this);
		this.vista.setVisible(true);
		this.vista.setEscalonUso(this.escalon.getEscalon());
		//Por default muestra el de el primer participante
		poneNombres();
        poneNombresEscalones();
        
        inicializarActionListeners();
        this.rondaDePreguntas(this.escalon.getParticipantes());
        //Mostrar en la vista
			// La cant errores
            // Cant aciertos
            // Filtrar participantes
		    // Subir escalon
	}


	//Metodos para la ronda normal
	private void rondaDePreguntas(List<Participante> participantes){
        
        mostrarPreguntaActual();
        esperandoRespuesta = true;
	}
    private void mostrarPreguntaActual() {
        Participante participante = escalon.getParticipantes().get(turnoJugador);

        esperandoRespuesta = true;
        
        if (this.escalon.getEscalon() != 7) {
            PreguntaOpcion pregunta = participante.getPreguntasParticipante().getFirst();
            int posParticipante = escalon.getParticipantes().indexOf(participante);
            PanelJugadorNormal panelParticipante = this.vista.getJugadorNormal().get(posParticipante);
            
            System.out.println("Respuesta correcta: " + pregunta.getRespuestaCorrecta());
            panelParticipante.setRespondiendo();
            
            this.vista.getLblprePregunta().setText("<html><div style='width: 450px; text-align: center;margin-left: 85px;'>" + pregunta.getPregunta() + "</div></html>");
            this.vista.getBtnpreRespuesta1().setText(pregunta.getOpcionA());
            this.vista.getBtnpreRespuesta2().setText(pregunta.getOpcionB());
            this.vista.getBtnpreRespuesta3().setText(pregunta.getOpcionC());
            this.vista.getBtnpreRespuesta4().setText(pregunta.getOpcionD());
        } else {
            mostrarPreguntaFinal(participante);
        }
    }
    private void procesarRespuesta(String respuesta) {
        Participante participante = escalon.getParticipantes().get(turnoJugador);
        int posParticipante = escalon.getParticipantes().indexOf(participante);
        participante.setRespuestaParticipante(respuesta);

        procesarPregunta(participante, posParticipante, respuesta);

        turnoJugador++;
        if (turnoJugador < escalon.getParticipantes().size()) {
                indiceActualPar = turnoJugador;
            } else {
                indiceActualPar = 0;
            }

        // Actualiza la flag de huboEmpate para que no continue el flujo del juego
        if(turnoJugador == escalon.getParticipantes().size()
        && getParticipantesAEliminar().size()>1
        && participante.getPreguntasParticipante().isEmpty()){
            huboEmpate = true;
            turnoJugador = 0;
            indiceEmpate = escalon.getParticipantes().indexOf(getParticipantesAEliminar().getFirst());
            escalon.getEstadoDeRonda().setRondaDeEmpate(getParticipantesAEliminar());
            escalon.getEstadoDeRonda().actualizarDatos(escalon.getEstadoDeRonda(), getParticipantesAEliminar(), escalon.getTema());
            this.vista.getPanelAproximacion().setVisible(true);
            setActivosEmpatados();
            mostrarPreguntaEmpate();
        }

        if (turnoJugador == escalon.getParticipantes().size() 
        && participante.getPreguntasParticipante().isEmpty() 
        && !huboEmpate) {
            manejarFinDeRonda();
        } else if (this.escalon.getEscalon() < 7 && !huboEmpate) {
            manejarRondaNormal();
        }
    }
    
    //Metodos para procesarRespuesta
    private void procesarPregunta(Participante participante, int posParticipante, String respuesta) {
        if (!participante.getPreguntasParticipante().isEmpty()) {
            PreguntaOpcion preguntaActual = participante.getPreguntasParticipante().getFirst();
            if (respuesta.equals(preguntaActual.getRespuestaCorrecta())) {
                this.vista.getJugadorNormal().get(posParticipante).setAcierto(participante);
                participante.sumaAcierto();
            } else {
                this.vista.getJugadorNormal().get(posParticipante).setError(participante);
                participante.sumaError();
            }
            participante.getPreguntasParticipante().remove(0);
        }
    }   
    private void manejarFinDeRonda() {
        turnoJugador = 0;
        this.filtrarParticipantes();

        this.escalon.subeEscalon();
        this.vista.getDefTable().setNumRows(0);
        this.vista.setEscalonUso(this.escalon.getEscalon());
        esperandoRespuesta = false;

        if (this.escalon.getEscalon() != 7) {
            for (PanelJugadorNormal panelJugadorNormal : this.vista.getJugadorNormal()) {
                if (panelJugadorNormal.isActivo()) {
                panelJugadorNormal.setResetErrores();
                }
            }
            this.rondaDePreguntas(escalon.getParticipantes());
        } else {
            manejarRondaFinal();
        }
    }
    private void manejarRondaFinal() {
        if (turnoJugador >= escalon.getParticipantes().size()) {
            turnoJugador = 0;
            indiceActualPar = 0;
        }

        Ronda ronda = this.escalon.getEstadoDeRonda();
        ronda.setRondaFinal();
        System.out.println("ronda final");

        for (PanelJugadorNormal jn : this.vista.getJugadorNormal()) {
            jn.setVisible(false);
        }

        this.vista.getPanelAproximacion().setVisible(false);
        this.vista.getPanelJugadores().setVisible(false);
        this.vista.getPanelFinal().setVisible(true);

        for (PanelJugadorFinal pjf : this.vista.getJugadorFinal()) {
            pjf.setVisible(true);
        }
        for (Participante par:  this.escalon.getParticipantes()){
            par.setCantAciertos(0);
            par.setCantErrores(0);
        }
        ronda.actualizarDatos(ronda, this.escalon.getParticipantes(), this.escalon.getTema());
        
        this.rondaFinal(this.escalon.getParticipantes());
    }
    private void manejarRondaNormal() {
        if (turnoJugador == escalon.getParticipantes().size()) {
            turnoJugador = 0;
            indiceActualPar = 0;
        }
        setColores();
        esperandoRespuesta = false;
        mostrarPreguntaActual();
    }
    
    //Metodos para la ronda de empate
    private void rondaEmpate( List<Participante> participantes){
		PreguntaAproximacion preg = participantes.get(0).getPregEmpate();
        Double respuestaCorrecta = Double.valueOf(preg.getRespuestaCorrecta());
        double respMasLejana = 0;
        double diferencia;
        Participante peorParticipante = null;
        List<Participante> empatados = new ArrayList<>();

        //Aca deberia ir la logica para manejar los turnos

        //recorre la lista de participantes y compara las respuestas de los participantes con la respuesta correcta
        for (model.Participante participante: participantes){	
            Double respuestaParticipante = participante.getRespuestaParticipanteEmpate();
            
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
            peorParticipante.sumaError();
            participantes.add(peorParticipante);
            System.out.println("Participante a eliminar: "+peorParticipante.getNombre());
        }
	}
    private void mostrarPreguntaEmpate(){
        Participante participante = getParticipantesAEliminar().get(turnoJugador);
        PreguntaAproximacion pregunta = participante.getPregEmpate();
        this.vista.getPanelPregunta().setVisible(false);
        this.vista.getlblaproxPregunta().setText("<html><div style='width: 300px;margin-top:47px;text-align:center'>" + pregunta.getPregunta() + "</div></html>");
        this.vista.getTxtaproxRespuesta().requestFocusInWindow();
        setColores();
        int posParticipante = escalon.getParticipantes().indexOf(participante);
        this.vista.getJugadorNormal().get(posParticipante).setRespondiendo();
        esperandoRespuesta = true;
    }
    private void procesarRespuestaEmpate(Double respuesta){
        Participante participante = getParticipantesAEliminar().get(turnoJugador);
        indiceEmpate = escalon.getParticipantes().indexOf(participante);
        participante.setRespuestaParticipanteEmpate(respuesta);
        this.vista.getDefTable().addRow(new Object[]{participante.getNombre(),participante.getRespuestaParticipanteEmpate()});
        this.vista.getTxtaproxRespuesta().setText("");
        siguienteTurnoEmpate();
    }
    private void siguienteTurnoEmpate(){
        this.vista.getJugadorNormal().get(indiceEmpate).setActivo();
        turnoJugador++;
        if(turnoJugador == getParticipantesAEliminar().size()){
            rondaEmpate(getParticipantesAEliminar());
            huboEmpate = false;
            this.vista.getPanelAproximacion().setVisible(false);
            this.vista.getPanelPregunta().setVisible(true);
            manejarFinDeRonda();
        } else {
            esperandoRespuesta = true;
            mostrarPreguntaEmpate();
        }
    }
    private void setActivosEmpatados(){
        for(Participante participante:escalon.getParticipantes()){
            int index = escalon.getParticipantes().indexOf(participante);
            if(!getParticipantesAEliminar().contains(participante)){
                this.vista.getJugadorNormal().get(index).setResetErrores();
            }
        }
    }
    
    //Metodos para la ronda final
    private void rondaFinal(List<Participante> participantes){
		//La base de datos deberá tener un tema llamado Final que junte todas las preguntas, para hacer preguntas de todos los temas.
        mostrarPreguntaActual();
    }
    private void procesarRespuestaFinal(String respuesta,Participante participante){
        
        int posParticipante = escalon.getParticipantes().indexOf(participante);   
        participante.setRespuestaParticipante(respuesta);//no se actualiza la respuesta y toma la del anterior. ej: jug1 responde 25, se pone que este responde 25 tmb.
        //PanelJugadorFinal pj= this.vista.getJugadorFinal().get(turnoJugador);
        if (!participante.getPreguntasParticipante().isEmpty()) {
            PreguntaOpcion preguntaActual =participante.getPreguntasParticipante().getFirst();
            if (respuesta.equals(preguntaActual.getRespuestaCorrecta())){
                this.vista.getJugadorFinal().get(indiceActualPar).setAcierto(participante);
                participante.sumaAcierto();
                turnoJugador++;
            participante.getPreguntasParticipante().remove(0);
            if (turnoJugador >= escalon.getParticipantes().size()) {
                turnoJugador = 0;  
            }
                esperandoRespuesta=false;
        } 
        if (!respuesta.equals(preguntaActual.getRespuestaCorrecta())){
            this.vista.getJugadorFinal().get(indiceActualPar).setError(participante);
            participante.sumaError();
            turnoJugador++;
        participante.getPreguntasParticipante().remove(0);
        
            esperandoRespuesta=false;}

        
        }
        if (turnoJugador >= escalon.getParticipantes().size()) {
            turnoJugador = 0;  
        } 
            if (!this.escalon.getParticipantes().get(turnoJugador).getPreguntasParticipante().isEmpty()){
                System.out.println(participante.getNombre()+" " +participante.getCantAciertos()); 
                mostrarPreguntaActual();
            }else { // Se ha dado una vuelta completa, todos respondieron
                    verificarRondaFinalYGanador();
                }
        }
        
    
    private void mostrarPreguntaFinal(Participante participante){
        //Podemos usar .remove() para sacar la preg y que no se repita
        
        PreguntaOpcion pregunta = participante.getPreguntasParticipante().getFirst();
        int posParticipante = escalon.getParticipantes().indexOf(participante);
        indiceActualPar= escalon.getParticipantes().indexOf(participante);
        PanelJugadorFinal panelParticipante = this.vista.getJugadorFinal().get(posParticipante);
        System.out.println("Respuesta correcta: "+pregunta.getRespuestaCorrecta());
        
        esperandoRespuesta=true;
        this.vista.getLblprePregunta().setText("<html><div style='width: 300px; text-align: center;margin-left: 150px;'>" + pregunta.getPregunta() + "</div></html>");
        this.vista.getBtnpreRespuesta1().setText(pregunta.getOpcionA());
        this.vista.getBtnpreRespuesta2().setText(pregunta.getOpcionB());
        this.vista.getBtnpreRespuesta3().setText(pregunta.getOpcionC());
        this.vista.getBtnpreRespuesta4().setText(pregunta.getOpcionD());
        
        }
    private void verificarRondaFinalYGanador() {
        
        List<Participante> participantesFinales = this.escalon.getParticipantes();
        Participante participante1 = participantesFinales.get(0);
        Participante participante2 = participantesFinales.get(1);       
        int aciertos1 = participante1.getCantAciertos();
        int aciertos2 = participante2.getCantAciertos();
            if (aciertos1!=aciertos2 && (aciertos1!=0 || aciertos2!=0 )) {
                if(aciertos1!=aciertos2){
                    if (aciertos1 > aciertos2) {//  ganador
                        System.out.println("cantidad aciertos juador 0 "+ aciertos1);
                        System.out.println("cantidad aciertos juador 1 "+ aciertos2);
                        System.out.println("El ganador es: " + participante1.getNombre());
                        //aca iria la vista de winner
                        PanelJugadorFinal panelParFinal=this.vista.getJugadorFinal().get(0);
                        PanelJugadorFinal panelParFinal2=this.vista.getJugadorFinal().get(1);
                        panelParFinal.setCampeon();
                        panelParFinal2.setEliminado();
                        //deberia saltar una ultima vista con dialog campeon
                    } else if (aciertos2 > aciertos1) {
                        System.out.println("cantidad aciertos juador 0 "+ aciertos1);
                        System.out.println("cantidad aciertos juador 1 "+ aciertos2);
                        System.out.println("El ganador es: " + participante2.getNombre());
                        PanelJugadorFinal panelParFinal=this.vista.getJugadorFinal().get(0);
                        PanelJugadorFinal panelParFinal2=this.vista.getJugadorFinal().get(1);
                        panelParFinal2.setCampeon();
                        panelParFinal.setEliminado();
                        //aca iria la vista de winner
                          //deberia saltar una ultima vista con dialog campeon y que salte al inicio
                    }}
            }  else if (aciertos1==aciertos2){
                
                escalon.getEstadoDeRonda().setRondaDeEmpate(participantesFinales);
            escalon.getEstadoDeRonda().actualizarDatos(escalon.getEstadoDeRonda(),participantesFinales, escalon.getTema());
            this.vista.getPanelAproximacion().setVisible(true);
            setActivosEmpatados();
            mostrarPreguntaEmpate();
            }}
	private void poneNombres(){
        for (int i = 0; i < 9; i++) {
			this.vista.getJugadorNormal().get(i).setNombre(escalon.getParticipantes().get(i).getNombre());
			this.vista.getJugadorNormal().get(i).setImagen(escalon.getParticipantes().get(i).getImg());
		}
	}
	
	//Metodos para filtrar y eliminar participantes
	private List<Participante> getParticipantesAEliminar() {
        List<Participante> participantesAEliminar = new ArrayList<>();
        int maxErrores = 0;

        for (Participante participante : escalon.getParticipantes()) {
            int errParticipante = participante.getCantErrores();
            if (errParticipante > 0) {
                if (errParticipante > maxErrores) {
                    maxErrores = errParticipante;
                    participantesAEliminar.clear();
                    participantesAEliminar.add(participante);
                } else if (errParticipante == maxErrores) {
                    participantesAEliminar.add(participante);
                }
            }
        }

        // If there is only one participant with the maximum errors, return only that participant
        if (participantesAEliminar.size() > 1) {
            List<Participante> maxErroresParticipantes = new ArrayList<>();
            for (Participante participante : participantesAEliminar) {
                if (participante.getCantErrores() == maxErrores) {
                    maxErroresParticipantes.add(participante);
                }
            }
            return maxErroresParticipantes;
        }

        return participantesAEliminar;
    }
    private void filtrarParticipantes(){
        List<Participante> participantesAEliminar = getParticipantesAEliminar();
        //Si hay mas de un participante con la misma cantidad de errores, setea la ronda de empate
        if (participantesAEliminar.size()>1){
            // les envia la pregunta de aproximacion a todos los participantes empatados.
        	this.vista.getPanelAproximacion().setVisible(true);
			Ronda ronda = this.escalon.getEstadoDeRonda();
            huboEmpate = true;

            //Envia la lista de participantes a eliminar y sigue la la logica de la ronda de empate
            ronda.setRondaDeEmpate(participantesAEliminar);
            ronda.actualizarDatos(ronda, participantesAEliminar, this.escalon.getTema());
            // Aca hay que meter la logica a la ronda de empate, aunque capaz no hace falta
            // mostrarPreguntaEmpate()
        }else{
            //Si solo hay uno, se elimina
            Participante participante = participantesAEliminar.getFirst();
            //Para ver la posicion en el panel recupero el indice que ocupa en la lista
            int indice = this.escalon.getParticipantes().indexOf(participante);
            this.setColores();
            this.vista.getJugadorNormal().get(indice).setEliminado();
            this.vista.getJugadorNormal().remove(indice);
            this.escalon.eliminaParticipante(participante);
            this.vista.getPanelAproximacion().setVisible(false);
            Ronda estado = this.escalon.getEstadoDeRonda();
            estado.setRondaNormal();
            escalon.setTema();
            estado.actualizarDatos(estado, escalon.getParticipantes(), escalon.getTema());
            this.rondaDePreguntas(escalon.getParticipantes());
        }
    }

    //Procesar preguntas y respuestas
    private void inicializarActionListeners(){
        this.vista.getBtnpreRespuesta1().addActionListener(e -> {
            if (esperandoRespuesta ) {
                if (this.escalon.getEscalon()==7 ){
                    procesarRespuestaFinal(e.getActionCommand(),escalon.getParticipantes().get(turnoJugador));
                }else  if(this.escalon.getEscalon()<7){
                    procesarRespuesta(e.getActionCommand());
                }
            } 
        });
        this.vista.getBtnpreRespuesta2().addActionListener(e -> {
            if (esperandoRespuesta) {
                if (this.escalon.getEscalon()==7 ){
                    procesarRespuestaFinal(e.getActionCommand(),escalon.getParticipantes().get(turnoJugador));
                }else if(this.escalon.getEscalon()<7) {
                    procesarRespuesta(e.getActionCommand());
                }
            }
        });
        this.vista.getBtnpreRespuesta3().addActionListener(e -> {
            if (esperandoRespuesta) {
                if (this.escalon.getEscalon()==7 ){
                    procesarRespuestaFinal(e.getActionCommand(),escalon.getParticipantes().get(turnoJugador));
                }else  if(this.escalon.getEscalon()<7) {
                    procesarRespuesta(e.getActionCommand());
                }
            }
        });
        this.vista.getBtnpreRespuesta4().addActionListener(e -> {
            if (esperandoRespuesta) {
                if (this.escalon.getEscalon()==7 ){
                    procesarRespuestaFinal(e.getActionCommand(),escalon.getParticipantes().get(turnoJugador));
                }else  if(this.escalon.getEscalon()<7) {
                    procesarRespuesta(e.getActionCommand());
                }
            }
        });

        this.vista.getBtnaproxEnviar().addActionListener(e->{
            if(esperandoRespuesta && huboEmpate){
                try{
                    Double ResParse = Double.valueOf(this.vista.getTxtaproxRespuesta().getText());
                procesarRespuestaEmpate(ResParse);
                }catch(NumberFormatException e1){
                    System.out.println("Error, ingrese un numero " + e1.getMessage());
                }
            }
        });
        
        KeyAdapter keyListener = new KeyAdapter() {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_1, KeyEvent.VK_NUMPAD1 -> {
                    if (!huboEmpate) {
                        vista.getBtnpreRespuesta1().doClick();
                    }
                }
                case KeyEvent.VK_2, KeyEvent.VK_NUMPAD2 -> {
                    if (!huboEmpate) {
                        vista.getBtnpreRespuesta2().doClick();
                    }
                }
                case KeyEvent.VK_3, KeyEvent.VK_NUMPAD3 -> {
                    if (!huboEmpate) {
                        vista.getBtnpreRespuesta3().doClick();
                    }
                }
                case KeyEvent.VK_4, KeyEvent.VK_NUMPAD4 -> {
                    if (!huboEmpate) {
                        vista.getBtnpreRespuesta4().doClick();
                    }
                }
                case KeyEvent.VK_ENTER -> vista.getBtnaproxEnviar().doClick();
            }
        }
    };

        this.vista.getBtnpreRespuesta1().addKeyListener(keyListener);
        this.vista.getBtnpreRespuesta2().addKeyListener(keyListener);
        this.vista.getBtnpreRespuesta3().addKeyListener(keyListener);
        this.vista.getBtnpreRespuesta4().addKeyListener(keyListener);
        this.vista.getTxtaproxRespuesta().addKeyListener(keyListener);
    }
    private void setColores(){
    //Setea los colores del fondo para indicar de quien es el turno
    Participante participante = escalon.getParticipantes().get(turnoJugador);
        if (turnoJugador!=0 ){
            participante = escalon.getParticipantes().get(turnoJugador-1);
            int nroParticipante = escalon.getParticipantes().indexOf(participante);
            PanelJugadorNormal panelParticipante = this.vista.getJugadorNormal().get(nroParticipante) ;
            panelParticipante.setActivo(); }
            else{
                participante = escalon.getParticipantes().getLast();
                int nroParticipante = escalon.getParticipantes().indexOf(participante);
                PanelJugadorNormal panelParticipante = this.vista.getJugadorNormal().get(nroParticipante) ;
                panelParticipante.setActivo(); 
            }}
    private void poneNombresEscalones(){
        this.vista.getEscalones().getFirst().getLblTema().setText("<html><div style='margin-bottom:4px;'>" + escalon.getTema().getNombre() + "</div></html>");
        for(int i = 0; i < 7; i++){
            System.out.println("tema "+i+" "+this.escalon.getTemas().get(i).getNombre());
            if(i==0){
            }else{
                this.vista.getEscalones().get(i).getLblTema().setText("<html><div style='margin-bottom:4px;'>" + escalon.getTemas().get(i-1).getNombre() + "</div></html>");
            }
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
