package miscellaneous;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import javax.swing.JOptionPane;

public class EncodeConvert {

    public static void transform(File source, String srcEncoding, File target, String tgtEncoding) throws IOException {
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(source), Charset.forName(srcEncoding)));
            bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), tgtEncoding));
            char[] buffer = new char[16384];
            int read;
            while ((read = br.read(buffer)) != -1) {
                bw.write(buffer, 0, read);
            }
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } finally {
                if (bw != null) {
                    bw.close();
                }
            }
        }
    }

    public static void transform2(File source, String srcEncoding, File target, String tgtEncoding) throws IOException {

        FileInputStream fis = new FileInputStream(source);
        InputStreamReader isr = new InputStreamReader(fis);
        String currentCode = isr.getEncoding();
        System.out.println(currentCode);
        isr.close();
//        BufferedReader br = null;
//        BufferedWriter bw = null;
////        br = new BufferedReader(new InputStreamReader(fis, Charset.forName(srcEncoding)));
//        bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(target), tgtEncoding));
//        char[] buffer = new char[16384];
//        int read;
//        while ((read = br.read(buffer)) != -1) {
//            bw.write(buffer, 0, read);
//        }
//        br.close();
//        bw.close();
    }

    static void recursion(String input, String output) throws IOException {
        File[] files = new File(input).listFiles();
        for (File f : files) {

            if (f.isFile() && f.getPath().split("\\.")[1].equals("java")) {

                transform(f, "windows-1256", new File(output + "\\" + f.getName()), "UTF-8");
//                
            } else if (f.isDirectory()) {
                new File(output + "\\" + f.getName()).mkdir();
//                System.out.println(new File(output+"\\"+f.getName()).getPath());
                recursion(f.getPath(), new File(output + "\\" + f.getName()).getPath());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String corpusIn = "F:\\Master\\Thesis\\Tools\\Conjugation\\Sarf_Arabic_Morphology_System\\Alshmowkh_Reference\\src";
        String corpusOut = "F:\\Master\\Thesis\\Implementations\\SARF_3\\ALshmowkh\\srcUTF8";
        recursion(corpusIn, corpusOut);
//        File source=new File("Shom_lib\\Encoding\\ui\\ImperativeVerb2.java");
//       
//        File target=new File("Shom_lib\\Encoding\\UTF-8\\ImperativeVerb2.java");
//        String srccode="windows-1256";
//        String targcode="UTF-8";
//        transform(source,srccode,target,targcode);

    }
}
