import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10000);
        System.out.println("서버가 시작되었습니다.");

        // ClientA와 ClientB 연결 대기
        Socket clientASocket = serverSocket.accept();
        System.out.println("ClientA 연결됨.");
        Socket clientBSocket = serverSocket.accept();
        System.out.println("ClientB 연결됨.");

        DataInputStream disA = new DataInputStream(new BufferedInputStream(clientASocket.getInputStream()));
        DataOutputStream dosA = new DataOutputStream(new BufferedOutputStream(clientASocket.getOutputStream()));

        DataInputStream disB = new DataInputStream(new BufferedInputStream(clientBSocket.getInputStream()));
        DataOutputStream dosB = new DataOutputStream(new BufferedOutputStream(clientBSocket.getOutputStream()));

        String messageFromA = disA.readUTF();
        System.out.println(messageFromA);
        dosB.writeUTF(messageFromA);
        dosB.flush();

        String messageFromB = disB.readUTF();
        System.out.println(messageFromB);
        dosA.writeUTF(messageFromB);
        dosA.flush();

        clientASocket.close();
        clientBSocket.close();
        serverSocket.close();
    }
}
