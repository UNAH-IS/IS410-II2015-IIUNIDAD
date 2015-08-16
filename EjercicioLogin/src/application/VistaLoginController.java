package application;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.Conexion;
import modelo.Usuario;

public class VistaLoginController {
	private Main main;
	@FXML private TextField txtUsuario;
	@FXML private PasswordField txtContrasena;

	@FXML
	public void abrirFormularioPrincipal(){
		Conexion conexion = new Conexion();
		conexion.establecerConexion();
		//Ejecutar el script
		if (
				Usuario.verificarUsuario(conexion.getConnection(),
				txtUsuario.getText(), txtContrasena.getText())
		)		
			main.abrirFormularioPrincipal();
		else{
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error");
			mensaje.setContentText("Usuario/Contraseña incorrecto");
			mensaje.setHeaderText("Error de acceso");
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
