import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientA {
    public static void main(String[] args) throws IOException {
        Socket socketA = new Socket("127.0.0.1", 10000);
        System.out.println("ClientA 연결됨");

        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socketA.getOutputStream()));
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socketA.getInputStream()));

        // 파일 경로를 "C:\sojin_java\Week08_MISSON02_2103296"로 설정하여 파일을 전송
        FileInputStream fis = new FileInputStream("C:\\sojin_java\\Week08_MISSON02_2103296\\Test.txt");
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = fis.read(buffer)) != -1) {
            dos.write(buffer, 0, bytesRead);
        }
        dos.flush();
        fis.close();
        System.out.println("파일 전송 완료");

        // 서버로부터 수신 완료 메시지 받기
        String response = dis.readUTF();
        System.out.println("서버 응답: " + response);

        socketA.close();
    }
}
