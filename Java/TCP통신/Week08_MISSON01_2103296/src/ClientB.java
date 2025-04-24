import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientB {
    public static void main(String[] args) throws IOException {
        Socket socketB = new Socket("127.0.0.1", 10000);
        System.out.println("ClientB 연결됨");

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socketB.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketB.getOutputStream()));

        String message = dis.readUTF();
        System.out.println(message);

        dos.writeUTF("방가");
        dos.flush();

        socketB.close();
    }
}
