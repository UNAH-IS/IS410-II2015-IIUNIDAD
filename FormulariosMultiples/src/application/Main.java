package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class Main extends Application {
	//Controladores
	private PrincipalController principalController;
	private Formulario1Controller formulario1Controller;
	private Formulario2Controller formulario2Controller;
	private Formulario3Controller formulario3Controller;
	
	//Formularios
	private Stage formulario1;
	private Stage formulario2;
	private Stage formulario3;
	private Stage formularioPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		formularioPrincipal = primaryStage;
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
	
	public void abrirFormulario1(){
		if (formulario1 == null){
			try {
				formulario1 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Formulario1.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formulario1.setScene(scene);
				formulario1Controller = loader.getController();
				formulario1Controller.setMain(this);
				
				formulario1.initOwner(formularioPrincipal);
				formulario1.initModality(Modality.WINDOW_MODAL);

			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario1.show();
	}
	
	public void abrirFormulario2(){
		if (formulario2 == null){
			try {
				formulario2 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Formulario2.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formulario2.setScene(scene);
				formulario2Controller = loader.getController();
				formulario2Controller.setMain(this);
				
				formulario2.initOwner(formularioPrincipal);
				formulario2.initModality(Modality.WINDOW_MODAL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario2.show();
	}
	
	public void abrirFormulario3(){
		if (formulario3 == null){
			try {
				formulario3 = new Stage();
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("Formulario3.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formulario3.setScene(scene);
				formulario3Controller = loader.getController();
				formulario3Controller.setMain(this);
				
				formulario3.initOwner(formulario1);
				formulario3.initModality(Modality.WINDOW_MODAL);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formulario3.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
