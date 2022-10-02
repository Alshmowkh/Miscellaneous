/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

/**
 *
 * @author bakee
 */
public class MySonName {

    String realName;

    static void getUnicodeEntries() {
        // BigInteger bigInt=new BigInteger("420000000");
        long begin = 420000000;
        long end = 2000000000;
        while (begin < end) {
            String unicode = String.format("\\u%04x", begin++);
            //  System.out.println(unicode + "\t--\t" + (char) (begin));
            System.out.println(begin + "\t" + unicode + "\t--\t" + (char) (begin));

//            begin++;
        }
    }

    void printArabicChar() {
        int seed = 1569;
        int last = 1791;
        while (seed++ < last) {
            pl((char) seed);
        }
    }

    void printAllArabics() {

        long seed = 420019824;
        long last = 420019964;
        while (seed++ < last) {
            pl((char) seed);
        }
    }

    void initial() {

        //printArabicChar();-
        // printAllArabics();
        prova();
    }

    void prova() {
        long firstLetter = 420019923;
        long endLetter = 420019889;
        long seed = 420019840;//420019824;
        long begin = seed;
        long last = 420019964;
        while (begin++ < last) {
            for (long i = seed; i < last; i++) {
                String term = (char) endLetter + "" + (char) i + "" + (char) begin + "" + (char)firstLetter  + "";
                pl(term);
            }
        }
    }

    public static void main(String[] args) {
        MySonName cls = new MySonName();
        cls.initial();
//        getUnicodeEntries();

    }

    static void pl(Object o) {
        System.out.println(o.toString());
    }

}
