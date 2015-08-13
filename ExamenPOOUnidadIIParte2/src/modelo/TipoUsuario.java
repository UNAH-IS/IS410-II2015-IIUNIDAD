package modelo;

import java.sql.Connection;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;



public class TipoUsuario{
   private IntegerProperty codigoTipoUsuario;
   private StringProperty tipoUsuario;

	 public TipoUsuario(int codigoTipoUsuario, String tipoUsuario) { 
		 this.codigoTipoUsuario = new SimpleIntegerProperty(codigoTipoUsuario);
		 this.tipoUsuario = new SimpleStringProperty(tipoUsuario);
	 }


	 public int getcodigoTipoUsuario() {
	     return codigoTipoUsuario.get();
	 }
	 public void setcodigoTipoUsuario(int codigoTipoUsuario) {
	      this.codigoTipoUsuario = new SimpleIntegerProperty(codigoTipoUsuario);
	 }
	 public IntegerProperty codigoTipoUsuarioProperty() {
	     return codigoTipoUsuario;
	 }

	 public String gettipoUsuario() {
	     return tipoUsuario.get();
	 }
	 public void settipoUsuario(String tipoUsuario) {
	      this.tipoUsuario = new SimpleStringProperty(tipoUsuario);
	 }
	 public StringProperty tipoUsuarioProperty() {
	     return tipoUsuario;
	 }
	 
	 public static void llenarListaTiposUsuarios(Connection conexion, ObservableList<TipoUsuario> lista){
		 //FINALIZAR ESTE METODO
		 //Consulta: SELECT codigo_tipo_usuario, tipo_usuario FROM tbl_tipos_usuarios
	 }
}