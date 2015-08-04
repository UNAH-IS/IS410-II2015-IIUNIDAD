package application;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Alumno;
import modelo.Carrera;
import modelo.CentroEstudio;
import modelo.Conexion;

public class FormularioAlumnosController implements Initializable{
	//Columnas
	@FXML private TableColumn<Alumno,String> clmnNombre;
	@FXML private TableColumn<Alumno,String> clmnApellido;
	@FXML private TableColumn<Alumno,Number> clmnEdad;
	@FXML private TableColumn<Alumno,String> clmnGenero;
	@FXML private TableColumn<Alumno,Date> clmnFechaIngreso;
	@FXML private TableColumn<Alumno,CentroEstudio> clmnCentroEstudio;
	@FXML private TableColumn<Alumno,Carrera> clmnCarrera;
	
	//Componentes GUI
	@FXML private ComboBox<Carrera> cmbCarrera;
	@FXML private ComboBox<CentroEstudio> cmbCentroEstudio;
	@FXML private TableView<Alumno> tblViewAlumnos;
	
	//Colecciones
	private ObservableList<Carrera> listaCarreras;
	private ObservableList<CentroEstudio> listaCentrosEstudios;
	private ObservableList<Alumno> listaAlumnos;
	
	private Conexion conexion;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		conexion = new Conexion();
		conexion.establecerConexion();
		
		//Inicializar listas
		listaCarreras = FXCollections.observableArrayList();
		listaCentrosEstudios = FXCollections.observableArrayList();
		listaAlumnos = FXCollections.observableArrayList();
		
		//Llenar listas
		Carrera.llenarInformacion(conexion.getConnection(), listaCarreras);
		CentroEstudio.llenarInformacion(conexion.getConnection(), listaCentrosEstudios);
		Alumno.llenarInformacionAlumnos(conexion.getConnection(), listaAlumnos);
		
		//Enlazar listas con ComboBox y TableView
		cmbCarrera.setItems(listaCarreras);
		cmbCentroEstudio.setItems(listaCentrosEstudios);
		tblViewAlumnos.setItems(listaAlumnos);
		
		//Enlazar columnas con atributos
		clmnNombre.setCellValueFactory(new PropertyValueFactory<Alumno,String>("nombre"));
		clmnApellido.setCellValueFactory(new PropertyValueFactory<Alumno,String>("apellido"));
		clmnEdad.setCellValueFactory(new PropertyValueFactory<Alumno,Number>("edad"));
		clmnGenero.setCellValueFactory(new PropertyValueFactory<Alumno,String>("genero"));
		clmnFechaIngreso.setCellValueFactory(new PropertyValueFactory<Alumno,Date>("fechaIngreso"));
		clmnCentroEstudio.setCellValueFactory(new PropertyValueFactory<Alumno,CentroEstudio>("centroEstudio"));
		clmnCarrera.setCellValueFactory(new PropertyValueFactory<Alumno,Carrera>("carrera"));
		
		conexion.cerrarConexion();
	}	
}
