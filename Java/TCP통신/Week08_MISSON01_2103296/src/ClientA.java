import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientA {
    public static void main(String[] args) throws IOException {
        Socket socketA = new Socket("127.0.0.1", 10000);
        System.out.println("ClientA 연결됨");

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketA.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socketA.getInputStream()));

        dos.writeUTF("안녕");
        dos.flush();

        String response = dis.readUTF();
        System.out.println(response);

        socketA.close();
    }
}
