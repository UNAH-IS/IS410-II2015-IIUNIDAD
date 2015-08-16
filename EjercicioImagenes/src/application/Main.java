package application;
	
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	private PrincipalController principalController;
	private NuevoPerfilController nuevoPerfilController;
	private Stage stgNuevoPerfil;

	private Stage stgPrimaryStage;
	@Override
	public void start(Stage primaryStage) {
		this.stgPrimaryStage = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Principal.fxml"));
			BorderPane root = (BorderPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			principalController = loader.getController();
			principalController.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void abrirStageNuevoPerfil(){
		if(stgNuevoPerfil == null) //En caso de no estar cargado el formulario lo carga por primera vez
			cargarStageNuevoPerfil();
		stgNuevoPerfil.showAndWait();
	}
	
	public void cargarStageNuevoPerfil(){
		try{
			stgNuevoPerfil = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("NuevoPerfil.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			nuevoPerfilController = loader.getController();
			nuevoPerfilController.setMain(this);
			stgNuevoPerfil.setScene(scene);
			stgNuevoPerfil.initOwner(stgPrimaryStage);
			stgNuevoPerfil.initModality(Modality.WINDOW_MODAL);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public Stage getStgNuevoPerfil() {
		return stgNuevoPerfil;
	}

	public Stage getStgPrimaryStage() {
		return stgPrimaryStage;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
