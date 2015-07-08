package prueba;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PruebaJDBC {

	private String usuario="root";
    private String contrasena="";
    private Connection conexion;
    private String url;
    
    public PruebaJDBC(){
    	try {
			
			//"jdbc:oracle:thin:@localhost:1521:xe"
			Class.forName("com.mysql.jdbc.Driver");//Cargar el driver
			url = "jdbc:mysql://localhost/db_facturacion"; //Connection String
	        conexion = DriverManager.getConnection(url, usuario,contrasena); //Conectarse a la base de datos
	        Statement instruccion = conexion.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE); 
            ResultSet resultado = instruccion.executeQuery("SELECT codigo_marca,nombre_marca FROM tbl_marcas");

            while(resultado.next()){
            	System.out.println(resultado.getString("codigo_marca")+" "+
            			resultado.getString("nombre_marca"));
            }
            conexion.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		new PruebaJDBC();

	}

}
