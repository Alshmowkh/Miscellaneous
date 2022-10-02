package miscellaneous;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import static miscellaneous.Misce.pl;

public class Zip {

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.unZip();
    }

    private void unZip() throws IOException {
        String path = "E:\\bakeel\\OneDriveSync\\OneDrive\\سطح المكتب\\UCanAccess-3.0.1-bin.zip";
        File file = new File(path);
//        String desDir = path.substring(0, path.length() - 4);
        String desDir = file.getParentFile().getPath();

        ZipInputStream zip = new ZipInputStream(new FileInputStream(path));
        ZipEntry entry = zip.getNextEntry();
        while (entry != null) {
            String newpath = desDir + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zip, newpath);
            } else {
                new File(newpath).mkdir();
            }
            zip.closeEntry();
            entry = zip.getNextEntry();
        }
        zip.close();
    }

    private void extractFile(ZipInputStream zip, String newpath) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(newpath));
            byte[] byteIn = new byte[4096];
            int packet = 0;
            while ((packet = zip.read(byteIn)) != -1) {
                bos.write(byteIn, 0, packet);
            }
            bos.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }
}
