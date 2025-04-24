import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClientE {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("<<ClientE>>");
		
		MulticastSocket mcse = null;
		try {
			mcse = new MulticastSocket();
		} catch(IOException e) {}
		System.out.println(mcse.getLocalSocketAddress()); //[0:0:0:0:0:0:0:0]:58844
		System.out.println();
		
		try {
			mcse.joinGroup(InetAddress.getByName("234.234.234.234"));
			
			while(true) {
				byte[] sendData = "안녕하세요".getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("234.234.234.234"), 20000);
				
				mcse.send(sendPacket);
				
				byte[] receivedData;
				DatagramPacket receivedPacket;
				
				receivedData = new byte[65508];
				receivedPacket = new DatagramPacket(receivedData, receivedData.length);
				
				mcse.receive(receivedPacket);
				
				System.out.println("ClientE가 수신한 데이터: "+new String(receivedPacket.getData()).trim());
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
