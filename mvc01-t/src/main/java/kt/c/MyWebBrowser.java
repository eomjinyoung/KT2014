package kt.c;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class MyWebBrowser {

	public static void main(String[] args) throws Exception {
			Socket socket = new Socket("localhost", 9999);
			PrintWriter out = new PrintWriter(socket.getOutputStream());
			BufferedReader in = new BufferedReader(
					new InputStreamReader(socket.getInputStream()));
			
			out.println("POST /mvc01-t/auth/login HTTP/1.1");
			out.println("Host: localhost");
			out.println("Content-Length: 24");
			out.println("Content-Type: application/x-www-form-urlencoded");
			out.println();
			out.println("id=admin&password=admin2");
			out.flush();
			
			String line = null;
			while(true) {
				line = in.readLine();
				System.out.println(line);
				
				if (line.length() == 0) {
					break;
				}
			}
			
			int ch;
			while((ch = in.read()) != -1) {
				System.out.print((char)ch);
			}
			
			out.close();
			in.close();
			socket.close();
	}

}











