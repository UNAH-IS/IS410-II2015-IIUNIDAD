package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class VistaPrincipalController implements Initializable {
	@FXML private TextField txtMensaje;
	@FXML private ProgressBar progressBar;
	@FXML private ProgressIndicator progressIndicator;
	
	
	private int i;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Task<String> tarea = new Task<String>(){
			@Override
			protected String call() throws Exception {
				
				for (i = 0; i<100; i++){
					try { Thread.sleep(100); } catch(Exception e){}
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							txtMensaje.setText("Porcentaje: "+i+"%");
							progressBar.setProgress(Double.valueOf(i)/100);							
						}
					});				
				}			
				System.out.println("Tarea terminada");
				return "Tarea terminada";
			}
			
		};
		
		Task<String> tarea2 = new Task<String>(){
			@Override
			protected String call() throws Exception {
				
				for (i = 0; i<1000; i++){
					try { Thread.sleep(200); } catch(Exception e){}
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							progressIndicator.setProgress(Double.valueOf(i)/1000);							
						}
					});				
				}				
				System.out.println("Tarea 2 terminada");
				return "Tarea 2 terminada";
			}
			
		};
		
		Thread hilo = new Thread(tarea);
		Thread hilo2 = new Thread(tarea2);
		hilo.setDaemon(true);
		hilo2.setDaemon(true);
		hilo.start();
		hilo2.start();
	}
	
}
