package view.componentes;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PanelEscalon extends JPanel{
	
	private static final long serialVersionUID = 1L;
	private Color colorOriginal = Color.black, colorUso = Color.red;
	
	public PanelEscalon(Integer num) {
		setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		setLayout(new BorderLayout(0, 0));
		JLabel lblNumeroEscalon = new JLabel(String.valueOf(num));
		lblNumeroEscalon.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroEscalon.setFont(new Font("Trebuchet MS", Font.PLAIN, 75));
		add(lblNumeroEscalon);
		setBackground(null);
	}
	
	// -- SET DE LOS COLORES EN USO DEL ESCALON EN PARTICULAR
	public void setcolorUso () {
		setBackground(colorUso);
	}
	
	public void setcolorNoUso () {
		setBackground(colorOriginal);
	}
	
	
	
}
