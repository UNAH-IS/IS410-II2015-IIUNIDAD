package ejercicio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EjercicioJDBC {
	private Connection conexion;
	private Statement instruccion;//Para parametrizar instrucciones SQL
	private ResultSet resultado;//Para almacenar el resultado de la consulta
	private String url = "jdbc:mysql://localhost/db_facturacion"; //IP,nombre de la base de datos
	private String usuario = "root";
	private String constrasena = "";
	
	public EjercicioJDBC(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,constrasena);
			instruccion = conexion.createStatement();
			resultado = instruccion.executeQuery(
					"SELECT codigo_marca,"
					+ "nombre_marca "
					+ "FROM tbl_marcas");
			while(resultado.next()){
				System.out.println(
						"Codigo Marca: " + resultado.getInt("codigo_marca")+
						", Nombre Marca: " + resultado.getString("nombre_marca"));
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new EjercicioJDBC();
	}

}
