package ejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket serverSocket;
	private Socket socketCliente;
	private DataOutputStream dos; //Enviar informacion
	private DataInputStream dis; //Recibir informacion
	public Servidor(){
		try {
			serverSocket =new ServerSocket(1234);
			System.out.println("Esperando conexion de cliente...");
			socketCliente = serverSocket.accept();
			dos = new DataOutputStream(socketCliente.getOutputStream());
			dos.writeUTF("Hola cliente, soy el servidor... soy tu padre");
			dis = new DataInputStream(socketCliente.getInputStream());
			System.out.println("[CLIENTE]: " + dis.readUTF());
			
			dos.close();
			dis.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new Servidor();
	}
}
