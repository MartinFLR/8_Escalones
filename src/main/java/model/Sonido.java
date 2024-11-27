package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
    private Clip clip;
    private File[] rutas = new File[15];
    
    public Sonido() {
    	rutas[0] = new File("musica/correcta.wav");
    	rutas[1] = new File("musica/incorrecta.wav");
    }
    
    
    public void setFile(int i) {
    	try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(rutas[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void reproducirmusica(int i) {
    	setFile(i);
    	clip.setFramePosition(0);
    	clip.start();
    }
    
    
}
