package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javafx.collections.ObservableList;

public class Conexion {
	private Connection conexion; //Objeto para establecer la conexion
	private String url = "jdbc:mysql://localhost/db_facturacion";//IP, base de datos
	private String usuario = "root";
	private String contrasena = "";
	
	public Conexion(){
		establecerConexion();
	}
	
	public void establecerConexion(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,contrasena);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void cerrarConexion(){
		try {
			conexion.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionMarcas(ObservableList<Marca> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = 
					instruccion.executeQuery(
							"SELECT codigo_marca, "
							+ "nombre_marca "
							+ "FROM tbl_marcas");
			while (resultado.next()){
				lista.add(
					new Marca(
						resultado.getInt("codigo_marca"),
						resultado.getString("nombre_marca")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionLotes(ObservableList<String> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = 
					instruccion.executeQuery(
							"SELECT codigo_lote, lote "
							+ "FROM tbl_lotes");
			while (resultado.next()){
				lista.add(resultado.getString("lote"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
	
	public void llenarInformacionCategorias(ObservableList<String> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_categoria, "
					+ "nombre_categoria "
					+ "FROM tbl_categorias");
			while(resultado.next()){
				lista.add(resultado.getString("nombre_categoria"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionUnidadMedida(ObservableList<String> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_unidad_medida, "
					+ "nombre_unidad_medida "
					+ "FROM tbl_unidad_medidas");
			while(resultado.next()){
				lista.add(resultado.getString("nombre_unidad_medida"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionProveedores(ObservableList<String> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_proveedor, "
					+ "nombre_proveedor "
					+ "FROM tbl_proveedores");
			while(resultado.next()){
				lista.add(resultado.getString("nombre_proveedor"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionMoneda(ObservableList<Moneda> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_moneda, "
					+ "nombre_moneda, "
					+ "abreviatura_moneda "
					+ "FROM tbl_monedas");
			while(resultado.next()){
				lista.add(
					new Moneda(
						resultado.getInt("codigo_moneda"),
						resultado.getString("nombre_moneda"),
						resultado.getString("abreviatura_moneda")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
