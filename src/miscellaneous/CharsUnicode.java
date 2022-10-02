/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.math.BigInteger;
import static miscellaneous.Misce.pl;

public class CharsUnicode {

    static void unicode() {
        //begin 600x  1536
        //end   700x  1792
        //Buckwalter transliterating start \u0621 with end  \u0652
        int begin = 1569;
        int end = 1792;
        while (begin < end) {
            String unicode = String.format("\\u%04x", begin++);
            System.out.println(unicode + "\t--\t" + (char) (begin));
//            begin++;
        }
    }

    static void getUnicodeEntries() {
        BigInteger bigInt=new BigInteger("420000000");
        long begin = 420000000;
        long end = 2000000000;
        while (begin < end) {
            String unicode = String.format("\\u%04x", begin++);
            System.out.println(begin+"\t"+unicode + "\t--\t" + (char) (begin));
//            begin++;
        }
    }

    static void ascii() {
        int number = 1;
        String string = ((char) number) + "";
        System.out.println(string);
    }

    public static void main(String[] args) {
       // getUnicodeEntries();
        unicode();
//        ascii();
//        pl("\u0621");
//        pl(Character.UnicodeBlock.of(2));
//        CharsUnicode cls = new CharsUnicode();
//        char c = 'ء';
//        String hex = cls.charToHex(c);
//        pl(c);
//        pl(c >>> 8);

    }

    private String charToHex(char c) {
        byte hi = (byte) (c >>> 8);
        byte lo = (byte) (c & 0xff);
//        pl(hi);
//        pl(lo);
        return byteToHex(hi) + byteToHex(lo);
    }

    public String byteToHex(byte b) {
        // Returns hex String representation of byte b
        char hexDigit[] = {
            '0', '1', '2', '3', '4', '5', '6', '7',
            '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'
        };
        char[] array = {hexDigit[(b >> 4) & 0x0f], hexDigit[b & 0x0f]};
        return new String(array);
    }
}
