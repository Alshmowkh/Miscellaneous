package OISReading;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.util.zip.GZIPInputStream;

public class SerZipFileReading {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String path = "./Shom_lib/arabicFactored.ser";
//        File file=new File(path);
        InputStream is = new FileInputStream(path);
//        is = new GZIPInputStream(is);
        is = new BufferedInputStream(is);
        ObjectInputStream ois = new ObjectInputStream(is);
         Object o = ois.readObject();
//     for((char)is.read()int i=0;i<10000;i++)   
//        p((char)is.read());
         p(o);
        
    }

    static void p(Object x) {
        System.out.print(x);
    }
}
