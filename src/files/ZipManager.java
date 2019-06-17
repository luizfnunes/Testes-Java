package files;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class ZipManager {
    public static void main(String[] args) {
        Path dirZip = Paths.get("pasta/subpasta/sub");
        Path zipFile = dirZip.resolve("arquivo.zip");
        Path dirFiles = Paths.get("pasta/");
        //zipandoNormal(dirZip,dirFiles,zipFile);
        zipandoBuffer(dirZip,dirFiles,zipFile);
        //readZip(zipFile);
    }
    private static void zipandoNormal(Path dirZip, Path dirFiles, Path zipFile){
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
            DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)){
            for(Path path: stream){
                if (!Files.isDirectory(path)) {
                    ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                    zip.putNextEntry(zipEntry);
                    FileInputStream fileInputStream = new FileInputStream(path.toFile());
                    byte[] buff = new byte[2048];
                    int byteRead;
                    while ((byteRead = fileInputStream.read(buff)) > 0) {
                        zip.write(buff, 0, byteRead);
                    }
                    zip.closeEntry();
                    fileInputStream.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void zipandoBuffer(Path dirZip, Path dirFiles, Path zipFile){
        try(ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(zipFile.toFile()));
            DirectoryStream<Path> stream = Files.newDirectoryStream(dirFiles)){
            for(Path path: stream){
                if (!Files.isDirectory(path)) {
                    ZipEntry zipEntry = new ZipEntry(path.getFileName().toString());
                    zip.putNextEntry(zipEntry);
                    FileInputStream fileInputStream = new FileInputStream(path.toFile());
                    BufferedInputStream buffer = new BufferedInputStream(fileInputStream);

                    byte[] buff = new byte[2048];
                    int byteRead;
                    while ((byteRead = buffer.read(buff)) > 0) {
                        zip.write(buff, 0, byteRead);
                    }
                    zip.flush();
                    zip.closeEntry();
                    fileInputStream.close();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readZip(Path zipFile){
        try(ZipInputStream zip = new ZipInputStream(new FileInputStream(zipFile.toString()))){
            ZipEntry zipEntry;
            while((zipEntry = zip.getNextEntry()) != null){
                System.out.println(zipEntry.getName()+":"+zipEntry.getCompressedSize());
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
}
