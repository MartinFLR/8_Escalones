package view.componentes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class PanelEscalon extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private JLabel lblTema;
	private JLabel lblNumeroEscalon;
	private Color colorOriginal = Color.white, colorUso = new Color(253, 201, 33), colorFinal = new Color(253, 201, 33);
	
	public PanelEscalon(Integer num) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1));
		setLayout(new BorderLayout());
		setBackground(colorOriginal);
		lblNumeroEscalon = new JLabel(String.valueOf(num));
		lblNumeroEscalon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroEscalon.setFont(new Font("Trebuchet MS", Font.PLAIN, 60));
		lblNumeroEscalon.setForeground(new Color(37, 36, 34));
		add(lblNumeroEscalon, BorderLayout.CENTER);
		
		lblTema = new JLabel();
		lblTema.setHorizontalAlignment(SwingConstants.CENTER);
		lblTema.setForeground(new Color(37, 36, 34));
		add(lblTema, BorderLayout.SOUTH);
		
		setBackground(null);
		
	}
	
	public void setNombreEscalon(String nombre) {
		lblTema.setText(nombre);
	}
	
	// -- SET DE LOS COLORES EN USO DEL ESCALON EN PARTICULAR
	public void setcolorUso () {
		setBackground(colorUso);
		lblNumeroEscalon.setForeground(new Color(255,255,255));
		lblTema.setForeground(new Color(255,255,255));
	}
	
	public void setcolorNoUso () {
		//setBackground(colorOriginal);
		lblNumeroEscalon.setForeground(new Color(37, 36, 34));
		lblTema.setForeground(new Color(37, 36, 34));
	}
	
	public void setcolorFinal() {
		setBackground(colorFinal);
	}

	public void setColorEscalon (Color color) {
		setBackground(color);
	}
	
    public JLabel getLblTema() {
        return this.lblTema;
    }

	public JLabel getLblNumeroEscalon(){
		return this.lblNumeroEscalon;
	}

	
	
}
