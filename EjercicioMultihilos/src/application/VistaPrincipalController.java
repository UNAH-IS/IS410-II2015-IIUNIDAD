package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;

public class VistaPrincipalController implements Initializable{
	@FXML TextField txtMensaje;
	@FXML ProgressBar progressBar;
	@FXML ProgressIndicator progressIndicator; 
	
	@FXML ProgressBar progressBar2;
	@FXML ProgressIndicator progressIndicator2; 
	
	int i;
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Task<String> tarea = new Task<String>(){

			@Override
			protected String call() throws Exception {
				for (i = 0; i<100;i++){
					try{ Thread.sleep(100); } catch(Exception e){}
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							txtMensaje.setText("Porcentaje: " + i + "%");
							progressBar.setProgress(Double.valueOf(i)/100);
						}
						
					});
				}
				
				
				/*Platform.runLater(new Runnable(){
					@Override
					public void run() {
						txtMensaje.setText("La tarea finalizo");	
					}
					
				});*/
				return "La tarea ha sido finalizada";
			}		
		};
		
		
		Task<String> tarea2 = new Task<String>(){

			@Override
			protected String call() throws Exception {
				for (i = 0; i<1000;i++){
					try{ Thread.sleep(100); } catch(Exception e){}
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
							progressIndicator.setProgress(Double.valueOf(i)/1000);
						}
						
					});
				}
				
				return "La tarea ha sido finalizada";
			}		
		};
		
		tarea.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent arg0) {
				txtMensaje.setText("La tarea finalizo");
				progressBar2.setVisible(false);
				progressIndicator2.setVisible(false);
			}
		});
		
		Thread hilo = new Thread(tarea);
		Thread hilo2 = new Thread(tarea2);
		hilo.setDaemon(true);
		hilo2.setDaemon(true);
		progressBar2.setVisible(true);
		progressIndicator2.setVisible(true);
		hilo.start();
		hilo2.start();
	}
	
}
