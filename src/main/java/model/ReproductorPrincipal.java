package model;

import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class ReproductorPrincipal {
    private Clip clip;
    private static ReproductorPrincipal instancia;
    private File[] rutas = new File[15];
    private FloatControl volumeControl;
    
    public ReproductorPrincipal() {
    	rutas[0] = new File("musica/musicaPrincipal.wav");
        rutas[1] = new File("musica/musicaFinal.wav");
        rutas[2] = new File("musica/muerte.wav");
    }
    
    public void setFile(int i) {
    	try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(rutas[i]);
			clip = AudioSystem.getClip();
			clip.open(ais);
			volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
    
    public void reproducir() {
        	clip.setFramePosition(0);
            clip.start();
    }
    
    public void pausar() {
    	clip.stop();
    }    
    
    public void loop() {
    	clip.loop(clip.LOOP_CONTINUOUSLY);
    }
    
    public void setVolume(float value) {
    	volumeControl.setValue(value);
    }
    
    //singleton 
    public static ReproductorPrincipal getInstance() {
        if (instancia == null) {
            instancia = new ReproductorPrincipal();
        }
        return instancia;
    }
    
    
    
    
}

