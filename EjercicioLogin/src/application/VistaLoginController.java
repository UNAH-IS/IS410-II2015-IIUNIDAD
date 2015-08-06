package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.fxml.FXML;
import modelo.Conexion;

public class VistaLoginController {
	private Main main;

	@FXML
	public void abrirFormularioPrincipal(){
		Conexion conexion = new Conexion();
		//Ejecutar el script
		Connection connection = conexion.getConnection();
		PreparedStatement ps;
		int cantidadRegistros = 0;
		try {
			ps = connection.prepareStatement(
				"SELECT codigo_usuario " +
				"FROM tbl_usuarios " + 
				"WHERE usuario = ? " +
				"and contrasena = sha1(?)"
			);
		
			ResultSet resultado = ps.executeQuery();
			cantidadRegistros = resultado.getFetchSize();
			conexion.cerrarConexion();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (cantidadRegistros == 1)
			main.abrirFormularioPrincipal();
	}
	
	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
}
