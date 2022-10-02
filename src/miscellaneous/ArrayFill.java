package miscellaneous;

import java.util.Arrays;

public class ArrayFill {

    public static void main(String[] args) {
        int[][] arrInt = new int[10][5];
        Arrays.fill(arrInt[5], -1);
        System.out.println(arrInt[5][3]);
    }
}
