package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class Usuario{
   private IntegerProperty codigoUsuario;
   private StringProperty nombreCompleto;
   private StringProperty usuario;
   private StringProperty contrasena;


   public Usuario(int codigoUsuario, String nombreCompleto, String usuario, 
String contrasena) { 
	   this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	   this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
	   this.usuario = new SimpleStringProperty(usuario);
	   this.contrasena = new SimpleStringProperty(contrasena);
   }

// ++++++++Metodos codigoUsuario
 public int getcodigoUsuario() {
     return codigoUsuario.get();
 }
 public void setcodigoUsuario(int codigoUsuario) {
      this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
 }
 public IntegerProperty codigoUsuarioProperty() {
     return codigoUsuario;
 }

// ++++++++Metodos nombreCompleto
 public String getnombreCompleto() {
     return nombreCompleto.get();
 }
 public void setnombreCompleto(String nombreCompleto) {
      this.nombreCompleto = new SimpleStringProperty(nombreCompleto);
 }
 public StringProperty nombreCompletoProperty() {
     return nombreCompleto;
 }

// ++++++++Metodos usuario
 public String getusuario() {
     return usuario.get();
 }
 public void setusuario(String usuario) {
      this.usuario = new SimpleStringProperty(usuario);
 }
 public StringProperty usuarioProperty() {
     return usuario;
 }

// ++++++++Metodos contrasena
 public String getcontrasena() {
     return contrasena.get();
 }
 public void setcontrasena(String contrasena) {
      this.contrasena = new SimpleStringProperty(contrasena);
 }
 public StringProperty contrasenaProperty() {
     return contrasena;
 }

 	public static boolean verificarUsuario(Connection connection,
 			String usuario,
 			String contrasena){
 		int cantidadRegistros = 0;
		try {
			PreparedStatement ps = 
					connection.prepareStatement(
							"SELECT codigo_usuario " +
							"FROM tbl_usuarios " +
							"WHERE usuario = ? " +
							"AND contrasena = sha1(?)"
					);
			
			
			ps.setString(1, usuario);
			ps.setString(2, contrasena);
			ResultSet resultado = ps.executeQuery();
			resultado.last();
			cantidadRegistros = resultado.getRow();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		if (cantidadRegistros==1)
			return true;
		else
			return false;
 	}
 
}
