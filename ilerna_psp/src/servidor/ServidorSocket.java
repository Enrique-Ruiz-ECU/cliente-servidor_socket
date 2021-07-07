package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorSocket {
	private final int PUERTO=4321; 
	private ServerSocket servidor;//socket correspondent to the server 
	private Socket cliente;//Socket correspondent to the client
	
	public ServidorSocket() throws IOException {
		servidor = new ServerSocket(PUERTO);
		cliente = new Socket();
	}
	
	public void connect() throws IOException {
		System.out.println("Iniciando servidor");
		System.out.println("Esperando 1r cliente");
		//the loop WHILE accept requests continuously
		while(true) {
			cliente =	servidor.accept();//socket is equal to the request that arrive to the server, (accept) The method blocks until a connection is made.
			//send and receive data of client
			DataInputStream entrada = new DataInputStream(cliente.getInputStream());
			DataOutputStream salida = new DataOutputStream(cliente.getOutputStream());
			salida.writeUTF("Bienvenido cliente");//send a message to the client
			
			String mensajeDeCliente;
			try {
					//we receive all the data	
				while(!(mensajeDeCliente=entrada.readUTF()).isEmpty())
					System.out.println(mensajeDeCliente);
			} catch (EOFException e) {
				System.out.println("El cliente ha finalizado la comunicación");
			}
			System.out.println("Esperando un nuevo cliente");
		}
	}


}
