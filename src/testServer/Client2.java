package testServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class Client2 extends Thread { 
	      Socket myClientSocket;
	      boolean m_bRunThread = true; 
	      boolean serverOn = true;
	      public Client2() { 
	         super(); 
	      } 
			
	      Client2(Socket s) { 
	         myClientSocket = s; 
	      } 
			
	      /* (non-Javadoc)
	     * @see java.lang.Thread#run()
	     */
	    public void run() { 
	         BufferedReader in = null; 
	         PrintWriter out = null; 
	         System.out.println(
	            "Accepted Client Address - " + myClientSocket.getInetAddress().getHostName());
	         try { 
	            in = new BufferedReader(
	               new InputStreamReader(myClientSocket.getInputStream()));
	            out = new PrintWriter(
	               new OutputStreamWriter(myClientSocket.getOutputStream()));
	            
	            while(m_bRunThread) { 
	               String clientCommand = in.readLine(); 
	               System.out.println("Client Says :" + clientCommand);
	               
	               if(!serverOn) { 
	                  System.out.print("Server has already stopped"); 
	                  out.println("Server has already stopped"); 
	                  out.flush(); 
	                  m_bRunThread = false;
	               } 
	               if(clientCommand.equalsIgnoreCase("quit")) {
	                  m_bRunThread = false;
	                  System.out.print("Stopping client thread for client : ");
	               } else if(clientCommand.equalsIgnoreCase("end")) {
	                  m_bRunThread = false;
	                  System.out.print("Stopping client thread for client : ");
	                  serverOn = false;
	               } else {
	                  out.println("Server Says : " + clientCommand);
	                  out.flush(); 
	               } 
	            } 
	         } catch(Exception e) { 
	            e.printStackTrace(); 
	         } 
	         finally { 
	            try { 
	               in.close(); 
	               out.close(); 
	               myClientSocket.close(); 
	               System.out.println("...Stopped"); 
	            } catch(IOException ioe) { 
	               ioe.printStackTrace(); 
	            } 
	         } 
	      } 
}
