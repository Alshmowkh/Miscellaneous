package miscellaneous;

import edu.stanford.nlp.util.ArrayUtils;

public class Recursion {

    int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }

    void concatenateTwoArrys() {
        int[] ary1 = {1, 2, 3};
        int[] ary2 = {4, 5, 6};
//    int[] both=(int[]) ArrayUtils.concatenate(ary1, ary2);
        int[] both = new int[ary1.length + ary2.length];
        System.arraycopy(ary1, 0, both, 0, ary1.length);
        System.arraycopy(ary2, 0, both, ary1.length, ary2.length);

        for (int i : both) {
            p(i);
        }
    }

    public static void main(String[] args) {
        Recursion cls = new Recursion();
//        p(cls.factorial(4));
        cls.concatenateTwoArrys();
    }

    static void p(Object o) {
        System.out.println(o);
    }
}
