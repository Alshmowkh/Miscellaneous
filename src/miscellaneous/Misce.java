/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

/**
 *
 * @author ALshmowkh
 */
public class Misce {

    void getClassName() {
        String className = getClass().getName();
        pl(className);
        String gerundClassName = getClass().getPackage().getName();// + ".pattern." + "GerundPattern" ;
        pl(gerundClassName);

    }

    void ifInOneLine() {
        String s = "";
        pl(s.isEmpty() ? "Empty" : "Full");
    }

    public static void main(String[] args) {
        Misce cls = new Misce();
//        cls.getClassName();
        cls.ifInOneLine();
    }

    static void pl(Object o) {
        System.out.println(o);
    }
}
