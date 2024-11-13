package view;

import controller.ControladorJuego;
import view.componentes.BotonPregunta;
import view.componentes.PanelEscalon;
import view.componentes.PanelJugadorNormal;
import view.componentes.PanelJugadorFinal;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.awt.Panel;
import java.lang.reflect.Array;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorJuego c;

	private JPanel panelPregunta;
	private JLabel lblprePregunta;
	private BotonPregunta btnpreRespuesta1 = new BotonPregunta();
	private BotonPregunta btnpreRespuesta2 = new BotonPregunta();;
	private BotonPregunta btnpreRespuesta3 = new BotonPregunta();;
	private BotonPregunta btnpreRespuesta4 = new BotonPregunta();;
	
	private JPanel panelAproximacion;
	private JButton btnaproxEnviar;
	private JFormattedTextField txtaproxRespuesta;
	
	private JPanel panelColumna;
	private JPanel panelJugadores;
	private JTable table;
	private JLabel lblJuez;
	private JLabel lblJugador;
	
	private JPanel panelFinal;
	
	// ATRIBUTOS PARA CADA JUGADOR Y ESCALON
	private ArrayList<PanelEscalon> escalones = new ArrayList<PanelEscalon>();
	private ArrayList<PanelJugadorNormal> jugadorNormal = new ArrayList<PanelJugadorNormal>();
	private ArrayList<PanelJugadorFinal> jugadorFinal = new ArrayList<PanelJugadorFinal>();

	public VistaJuego(ControladorJuego c) {
		this.setC(c);
		setTitle("8 ESCALONES");
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.addKeyListener(c);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		//
		// PANEL COLUMNAS
		//
		
		panelColumna = new JPanel();
		panelColumna.setBackground(Color.BLACK);
		panelColumna.setBounds(0, 0, 85, 683);
		contentPane.add(panelColumna);
		GridLayout gridLayoutColumna = new GridLayout(8, 1);
        gridLayoutColumna.setVgap(2); 
		panelColumna.setLayout(gridLayoutColumna);
		
		// --- FALTA CAMBIAR COLOR A LOS ESCALONES Y LOS GAPS ENTRE LAYOUT
		for (int i = 0; i < 8; i++) {
			this.escalones.add(new PanelEscalon(i+1));
			panelColumna.add(this.escalones.get(i));
		}
		
		//
		// PANEL JUGADORES (FINAL)
		//
		
		panelFinal = new JPanel();
		panelFinal.setBounds(95, 370, 1181, 131);
		contentPane.add(panelFinal);
		GridLayout gridLayoutFinal = new GridLayout (2, 1);
		gridLayoutFinal.setHgap(10); 
		gridLayoutFinal.setVgap(20); 
		panelFinal.setLayout(gridLayoutFinal);
		
		for (int i = 0; i < 2; i++) {
			this.jugadorFinal.add(new PanelJugadorFinal());
		}
		
		//
		// PANEL JUGADORES
		//
		
		panelJugadores = new JPanel();
		panelJugadores.setBackground(Color.BLACK);
		panelJugadores.setSize(new Dimension(5, 5));
		panelJugadores.setBounds(85, 508, 1181, 175);
		contentPane.add(panelJugadores);
		GridLayout gridLayoutJugador = new GridLayout (1, 9);
		gridLayoutJugador.setHgap(10); 
		gridLayoutJugador.setVgap(20); 
		panelJugadores.setLayout(gridLayoutJugador);
		panelJugadores.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		// PANELES CON LOS JUGADORES HAY QUE SETEAR LA IMAGEN
		for (int i = 0; i < 9; i++) {
			this.jugadorNormal.add(new PanelJugadorNormal());
		}
		
		//
		// PANEL INFORMATIVOS
		//
		
		lblJuez = new JLabel("Nombre JUEZ");
		lblJuez.setBounds(627, 38, 71, 56);
		contentPane.add(lblJuez);
		
		lblJugador = new JLabel("Nombre JUGADOR");
		lblJugador.setBounds(616, 89, 97, 56);
		contentPane.add(lblJugador);
		
		//---------------------Panel Principal----------------------------------
		//
		// PANEL APROXIMACION
		//

		panelAproximacion = new JPanel();
		panelAproximacion.setBounds(695, 11, 571, 359);
		contentPane.add(panelAproximacion);
		panelAproximacion.setLayout(null);
		
		btnaproxEnviar = new JButton("ENVIAR");
		btnaproxEnviar.setBounds(48, 316, 142, 47);
		panelAproximacion.add(btnaproxEnviar);
		
		txtaproxRespuesta = new JFormattedTextField();
		txtaproxRespuesta.setBounds(48, 257, 142, 48);
		panelAproximacion.add(txtaproxRespuesta);

		
		table = new JTable();
		table.setBounds(229, 209, 196, 149);
		panelAproximacion.add(table);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(239, 368, 179, 43);
		panelAproximacion.add(lblNewLabel);
		
		//
		// PANEL PREGUNTA
		//

		panelPregunta = new JPanel();
		panelPregunta.setBounds(89, 11, 542, 359);
		contentPane.add(panelPregunta);
	
		panelPregunta.setLayout(null);
		
		btnpreRespuesta1.setBounds(10, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta1);
		
		btnpreRespuesta2.setBounds(243, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta2);
		
		btnpreRespuesta3.setBounds(10, 313, 187, 55);
		panelPregunta.add(btnpreRespuesta3);
	
		btnpreRespuesta4.setBounds(243, 313, 187, 55);
		panelPregunta.add(btnpreRespuesta4);
		
		lblprePregunta = new JLabel("New label");
		lblprePregunta.setBounds(10, 98, 420, 131);
		panelPregunta.add(lblprePregunta);
		
		

		
	}
	
	//GET DE LOS ESCALONES
	public JPanel getPanelColumna() {
		return panelColumna;
	}	
	public ArrayList<PanelEscalon> getEscalones() {
		return escalones;
	}

	//GET DE LOS JUGADORES
	public JPanel getPanelJugadores() {
		return panelJugadores;
	}
	public ArrayList<PanelJugadorNormal> getJugadorNormal() {
		return jugadorNormal;
	}
	public ArrayList<PanelJugadorFinal> getJugadorFinal() {
		return jugadorFinal;
	}

	public ControladorJuego getC() {return c;}
	public void setC(ControladorJuego c) {this.c = c;}
	
	
	public JTable getTable() {return table;}
	public void setTable(JTable table) {this.table = table;}

	public JLabel getLblJuez() {return lblJuez;}
	public void setLblJuez(JLabel lblJuez) {this.lblJuez = lblJuez;}
	
	public JLabel getLblJugador() {return lblJugador;}
	public void setLblJugador(JLabel lblJugador) {this.lblJugador = lblJugador;}
	
	
	
	public JPanel getPanelPregunta() {return panelPregunta;}
	public JLabel getLblprePregunta() {return lblprePregunta;}
	public void setLblprePregunta(JLabel lblprePregunta) {this.lblprePregunta = lblprePregunta;}

	public JButton getBtnpreRespuesta2() {return btnpreRespuesta2;}
	public JButton getBtnpreRespuesta1() {return btnpreRespuesta1;}
	public JButton getBtnpreRespuesta3() {return btnpreRespuesta3;}
	public JButton getBtnpreRespuesta4() {return btnpreRespuesta4;}
	public void setBtnpreRespuesta2(BotonPregunta btnpreRespuesta2) {this.btnpreRespuesta2 = btnpreRespuesta2;}
	public void setBtnpreRespuesta1(BotonPregunta btnpreRespuesta1) {this.btnpreRespuesta1 = btnpreRespuesta1;}
	public void setBtnpreRespuesta3(BotonPregunta btnpreRespuesta3) {this.btnpreRespuesta3 = btnpreRespuesta3;}
	public void setBtnpreRespuesta4(BotonPregunta btnpreRespuesta4) {this.btnpreRespuesta4 = btnpreRespuesta4;}
	
	
	public JPanel getPanelAproximacion() {return panelAproximacion;}
	
	public JButton getBtnaproxEnviar() {return btnaproxEnviar;}
	public void setBtnaproxEnviar(JButton btnaproxEnviar) {this.btnaproxEnviar = btnaproxEnviar;}
	public JFormattedTextField getTxtaproxRespuesta() {return txtaproxRespuesta;}
	public void setTxtaproxRespuesta(JFormattedTextField txtaproxRespuesta) {this.txtaproxRespuesta = txtaproxRespuesta;}
}
