package server;
import java.io.*;
import java.sql.*;
import java.net.*;
import tcp.TCP_Socket;

//import static java.lang.System.out;
//import server.GetOpt;
public class DB_Server{
	public String DB_path= null;
	//private int port;
	
	
	public static void main(String args[]) {
		/*try{
		System.out.println(args[0]);
		System.out.println(args[1]);
		System.out.println(args[2]);
		System.out.println(args[3]);
		System.out.println(args[4]);
		}catch(Exception e){System.out.println("Error");  }*/
		String DB_path=args[2];
		int port=Integer.parseInt(args[4]);
		
		//char port = new GetOpt().getopt(args, "fc:d");

		System.out.println(port);
		Socket sock;  
		try{
			ServerSocket server_sock=new ServerSocket(port, 5);
			for(;;){
				sock=server_sock.accept();
				new TCP_Socket(sock).start();
			}
		}catch(IOException e){  }
	}
}