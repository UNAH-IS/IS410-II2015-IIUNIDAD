package ejercicio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
	private Socket socketCliente;
	private DataOutputStream dos;
	private DataInputStream dis;
	public Cliente(){
		try {
			System.out.println("Intentando conectar a servidor");
			socketCliente = new Socket("169.254.72.191", 1234);
			dos = new DataOutputStream(socketCliente.getOutputStream());
			dos.writeUTF("Hola servidor, soy cliente... tu hijo");
			dis = new DataInputStream(socketCliente.getInputStream());
			System.out.println("[SERVIDOR]: " + dis.readUTF());
			
			dos.close();
			dis.close();
			socketCliente.close();			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new Cliente();
	}

}
