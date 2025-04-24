package week07.mission03;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(10000);
		Socket socket = serverSocket.accept();
//		System.out.println(socket.getInetAddress()+", "+socket.getPort()+"에서 연결요청이 있었습니다.");
		OutputStream os = socket.getOutputStream();
		String send = "환영합니다.";
		os.write(send.getBytes());
		os.flush();
		
	}
}
