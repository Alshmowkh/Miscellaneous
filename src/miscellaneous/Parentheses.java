package miscellaneous;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static miscellaneous.Misce.pl;

public class Parentheses {

    String recursion(String str) {
        String st = "";
        boolean bool = !str.startsWith("(");
        char[] chs = str.toCharArray();
        int i = 0;
        while (bool && i < chs.length) {
            st += chs[i];
            bool = chs[i++] != '(';

        }
        return st;
    }

    String recursion(Iterator<String> itr) {
        String st = "";
        while (itr.hasNext()) {
            st += itr.next();
            if (st.endsWith("(")) {
                st += recursion(itr);
                pl(st);
            } else if (st.endsWith(")")) {

                return st;
            }
        }
        return st;
    }

    void start() {
        String str = "a(b())";
        str = "(ROOT (NP (NP (NN مدرب) (NP (DTNN المجموعة) (DTJJ السابقة))) (NP (NN حمار))))";
        str = "خدم(c1(A(P(خَدَمْتُ,خَدَمْنَا,خَدَمْتَ,خَدَمْتِ,خَدَمْتُمَا,خَدَمْتُمْ,خَدَمْتُنَّ,خَدَمَ,خَدَمَتْ,خَدَمَا,خَدَمَتَا,خَدَمُوا,خَدَمْنَ),N(أَخْدُمُ,نَخْدُمُ,تَخْدُمُ,تَخْدُمِينَ,تَخْدُمَانِ,تَخْدُمُونَ,تَخْدُمْنَ,يَخْدُمُ,تَخْدُمُ,يَخْدُمَانِ,تَخْدُمَانِ,يَخْدُمُونَ,يَخْدُمْنَ),A(أَخْدُمَ,نَخْدُمَ,تَخْدُمَ,تَخْدُمِي,تَخْدُمَا,تَخْدُمُوا,تَخْدُمْنَ,يَخْدُمَ,تَخْدُمَ,يَخْدُمَا,تَخْدُمَا,يَخْدُمُوا,يَخْدُمْنَ),J(أَخْدُمْ,نَخْدُمْ,تَخْدُمْ,تَخْدُمِي,تَخْدُمَا,تَخْدُمُوا,تَخْدُمْنَ,يَخْدُمْ,تَخْدُمْ,يَخْدُمَا,تَخْدُمَا,يَخْدُمُوا,يَخْدُمْنَ),E(أَخْدُمَنَّ,نَخْدُمَنَّ,تَخْدُمَنَّ,تَخْدُمِنَّ,تَخْدُمَانِّ,تَخْدُمُنَّ,تَخْدُمْنَانِّ,يَخْدُمَنَّ,تَخْدُمَنَّ,يَخْدُمَانِّ,تَخْدُمَانِّ,يَخْدُمُنَّ,يَخْدُمْنَانِّ),I(0,0,اخْدُمْ,اخْدُمِي,اخْدُمَا,اخْدُمُوا,اخْدُمْنَ,0,0,0,0,0,0),M(0,0,اخْدُمَنَّ,اخْدُمِنَّ,اخْدُمَانِّ,اخْدُمُنَّ,اخْدُمْنَانِّ,0,0,0,0,0,0)),P(P(خُدِمْتُ,خُدِمْنَا,خُدِمْتَ,خُدِمْتِ,خُدِمْتُمَا,خُدِمْتُمْ,خُدِمْتُنَّ,خُدِمَ,خُدِمَتْ,خُدِمَا,خُدِمَتَا,خُدِمُوا,خُدِمْنَ),N(أُخْدَمُ,نُخْدَمُ,تُخْدَمُ,تُخْدَمِينَ,تُخْدَمَانِ,تُخْدَمُونَ,تُخْدَمْنَ,يُخْدَمُ,تُخْدَمُ,يُخْدَمَانِ,تُخْدَمَانِ,يُخْدَمُونَ,يُخْدَمْنَ),A(أُخْدَمَ,نُخْدَمَ,تُخْدَمَ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمَ,تُخْدَمَ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),J(أُخْدَمْ,نُخْدَمْ,تُخْدَمْ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمْ,تُخْدَمْ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),E(أُخْدَمَنَّ,نُخْدَمَنَّ,تُخْدَمَنَّ,تُخْدَمِنَّ,تُخْدَمَانِّ,تُخْدَمُنَّ,تُخْدَمْنَانِّ,يُخْدَمَنَّ,تُخْدَمَنَّ,يُخْدَمَانِّ,تُخْدَمَانِّ,يُخْدَمُنَّ,يُخْدَمْنَانِّ))),c2(A(P(خَدَمْتُ,خَدَمْنَا,خَدَمْتَ,خَدَمْتِ,خَدَمْتُمَا,خَدَمْتُمْ,خَدَمْتُنَّ,خَدَمَ,خَدَمَتْ,خَدَمَا,خَدَمَتَا,خَدَمُوا,خَدَمْنَ),N(أَخْدِمُ,نَخْدِمُ,تَخْدِمُ,تَخْدِمِينَ,تَخْدِمَانِ,تَخْدِمُونَ,تَخْدِمْنَ,يَخْدِمُ,تَخْدِمُ,يَخْدِمَانِ,تَخْدِمَانِ,يَخْدِمُونَ,يَخْدِمْنَ),A(أَخْدِمَ,نَخْدِمَ,تَخْدِمَ,تَخْدِمِي,تَخْدِمَا,تَخْدِمُوا,تَخْدِمْنَ,يَخْدِمَ,تَخْدِمَ,يَخْدِمَا,تَخْدِمَا,يَخْدِمُوا,يَخْدِمْنَ),J(أَخْدِمْ,نَخْدِمْ,تَخْدِمْ,تَخْدِمِي,تَخْدِمَا,تَخْدِمُوا,تَخْدِمْنَ,يَخْدِمْ,تَخْدِمْ,يَخْدِمَا,تَخْدِمَا,يَخْدِمُوا,يَخْدِمْنَ),E(أَخْدِمَنَّ,نَخْدِمَنَّ,تَخْدِمَنَّ,تَخْدِمِنَّ,تَخْدِمَانِّ,تَخْدِمُنَّ,تَخْدِمْنَانِّ,يَخْدِمَنَّ,تَخْدِمَنَّ,يَخْدِمَانِّ,تَخْدِمَانِّ,يَخْدِمُنَّ,يَخْدِمْنَانِّ),I(0,0,اخْدِمْ,اخْدِمِي,اخْدِمَا,اخْدِمُوا,اخْدِمْنَ,0,0,0,0,0,0),M(0,0,اخْدِمَنَّ,اخْدِمِنَّ,اخْدِمَانِّ,اخْدِمُنَّ,اخْدِمْنَانِّ,0,0,0,0,0,0)),P(P(خُدِمْتُ,خُدِمْنَا,خُدِمْتَ,خُدِمْتِ,خُدِمْتُمَا,خُدِمْتُمْ,خُدِمْتُنَّ,خُدِمَ,خُدِمَتْ,خُدِمَا,خُدِمَتَا,خُدِمُوا,خُدِمْنَ),N(أُخْدَمُ,نُخْدَمُ,تُخْدَمُ,تُخْدَمِينَ,تُخْدَمَانِ,تُخْدَمُونَ,تُخْدَمْنَ,يُخْدَمُ,تُخْدَمُ,يُخْدَمَانِ,تُخْدَمَانِ,يُخْدَمُونَ,يُخْدَمْنَ),A(أُخْدَمَ,نُخْدَمَ,تُخْدَمَ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمَ,تُخْدَمَ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),J(أُخْدَمْ,نُخْدَمْ,تُخْدَمْ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمْ,تُخْدَمْ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),E(أُخْدَمَنَّ,نُخْدَمَنَّ,تُخْدَمَنَّ,تُخْدَمِنَّ,تُخْدَمَانِّ,تُخْدَمُنَّ,تُخْدَمْنَانِّ,يُخْدَمَنَّ,تُخْدَمَنَّ,يُخْدَمَانِّ,تُخْدَمَانِّ,يُخْدَمُنَّ,يُخْدَمْنَانِّ))),c7(A(P(أَخْدَمْتُ,أَخْدَمْنَا,أَخْدَمْتَ,أَخْدَمْتِ,أَخْدَمْتُمَا,أَخْدَمْتُمْ,أَخْدَمْتُنَّ,أَخْدَمَ,أَخْدَمَتْ,أَخْدَمَا,أَخْدَمَتَا,أَخْدَمُوا,أَخْدَمْنَ),N(أُخْدِمُ,نُخْدِمُ,تُخْدِمُ,تُخْدِمِينَ,تُخْدِمَانِ,تُخْدِمُونَ,تُخْدِمْنَ,يُخْدِمُ,تُخْدِمُ,يُخْدِمَانِ,تُخْدِمَانِ,يُخْدِمُونَ,يُخْدِمْنَ),A(أُخْدِمَ,نُخْدِمَ,تُخْدِمَ,تُخْدِمِي,تُخْدِمَا,تُخْدِمُوا,تُخْدِمْنَ,يُخْدِمَ,تُخْدِمَ,يُخْدِمَا,تُخْدِمَا,يُخْدِمُوا,يُخْدِمْنَ),J(أُخْدِمْ,نُخْدِمْ,تُخْدِمْ,تُخْدِمِي,تُخْدِمَا,تُخْدِمُوا,تُخْدِمْنَ,يُخْدِمْ,تُخْدِمْ,يُخْدِمَا,تُخْدِمَا,يُخْدِمُوا,يُخْدِمْنَ),E(أُخْدِمَنَّ,نُخْدِمَنَّ,تُخْدِمَنَّ,تُخْدِمِنَّ,تُخْدِمَانِّ,تُخْدِمُنَّ,تُخْدِمْنَانِّ,يُخْدِمَنَّ,تُخْدِمَنَّ,يُخْدِمَانِّ,تُخْدِمَانِّ,يُخْدِمُنَّ,يُخْدِمْنَانِّ),I(0,0,أَخْدِمْ,أَخْدِمِي,أَخْدِمَا,أَخْدِمُوا,أَخْدِمْنَ,0,0,0,0,0,0),M(0,0,أَخْدِمَنَّ,أَخْدِمِنَّ,أَخْدِمَانِّ,أَخْدِمُنَّ,أَخْدِمْنَانِّ,0,0,0,0,0,0)),P(P(أُخْدِمْتُ,أُخْدِمْنَا,أُخْدِمْتَ,أُخْدِمْتِ,أُخْدِمْتُمَا,أُخْدِمْتُمْ,أُخْدِمْتُنَّ,أُخْدِمَ,أُخْدِمَتْ,أُخْدِمَا,أُخْدِمَتَا,أُخْدِمُوا,أُخْدِمْنَ),N(أُخْدَمُ,نُخْدَمُ,تُخْدَمُ,تُخْدَمِينَ,تُخْدَمَانِ,تُخْدَمُونَ,تُخْدَمْنَ,يُخْدَمُ,تُخْدَمُ,يُخْدَمَانِ,تُخْدَمَانِ,يُخْدَمُونَ,يُخْدَمْنَ),A(أُخْدَمَ,نُخْدَمَ,تُخْدَمَ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمَ,تُخْدَمَ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),J(أُخْدَمْ,نُخْدَمْ,تُخْدَمْ,تُخْدَمِي,تُخْدَمَا,تُخْدَمُوا,تُخْدَمْنَ,يُخْدَمْ,تُخْدَمْ,يُخْدَمَا,تُخْدَمَا,يُخْدَمُوا,يُخْدَمْنَ),E(أُخْدَمَنَّ,نُخْدَمَنَّ,تُخْدَمَنَّ,تُخْدَمِنَّ,تُخْدَمَانِّ,تُخْدَمُنَّ,تُخْدَمْنَانِّ,يُخْدَمَنَّ,تُخْدَمَنَّ,يُخْدَمَانِّ,تُخْدَمَانِّ,يُخْدَمُنَّ,يُخْدَمْنَانِّ))),c8(A(P(خَدَّمْتُ,خَدَّمْنَا,خَدَّمْتَ,خَدَّمْتِ,خَدَّمْتُمَا,خَدَّمْتُمْ,خَدَّمْتُنَّ,خَدَّمَ,خَدَّمَتْ,خَدَّمَا,خَدَّمَتَا,خَدَّمُوا,خَدَّمْنَ),N(أُخَدِّمُ,نُخَدِّمُ,تُخَدِّمُ,تُخَدِّمِينَ,تُخَدِّمَانِ,تُخَدِّمُونَ,تُخَدِّمْنَ,يُخَدِّمُ,تُخَدِّمُ,يُخَدِّمَانِ,تُخَدِّمَانِ,يُخَدِّمُونَ,يُخَدِّمْنَ),A(أُخَدِّمَ,نُخَدِّمَ,تُخَدِّمَ,تُخَدِّمِي,تُخَدِّمَا,تُخَدِّمُوا,تُخَدِّمْنَ,يُخَدِّمَ,تُخَدِّمَ,يُخَدِّمَا,تُخَدِّمَا,يُخَدِّمُوا,يُخَدِّمْنَ),J(أُخَدِّمْ,نُخَدِّمْ,تُخَدِّمْ,تُخَدِّمِي,تُخَدِّمَا,تُخَدِّمُوا,تُخَدِّمْنَ,يُخَدِّمْ,تُخَدِّمْ,يُخَدِّمَا,تُخَدِّمَا,يُخَدِّمُوا,يُخَدِّمْنَ),E(أُخَدِّمَنَّ,نُخَدِّمَنَّ,تُخَدِّمَنَّ,تُخَدِّمِنَّ,تُخَدِّمَانِّ,تُخَدِّمُنَّ,تُخَدِّمْنَانِّ,يُخَدِّمَنَّ,تُخَدِّمَنَّ,يُخَدِّمَانِّ,تُخَدِّمَانِّ,يُخَدِّمُنَّ,يُخَدِّمْنَانِّ),I(0,0,خَدِّمْ,خَدِّمِي,خَدِّمَا,خَدِّمُوا,خَدِّمْنَ,0,0,0,0,0,0),M(0,0,خَدِّمَنَّ,خَدِّمِنَّ,خَدِّمَانِّ,خَدِّمُنَّ,خَدِّمْنَانِّ,0,0,0,0,0,0)),P(P(خُدِّمْتُ,خُدِّمْنَا,خُدِّمْتَ,خُدِّمْتِ,خُدِّمْتُمَا,خُدِّمْتُمْ,خُدِّمْتُنَّ,خُدِّمَ,خُدِّمَتْ,خُدِّمَا,خُدِّمَتَا,خُدِّمُوا,خُدِّمْنَ),N(أُخَدَّمُ,نُخَدَّمُ,تُخَدَّمُ,تُخَدَّمِينَ,تُخَدَّمَانِ,تُخَدَّمُونَ,تُخَدَّمْنَ,يُخَدَّمُ,تُخَدَّمُ,يُخَدَّمَانِ,تُخَدَّمَانِ,يُخَدَّمُونَ,يُخَدَّمْنَ),A(أُخَدَّمَ,نُخَدَّمَ,تُخَدَّمَ,تُخَدَّمِي,تُخَدَّمَا,تُخَدَّمُوا,تُخَدَّمْنَ,يُخَدَّمَ,تُخَدَّمَ,يُخَدَّمَا,تُخَدَّمَا,يُخَدَّمُوا,يُخَدَّمْنَ),J(أُخَدَّمْ,نُخَدَّمْ,تُخَدَّمْ,تُخَدَّمِي,تُخَدَّمَا,تُخَدَّمُوا,تُخَدَّمْنَ,يُخَدَّمْ,تُخَدَّمْ,يُخَدَّمَا,تُخَدَّمَا,يُخَدَّمُوا,يُخَدَّمْنَ),E(أُخَدَّمَنَّ,نُخَدَّمَنَّ,تُخَدَّمَنَّ,تُخَدَّمِنَّ,تُخَدَّمَانِّ,تُخَدَّمُنَّ,تُخَدَّمْنَانِّ,يُخَدَّمَنَّ,تُخَدَّمَنَّ,يُخَدَّمَانِّ,تُخَدَّمَانِّ,يُخَدَّمُنَّ,يُخَدَّمْنَانِّ))),c11(A(P(اخْتَدَمْتُ,اخْتَدَمْنَا,اخْتَدَمْتَ,اخْتَدَمْتِ,اخْتَدَمْتُمَا,اخْتَدَمْتُمْ,اخْتَدَمْتُنَّ,اخْتَدَمَ,اخْتَدَمَتْ,اخْتَدَمَا,اخْتَدَمَتَا,اخْتَدَمُوا,اخْتَدَمْنَ),N(أَخْتَدِمُ,نَخْتَدِمُ,تَخْتَدِمُ,تَخْتَدِمِينَ,تَخْتَدِمَانِ,تَخْتَدِمُونَ,تَخْتَدِمْنَ,يَخْتَدِمُ,تَخْتَدِمُ,يَخْتَدِمَانِ,تَخْتَدِمَانِ,يَخْتَدِمُونَ,يَخْتَدِمْنَ),A(أَخْتَدِمَ,نَخْتَدِمَ,تَخْتَدِمَ,تَخْتَدِمِي,تَخْتَدِمَا,تَخْتَدِمُوا,تَخْتَدِمْنَ,يَخْتَدِمَ,تَخْتَدِمَ,يَخْتَدِمَا,تَخْتَدِمَا,يَخْتَدِمُوا,يَخْتَدِمْنَ),J(أَخْتَدِمْ,نَخْتَدِمْ,تَخْتَدِمْ,تَخْتَدِمِي,تَخْتَدِمَا,تَخْتَدِمُوا,تَخْتَدِمْنَ,يَخْتَدِمْ,تَخْتَدِمْ,يَخْتَدِمَا,تَخْتَدِمَا,يَخْتَدِمُوا,يَخْتَدِمْنَ),E(أَخْتَدِمَنَّ,نَخْتَدِمَنَّ,تَخْتَدِمَنَّ,تَخْتَدِمِنَّ,تَخْتَدِمَانِّ,تَخْتَدِمُنَّ,تَخْتَدِمْنَانِّ,يَخْتَدِمَنَّ,تَخْتَدِمَنَّ,يَخْتَدِمَانِّ,تَخْتَدِمَانِّ,يَخْتَدِمُنَّ,يَخْتَدِمْنَانِّ),I(0,0,اخْتَدِمْ,اخْتَدِمِي,اخْتَدِمَا,اخْتَدِمُوا,اخْتَدِمْنَ,0,0,0,0,0,0),M(0,0,اخْتَدِمَنَّ,اخْتَدِمِنَّ,اخْتَدِمَانِّ,اخْتَدِمُنَّ,اخْتَدِمْنَانِّ,0,0,0,0,0,0)),P(P(اخْتُدِمْتُ,اخْتُدِمْنَا,اخْتُدِمْتَ,اخْتُدِمْتِ,اخْتُدِمْتُمَا,اخْتُدِمْتُمْ,اخْتُدِمْتُنَّ,اخْتُدِمَ,اخْتُدِمَتْ,اخْتُدِمَا,اخْتُدِمَتَا,اخْتُدِمُوا,اخْتُدِمْنَ),N(أُخْتَدَمُ,نُخْتَدَمُ,تُخْتَدَمُ,تُخْتَدَمِينَ,تُخْتَدَمَانِ,تُخْتَدَمُونَ,تُخْتَدَمْنَ,يُخْتَدَمُ,تُخْتَدَمُ,يُخْتَدَمَانِ,تُخْتَدَمَانِ,يُخْتَدَمُونَ,يُخْتَدَمْنَ),A(أُخْتَدَمَ,نُخْتَدَمَ,تُخْتَدَمَ,تُخْتَدَمِي,تُخْتَدَمَا,تُخْتَدَمُوا,تُخْتَدَمْنَ,يُخْتَدَمَ,تُخْتَدَمَ,يُخْتَدَمَا,تُخْتَدَمَا,يُخْتَدَمُوا,يُخْتَدَمْنَ),J(أُخْتَدَمْ,نُخْتَدَمْ,تُخْتَدَمْ,تُخْتَدَمِي,تُخْتَدَمَا,تُخْتَدَمُوا,تُخْتَدَمْنَ,يُخْتَدَمْ,تُخْتَدَمْ,يُخْتَدَمَا,تُخْتَدَمَا,يُخْتَدَمُوا,يُخْتَدَمْنَ),E(أُخْتَدَمَنَّ,نُخْتَدَمَنَّ,تُخْتَدَمَنَّ,تُخْتَدَمِنَّ,تُخْتَدَمَانِّ,تُخْتَدَمُنَّ,تُخْتَدَمْنَانِّ,يُخْتَدَمَنَّ,تُخْتَدَمَنَّ,يُخْتَدَمَانِّ,تُخْتَدَمَانِّ,يُخْتَدَمُنَّ,يُخْتَدَمْنَانِّ))),c14(A(P(تَخَدَّمْتُ,تَخَدَّمْنَا,تَخَدَّمْتَ,تَخَدَّمْتِ,تَخَدَّمْتُمَا,تَخَدَّمْتُمْ,تَخَدَّمْتُنَّ,تَخَدَّمَ,تَخَدَّمَتْ,تَخَدَّمَا,تَخَدَّمَتَا,تَخَدَّمُوا,تَخَدَّمْنَ),N(أَتَخَدَّمُ,نَتَخَدَّمُ,تَتَخَدَّمُ,تَتَخَدَّمِينَ,تَتَخَدَّمَانِ,تَتَخَدَّمُونَ,تَتَخَدَّمْنَ,يَتَخَدَّمُ,تَتَخَدَّمُ,يَتَخَدَّمَانِ,تَتَخَدَّمَانِ,يَتَخَدَّمُونَ,يَتَخَدَّمْنَ),A(أَتَخَدَّمَ,نَتَخَدَّمَ,تَتَخَدَّمَ,تَتَخَدَّمِي,تَتَخَدَّمَا,تَتَخَدَّمُوا,تَتَخَدَّمْنَ,يَتَخَدَّمَ,تَتَخَدَّمَ,يَتَخَدَّمَا,تَتَخَدَّمَا,يَتَخَدَّمُوا,يَتَخَدَّمْنَ),J(أَتَخَدَّمْ,نَتَخَدَّمْ,تَتَخَدَّمْ,تَتَخَدَّمِي,تَتَخَدَّمَا,تَتَخَدَّمُوا,تَتَخَدَّمْنَ,يَتَخَدَّمْ,تَتَخَدَّمْ,يَتَخَدَّمَا,تَتَخَدَّمَا,يَتَخَدَّمُوا,يَتَخَدَّمْنَ),E(أَتَخَدَّمَنَّ,نَتَخَدَّمَنَّ,تَتَخَدَّمَنَّ,تَتَخَدَّمِنَّ,تَتَخَدَّمَانِّ,تَتَخَدَّمُنَّ,تَتَخَدَّمْنَانِّ,يَتَخَدَّمَنَّ,تَتَخَدَّمَنَّ,يَتَخَدَّمَانِّ,تَتَخَدَّمَانِّ,يَتَخَدَّمُنَّ,يَتَخَدَّمْنَانِّ),I(0,0,تَخَدَّمْ,تَخَدَّمِي,تَخَدَّمَا,تَخَدَّمُوا,تَخَدَّمْنَ,0,0,0,0,0,0),M(0,0,تَخَدَّمَنَّ,تَخَدَّمِنَّ,تَخَدَّمَانِّ,تَخَدَّمُنَّ,تَخَدَّمْنَانِّ,0,0,0,0,0,0)),P(P(تُخُدِّمْتُ,تُخُدِّمْنَا,تُخُدِّمْتَ,تُخُدِّمْتِ,تُخُدِّمْتُمَا,تُخُدِّمْتُمْ,تُخُدِّمْتُنَّ,تُخُدِّمَ,تُخُدِّمَتْ,تُخُدِّمَا,تُخُدِّمَتَا,تُخُدِّمُوا,تُخُدِّمْنَ),N(أُتَخَدَّمُ,نُتَخَدَّمُ,تُتَخَدَّمُ,تُتَخَدَّمِينَ,تُتَخَدَّمَانِ,تُتَخَدَّمُونَ,تُتَخَدَّمْنَ,يُتَخَدَّمُ,تُتَخَدَّمُ,يُتَخَدَّمَانِ,تُتَخَدَّمَانِ,يُتَخَدَّمُونَ,يُتَخَدَّمْنَ),A(أُتَخَدَّمَ,نُتَخَدَّمَ,تُتَخَدَّمَ,تُتَخَدَّمِي,تُتَخَدَّمَا,تُتَخَدَّمُوا,تُتَخَدَّمْنَ,يُتَخَدَّمَ,تُتَخَدَّمَ,يُتَخَدَّمَا,تُتَخَدَّمَا,يُتَخَدَّمُوا,يُتَخَدَّمْنَ),J(أُتَخَدَّمْ,نُتَخَدَّمْ,تُتَخَدَّمْ,تُتَخَدَّمِي,تُتَخَدَّمَا,تُتَخَدَّمُوا,تُتَخَدَّمْنَ,يُتَخَدَّمْ,تُتَخَدَّمْ,يُتَخَدَّمَا,تُتَخَدَّمَا,يُتَخَدَّمُوا,يُتَخَدَّمْنَ),E(أُتَخَدَّمَنَّ,نُتَخَدَّمَنَّ,تُتَخَدَّمَنَّ,تُتَخَدَّمِنَّ,تُتَخَدَّمَانِّ,تُتَخَدَّمُنَّ,تُتَخَدَّمْنَانِّ,يُتَخَدَّمَنَّ,تُتَخَدَّمَنَّ,يُتَخَدَّمَانِّ,تُتَخَدَّمَانِّ,يُتَخَدَّمُنَّ,يُتَخَدَّمْنَانِّ))),c15(A(P(اسْتَخْدَمْتُ,اسْتَخْدَمْنَا,اسْتَخْدَمْتَ,اسْتَخْدَمْتِ,اسْتَخْدَمْتُمَا,اسْتَخْدَمْتُمْ,اسْتَخْدَمْتُنَّ,اسْتَخْدَمَ,اسْتَخْدَمَتْ,اسْتَخْدَمَا,اسْتَخْدَمَتَا,اسْتَخْدَمُوا,اسْتَخْدَمْنَ),N(أَسْتَخْدِمُ,نَسْتَخْدِمُ,تَسْتَخْدِمُ,تَسْتَخْدِمِينَ,تَسْتَخْدِمَانِ,تَسْتَخْدِمُونَ,تَسْتَخْدِمْنَ,يَسْتَخْدِمُ,تَسْتَخْدِمُ,يَسْتَخْدِمَانِ,تَسْتَخْدِمَانِ,يَسْتَخْدِمُونَ,يَسْتَخْدِمْنَ),A(أَسْتَخْدِمَ,نَسْتَخْدِمَ,تَسْتَخْدِمَ,تَسْتَخْدِمِي,تَسْتَخْدِمَا,تَسْتَخْدِمُوا,تَسْتَخْدِمْنَ,يَسْتَخْدِمَ,تَسْتَخْدِمَ,يَسْتَخْدِمَا,تَسْتَخْدِمَا,يَسْتَخْدِمُوا,يَسْتَخْدِمْنَ),J(أَسْتَخْدِمْ,نَسْتَخْدِمْ,تَسْتَخْدِمْ,تَسْتَخْدِمِي,تَسْتَخْدِمَا,تَسْتَخْدِمُوا,تَسْتَخْدِمْنَ,يَسْتَخْدِمْ,تَسْتَخْدِمْ,يَسْتَخْدِمَا,تَسْتَخْدِمَا,يَسْتَخْدِمُوا,يَسْتَخْدِمْنَ),E(أَسْتَخْدِمَنَّ,نَسْتَخْدِمَنَّ,تَسْتَخْدِمَنَّ,تَسْتَخْدِمِنَّ,تَسْتَخْدِمَانِّ,تَسْتَخْدِمُنَّ,تَسْتَخْدِمْنَانِّ,يَسْتَخْدِمَنَّ,تَسْتَخْدِمَنَّ,يَسْتَخْدِمَانِّ,تَسْتَخْدِمَانِّ,يَسْتَخْدِمُنَّ,يَسْتَخْدِمْنَانِّ),I(0,0,اسْتَخْدِمْ,اسْتَخْدِمِي,اسْتَخْدِمَا,اسْتَخْدِمُوا,اسْتَخْدِمْنَ,0,0,0,0,0,0),M(0,0,اسْتَخْدِمَنَّ,اسْتَخْدِمِنَّ,اسْتَخْدِمَانِّ,اسْتَخْدِمُنَّ,اسْتَخْدِمْنَانِّ,0,0,0,0,0,0)),P(P(اسْتُخْدِمْتُ,اسْتُخْدِمْنَا,اسْتُخْدِمْتَ,اسْتُخْدِمْتِ,اسْتُخْدِمْتُمَا,اسْتُخْدِمْتُمْ,اسْتُخْدِمْتُنَّ,اسْتُخْدِمَ,اسْتُخْدِمَتْ,اسْتُخْدِمَا,اسْتُخْدِمَتَا,اسْتُخْدِمُوا,اسْتُخْدِمْنَ),N(أُسْتَخْدَمُ,نُسْتَخْدَمُ,تُسْتَخْدَمُ,تُسْتَخْدَمِينَ,تُسْتَخْدَمَانِ,تُسْتَخْدَمُونَ,تُسْتَخْدَمْنَ,يُسْتَخْدَمُ,تُسْتَخْدَمُ,يُسْتَخْدَمَانِ,تُسْتَخْدَمَانِ,يُسْتَخْدَمُونَ,يُسْتَخْدَمْنَ),A(أُسْتَخْدَمَ,نُسْتَخْدَمَ,تُسْتَخْدَمَ,تُسْتَخْدَمِي,تُسْتَخْدَمَا,تُسْتَخْدَمُوا,تُسْتَخْدَمْنَ,يُسْتَخْدَمَ,تُسْتَخْدَمَ,يُسْتَخْدَمَا,تُسْتَخْدَمَا,يُسْتَخْدَمُوا,يُسْتَخْدَمْنَ),J(أُسْتَخْدَمْ,نُسْتَخْدَمْ,تُسْتَخْدَمْ,تُسْتَخْدَمِي,تُسْتَخْدَمَا,تُسْتَخْدَمُوا,تُسْتَخْدَمْنَ,يُسْتَخْدَمْ,تُسْتَخْدَمْ,يُسْتَخْدَمَا,تُسْتَخْدَمَا,يُسْتَخْدَمُوا,يُسْتَخْدَمْنَ),E(أُسْتَخْدَمَنَّ,نُسْتَخْدَمَنَّ,تُسْتَخْدَمَنَّ,تُسْتَخْدَمِنَّ,تُسْتَخْدَمَانِّ,تُسْتَخْدَمُنَّ,تُسْتَخْدَمْنَانِّ,يُسْتَخْدَمَنَّ,تُسْتَخْدَمَنَّ,يُسْتَخْدَمَانِّ,تُسْتَخْدَمَانِّ,يُسْتَخْدَمُنَّ,يُسْتَخْدَمْنَانِّ))))";
        List<String> cs = Arrays.asList(str.split(""));
        Iterator<String> itr = cs.iterator();
        recursion(itr);
    }

