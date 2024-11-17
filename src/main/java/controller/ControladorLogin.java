package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import model.ABM.AdminDAO;
import view.VistaLogin;
import view.VistaPrincipal;
import model.ABM.ManagerSession;

public class ControladorLogin implements ActionListener{

	private VistaLogin vista;
	private AdminDAO adminDAO;
	private ControladorPrincipal controladorPrincipal;

	

	public ControladorLogin (ControladorPrincipal controladorPrincipal) {
		this.controladorPrincipal = controladorPrincipal;
		this.vista = new VistaLogin(this);
		this.vista.setVisible(true);
		this.adminDAO = new AdminDAO();

		this.vista.getBtnLogin().addActionListener(this);
		this.vista.getBtnSalir().addActionListener(e -> {this.vista.dispose();});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == vista.getBtnLogin()) {
            String cuenta = vista.getTxtCuenta().getText();
            String contrasenia = new String(vista.getTxtContrasenia().getPassword());

            // Validar login con las credenciales
            if (adminDAO.Login(cuenta, contrasenia)) {
                // Si el login es exitoso, mostrar vista principal
                JOptionPane.showMessageDialog(vista, "¡Login exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
				ManagerSession.setLogueado(true);
				controladorPrincipal.verificarEstadoSesion();
				controladorPrincipal.getVista().actualizarEstadoLogin(true);
				
                vista.dispose(); // Cierra la ventana de login
            } else {
                // Si el login falla
                JOptionPane.showMessageDialog(vista, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }

		
	}

	



	
}
