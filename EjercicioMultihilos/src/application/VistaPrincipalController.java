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

public class VistaPrincipalController implements Initializable{

	@FXML TextField txtMensaje;
	@FXML ProgressBar progresbar;
	@FXML ProgressIndicator progressIndicator;
	private int i;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Task<String> tareaTask=new Task<String>() {
			@Override
			protected String call() throws Exception {
				for (i = 0; i < 100; i++) {
					try{
						Thread.sleep(100);
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								txtMensaje.setText("Porsentaje: "+i+"%");
							progresbar.setProgress(Double.valueOf(i)/100);
							//progressIndicator.setProgress(Double.valueOf(i)/100);
							}
						});
						
						System.out.println(i);
					}catch(Exception e){
						e.printStackTrace();
					}
				
				}
				//System.out.println("Tarea Terminada");
				return "Tarea Terminada";
			}
		};
		
		//tarea 2
		Task<String> tareaTask2=new Task<String>() {
			@Override
			protected String call() throws Exception {
				for (i = 0; i < 1000; i++) {
					try{
						Thread.sleep(900);
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								//txtMensaje.setText("Porsentaje: "+i+"%");
							//progresbar.setProgress(Double.valueOf(i)/100);
							progressIndicator.setProgress(Double.valueOf(i)/1000);
							}
						});
						
						System.out.println(i);
					}catch(Exception e){
						e.printStackTrace();
					}
				
				}
				//System.out.println("Tarea Terminada");
				return "Tarea 2 Terminada";
			}
		};
		
		Thread hilo=new Thread(tareaTask);
		Thread hilo2=new Thread(tareaTask2);
		
		hilo.setDaemon(true);
		hilo2.setDaemon(true);
		
		hilo.start();
		hilo2.start();
		
	}
	
}
