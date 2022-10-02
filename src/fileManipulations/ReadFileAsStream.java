package fileManipulations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ReadFileAsStream {

    void ini() throws FileNotFoundException, UnsupportedEncodingException, IOException {
        String filePath = "F:\\Master\\Thesis\\Implementations\\AraMorph_2\\dictStems";
//        filePath="E:\\bakeel\\OneDriveSync\\OneDrive\\سطح المكتب\\My note.lnk";
        String[] encoding = {"ISO8859_1", "UTF-8", "windows-1256", "ANSI"};
        InputStream is = new FileInputStream(filePath);

        LineNumberReader IN = new LineNumberReader(new InputStreamReader(is, encoding[0]));
        String line;
        int i = 0;
        while ((line = IN.readLine()) != null || i < 10) {
            if (!line.startsWith(";")) {
                lineProcess(line);
                i++;
            }
        }
    }
    List tags = new ArrayList();

    void lineProcess(String line) {
        String str;
        str = "none";
//        List tags = new ArrayList();
        if (line.contains("pos")) {
            str = line.split("/", -1)[1];

        } else {
            str = line.split("\t")[2];

        }
        if (!tags.contains(str.trim())) {
            tags.add(str);
            pl(str);
        }
    }

    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        new ReadFileAsStream().ini();
    }

    void pl(Object o) {
        System.out.println(o);
    }
}
