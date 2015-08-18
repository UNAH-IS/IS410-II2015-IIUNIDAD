package ejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//127.0.0.1, localhost, 169.254.72.191
public class Cliente {
	private Socket socketCliente;
	private DataInputStream dis;
	private DataOutputStream dos;
	public Cliente(){
		try {
			System.out.println("Intentar conectar a servidor");
			socketCliente = new Socket("169.254.72.191", 1234);
			System.out.println("Se conecto al servidor");
			//Escribir al servidor
			dos = new DataOutputStream(socketCliente.getOutputStream());
			dos.writeUTF("Hola servidor, soy cliente. Tu hijo.");
			//Leer lo que envia el servidor
			dis = new DataInputStream(socketCliente.getInputStream());
			System.out.println("[SERVIDOR]: "+dis.readUTF());
			
			dis.close();
			dos.close();
			socketCliente.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]){
		new Cliente();
	}
}
