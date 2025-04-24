import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClientA {
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("<<ClientA>>");
		
		MulticastSocket mcsa = null;
		try {
			mcsa = new MulticastSocket(10000);
		} catch(IOException e) {}
		System.out.println(mcsa.getLocalSocketAddress());
		System.out.println();
		
		try {
			mcsa.joinGroup(InetAddress.getByName("234.234.234.234"));
			
			while(true) {
				byte[] receivedData;
				DatagramPacket receivedPacket;
				
				receivedData = new byte[65508];
				receivedPacket = new DatagramPacket(receivedData, receivedData.length);
				
				mcsa.receive(receivedPacket);
				
				System.out.println("ClientA가 수신한 데이터: "+new String(receivedPacket.getData()).trim());
				System.out.println("송신지: "+receivedPacket.getSocketAddress());
				
				Thread.sleep(5000);
			}
			
			
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
