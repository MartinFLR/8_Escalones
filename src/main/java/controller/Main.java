package controller;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import raven.toast.Notifications;

import javax.swing.*;
import java.awt.EventQueue;
//?

public class Main {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Notifications.getInstance().show(Notifications.Type.INFO,Notifications.Location.TOP_RIGHT,"bienvenidos panchitos");
					UIManager.setLookAndFeel(new FlatDarkLaf()); //Tema oscuro
					//UIManager.setLookAndFeel(new FlatLightLaf()); //Tema claro
					//UIManager.setLookAndFeel(new FlatDarculaLaf()); //Tema oscuro pero diferente XD
					//UIManager.setLookAndFeel(new FlatIntelliJLaf()); //tema claro y diferente tmb
					ControladorPrincipal c = new ControladorPrincipal();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
