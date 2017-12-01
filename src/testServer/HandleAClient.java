package testServer;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class HandleAClient implements Runnable {
	private Socket socket;

	public HandleAClient(Socket clientSocket) {
		this.socket = clientSocket;
	}

	@Override
	public void run() {
		// create data input and output streams
		try {
			DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
			DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

			// continuously serve the client
			while (true) {
				// receive data from client
				double radius = inputFromClient.readDouble();
				// do some math
				double area = radius * radius * Math.PI;
				// give it to client
				outputToClient.writeDouble(area);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
	   
	  }

}
