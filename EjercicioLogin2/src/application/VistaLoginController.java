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
		//Verificar el usuario (Script)
		Connection connection = conexion.getConnection();
		int cantidadRegistros = 0;
		try {
			PreparedStatement ps = 
					connection.prepareStatement(
							"SELECT codigo_usuario " +
							"FROM tbl_usuarios " +
							"WHERE usuario = ? " +
							"AND contrasena = sha1(?)"
					);
			
			
			ps.setString(1, txtUsuario.getText());
			ps.setString(2, txtContrasena.getText());
			ResultSet resultado = ps.executeQuery();
			cantidadRegistros = resultado.getFetchSize();
			while(resultado.next())
				System.out.println(resultado.getInt("codigo_usuario"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conexion.cerrarConexion();	
		if (cantidadRegistros == 1)
			main.abrirFormularioPrincipal();
		else {
			Alert mensaje = new Alert(AlertType.ERROR);
			mensaje.setTitle("Error");
			mensaje.setContentText("Error, usuario/contrasena invalido.");
			mensaje.show();
		}
			
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	} 
}
