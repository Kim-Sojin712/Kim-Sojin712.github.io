import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        File originDir = new File("Working\\origin_folder");
        File backupDir = new File("Working\\backup_folder");

        while (true) {
            syncFolders(originDir, backupDir);
            System.out.println("동기화 완료");
            Thread.sleep(2000);
        }
    }

    public static void syncFolders(File originDir, File backupDir) throws IOException {
        if (!backupDir.exists()) {
            backupDir.mkdirs();
        }

        // 복사
        for (File file : originDir.listFiles()) {
            File targetFile = new File(backupDir, file.getName());
            if (file.isDirectory()) {
                syncFolders(file, targetFile);
            } else {
                copyFile(file, targetFile);
            }
        }

        // 백업 폴더에 있는 원본에 없는 파일 삭제
        for (File file : backupDir.listFiles()) {
            if (!new File(originDir, file.getName()).exists()) {
                deleteFileOrFolder(file);
            }
        }
    }

    // 복사
    public static void copyFile(File source, File destination) throws IOException {
        try (FileInputStream in = new FileInputStream(source);
             FileOutputStream out = new FileOutputStream(destination)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        }
    }

    // 삭제
    public static void deleteFileOrFolder(File file) {
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                deleteFileOrFolder(subFile);
            }
        }
        file.delete();
    }
}
