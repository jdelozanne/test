package testServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client1 extends Thread {
	DataInputStream inputFromServer;
	DataOutputStream outputToServer;
	
	

	public Client1() {
		try {
			Socket socket = new Socket("localhost", 9000);
			while(inputFromServer)
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new Client1();
		
	}

}
