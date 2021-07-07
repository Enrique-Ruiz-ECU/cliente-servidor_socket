package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClienteSocket {

		private Socket socket;
		
		public ClienteSocket() throws IOException{
			socket = new Socket("localhost",4321);//connection to the server
			 
		}
	
		
		public void 	connect() throws IOException {
				//define the input and output to send and receive data
				DataInputStream entrada = new DataInputStream(socket.getInputStream());//collect the data
				DataOutputStream salida = new DataOutputStream(socket.getOutputStream());
				
				
				System.out.println(entrada.readUTF());//show in the screen the message sent by the server, 1 step
				//send a set of packets to the server
				for (int i = 0; i < 10; i++) {
					salida.writeUTF("Este es el mensaje nº "+(i+1));	//step 2
				}
				//we close the entrance, exit and we finish the socket
				salida.close();
				entrada.close();
				socket.close();
				
				//our client is already configured!!!
				
		}

}