    void nested() {
        String str = "a(b(c,d),e(f,h))";
        Pattern p;
        Matcher m;
        String reg;

        reg = ".\\(.*?[^\\(]\\)";
        reg = "(\\w+)(\\([^()]*|\\([^()]*\\)*\\))";
        reg = ".\\([^()]*\\)";
        p = Pattern.compile(reg);
        m = p.matcher(str);
        while (m.find()) {
            pl(m.group());
        }
    }

    void getElements() {
        //"(.*?)[^(),a-zA-Z\\d*]*"
        String str;
//        str= "ءبب(C1(O(أب,أبا,أبأبيب,أبيبا,أبيبأباب,أبابا,أبابأبابة,أبابة,أبابةإبابة,إبابة,إبابة),M(مأب,مأبا,مأب),N(أبة,أبتان,أبات,أبة,أبتين,أبات,أبة,أبتين,أبات),Q(إبة,إبة,إبة)),C2(O(أب,أبا,أبأبيب,أبيبا,أبيبأباب,أبابا,أبابأبابة,أبابة,أبابة),M(مأب,مأبا,مأب),N(أبة,أبتان,أبات,أبة,أبتين,أبات,أبة,أبتين,أبات),Q(إبة,إبة,إبة)),C8(O(تأبيب,تأبيبان,تأبيبات,تأبيبا,تأبيبين,تأبيبات,تأبيب,تأبيبين,تأبيبا),N(تأبيبة,تأبيبتان,تأبيبات,تأبيبة,تأبيبتين,تأبيبات,تأبيبة,تأبيبتين,تأبيبا),M(مؤبب,مؤببا,مؤب)),,C11(O(ائتباب,ائتبابان,ائتبابات,ائتبابا,ائتبابين,ائتبابات,ائتباب,ائتبابين,ائتبابا),N(ائتبابة,ائتبابتان,ائتبابات,ائتبابة,ائتبابتين,ائتبابات,ائتبابة,ائتبابتين,ائتبابا),M(مؤتب,مؤتبا,مؤت)),,C14(O(تأبب,تأببان,تأببات,تأببا,تأببين,تأببات,تأبب,تأببين,تأببا),N(تأببة,تأببتان,تأببات,تأببة,تأببتين,تأببات,تأببة,تأببتين,تأببا),M(متأبب,متأببا,متأب)),)";
        str = "ءبب(C1(Av(P(أببت,أببنا,أببت,أببت,أببتما,أببتم,أببتن,أب,أبت,أبا,أبتا,أبوا,أببن),N(أؤب,نؤب,تؤب,تؤبين,تؤبان,تؤبون,تأببن,يؤب,تؤب,يؤبان,تؤبان,يؤبون,يأببن),A(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تأببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يأببن),J(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تأببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يأببن),E(أؤبن,نؤبن,تؤبن,تؤبن,تؤبان,تؤبن,تأببنان,يؤبن,تؤبن,يؤبان,تؤبان,يؤبن,يأببنان),I(0,0,أب,أبي,أبا,أبوا,اؤببن,0,0,0,0,0,0),M(0,0,أبن,أبن,أبان,أبن,اؤببنان,0,0,0,0,0,0)),Pv(P(أببت,أببنا,أببت,أببت,أببتما,أببتم,أببتن,أب,أبت,أبا,أبتا,أبوا,أببن),N(أؤب,نؤب,تؤب,تؤبين,تؤبان,تؤبون,تؤببن,يؤب,تؤب,يؤبان,تؤبان,يؤبون,يؤببن),A(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تؤببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يؤببن),J(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تؤببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يؤببن),E(أؤبن,نؤبن,تؤبن,تؤبن,تؤبان,تؤبن,تؤببنان,يؤبن,تؤبن,يؤبان,تؤبان,يؤبن,يؤببنان))),C2(Av(P(أببت,أببنا,أببت,أببت,أببتما,أببتم,أببتن,أب,أبت,أبا,أبتا,أبوا,أببن),N(أئب,نئب,تئب,تئبين,تئبان,تئبون,تأببن,يئب,تئب,يئبان,تئبان,يئبون,يأببن),A(أئب,نئب,تئب,تئبي,تئبا,تئبوا,تأببن,يئب,تئب,يئبا,تئبا,يئبوا,يأببن),J(أئب,نئب,تئب,تئبي,تئبا,تئبوا,تأببن,يئب,تئب,يئبا,تئبا,يئبوا,يأببن),E(أئبن,نئبن,تئبن,تئبن,تئبان,تئبن,تأببنان,يئبن,تئبن,يئبان,تئبان,يئبن,يأببنان),I(0,0,إب,إبي,إبا,إبوا,ائببن,0,0,0,0,0,0),M(0,0,إبن,إبن,إبان,إبن,ائببنان,0,0,0,0,0,0)),Pv(P(أببت,أببنا,أببت,أببت,أببتما,أببتم,أببتن,أب,أبت,أبا,أبتا,أبوا,أببن),N(أؤب,نؤب,تؤب,تؤبين,تؤبان,تؤبون,تؤببن,يؤب,تؤب,يؤبان,تؤبان,يؤبون,يؤببن),A(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تؤببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يؤببن),J(أؤب,نؤب,تؤب,تؤبي,تؤبا,تؤبوا,تؤببن,يؤب,تؤب,يؤبا,تؤبا,يؤبوا,يؤببن),E(أؤبن,نؤبن,تؤبن,تؤبن,تؤبان,تؤبن,تؤببنان,يؤبن,تؤبن,يؤبان,تؤبان,يؤبن,يؤببنان))),C8(Av(P(أببت,أببنا,أببت,أببت,أببتما,أببتم,أببتن,أبب,أببت,أببا,أببتا,أببوا,أببن),N(أؤبب,نؤبب,تؤبب,تؤببين,تؤببان,تؤببون,تؤببن,يؤبب,تؤبب,يؤببان,تؤببان,يؤببون,يؤببن),A(أؤبب,نؤبب,تؤبب,تؤببي,تؤببا,تؤببوا,تؤببن,يؤبب,تؤبب,يؤببا,تؤببا,يؤببوا,يؤببن),J(أؤبب,نؤبب,تؤبب,تؤببي,تؤببا,تؤببوا,تؤببن,يؤبب,تؤبب,يؤببا,تؤببا,يؤببوا,يؤببن),E(أؤببن,نؤببن,تؤببن,تؤببن,تؤببان,تؤببن,تؤببنان,يؤببن,تؤببن,يؤببان,تؤببان,يؤببن,يؤببنان),I(0,0,أبب,أببي,أببا,أببوا,أببن,0,0,0,0,0,0),M(0,0,أببن,أببن,أببان,أببن,أببنان,0,0,0,0,0,0)),Pv(P(0,0,0,0,0,0,0,أبب,أببت,0,0,0,0),N(0,0,0,0,0,0,0,يؤبب,تؤبب,0,0,0,0),A(0,0,0,0,0,0,0,يؤبب,تؤبب,0,0,0,0),J(0,0,0,0,0,0,0,يؤبب,تؤبب,0,0,0,0),E(0,0,0,0,0,0,0,يؤببن,تؤببن,0,0,0,0))),C11(Av(P(ائتببت,ائتببنا,ائتببت,ائتببت,ائتببتما,ائتببتم,ائتببتن,ائتب,ائتبت,ائتبا,ائتبتا,ائتبوا,ائتببن),N(آتب,نأتب,تأتب,تأتبين,تأتبان,تأتبون,تأتببن,يأتب,تأتب,يأتبان,تأتبان,يأتبون,يأتببن),A(آتب,نأتب,تأتب,تأتبي,تأتبا,تأتبوا,تأتببن,يأتب,تأتب,يأتبا,تأتبا,يأتبوا,يأتببن),J(آتب,نأتب,تأتب,تأتبي,تأتبا,تأتبوا,تأتببن,يأتب,تأتب,يأتبا,تأتبا,يأتبوا,يأتببن),E(آتبن,نأتبن,تأتبن,تأتبن,تأتبان,تأتبن,تأتببنان,يأتبن,تأتبن,يأتبان,تأتبان,يأتبن,يأتببنان),I(0,0,ائتب,ائتبي,ائتبا,ائتبوا,ائتببن,0,0,0,0,0,0),M(0,0,ائتبن,ائتبن,ائتبان,ائتبن,ائتببنان,0,0,0,0,0,0)),Pv(P(0,0,0,0,0,0,0,اؤتب,اؤتبت,0,0,0,0),N(0,0,0,0,0,0,0,يؤتب,تؤتب,0,0,0,0),A(0,0,0,0,0,0,0,يؤتب,تؤتب,0,0,0,0),J(0,0,0,0,0,0,0,يؤتب,تؤتب,0,0,0,0),E(0,0,0,0,0,0,0,يؤتبن,تؤتبن,0,0,0,0))),C14(Av(P(تأببت,تأببنا,تأببت,تأببت,تأببتما,تأببتم,تأببتن,تأبب,تأببت,تأببا,تأببتا,تأببوا,تأببن),N(أتأبب,نتأبب,تتأبب,تتأببين,تتأببان,تتأببون,تتأببن,يتأبب,تتأبب,يتأببان,تتأببان,يتأببون,يتأببن),A(أتأبب,نتأبب,تتأبب,تتأببي,تتأببا,تتأببوا,تتأببن,يتأبب,تتأبب,يتأببا,تتأببا,يتأببوا,يتأببن),J(أتأبب,نتأبب,تتأبب,تتأببي,تتأببا,تتأببوا,تتأببن,يتأبب,تتأبب,يتأببا,تتأببا,يتأببوا,يتأببن),E(أتأببن,نتأببن,تتأببن,تتأببن,تتأببان,تتأببن,تتأببنان,يتأببن,تتأببن,يتأببان,تتأببان,يتأببن,يتأببنان),I(0,0,تأبب,تأببي,تأببا,تأببوا,تأببن,0,0,0,0,0,0),M(0,0,تأببن,تأببن,تأببان,تأببن,تأببنان,0,0,0,0,0,0)),Pv(P(0,0,0,0,0,0,0,تؤبب,تؤببت,0,0,0,0),N(0,0,0,0,0,0,0,يتأبب,تتأبب,0,0,0,0),A(0,0,0,0,0,0,0,يتأبب,تتأبب,0,0,0,0),J(0,0,0,0,0,0,0,يتأبب,تتأبب,0,0,0,0),E(0,0,0,0,0,0,0,يتأببن,تتأببن,0,0,0,0))))";
        String regex;
        Pattern p;
        Matcher m;
//        regex = ".*?[^(),]*";
        regex = "(.*?)[^(),a-zA-Z\\d*]*";
        p = Pattern.compile(regex);
        m = p.matcher(str);

        MatchResult mr;//=m.toMatchResult();

        while (m.find()) {
            mr = m.toMatchResult();
            str=mr.group();
            if(!str.trim().isEmpty())
                pl(mr.group());
//                        pl(mr.groupCount());

        }
    }

