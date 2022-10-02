/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
public class ExtensionChange {

    String source_files = "F:\\Master\\Thesis\\Tools\\Dataset\\Corpora\\Watan\\All text files";

    void file(String path, String type) throws IOException {
        String[] ext = path.split("\\.");
        String pathExt = ext[0] + "." + type;
        File fileOrg = new File(path);
        File fileCpy = new File(pathExt);
//             copySingleFile(fileOrg, fileCpy);
//            System.out.println(path);

    }

    void rename(String oldName, String change) {
        String[] split=oldName.split("\\.");
        
        File old = new File(oldName);
//        System.out.println(old.)
        File news = new File(split[0]+"."+change);
               if (old.renameTo(news)) {
            System.out.println("Done");
        }
    }

    void folder(String path,String ext) {
        
        File[] files = new File(path).listFiles();
        for(File f: files){
            rename(f.getPath(),ext);
        }
    }
    void encodingChange(String path){
//        File file=new File(path);
//        String contents=FileUtiles
       
    }

    public static void main(String[] args) throws IOException {
        ExtensionChange cls = new ExtensionChange();
//        cls.replace();
//        cls.folder(cls.source_files,"txt");
//        cls.rename(cls.source_files, "html");
        // encoding text file change
//        File[] files=new File(cls.source_files).listFiles();
//        for(File f:files){
        File f=new File("F:\\Master\\Thesis\\Tools\\Dataset\\Corpora\\Watan\\capr2.txt");
        System.out.println(f);
//            String contents=FileUtils.readFileToString(f);
//            FileUtils.writeStringToFile(f, contents, "UTF-8");
//        }
 
    }

    void replace() {
//        String REGEX = "a*b";
        String REGEX = "\\.";
        String INPUT = "aabfooaabfooabfoob";
        String REPLACE = ".txt";

        Pattern p = Pattern.compile(REGEX);
        // get a matcher object
        Matcher m = p.matcher(source_files);
        INPUT = m.replaceAll(REPLACE);
        System.out.println(INPUT);

    }
}
