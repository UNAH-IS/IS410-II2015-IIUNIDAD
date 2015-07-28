package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import modelo.Carrera;
import modelo.CentroEstudio;
import modelo.Conexion;

public class FormularioAlumnosController implements Initializable{
	//Componentes GUI
	@FXML private ComboBox<Carrera> cmbCarrera;
	@FXML private ComboBox<CentroEstudio> cmbCentroEstudio;
	
	//Colecciones
	private ObservableList<Carrera> listaCarreras;
	private ObservableList<CentroEstudio> listaCentrosEstudios;
	
	private Conexion conexion;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		conexion.establecerConexion();
		//Inicializar listas
		listaCarreras = FXCollections.observableArrayList();
		listaCentrosEstudios = FXCollections.observableArrayList();
		//Llenar listas
		Carrera.llenarInformacion(conexion.getConnection(), listaCarreras);
		CentroEstudio.llenarInformacion(conexion.getConnection(), listaCentrosEstudios);
		//Enlazar listas con ComboBox
		cmbCarrera.setItems(listaCarreras);
		cmbCentroEstudio.setItems(listaCentrosEstudios);
		
		conexion.cerrarConexion();
	}	
}
