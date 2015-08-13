package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.Conexion;
import modelo.Usuario;

public class VistaLoginController {
	private Main main;
	private Conexion conexion;
	@FXML private TextField txtUsuario;
	@FXML private PasswordField txtContrasena;
	
	@FXML
	public void abrirFormularioPrincipal(){
		//Conectar a la bd
		conexion = new Conexion();
		conexion.establecerConexion();
			
		if (Usuario.verificarUsuario(conexion.getConnection(), 
				txtUsuario.getText(), txtContrasena.getText()))
			main.abrirFormularioPrincipal();
		else {
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error");
			mensaje.setContentText("Error, usuario/contrasena invalido.");
			mensaje.show();
		}
		conexion.cerrarConexion();
			
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	} 
}
