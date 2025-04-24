package week07.mission01;

import java.io.IOException;
import java.net.InetAddress;

public class Test1 {
	public static void main(String[] args) throws IOException {
		InetAddress ia1 = InetAddress.getByAddress(new byte[] {(byte)192, (byte)158, 0, 10});
		InetAddress ia2 = InetAddress.getByName("www.hywoman.ac.kr");
		
		System.out.println(ia1.getHostName()+"/"+ia1.getHostAddress());
		System.out.println(ia2);
	}
}
