package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;

public class SampleController implements Initializable{

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		Task<String> tarea = new Task<String>(){

			@Override
			protected String call() throws Exception {
				for (int i=0;i<100;i++){
					Thread.sleep(100);
					System.out.println(i);
				}
				return "Tarea finalizada";
			}
			
		};
		
		tarea.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
			
			@Override
			public void handle(WorkerStateEvent event) {
				System.out.println(tarea.getValue());				
			}
		});
		
		Thread hilo = new Thread(tarea);
		hilo.start();
		
	}
	
}
