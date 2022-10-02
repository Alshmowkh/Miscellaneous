/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import static miscellaneous.Misce.pl;

/**
 *
 * @author bakee
 */
public class RandomNumber {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        RandomNumber random = new RandomNumber();
        random.attempt1();
//        pl(random.check(140055404));
    }

    private void attempt1() throws FileNotFoundException, IOException {
        Random random = new Random();
        String path = "F:\\Master\\Thesis\\Implementations\\Selenium\\mylib\\RandomNumber4.txt";

        int num;
        num = random.nextInt(999999);
        List<Integer> list = new ArrayList();
        IntStream intstream;
//        intstream = random.ints(100000, 999999);
        String ds;
        intstream = IntStream.range(100000, 999999).filter(i -> check(i));
//        intstream = intstream.limit(5000000).distinct();
        Iterable<Integer> iterable = intstream::iterator;
//        pl(iterable.iterator());
//        list = intstream.boxed().distinct().limit(1000000).collect(Collectors.toList());
        FileWriter fw = new FileWriter(path);
        Iterator<Integer> itr = iterable.iterator();
        while (itr.hasNext()) {
            fw.write(itr.next() + "\n");
//            pl(itr.next());
        }
        fw.close();
//        intstream.forEach(i -> {
//            if (!list.contains(i)) {
//                list.add(i);
//            }
//            if (list.size() >= 99999) {
//                try {
//                    saveList(list);
//                } catch (IOException ex) {
//                    Logger.getLogger(RandomNumber.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                try {
//                    throw new Exception();
//                } catch (Exception ex) {
//                    Logger.getLogger(RandomNumber.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        });
//        List list=intstream.distinct().collect(Collectors.toList());
//        File fileout = new File(path);
//        Files.write(Paths.get(path), (Iterable<String>) random.ints(100000, 999999).mapToObj(String::valueOf)::iterator);
//        OutputStream outstream = new FileOutputStream(fileout);
//BufferedReader br = new BufferedReader(new InputStreamReader(intstream));
//        outstream.write(arg0);
        pl(list.size());
//        pl(ints.count());
//        for (int i = 0; i < 999999; i++) {
//            num = random.;
//            pl(num);
//        }
    }

    private void saveList(List<Integer> list) throws IOException {
        String path = "F:\\Master\\Thesis\\Implementations\\Selenium\\mylib\\RandomNumber5.txt";
        FileWriter fw = new FileWriter(path);
        Iterator itr = list.iterator();
        while (itr.hasNext()) {
            fw.write(path);
        }
        fw.close();
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//        Files.write(Paths.get(path), list, Charset.forName("UTF-8"));

    }

    private boolean check(int i) {
        String ds = i + "";
        char[] chrs = ds.toCharArray();
        for (int j = 0; j < chrs.length - 1; j++) {
            if (chrs[j] == chrs[j + 1]) {
                return false;
            }
            if (howMuchOccur(chrs[j], ds) > 1) {
                return false;
            }
        }

        return true;
    }

    private int howMuchOccur(char j, String ds) {
        int count = 0;
        for (int k = ds.indexOf(j); k < ds.length(); k++) {
            if (j == ds.charAt(k)) {
                count++;
            }
        }
        return count;
    }
}
