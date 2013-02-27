package tcp;
import java.io.*;
import java.net.*;

public class TCP_Socket extends Thread{

	Socket sock;
	BufferedReader reader;
	BufferedWriter out;
	String input;
	public TCP_Socket(Socket _sock){sock=_sock;}
	public void run(){
		try{
			reader =  new BufferedReader(new InputStreamReader(sock.getInputStream(), "latin1"));
			out=new BufferedWriter(new OutputStreamWriter(sock.getOutputStream(), "latin1"));
			out.write("Hello Concurrent!\n");out.flush();
			for(int k=0;k<7;k++){
				//System.out.println(reader.readLine());
				if((input=reader.readLine())==null) break;
				//if((input=reader.readLine())=="quit\n") sock.close();
				out.write(input+"\n");
				out.flush();
			}
			sock.close();  // MUST close before termination
		}catch(IOException e){	}    
	}

}
