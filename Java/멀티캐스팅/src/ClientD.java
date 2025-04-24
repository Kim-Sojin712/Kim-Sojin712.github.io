import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClientD {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("<<ClientD>>");
		
		MulticastSocket mcsd = null;
		try {
			mcsd = new MulticastSocket(20000);
		} catch(IOException e) {}
		System.out.println(mcsd.getLocalSocketAddress());
		System.out.println();
		
		try {
			mcsd.joinGroup(InetAddress.getByName("234.234.234.234"));
			
			while(true) {
				byte[] receivedData;
				DatagramPacket receivedPacket;
				
				receivedData = new byte[65508];
				receivedPacket = new DatagramPacket(receivedData, receivedData.length);
				
				mcsd.receive(receivedPacket);
				
				System.out.println("ClientD가 수신한 데이터: "+new String(receivedPacket.getData()).trim());
				System.out.println("송신지: "+receivedPacket.getSocketAddress());
				
				byte[] sendData = "어서와".getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("234.234.234.234"), receivedPacket.getPort());
				
				mcsd.send(sendPacket);
				
				Thread.sleep(5000);
			}
			
		} catch(UnknownHostException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
