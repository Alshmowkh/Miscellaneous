package Serialization_package;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serialization {

    void serialize(A_class obj, String filename) {
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(obj);
            oos.close();
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    Object deserialize(String filename) {
        Object savedObj = null;

        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
//            BufferedInputStream bi=new BufferedInputStream(ois);
//            System.out.println(ois.read());
            savedObj = ois.readObject();
            ois.close();
        } catch (IOException ex) {
            System.err.println(ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Serialization.class.getName()).log(Level.SEVERE, null, ex);
        }

        return savedObj;
    }

    public static void main(String[] args) {
        Serialization cls = new Serialization();
        String[] exps = {"a_class","ser_preference","arabicFactored","englishPCFG"};
        String objectPath = "./Shom_lib/" + exps[1] + ".ser";
//-------------------------------------------------------        
//        String username = "codejava";
//        String email = "info@codejava.net";
//        String password = "secret";
//        Date birthDay = new Date();
//        int age = 20;

//        A_class obj = new A_class(username, email, password, birthDay, age);
//        cls.serialize(obj);
//--------------------------------------------------------
        Object savedObject = cls.deserialize(objectPath);
//
        if (savedObject != null) {
            System.out.println(savedObject.getClass().getSimpleName());
        }
    }
}
