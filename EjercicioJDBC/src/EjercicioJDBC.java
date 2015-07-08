import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class EjercicioJDBC {
	private Connection conexion; //Objeto para establecer la conexion
	private String url = "jdbc:mysql://localhost/db_facturacion";//IP, base de datos
	private String usuario = "root";
	private String contrasena = "";
	private Statement instruccion; //Necesario para ejecutar una instruccion SQL
	private ResultSet resultado; //Almacenar el resultado de una consulta
	
	public EjercicioJDBC(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conexion = DriverManager.getConnection(url,usuario,contrasena);
			instruccion = conexion.createStatement();
			String sql = "SELECT codigo_marca, "
					+ "nombre_marca "
					+ "FROM tbl_marcas";
			System.out.println(sql);
			resultado = instruccion.executeQuery(sql);
			
			while(resultado.next()){
				System.out.println("Codigo: "+ resultado.getInt("codigo_marca")+
						", Nombre Marca:" + resultado.getString("nombre_marca"));
			}
			conexion.close();
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