    void parentheses() {
        String str = "ءبب(C1(O(أب,أبا,أبأبيب,أبيبا,أبيبأباب,أبابا,أبابأبابة,أبابة,أبابةإبابة,إبابة,إبابة),M(مأب,مأبا,مأب),N(أبة,أبتان,أبات,أبة,أبتين,أبات,أبة,أبتين,أبات),Q(إبة,إبة,إبة)),C2(O(أب,أبا,أبأبيب,أبيبا,أبيبأباب,أبابا,أبابأبابة,أبابة,أبابة),M(مأب,مأبا,مأب),N(أبة,أبتان,أبات,أبة,أبتين,أبات,أبة,أبتين,أبات),Q(إبة,إبة,إبة)),C8(O(تأبيب,تأبيبان,تأبيبات,تأبيبا,تأبيبين,تأبيبات,تأبيب,تأبيبين,تأبيبا),N(تأبيبة,تأبيبتان,تأبيبات,تأبيبة,تأبيبتين,تأبيبات,تأبيبة,تأبيبتين,تأبيبا),M(مؤبب,مؤببا,مؤب)),,C11(O(ائتباب,ائتبابان,ائتبابات,ائتبابا,ائتبابين,ائتبابات,ائتباب,ائتبابين,ائتبابا),N(ائتبابة,ائتبابتان,ائتبابات,ائتبابة,ائتبابتين,ائتبابات,ائتبابة,ائتبابتين,ائتبابا),M(مؤتب,مؤتبا,مؤت)),,C14(O(تأبب,تأببان,تأببات,تأببا,تأببين,تأببات,تأبب,تأببين,تأببا),N(تأببة,تأببتان,تأببات,تأببة,تأببتين,تأببات,تأببة,تأببتين,تأببا),M(متأبب,متأببا,متأب)),)";
//        str=str.substring(str.indexOf("("), str.indexOf(")"));
        String regex = "(.*?)[^(),a-zA-Z\\d*]*";

        String strs = str.replaceAll("[a-zA-Z]", " ");
//        for (String s : strs) {
        pl(str);
//        }
    }

    public static void main(String[] args) {
        Parentheses cls = new Parentheses();
//        cls.start();
//        cls.nested();
        cls.getElements();
//        cls.parentheses();
    }
}
