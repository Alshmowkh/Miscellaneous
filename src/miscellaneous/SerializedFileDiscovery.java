/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * @author ALshmowkh
 */
public class SerializedFileDiscovery {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String serPath="F:\\Master\\Thesis\\Implementations\\serialization\\ser_preference.ser";
//        String serPath = "F:\\Master\\Thesis\\Tools\\Parsers\\stanford-arabic-parser\\arabicFactored.ser";
        System.out.println(System.nanoTime() / 1000000);
        FileInputStream fis = new FileInputStream(serPath);
        System.out.println(System.nanoTime() / 1000000);
        ObjectInputStream ois = new ObjectInputStream(fis);
        System.out.println(System.nanoTime() / 1000000);
        int count = 0;
        try {
            while (true) {
                count++;
                try {
                    Object obj = ois.readObject();
                    System.out.println("obj #" + count + " is a: " + obj.getClass());
                    System.out.println(obj + ".toString(): " + obj);
                    System.out.print("\t"+count );
                } catch (ClassNotFoundException e) {
                    System.out.println("can't read obj #" + count + ": " + e);
                }
            }
        } catch (EOFException e) {
            // unfortunately ObjectInputStream doesn't have a good way to detect the end of the stream
            // so just ignore this exception - it's expected when there are no more objects
        } finally {
            ois.close();
        }
        System.out.println("\n"+System.nanoTime()/1000000);
    }
}
