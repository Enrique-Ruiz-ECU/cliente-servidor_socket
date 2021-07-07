package servidor;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		
		ServidorSocket servidor = new ServidorSocket();
		servidor.connect();
	}

}
