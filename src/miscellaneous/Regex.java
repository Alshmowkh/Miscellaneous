package miscellaneous;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    String s, r;
    Pattern p;
    Matcher m;

    void validRegexs() {
        r = ".*"; //match any char in line
        r = "o.*[r]"; //match from o to r
        r = "[a-z]+\\d"; // match char a,b,...,z then a digit
        r = "[a-z]+\\d{2}"; // match char a,b,...,z then two followd digits

        r = "(\\d)+[a-z]+(\\d)";//match a digit then any character a,b,c,...,z then a digit
        r = "((\\d)+[a-z]+(\\d))+";//match a digit then any character a,b,c,...,z then a digit with more one occurence regex;
        r = "\\([^\\)]+\\)"; // match what in side of parentheses as         s="(1,2),(3,4),(5,6)";

    }

    void initial() {
        String stmt = "(S (NP (NNP سمير)) (VP (VBP يأكل) (NP (DTNN التفاحة)) (PP (IN في) (NP (DTNN المزرعة)))) (PUNC .))";
        String tags = "DTNN-0, DTNN-1, PRP-2, NN-3, JJ-4, VBP-5, DTNN-6, DTJJ-7, DTJJ-8, DTNN-9, NN-10, JJ-11, JJ-12, JJ-13, NN-14, NN-15, JJ-16, PUNC-17";
        s = "sk2sdt4d1fadsf578*-84 9 sdaf +s 1+1=2 ksd4flk ";
        String s2 = "This order was placed for QT3000! OK?";
//        s="a";
//        s="I lost my wallet";
//        String r2 = "(.*)(\\d+)(.*)";

        r = "df";
//        r = "((\\d)+[a-z]+(\\d))+";
        r = "\\((.*?)\\)";
//        r = "\\([^()]*\\)";
//        r = "(\\(.*()?\\))+";
        r = "\\(.*?\\)";
//        r="[A-Z]+";
        r = "(DTNN)";
        p = Pattern.compile(r);
        m = p.matcher(tags);
//        pl(m.groupCount());
//        String[] ary;
//        ary = tags.split(",");
        while (m.find()) {
            pl(m.group());
//             pl("\tg:" + m.group(0));
//              pl("\tg:" + m.group());
        }
//        for (String ary1 : ary) {
////            pl(ary1);
//        }
//        String f=s.

    }
    List phrases;

    String treeNLP(String stmt) {
//        String stmt = "(S (NP (NNP سمير)) (VP (VBP يأكل) (NP (DTNN التفاحة)) (PP (IN في) (NP (DTNN المزرعة)))) (PUNC .))";

        char[] cs = stmt.toCharArray();
        StringBuilder sb = new StringBuilder();
//        sb.append('(');
        int opnd = -1;
        String reminder = "";
        for (int i = 1; i < cs.length; i++) {
            sb.append(cs[i]);
            if (cs[i] == ')') {
                if (opnd == 0) {
//                    sb.append(')');
//                    phrases.add(sb.toString());
                    return sb.toString();
//                    reminder = (stmt.substring(i)).trim();

//                    break;
                } else {
                    opnd--;
                }
            }
            if (cs[i] == '(') {
                opnd++;
            }
        }
//        if (reminder.startsWith("(")) {
//            phrases.add(treeNLP(reminder));
//        }
//        sb.append(')');
//        phrases.add(sb.toString());
        return sb.toString();
    }

    void treeNLP() {
        phrases = new ArrayList();
        String stmt = "(S (NP (NNP سمير)) (VP (VBP يأكل) (NP (DTNN التفاحة)) (PP (IN في) (NP (DTNN المزرعة)))) (PUNC .))";
//        System.out.println(stmt.substring(1, stmt.length() -1));
        String[] splt = stmt.split(" ");
        m = Pattern.compile("\\s.*").matcher(stmt);
        String g = "", phr = "";
        if (m.find()) {
            g = m.group();
            phr = treeNLP(g.substring(0, g.length() - 1));
        }
        System.out.println(g);
    }

    void split() {
        String str = "c1(lksdf)c(k)c2(3sdf)";
//        str = "(1,2),(3,4),(5,6)";
        r = "(c\\d+\\(.*?\\))";
//        r = "\\([^\\)]+\\)";
//        r="((?:\\),\\()|(?:(?<!,)\\()|(?:\\)(?!,)))";
//        r="(\\d+,\\d+)";
        //----------------------------
        p = Pattern.compile(r);
        m = p.matcher(str);
        while (m.find()) {
            pl(m.group());
        }
    }

    public static void main(String[] args) {
        Regex cls = new Regex();
        cls.split();
//        cls.treeNLP();
//        cls.initial();
//        String str = "bakeel";
//        pl(str.matches("[^ba.* || ^be.*]"));

    }

    static void pl(Object o) {
        System.out.println(o);
    }
}
