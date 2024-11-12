package view;

import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelEscalon extends JPanel{
	
	public PanelEscalon(Integer num) {
		setLayout(new BorderLayout(0, 0));
		JLabel lblNewLabel = new JLabel(String.valueOf(num));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.PLAIN, 80));
		add(lblNewLabel, BorderLayout.WEST);
	}
	
}
