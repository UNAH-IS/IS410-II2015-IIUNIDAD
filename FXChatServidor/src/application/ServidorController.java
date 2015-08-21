package application;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;


public class ServidorController implements Initializable{
	private boolean finalizo = false;
	private ServerSocket servidor;
	private Socket cliente;
	
	private DataOutputStream salida;
	private DataInputStream entrada;
	
	@FXML private TextArea txtMensaje;
	@FXML private TextArea txtResultado;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Task<String> tarea = new Task<String>(){

			@Override
			protected String call() throws Exception {
				servidor = new ServerSocket(6066);//0-65000
				System.out.println("Esperando conexiones");
				cliente = servidor.accept();
				System.out.println("Se conecto un cliente");
				salida = new DataOutputStream(cliente.getOutputStream());
				entrada = new DataInputStream(cliente.getInputStream());
				while(!finalizo){
					String mensaje = entrada.readUTF();
					Platform.runLater(new Runnable(){
						@Override
						public void run() {
								txtResultado.appendText(mensaje+"\n");
						}
					});
				}
				servidor.close();
				cliente.close();
				return "Finalizo la tarea";
			}
			
		};
		Thread hilo = new Thread(tarea);
		hilo.setDaemon(true); //Para que el hilo de la aplicacion
		//finalicen cuando se cierra la aplicacion
		hilo.start();//Inicia el hilo, es decir llama al metodo call()
	}
	
	@FXML
	public void enviarMensaje(){
		 try {
			salida.writeUTF("[SERVIDOR]: " + txtMensaje.getText());
			txtResultado.appendText("[SERVIDOR]: " + txtMensaje.getText()+"\n");
			txtMensaje.setText(null);
		} catch (IOException e) {
			e.printStackTrace();
		}		 
	}
	
}
