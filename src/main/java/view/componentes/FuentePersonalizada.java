package view.componentes;

import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;

public class FuentePersonalizada {

	public FuentePersonalizada () {
	}
	
	public Font getFuente(String path, Float size) {
		try{
            // load a custom font in your project folder
			Font pixelMplus;
			pixelMplus = Font.createFont(Font.TRUETYPE_FONT, new File(path)).deriveFont(size);	
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File(path)));
			return pixelMplus;
		}
		catch(IOException | FontFormatException e){
			e.printStackTrace();
		}
		return null;
	}
	
}
