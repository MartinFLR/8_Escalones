package view;

import controller.ControladorJuego;
import view.componentes.PanelEscalon;
import view.componentes.PanelJugadorNormal;
import view.componentes.PanelJugadorFinal;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JDesktopPane;
import javax.swing.JFormattedTextField;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JTable;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorJuego c;

	private JPanel panelPregunta;
	private JLabel lblprePregunta;
	private JButton btnpreRespuesta2;
	private JButton btnpreRespuesta1;
	private JButton btnpreRespuesta3;
	private JButton btnpreRespuesta4;
	
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
	private PanelEscalon e1, e2, e3, e4, e5, e6, e7, e8;
	private PanelJugadorNormal j1, j2, j3, j4, j5, j6 ,j7 ,j8 ,j9;
	private PanelJugadorFinal jf1, jf2;

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
		e8 = new PanelEscalon(8,Color.BLACK,Color.red);
		panelColumna.add(e8);
		e7 = new PanelEscalon(7,Color.BLACK,Color.red);
		panelColumna.add(e7);
		e6 = new PanelEscalon(6,Color.BLACK,Color.red);
		panelColumna.add(e6);
		e5 = new PanelEscalon(5,Color.BLACK,Color.red);
		panelColumna.add(e5);
		e4 = new PanelEscalon(4,Color.BLACK,Color.red);
		panelColumna.add(e4);
		e3 = new PanelEscalon(3,Color.BLACK,Color.red);
		panelColumna.add(e3);
		e2 = new PanelEscalon(2,Color.BLACK,Color.red);
		panelColumna.add(e2);
		e1 = new PanelEscalon(1,Color.BLACK,Color.red);
		panelColumna.add(e1);
		
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
		
		jf1 = new PanelJugadorFinal("imagenes/playericon/playerBlack.png");
		panelFinal.add(jf1);
		jf2 = new PanelJugadorFinal("imagenes/playericon/playerBlack.png");
		panelFinal.add(jf2);
		
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
		j1 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j1);
		j2 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j2);
		j3 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j3);
		j4 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j4);
		j5 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j5);
		j6 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j6);
		j7 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j7);
		j8 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j8);
		j9 = new PanelJugadorNormal("imagenes/playericon/playerBlack.png");
		panelJugadores.add(j9);
		
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
		
		btnpreRespuesta1 = new JButton("New button");
		btnpreRespuesta1.setBounds(10, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta1);
		
		btnpreRespuesta2 = new JButton("New button");
		btnpreRespuesta2.setBounds(243, 239, 187, 55);
		panelPregunta.add(btnpreRespuesta2);
		
		btnpreRespuesta3 = new JButton("New button");
		btnpreRespuesta3.setBounds(10, 313, 187, 55);
		panelPregunta.add(btnpreRespuesta3);
		
		btnpreRespuesta4 = new JButton("New button");
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
	public PanelEscalon getE1() {return e1;}
	public PanelEscalon getE2() {return e2;}
	public PanelEscalon getE3() {return e3;}
	public PanelEscalon getE4() {return e4;}
	public PanelEscalon getE5() {return e5;}
	public PanelEscalon getE6() {return e6;}
	public PanelEscalon getE7() {return e7;}
	public PanelEscalon getE8() {return e8;}
	
	//GET DE LOS JUGADORES
	public JPanel getPanelJugadores() {
		return panelJugadores;
	}
	public PanelJugadorNormal getJ1() {return j1;}
	public PanelJugadorNormal getJ2() {return j2;}
	public PanelJugadorNormal getJ3() {return j3;}
	public PanelJugadorNormal getJ4() {return j4;}
	public PanelJugadorNormal getJ5() {return j5;}
	public PanelJugadorNormal getJ6() {return j6;}
	public PanelJugadorNormal getJ7() {return j7;}
	public PanelJugadorNormal getJ8() {return j8;}
	public PanelJugadorNormal getJ9() {return j9;}
	
	
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
	public void setBtnpreRespuesta2(JButton btnpreRespuesta2) {this.btnpreRespuesta2 = btnpreRespuesta2;}
	public void setBtnpreRespuesta1(JButton btnpreRespuesta1) {this.btnpreRespuesta1 = btnpreRespuesta1;}
	public void setBtnpreRespuesta3(JButton btnpreRespuesta3) {this.btnpreRespuesta3 = btnpreRespuesta3;}
	public void setBtnpreRespuesta4(JButton btnpreRespuesta4) {this.btnpreRespuesta4 = btnpreRespuesta4;}
	
	
	public JPanel getPanelAproximacion() {return panelAproximacion;}
	
	public JButton getBtnaproxEnviar() {return btnaproxEnviar;}
	public void setBtnaproxEnviar(JButton btnaproxEnviar) {this.btnaproxEnviar = btnaproxEnviar;}
	public JFormattedTextField getTxtaproxRespuesta() {return txtaproxRespuesta;}
	public void setTxtaproxRespuesta(JFormattedTextField txtaproxRespuesta) {this.txtaproxRespuesta = txtaproxRespuesta;}
}
