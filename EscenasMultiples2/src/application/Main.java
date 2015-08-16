package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	private Scene scene1;
	private Scene scene2;
	
	private PrincipalController principalController;
	private Escena2Controller escena2Controller; 
	
	private Stage formularioPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		formularioPrincipal = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Principal.fxml"));
			BorderPane root = (BorderPane)loader.load();
			scene1 = new Scene(root);
			scene1.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene1);
			principalController = loader.getController();
			principalController.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarEscena2(){
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("Escena2.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			scene2 = new Scene(root);
			formularioPrincipal.setScene(scene2);
			escena2Controller = loader.getController();
			escena2Controller.setMain(this);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void cambiarEscena1(){
		formularioPrincipal.setScene(scene1);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
