import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.UnknownHostException;

public class ClientB {
	public static void main(String[] args) throws InterruptedException {

		System.out.println("<<ClientB>>");
		
		MulticastSocket mcsb = null;
		try {
			mcsb = new MulticastSocket(10000);
		} catch(IOException e) {}
		System.out.println(mcsb.getLocalSocketAddress());
		System.out.println();
		
		
		try {
			mcsb.joinGroup(InetAddress.getByName("234.234.234.234"));
			
			
			while(true) {
				byte[] sendData = "반갑습니다".getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, InetAddress.getByName("234.234.234.234"), 10000);
				
				mcsb.send(sendPacket);
				
				byte[] receivedData;
				DatagramPacket receivedPacket;
				
				receivedData = new byte[65508];
				receivedPacket = new DatagramPacket(receivedData, receivedData.length);
				
				mcsb.receive(receivedPacket);
				
				System.out.println("ClientB가 수신한 데이터: "+new String(receivedPacket.getData()).trim());
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
