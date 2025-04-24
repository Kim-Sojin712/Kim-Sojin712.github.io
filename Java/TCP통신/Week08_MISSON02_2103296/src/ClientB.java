import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientB {
    public static void main(String[] args) throws IOException {
        Socket socketB = new Socket("127.0.0.1", 10000);
        System.out.println("ClientB 연결됨");

        DataInputStream dis = new DataInputStream(new BufferedInputStream(socketB.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketB.getOutputStream()));

        // 수신한 파일을 "C:\sojin_java\Week08_MISSON02_2103296" 경로에 저장
        FileOutputStream fos = new FileOutputStream("C:\\sojin_java\\Week08_MISSON02_2103296\\received_Test.txt");
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = dis.read(buffer)) != -1) {
            fos.write(buffer, 0, bytesRead);
        }

        fos.close();
        System.out.println("파일 수신 완료");

        // 서버에 "수신 완료" 메시지 전송
        dos.writeUTF("수신 완료");
        dos.flush();

        socketB.close();
    }
}
