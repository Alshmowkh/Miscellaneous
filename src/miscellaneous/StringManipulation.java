/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static miscellaneous.Misce.pl;

/**
 *
 * @author ALshmowkh
 */
public class StringManipulation {

    static void p(Object o) {
        System.out.println(o);
    }

    void stringSelection() {
        String item = "wiraAvap_n1AR";
        p(item);
        p(item.length() - 1);
        p(item.endsWith("AR"));
        p(item.lastIndexOf("p"));
        p(item.lastIndexOf("_") + 2);
        p(item.charAt(12));
        p(String.valueOf('j'));
        p(String.valueOf(item.charAt(item.lastIndexOf("_") + 1)));
        p(item.substring(item.length() - 2, item.length()));
    }

    void split() {
        String str = "قررنا الابتعاد مؤقتا في هذه الزاوية عن الملفات العربية المعتادة مثل سورية واليمن والحروب الدائرة فيها او حولها، عسكريا ودبلوماسيا، بحثا عن جديد لتجنب ملل القارئ العزيز على قلوبنا، والحفاظ على اهتمامه، ومودته، معا، فاستوقفنا حدثان سياسيان ينطويان على الكثير من المعاني والدروس والعبر، وان كنا لا نستطيع فصلهما كليا عن منطقتنا العربية:\n"
                + "الأول: اعلان مكتب الرئيس النيجيري محمد بخاري (منتخب ديمقراطيا)، ان الرئيس طلب من البرلمان تمديد اجازته المرضية بعد ان قضى أسبوعين لاجراء فحوص طبية في بريطانيا، وذلك لاستكمال هذه الفحوص التي أوصى بها اطباؤه، وانتظار النتائج.";
        String str2 = "عبد الله";
        String[] split = str2.split("([^\u067E\u0686\u0698\u06AF\u0621-\u0636\u0637-\u0643\u0644\u0645-\u0648\u0649-\u064A\u064B-\u064E\u064F\u0650\u0651\u0652]+)");

        for (String s : split) {
            p(s);
        }
    }

    void printWithColor() {
        String what = "what";
        System.out.println((char) 27 + "[32m" + what + (char) 27 + "[0m");
    }

    void miss() {
        String str = "اليمن";
        pl(str.substring(2, 4));
//        String[] split="و_ب_استهداف/ه".split("_");
//        pl(split.length);
//        for (int i = 0; i < split.length - 1; i++) {
//                    pl(split[i]);
//                }
//        String line = "لكم";
//        pl(line.substring(0, 1));
    }

    void hasNumber() {
        String str = "اليمن 8اليماني";
        boolean has;
        str = "1asdf";
        pl(str.matches("\\d+.*"));
    }

    void substring() {
        String str = "مُقابَلَتكُنَّ";
        pl(str.length());
        pl(str.substring(0, str.length() - 1));

    }

    void stringBuilder() {
        StringBuilder sb = new StringBuilder();
        sb.append("yemen");
        sb.deleteCharAt(sb.length() - 1);
//        sb.append(null);
        pl(sb.toString());
    }

    void contains() {
        String str = "يمن جديد.";
        pl(str.split("جد").length);
    }

    void index() {
        String str = "يمن جديد.";
//        pl(line.codePointAt(5));
        pl(str.charAt(0));
    }

    void readToSpecific() {
        String str = "bakeel";
        Pattern p;
        Matcher m;
        String reg = ".*k";
        p = Pattern.compile(reg);
        m = p.matcher(str);
        while (m.find()) {
            pl(m.group());
        }
        reg = str.split(".*k")[0];
        pl(reg);
    }

    void match() {
        String str = "(2:137:16:1)	{ll~ahu	PN	STEM|POS:PN|LEM:{ll~ah|ROOT:Alh|NOM";
        pl(str.matches(".*STEM.*"));

    }

    void lastIndex() {
        String str = "abc_de_jh";
        pl(str.substring(str.lastIndexOf("_") + 1));
    }

    public static boolean isArabic(String character) {
        if (character.trim().isEmpty()) {
            return false;
        }
        Map map = new HashMap();
        map.put("\u0621", "'");
        map.put("\u0622", "|");
        map.put("\u0623", ">");
        map.put("\u0624", "&");
        map.put("\u0625", "<");
        map.put("\u0626", "}");
        map.put("\u0627", "A");
        map.put("\u0628", "b");
        map.put("\u0629", "p");
        map.put("\u062A", "t");
        map.put("\u062B", "v");
        map.put("\u062C", "j");
        map.put("\u062D", "H");
        map.put("\u062E", "x");
        map.put("\u062F", "d");
        map.put("\u0630", "*");
        map.put("\u0631", "r");
        map.put("\u0632", "z");
        map.put("\u0633", "s");
        map.put("\u0634", "$");
        map.put("\u0635", "S");
        map.put("\u0636", "D");
        map.put("\u0637", "T");
        map.put("\u0638", "Z");
        map.put("\u0639", "E");
        map.put("\u063A", "g");
        map.put("\u0640", "_");
        map.put("\u0641", "f");
        map.put("\u0642", "q");
        map.put("\u0643", "k");
        map.put("\u0644", "l");
        map.put("\u0645", "m");
        map.put("\u0646", "n");
        map.put("\u0647", "h");
        map.put("\u0648", "w");
        map.put("\u0649", "Y");
        map.put("\u064A", "y");
        map.put("\u064B", "F");
        map.put("\u064C", "N");
        map.put("\u064D", "K");
        map.put("\u064E", "a");
        map.put("\u064F", "u");
        map.put("\u0650", "i");
        map.put("\u0651", "~");
        map.put("\u0652", "o");
        map.put("\u0670", "`");
        map.put("\u0652", "{");

        return map.containsKey(character.charAt(0));
    }

    void matchOnlyArabicCharacter() {
        String line = " آلة موسيقية match arbic character in java آلة موسيقية";
        String[] slices = line.split("\\s");
        int k = 0;
        String value = slices[k++].trim();
        while (value.isEmpty() || isArabic(value)) {
            value = slices[k++].trim();
            value += "_" + slices[k].trim();
        }
//        while (isArabic(slices[k++].trim())) {
//           
//        }
        pl(value);
        line = value + " " + line.substring(value.length() + 1, line.length());
        pl(line);
    }

    public static void main(String[] args) {
        StringManipulation cls = new StringManipulation();
        cls.matchOnlyArabicCharacter();
//        cls.lastIndex();
//        cls.readToSpecific();
//        cls.index();
//        cls.contains();
//        cls.stringBuilder();
//        cls.printWithColor();
//        cls.miss();
//        cls.hasNumber();
//        cls.substring();
//        cls.match();
    }
}
