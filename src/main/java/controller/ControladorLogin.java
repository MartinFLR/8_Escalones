package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import model.ABM.AdminDAO;
import model.Admin;
import view.VistaLogin;
import view.VistaPrincipal;
import model.ABM.ManagerSession;
import raven.toast.Notifications;

public class ControladorLogin implements ActionListener{

	private VistaLogin vista;
	private AdminDAO adminDAO;
	private ControladorPrincipal controladorPrincipal;
	
	public ControladorLogin (ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.vista = new VistaLogin();
		this.vista.setVisible(true);
		this.adminDAO = new AdminDAO();

		this.vista.getBtnLogin().addActionListener(this);
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
		
		this.vista.getBtnOlvidoContrasenia().addActionListener(e -> {
			this.vista.getPanelCambio().setVisible(true);
		});
		this.vista.getBtnCambioSalir().addActionListener(e -> {this.vista.getPanelCambio().setVisible(false);});
		this.vista.getBtnCambioAceptar().addActionListener(e -> {
			String nuevoUsuario = this.vista.getTxtCambioCuenta().getText();
			String nuevaContrasenia1 = this.vista.getTxtContraseniaNueva1().getText();
			String nuevaContrasenia2 = this.vista.getTxtContraseniaNueva2().getText();

			Admin antiguoAdmin = this.adminDAO.buscarAdmin();

			if (!antiguoAdmin.getNombre().equals(nuevoUsuario)) {
				Notifications.getInstance().setJFrame(controladorPrincipal.getVista());
				Notifications.getInstance().show(
						Notifications.Type.ERROR,
						Notifications.Location.TOP_CENTER,
						"El nombre de usuario no coincide con el actual. Por favor, ingrese su nombre de usuario correctamente."
				);
				return;
			}
			if (!nuevaContrasenia1.equals(nuevaContrasenia2)) {
				Notifications.getInstance().setJFrame(controladorPrincipal.getVista());
				Notifications.getInstance().show(
						Notifications.Type.ERROR,
						Notifications.Location.TOP_CENTER,
						"Las contraseñas no coinciden. Por favor, intente nuevamente."
				);
				return;
			}

			Admin nuevoAdmin = new Admin(antiguoAdmin.getNombre(), nuevaContrasenia1);

			this.adminDAO.modificar(nuevoAdmin);

			Notifications.getInstance().setJFrame(controladorPrincipal.getVista());
			Notifications.getInstance().show(
					Notifications.Type.SUCCESS,
					Notifications.Location.TOP_CENTER,
					"Contraseña cambiada con éxito."
			);

			this.vista.dispose();
			this.vista.getPanelCambio().setVisible(false);
		});
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == vista.getBtnLogin()) {
            String cuenta = vista.getTxtCuenta().getText();
            String contrasenia = new String(vista.getTxtContrasenia().getPassword());

            if (adminDAO.Login(cuenta, contrasenia)) {
                Notifications.getInstance().show(Notifications.Type.SUCCESS, Notifications.Location.TOP_CENTER, "Te has logueado correctamente");
                Notifications.getInstance().setJFrame(controladorPrincipal.getVista());
				ManagerSession.setLogueado(true);
				controladorPrincipal.verificarEstadoSesion();
				controladorPrincipal.getVista().actualizarEstadoLogin(true);
                vista.dispose();
            } else {
            	Notifications.getInstance().show(Notifications.Type.ERROR, Notifications.Location.TOP_CENTER, "Credenciales incorrectas");
            	Notifications.getInstance().setJFrame(this.vista);
            }
        }
	}
}
