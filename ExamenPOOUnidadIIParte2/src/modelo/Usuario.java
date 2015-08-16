package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class Usuario{
   private IntegerProperty codigoUsuario;
   private TipoUsuario tipoUsuario;
   private StringProperty nombreUsuario;
   private StringProperty contrasena;


   public Usuario(int codigoUsuario, TipoUsuario tipoUsuario, String nombreUsuario, 
		   String contrasena) { 
	   this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	   this.tipoUsuario = tipoUsuario;
	   this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	   this.contrasena = new SimpleStringProperty(contrasena);
   }

	 public int getcodigoUsuario() {
	     return codigoUsuario.get();
	 }
	 public void setcodigoUsuario(int codigoUsuario) {
	      this.codigoUsuario = new SimpleIntegerProperty(codigoUsuario);
	 }
	 public IntegerProperty codigoUsuarioProperty() {
	     return codigoUsuario;
	 }
	
	 public TipoUsuario gettipoUsuario() {
	     return tipoUsuario;
	 }
	 public void settipoUsuario(TipoUsuario tipoUsuario) {
	      this.tipoUsuario = tipoUsuario;
	 }
	 
	 public String getnombreUsuario() {
	     return nombreUsuario.get();
	 }
	 public void setnombreUsuario(String nombreUsuario) {
	      this.nombreUsuario = new SimpleStringProperty(nombreUsuario);
	 }
	 public StringProperty nombreUsuarioProperty() {
	     return nombreUsuario;
	 }
	
	 public String getcontrasena() {
	     return contrasena.get();
	 }
	 public void setcontrasena(String contrasena) {
	      this.contrasena = new SimpleStringProperty(contrasena);
	 }
	 public StringProperty contrasenaProperty() {
	     return contrasena;
	 }
	 @Override
	 public String toString(){
		 return nombreUsuario.get();
	 }
	 public static void llenarListaUsuarios(Connection connection, ObservableList<Usuario> lista){
		try {
			Statement instruccion = connection.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT A.codigo_usuario, "+
								"A.usuario, " +
					            "A.codigo_tipo_usuario, "+ 
								"A.contrasena, "+
					            "B.tipo_usuario "+
					"FROM tbl_usuarios A "+ 
					"INNER JOIN tbl_tipos_usuarios  B "+ 
					"ON (A.codigo_tipo_usuario=B.codigo_tipo_usuario) "
			);
			//AGREGAR EL CODIGO QUE FALTA AQUI
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 
	 }
	 public int almacenarRegistro(Connection connection){
		 //FINALIZAR ESTE METODO.
		 //Script: INSERT INTO tbl_usuarios (usuario, contrasena, codigo_tipo_usuario) VALUES (?,?,?,?);
		 return 0;
	 }
 }
