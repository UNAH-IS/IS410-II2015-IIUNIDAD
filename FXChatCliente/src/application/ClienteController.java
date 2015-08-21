package application;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class ClienteController implements Initializable{
	private boolean finalizo = false;
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
				try{
					System.out.println("Intentando conectar");
					cliente = new Socket("localhost",6066);
					System.out.println("Se conecto satisfactoriamente");
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
					//cliente.close();
				} catch (UnknownHostException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}		
				return "Finalizo el hilo";
			}
			
		};
		Thread hilo = new Thread(tarea);
		hilo.setDaemon(true);
		hilo.start();
	}
	
	public void enviarMensaje(){
		try {
			salida.writeUTF("[CLIENTE]: " + txtMensaje.getText());
			txtResultado.appendText("[CLIENTE]: " + txtMensaje.getText()+"\n");
			txtMensaje.setText(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
