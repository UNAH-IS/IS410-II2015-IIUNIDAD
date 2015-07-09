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
	
	public void llenarInformacionMarca(ObservableList<Marca> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_marca, "
					+ "nombre_marca "
					+ "FROM tbl_marcas");
			while(resultado.next()){
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
	
	public void llenarInformacionLote(ObservableList<Lote> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_lote, "
					+ "lote "
					+ "FROM tbl_lotes");
			while(resultado.next()){
				lista.add(
					new Lote(
						resultado.getInt("codigo_lote"),
						resultado.getString("lote")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionCategorias(ObservableList<Categoria> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_categoria, "
					+ "nombre_categoria "
					+ "FROM tbl_categorias");
			while(resultado.next()){
				lista.add(
					new Categoria(
						resultado.getInt("codigo_categoria"),
						resultado.getString("nombre_categoria")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionUnidadMedida(ObservableList<UnidadMedida> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_unidad_medida, "
					+ "nombre_unidad_medida "
					+ "FROM tbl_unidad_medidas");
			while(resultado.next()){
				lista.add(
					new UnidadMedida(
						resultado.getInt("codigo_unidad_medida"),
						resultado.getString("nombre_unidad_medida")
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void llenarInformacionProveedores(ObservableList<Proveedor> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT codigo_proveedor, "
					+ "nombre_proveedor "
					+ "FROM tbl_proveedores");
			while(resultado.next()){
				lista.add(
					new Proveedor(
						resultado.getInt("codigo_proveedor"),
						resultado.getString("nombre_proveedor")
					)
				);
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
	
	public void llenarInformacionTableView(ObservableList<Producto> lista){
		try {
			Statement instruccion = conexion.createStatement();
			ResultSet resultado = instruccion.executeQuery(
					"SELECT  A.codigo_producto, " +
						"A.codigo_barra, " +
						"A.nombre_producto, " +
						"A.descripcion_de_producto, " +
				        "A.codigo_marca, " +
				        "B.nombre_marca, " +
				        "A.codigo_lote, " +
				        "A.precio_de_compra, " +
				        "A.precio_de_venta, " +
				        "C.lote, " +
				        "A.codigo_categoria, " +
				        "D.nombre_categoria, " +
				        "A.codigo_proveedores, " +
				        "E.nombre_proveedor, " +
				        "A.codigo_moneda, " +
				        "F.nombre_moneda, " +
				        "F.abreviatura_moneda, " +
				        "A.codigo_unidad_medida, " +
				        "G.nombre_unidad_medida, " +
				        "A.existencia, " +
				        "A.fecha_vencimiento " + 
					"FROM 	tbl_productos A " +
					"INNER JOIN tbl_marcas B " +
					"ON (A.codigo_marca = B.codigo_marca) " +
					"INNER JOIN tbl_lotes C " +
					"ON (A.codigo_lote = c.codigo_lote) " +
					"INNER JOIN tbl_categorias D " +
					"ON (A.codigo_categoria = D.codigo_categoria) " +
					"INNER JOIN tbl_proveedores E " +
					"ON (A.codigo_proveedores = E.codigo_proveedor) " +
					"INNER JOIN tbl_monedas F " +
					"ON (A.codigo_moneda = F.codigo_moneda) " +
					"INNER JOIN tbl_unidad_medidas G " +
					"ON (A.codigo_unidad_medida = G.codigo_unidad_medida)");
			while(resultado.next()){
				lista.add(
					new Producto(
						resultado.getInt("codigo_producto"),
						resultado.getString("codigo_barra"),
						resultado.getString("nombre_producto"),
						resultado.getString("descripcion_de_producto"),
						resultado.getDouble("precio_de_compra"),
						resultado.getDouble("precio_de_venta"),
						new Marca(
								resultado.getInt("codigo_marca"),
								resultado.getString("nombre_marca")
						),
						new Lote(
								resultado.getInt("codigo_lote"),
								resultado.getString("lote")
						),
						new Categoria(
								resultado.getInt("codigo_categoria"),
								resultado.getString("nombre_categoria")
						),
						new UnidadMedida(
								resultado.getInt("codigo_unidad_medida"),
								resultado.getString("nombre_unidad_medida")
						),
						new Proveedor(
								resultado.getInt("codigo_proveedores"),
								resultado.getString("nombre_proveedor")
						),
						resultado.getFloat("existencia"),
						resultado.getDate("fecha_vencimiento"),
						new Moneda(
								resultado.getInt("codigo_moneda"),
								resultado.getString("nombre_moneda"),
								resultado.getString("abreviatura_moneda")
						)					
					)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
}
