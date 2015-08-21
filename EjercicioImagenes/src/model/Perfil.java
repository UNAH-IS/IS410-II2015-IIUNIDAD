package model;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.image.Image;



public class Perfil {
	private IntegerProperty codigo;
	private StringProperty nombre;
	private Image imagen;
	private Date fechaRegistro;
	
	public Perfil(int codigo, String nombre, Image imagen,Date fechaRegistro) {
		this.codigo = new SimpleIntegerProperty(codigo);
		this.nombre = new SimpleStringProperty(nombre);
		this.imagen = imagen;
		this.fechaRegistro = fechaRegistro;
		
	}
	public Perfil(){}
	public int getCodigo() {
		return codigo.get();
	}
	public IntegerProperty codigoProperty(){
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = new SimpleIntegerProperty(codigo);
	}
	public String getNombre(){
		return nombre.get();
	}
	public StringProperty nombreProperty(){
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = new SimpleStringProperty(nombre);
	}
	public Image getImagen() {
		return imagen;
	}
	public void setImagen(Image imagen) {
		this.imagen = imagen;
	}
	public Date getFechaRegistro(){
		return fechaRegistro;
	}
	public void setFechaRegistro(Date fechaRegistro){
		this.fechaRegistro = fechaRegistro;
	}
	@Override
	public String toString(){
		return nombre.get();
	}
	
	public int guardarRegistro(Connection connection, File archivoImagen){
		try{
		    PreparedStatement instruccion = 
		    		connection.prepareStatement(
		    				"insert into tbl_perfiles(nombre,imagen,fecha_registro) "+
		    				"values (?,?,?)");
		   
		    instruccion.setString(1, nombre.get());
		    instruccion.setBinaryStream(2,new FileInputStream(archivoImagen),(int)archivoImagen.length());
		    instruccion.setDate(3, fechaRegistro);
		    return instruccion.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
