package model;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sonido {
    private Clip clip;
    private File[] rutas = new File[15];
    private static Sonido instancia;
    private FloatControl volumeControl;
    private float numero;
    
    private Sonido() {
    	rutas[0] = new File("musica/correcta.wav");
    	rutas[1] = new File("musica/incorrecta.wav");
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
    
    public void reproducirmusica(int i, float numero) {
    	setFile(i);
    	setVolume(numero);
    	clip.setFramePosition(0);
    	clip.start();
    }
    
    public void setVolume(float value) {
    	volumeControl.setValue(value);
    }
    
    public static Sonido getInstance() {
        if (instancia == null) {
            instancia = new Sonido();
        }
        return instancia;
    }


	public float getNumero() {
		return numero;
	}


	public void setNumero(float numero) {
		this.numero = numero;
	}
    
    
}
