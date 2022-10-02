/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author ALshmowkh
 */
public class ShiftReduceParser2 {

    void test1() throws IOException {
        int no, loc = 0, i, j;
        String str, stack = "", temp;
//        String[][] productions;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter a string: ");
        str = in.readLine(); //id + id
        while (loc < str.length() - 1) {
            temp = str.substring(loc, str.indexOf(' ', loc));
            loc = str.indexOf(' ', loc) + 1;
            System.out.println(loc);
            System.out.println(temp);
//            for (i = 0; i < no; i++) {
////                if (temp.equals(productions[i][1])) {
////                    temp = productions[i][0];
////                    break;
////                }
//            }
            stack = stack + temp;
            System.out.println("Stack contents: " + stack);
//            for (i = 0; i < no; i++) {
//                if (stack.equals(productions[i][1])) {
//                    stack = productions[i][0];
//                    break;
//                }
//            }
        }
        System.out.println("Stack contents: " + stack);
//        if (stack.equals(productions[0][0])) {
//            System.out.println("Accepted.");
//        } else {
//            System.out.println("Rejected.");
//        }
    }

    void shiftParsing() throws IOException {
        int no, loc = 0, i, j;
        String str, stack = "", temp;
        String[][] productions;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no. of productions: ");
        no = Integer.parseInt(in.readLine());
        productions = new String[no][2];
        System.out.println("Enter the productions:");
        for (i = 0; i < no; i++) {
            System.out.print("LHS for production " + (i + 1) + ": ");
            productions[i][0] = in.readLine();
            System.out.print("RHS for production " + (i + 1) + ": ");
            productions[i][1] = in.readLine();
        }
        System.out.println("The productions are:");
        for (i = 0; i < no; i++) {
            System.out.println(productions[i][0] + " -> " + productions[i][1]);
        }
        System.out.print("Enter a string: ");
        str = in.readLine();
        String[] tokens = str.split(" ");
        for (String t : tokens) {
            temp = t;
            for (i = 0; i < no; i++) {
                if (temp.equals(productions[i][1])) {
                    temp = productions[i][0];
                    break;
                }
            }
            stack = stack + temp;
            System.out.println("Stack contents: " + stack);
            for (i = 0; i < no; i++) {
                if (stack.equals(productions[i][1])) {
                    stack = productions[i][0];
                    break;
                }
            }
        }

        System.out.println("Stack contents: " + stack);
        if (stack.equals(productions[0][0])) {
            System.out.println("Accepted.");
        } else {
            System.out.println("Rejected.");
        }
    }

    void shiftParsing2() throws IOException {
        int no, loc = 0, i, j;
        String str, stack = "", temp;
        String[][] productions;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter no. of productions: ");
        no = Integer.parseInt(in.readLine());
        productions = new String[no][2];
        System.out.println("Enter the productions:");
        for (i = 0; i < no; i++) {
            System.out.print("LHS for production " + (i + 1) + ": ");
            productions[i][0] = in.readLine();
            System.out.print("RHS for production " + (i + 1) + ": ");
            productions[i][1] = in.readLine();
        }
        System.out.println("The productions are:");
        for (i = 0; i < no; i++) {
            System.out.println(productions[i][0] + " -> " + productions[i][1]);
        }
        System.out.print("Enter a string: ");
        str = in.readLine();
        String[] tokens = str.split(" ");
        for (String t : tokens) {
            temp = t;
            for (i = 0; i < no; i++) {
                if (temp.equals(productions[i][1])) {
                    temp = productions[i][0];
                    break;
                }
            }
            stack = stack + temp;
            System.out.println("Stack contents: " + stack);
            for (i = 0; i < no; i++) {
                if (stack.equals(productions[i][1])) {
                    stack = productions[i][0];
                    break;
                }
            }
        }

        System.out.println("Stack contents: " + stack);
        if (stack.equals(productions[0][0])) {
            System.out.println("Accepted.");
        } else {
            System.out.println("Rejected.");
        }
    }

    public static void main(String[] args) throws IOException {
        ShiftReduceParser2 cls = new ShiftReduceParser2();
        cls.shiftParsing2();
    }
}

//S = NP VP
//VP = V NP
//VP = V NP PP
//PP = P NP
//NP = DT NN
//NP= John
//NP= Mary
//DT= a
//DT = the
//NN = man
//NN = dog
//NN = cat
//NN = park
//NN = telescope
//P = in
//P = on
//P = with
//S -> NP VP
//VP -> V NP | V NP PP
//PP -> P NP
//V -> "saw" | "ate" | "walked"
//NP -> "John" | "Mary" | "Bob" | Det N | Det N PP
//Det -> "a" | "an" | "the" | "my"
//N -> "man" | "dog" | "cat" | "telescope" | "park"
//P -> "in" | "on" | "by" | "with"
//""")
