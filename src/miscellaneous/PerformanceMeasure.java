package miscellaneous;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import static miscellaneous.Misce.pl;

public class PerformanceMeasure {

    void read(String path) throws FileNotFoundException, IOException {
        File file = new File(path);
        StringBuilder sb = new StringBuilder();
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        int i = 0;
        while ((line = bfr.readLine()) != null) {
            WriteLine(line);
        }
//        System.out.println(sb.length());
    }

    void createFile() throws IOException {
        String path = "./Shom_lib/performance/createdFile04.txt";
        writer = new FileWriter(path);
//        BufferedWriter bw = new BufferedWriter(writer);
        writer.append("\n");
        writer.write("a\tq");
        writer.close();
    }

    void WriteLine(String line) throws IOException {
//        String path = "./Shom_lib/performance/createdFile03.txt";
//        FileWriter writer = new FileWriter(path);
        writer.write("\n");
        writer.write(line);

//        writer.close();
    }

    FileWriter writer;

    void ini() throws IOException {
        String path2 = "F:\\Master\\Thesis\\Implementations\\Miscellaneous\\Shom_lib\\performance\\testTimeSpeed.txt";
        String path = "./Shom_lib/performance/createdFile03.txt";
        writer = new FileWriter(path);
        read(path2);
        writer.close();
    }

    public static void main(String[] args) throws IOException {
        PerformanceMeasure cls = new PerformanceMeasure();
        String path2 = "F:\\Master\\Thesis\\Implementations\\Miscellaneous\\Shom_lib\\performance\\testTimeSpeed.txt";
        cls.read(path2);
        cls.createFile();
//        cls.ini();
    }
     void performance() {
        int tim = (LocalTime.now().getSecond() + LocalTime.now().getMinute() * 60);
       pl(tim);
    }
}
