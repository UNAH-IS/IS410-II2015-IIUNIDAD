package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	//Controladores
	private VistaLoginController vistaLoginController;
	private VistaPrincipalController vistaPrincipalController;
	
	//Formularios
	private Stage formularioLogin;
	private Stage formularioPrincipal;
	
	@Override
	public void start(Stage primaryStage) {
		formularioLogin = primaryStage;
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("VistaLogin.fxml"));
			AnchorPane root = (AnchorPane)loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			
			vistaLoginController = loader.getController();
			vistaLoginController.setMain(this);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void abrirFormularioPrincipal(){
		if (formularioPrincipal == null){
			formularioPrincipal = new Stage();
			try {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(getClass().getResource("VistaPrincipal.fxml"));
				AnchorPane root = (AnchorPane)loader.load();
				Scene scene = new Scene(root);
				formularioPrincipal.setScene(scene);
				vistaPrincipalController = loader.getController();
				vistaPrincipalController.setMain(this);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		formularioLogin.hide();
		formularioPrincipal.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
