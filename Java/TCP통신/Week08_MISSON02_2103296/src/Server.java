import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("서버가 시작되었습니다.");

        Socket clientASocket = serverSocket.accept();
        System.out.println("ClientA 연결됨.");
        Socket clientBSocket = serverSocket.accept();
        System.out.println("ClientB 연결됨.");

        DataInputStream disA = new DataInputStream(new BufferedInputStream(clientASocket.getInputStream()));
        DataOutputStream dosA = new DataOutputStream(new BufferedOutputStream(clientASocket.getOutputStream()));

        DataInputStream disB = new DataInputStream(new BufferedInputStream(clientBSocket.getInputStream()));
        DataOutputStream dosB = new DataOutputStream(new BufferedOutputStream(clientBSocket.getOutputStream()));

        // ClientA로부터 파일 데이터를 수신하고 ClientB로 전송
        FileOutputStream fos = new FileOutputStream("received_Test.txt");
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = disA.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);  // 서버에서 파일 저장 (optional)
            dosB.write(buffer, 0, bytesRead); // ClientB로 파일 전송
            dosB.flush();
        }

        fos.close();
        System.out.println("파일 전송 완료");

        // ClientB로부터 "수신 완료" 메시지 수신 후 ClientA로 전달
        String messageFromB = disB.readUTF();
        System.out.println("ClientB로부터 수신: " + messageFromB);
        dosA.writeUTF(messageFromB);
        dosA.flush();

        clientASocket.close();
        clientBSocket.close();
        serverSocket.close();
    }
}
