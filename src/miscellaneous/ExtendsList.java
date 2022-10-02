/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * @author bakee
 */
public class ExtendsList extends ArrayList {

    void test() {
        this.add("some thing");
    }

    public static void main(String[] args) {
        ExtendsList cls = new ExtendsList();
        cls.add(cls);
        pl(cls.size());
    }

    static void pl(Object o) {
        System.out.println(o);
    }
}
