package ejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	private ServerSocket serverSocket;
	private Socket socketCliente;
	private DataInputStream dis;
	private DataOutputStream dos;
	public Servidor(){
		try {
			serverSocket = new ServerSocket(1234);
			//Escuchar peticiones
			System.out.println("Esperando conexion de cliente");
			socketCliente = serverSocket.accept();
			System.out.println("Se conecto un cliente");
			//Escribir al cliente
			dos = new DataOutputStream(socketCliente.getOutputStream());
			dos.writeUTF("Hola cliente, soy el servidor. Soy tu padre.");
			//Leer lo que envia el cliente
			dis = new DataInputStream(socketCliente.getInputStream());
			System.out.println("[CLIENTE]: "+dis.readUTF());
			
			dis.close();
			dos.close();
			serverSocket.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Servidor();
	}
}
