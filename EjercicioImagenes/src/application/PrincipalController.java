package application;

import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;

import javax.imageio.ImageIO;

import model.Conexion;
import model.Perfil;

public class PrincipalController implements Initializable{
	private Main main;
	@FXML
	private ListView<Perfil> lstPerfiles; 
	@FXML
	private ImageView imageView;
	
	private ObservableList<Perfil> perfiles;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		perfiles = FXCollections.observableArrayList();
		lstPerfiles.setItems(perfiles);
		
		lstPerfiles.getSelectionModel().
			selectedItemProperty().
			addListener(
	        new ChangeListener<Perfil>() {
				@Override
				public void changed(ObservableValue<? extends Perfil> list,
						Perfil oldValue, Perfil newValue) {
						if(newValue!=null){
								imageView.setImage(newValue.getImagen());
						}
				}
	    });
		
		cargarPerfiles();
	}
	
	public void cargarPerfiles(){
		perfiles.clear();
		InputStream inputStream;
		try{
			Conexion conexion = new Conexion();
			conexion.establecerConexion();
			Connection connection = conexion.getConnection();
			Statement instruccionPerfiles = connection.createStatement();
			ResultSet resultado = instruccionPerfiles.executeQuery("SELECT CODIGO,NOMBRE,IMAGEN,FECHA_REGISTRO FROM tbl_perfiles");
			while(resultado.next()){
				inputStream = resultado.getBinaryStream("IMAGEN");
				Image imagen = null;
				if(inputStream!=null){
					BufferedImage bimage = ImageIO.read(inputStream);
			        WritableImage writableImage = new WritableImage(bimage.getWidth(), bimage.getHeight());
			        imagen = SwingFXUtils.toFXImage(bimage,writableImage);
		        }
				perfiles.add(new Perfil(resultado.getInt("CODIGO"),
							resultado.getString("NOMBRE"),
							imagen,
							resultado.getDate("FECHA_REGISTRO")));
			}
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public Main getMain() {
		return main;
	}

	public void setMain(Main main) {
		this.main = main;
	}
	@FXML
	public void abrirStageNuevoPerfil(){
		main.abrirStageNuevoPerfil();
	}
	
}
