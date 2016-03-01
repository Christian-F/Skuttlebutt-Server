import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
	
	public static void main(String[] args) throws IOException{
		try {
			final int PORT = 6677;
			ServerSocket server = new ServerSocket(PORT);
			
			while(true){
				System.out.println("Waiting for pirates...");
				Socket s = server.accept();
				
				System.out.println("Pirate connected from " +s.getLocalAddress().getHostName());
				
				Client chat = new Client(s);
				
				//start another thread to handle the connection
				Thread t = new Thread(chat);
				t.start();
			}
			
			
		}catch(Exception e){
			System.out.println("An error occured, handle lazy.");
			e.printStackTrace();
		}
	}
}
