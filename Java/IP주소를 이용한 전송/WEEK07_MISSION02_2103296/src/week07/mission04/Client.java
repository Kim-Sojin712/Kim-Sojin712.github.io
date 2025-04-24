package week07.mission04;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getByName("172.18.94.15"), 10000, InetAddress.getLocalHost(), 20000);
		InputStream is = socket.getInputStream();
		byte[] array = new byte[50];
		int txt = is.read(array);
		String receive = new String(array);
		System.out.println(receive);
		
		
	}
}
