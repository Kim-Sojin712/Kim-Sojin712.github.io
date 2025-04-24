package week07.mission02;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;

public class Test2 {
	public static void main(String[] args) throws IOException {
		InetAddress ia = InetAddress.getByAddress(new byte[] {(byte)192,(byte)168,0,10});
		
		InetSocketAddress isa1 = new InetSocketAddress(20000);
		InetSocketAddress isa2 = new InetSocketAddress(ia,10000);
		
		System.out.println(isa1.getHostName()+"/IP:"+isa1.getPort());
		System.out.println(isa2.getHostName()+"/IP:"+isa2.getPort());
		
	}
}
