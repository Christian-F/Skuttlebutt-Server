import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable{
	
	private Socket socket;
	
	public Client(Socket s){
		this.socket = s;
	}

	@Override
	public void run() {
		 try{
			 Scanner in = new Scanner(socket.getInputStream());
			 PrintWriter out = new PrintWriter(socket.getOutputStream());
			 
			 while(true){
				 	if (in.hasNext()){
				 		String input = in.nextLine();
				 		System.out.println("Client said: " + input);
				 		out.println("You said: " + input);
				 		out.flush();
				 	}
			 }
		 } catch(Exception e){
			 e.printStackTrace();;
		 }
		
	}
}	
