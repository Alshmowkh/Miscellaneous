package miscellaneous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TextFileReader {

    void read(String path) {
        File file = new File(path);
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bfr = new BufferedReader(fr);
            System.out.println(bfr.readLine());
            System.out.println(bfr.readLine());

        } catch (Exception e) {
        }

    }

    public static void main(String[] args) {
        TextFileReader cls = new TextFileReader();
        String path = "./Shom_lib/TextFile.txt";
        cls.read(path);
    }
}
