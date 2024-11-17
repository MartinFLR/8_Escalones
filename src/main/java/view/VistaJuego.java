package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;

import controller.ControladorJuego;
import view.componentes.BotonPregunta;
import view.componentes.PanelEscalon;
import view.componentes.PanelJugadorFinal;
import view.componentes.PanelJugadorNormal;

public class VistaJuego extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private ControladorJuego c;

	private JPanel panelPregunta;
	private JLabel lblprePregunta;
	private BotonPregunta btnpreRespuesta1 = new BotonPregunta();
	private BotonPregunta btnpreRespuesta2 = new BotonPregunta();;
	private BotonPregunta btnpreRespuesta3 = new BotonPregunta();;
	private BotonPregunta btnpreRespuesta4 = new BotonPregunta();
	
	private JPanel panelAproximacion;
	private JButton btnaproxEnviar;
	private JFormattedTextField txtaproxRespuesta;
	
	private JPanel panelColumna;
	private JPanel panelJugadores;
	
	private JLabel lblaproxPregunta;
	private JLabel lblaproxRespuesta;
	private JTable table;
	
	private JPanel panelFinal;
	
	// ATRIBUTOS PARA CADA JUGADOR Y ESCALON
	private ArrayList<PanelEscalon> escalones = new ArrayList<PanelEscalon>();
	private ArrayList<PanelJugadorNormal> jugadorNormal = new ArrayList<PanelJugadorNormal>();
	private ArrayList<PanelJugadorFinal> jugadorFinal = new ArrayList<PanelJugadorFinal>();
	
	

	public VistaJuego(ControladorJuego c) {
		this.setC(c);
		setTitle("8 ESCALONES");
		setLocationRelativeTo(null);
		setResizable(false);
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
		// Cambia el color del primer escalon por default
		this.escalones.getFirst().setcolorUso();

		//
		// PANEL JUGADORES (FINAL)
		//
		
		panelFinal = new JPanel();
		panelFinal.setBounds(85, 390, 1181, 131);
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
			panelJugadores.add(this.jugadorNormal.get(i));
		}
	
		
		//---------------------Panel Principal----------------------------------
		//
		// PANEL APROXIMACION
		//

		panelAproximacion = new JPanel();
		panelAproximacion.setBounds(695, 11, 571, 359);
		contentPane.add(panelAproximacion);
		panelAproximacion.setLayout(null);
		
		btnaproxEnviar = new JButton("ENVIAR");
		btnaproxEnviar.setBounds(48, 247, 142, 47);
		panelAproximacion.add(btnaproxEnviar);
		btnaproxEnviar.setBackground(new Color(222, 226, 230));
		btnaproxEnviar.setForeground(new Color(37, 36, 34));
		
		NumberFormat formatoNumero = NumberFormat.getIntegerInstance();
        NumberFormatter formateador = new NumberFormatter(formatoNumero);
        formateador.setAllowsInvalid(false);
        formateador.setMaximum(10000000); 
		txtaproxRespuesta = new JFormattedTextField(formateador);
		txtaproxRespuesta.setBounds(48, 188, 142, 48);
		panelAproximacion.add(txtaproxRespuesta);
		txtaproxRespuesta.setBackground(new Color(222, 226, 230));
		txtaproxRespuesta.setForeground(new Color(37, 36, 34));

		String[] column = {"Jugador", "Respuesta"};
		DefaultTableModel defTable = new DefaultTableModel(null,column);
		table = new JTable(defTable);
		table.setBounds(214, 188, 347, 118);
		panelAproximacion.add(table);
		table.setBackground(new Color(222, 226, 230));
		
		JPanel panelPregunta = new JPanel();
		panelPregunta.setBackground(new Color(222, 226, 230));
		panelPregunta.setBounds(10, 11, 551, 167);
		panelPregunta.setBackground(new Color(222, 226, 230));
		panelAproximacion.add(panelPregunta);
		
		lblaproxPregunta = new JLabel();
		lblaproxPregunta.setVerticalAlignment(SwingConstants.CENTER);
		lblaproxPregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblaproxPregunta.setForeground(new Color(37, 36, 34));
		lblaproxPregunta.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panelPregunta.add(lblaproxPregunta);
		
		JPanel panelCorrecto = new JPanel();
		panelCorrecto.setBounds(214, 317, 347, 31);
		panelAproximacion.add(panelCorrecto);
		lblaproxRespuesta = new JLabel();
		lblaproxRespuesta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblaproxRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
		lblaproxRespuesta.setVerticalAlignment(SwingConstants.CENTER);
		lblaproxRespuesta.setForeground(new Color(37, 36, 34));
		panelCorrecto.add(lblaproxRespuesta);
		panelCorrecto.setBackground(new Color(222, 226, 230));
		
		
		//
		// PANEL PREGUNTA
		//

		panelPregunta = new JPanel();
		panelPregunta.setBounds(89, 11, 542, 359);
		contentPane.add(panelPregunta);
	
		panelPregunta.setLayout(null);

		btnpreRespuesta1.setBounds(10, 189, 230, 70);
		btnpreRespuesta1.setForeground(new Color(37, 36, 34));
		panelPregunta.add(btnpreRespuesta1);
		
		btnpreRespuesta2.setBounds(302, 189, 230, 70);
		btnpreRespuesta2.setForeground(new Color(37, 36, 34));
		panelPregunta.add(btnpreRespuesta2);
		
		btnpreRespuesta3.setBounds(10, 278, 230, 70);
		btnpreRespuesta3.setForeground(new Color(37, 36, 34));
		panelPregunta.add(btnpreRespuesta3);

		btnpreRespuesta4.setBounds(302, 278, 230, 70);
		btnpreRespuesta4.setForeground(new Color(37, 36, 34));
		panelPregunta.add(btnpreRespuesta4);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 11, 522, 167);
		panel.setBackground(new Color(222, 226, 230));
		panelPregunta.add(panel);		
		lblprePregunta = new JLabel();
		lblprePregunta.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblprePregunta.setHorizontalAlignment(SwingConstants.CENTER);
		lblprePregunta.setVerticalAlignment(SwingConstants.CENTER);
		lblprePregunta.setForeground(new Color(37, 36, 34));
		panel.add(lblprePregunta);		
		
		
		

		
	}
	
	//GET DE LOS ESCALONES
	public JPanel getPanelColumna() {
		return panelColumna;
	}	
	public ArrayList<PanelEscalon> getEscalones() {
		return escalones;
	}
	//SET DE ESCALON EN USO
	public void setEscalonUso(int nroEscalon) {
		for (PanelEscalon panelEscalon : escalones) {
			panelEscalon.setcolorNoUso();
		}
		escalones.get(nroEscalon).setcolorUso();
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
