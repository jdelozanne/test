package testServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	ServerSocket socket;
	Socket clientSocket;

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		try {
			socket = new ServerSocket(9000);
			System.out.println("waiting..");

			while (true) {
				HandleAClient c;
				clientSocket = socket.accept();
				// server.accept returns a client connection
				c = new HandleAClient(clientSocket);
				Thread t = new Thread(c);
				t.start();

			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public static void main(String[] args) {
		  new Server().run(); 
	  }
}
