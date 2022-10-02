package miscellaneous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.toList;
import java.util.stream.Stream;
import static miscellaneous.Misce.pl;

public class Streamy {
    
    String path = "F:\\Master\\Thesis\\Implementations\\CognateIdentifer\\resources\\Verbs02.database";
    
    public List<String> getAllLines2() {
        List<String> lines = null;
        Stream<String> stream;
        File file = new File(path);
        FileReader fr = null;
        try {
            fr = new FileReader(file);
        } catch (FileNotFoundException ex) {
        }
        BufferedReader bfr = new BufferedReader(fr);
        stream = bfr.lines();
//        lines = stream
//                .map(d -> d.matches(""))
//                .distinct()
//                .collect(toList());

        return lines;
    }
    
    void ini() throws IOException {
        List<String> list;
//        list= Arrays.asList("Yemen", "Baghdad", "China");
        Stream<String> stream;
//        stream= title.stream();
//        stream.forEach(System.out::println);
        stream = Files.lines(Paths.get(path));
//        list = stream.map(x -> Arrays.asList(x.split(","))).collect(Collectors.toList());
//        pl(stream.count());
//        stream=stream.filter(x-> x.)
//        stream = stream.map(x -> x.split("\\(")[0]);
        pl(stream);
    }
    
    public static void main(String[] args) throws IOException {
        Streamy strm = new Streamy();
        strm.ini();
    }
    
}
