package Serialization_package;

//import edu.stanford.nlp.parser.lexparser.BinaryRule;
//import edu.stanford.nlp.parser.lexparser.LexicalizedParser;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Iterator;
import java.util.List;

public class ser01 {

    static Object deserialization(String ser) throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream is = new FileInputStream(new File(ser));
        ObjectInputStream ois = new ObjectInputStream(is);
        Object o = ois.readObject();

        return o;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        String Model = "./Shom_lib/arabicFactored.ser";
//        String Model="englishPCFG.ser.gz";
//        String Model = "F:\\Master\\Thesis\\Implementations\\Miscellaneous\\Shom_lib\\a_class.ser";

        Object o = null;
//        o = deserialization(Model); 
//        System.out.println(o.getClass().getSimpleName());

        LexicalizedParser lp = LexicalizedParser.loadModel(Model);
        pl(lp);

                        
            
//        }

//        LexicalizedParser lp = LexicalizedParser.loadModel("arabicFactored.ser.gz");
//        lp = LexicalizedParser.loadModelFromZip(Model,"arabicFactored.ser");
    }

    static void pl(Object o) {
        System.out.println(o);
    }
}
