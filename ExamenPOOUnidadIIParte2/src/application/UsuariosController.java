package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import modelo.Conexion;
import modelo.TipoUsuario;
import modelo.Usuario;

public class UsuariosController implements Initializable{
	private Conexion conexion; 
	
	@FXML private ComboBox<TipoUsuario> cmbTiposUsuarios;
	@FXML private ListView<Usuario> lstUsuarios;
	
	@FXML private TextField txtCodigoUsuario;
	@FXML private TextField txtUsuario;
	@FXML private PasswordField txtContrasena;	
	
	
	private ObservableList<TipoUsuario> listaTiposUsuarios;
	private ObservableList<Usuario> listaUsuarios;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		conexion = new Conexion();
		conexion.establecerConexion();
		listaTiposUsuarios = FXCollections.observableArrayList();
		listaUsuarios = FXCollections.observableArrayList();
		TipoUsuario.llenarListaTiposUsuarios(conexion.getConnection(), listaTiposUsuarios);
		Usuario.llenarListaUsuarios(conexion.getConnection(), listaUsuarios);
		cmbTiposUsuarios.setItems(listaTiposUsuarios);
		lstUsuarios.setItems(listaUsuarios);
		conexion.cerrarConexion();
	}
	
	@FXML
	public void guardarRegistro(){
		//FINALIZAR ESTE METODO
		//Agregar registro en la base de datos
		//Agregar registro en el ListView
	}
}

