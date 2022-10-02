/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 *
 * @author ALshmowkh
 */
public class HtmlCreater {

    String source = "F:\\Master\\Thesis\\Implementations\\SAARR\\Rhe_lib\\Corpus\\Corpora 02\\htmlExample.txt";
    String dest = "F:\\Master\\Thesis\\Implementations\\SAARR\\Rhe_lib\\Corpus\\Corpora 02\\htmlExample2.html";

    void create1() throws FileNotFoundException, IOException {
        BufferedReader txtfile = new BufferedReader(new FileReader(source));
        OutputStream htmlfile = new FileOutputStream(new File(dest));
        PrintStream printhtml = new PrintStream(htmlfile);

        String[] txtbyLine = new String[500];
        String temp = "";
        String txtfiledata = "";

        String htmlheader = "<html><head>";
        htmlheader += "<title>Equivalent HTML</title>";
        htmlheader += "</head><body>";
        String htmlfooter = "</body></html>";
        int linenum = 0;

        while ((txtfiledata = txtfile.readLine()) != null) {
            txtbyLine[linenum] = txtfiledata;
            linenum++;
        }
        for (int i = 0; i < linenum; i++) {
            if (i == 0) {
                temp = htmlheader + txtbyLine[0];
                txtbyLine[0] = temp;
            }
            if (linenum == i + 1) {
                temp = txtbyLine[i] + htmlfooter;
                txtbyLine[i] = temp;
            }
            printhtml.println(txtbyLine[i]);
        }

        printhtml.close();
        htmlfile.close();
        txtfile.close();

    }

    void create2() throws FileNotFoundException, IOException {
//        BufferedReader txtfile = new BufferedReader(new FileReader(source));
        OutputStream htmlfile = new FileOutputStream(new File(dest));
        PrintStream printhtml = new PrintStream(htmlfile);

        String htmlheader = "<html dir='RTL'><head>";
        String title = "<title>Equivalent HTML</title>";
        String endhead = "</head><body>";
        String body = "<table border='5'  bgcolor='#f5f6fa'>\n"
                + "<tr><td>\n"
                + "  <h1>London</h1></td><td>sana'a</td></tr><tr><td>\n"
                + "  <p>London is the capital city of England. It is the most populous city in the  United Kingdom, with a metropolitan area of over 13 million inhabitants.</p></td><td>sana'a</td></tr><tr><td>\n"
                + "  <p>Standing on the River Thames, London has been a major settlement for two millennia, its history going back to its founding by the Romans, who named it Londinium.</p></td><td>sana'a</td></tr> \n"
                + "  <tr><td>yemen</td><td>sana'a</td></tr></table>";
        String htmlfooter = "</body></html>";

        String temp = "<!DOCTYPE html>\n"
                + "<html dir='RTL'>\n"
                + "<head>\n"
                + "<style>\n"
                + "div.container {\n"
                + "    width: 100%;\n"
                + "    border: 1px solid gray;\n"
                + "}\n"
                + "\n"
                + "header, footer {\n"
                + "    padding: 1em;\n"
                + "    color: white;\n"
                + "    background-color: #9a121b;\n"
                + "    clear: left;\n"
                + "    text-align: center;\n"
                + "}\n"
                + "\n"
                + "\n"
                + "\n"
                + "   \n"
                + "\n"
                + "\n"
                + "article {\n"
                + "    margin-left: 50px;\n"
                + "     margin-right: 20px;\n"
                + "    border-left: 5px solid gray;\n"
                + "        border-right: 1px solid gray;\n"
                + "    padding: 1em;\n"
                + "    overflow: hidden;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<div class=\"container\">\n"
                + "\n"
                + "<header>\n"
                + "   <h1>City Gallery</h1>\n"
                + "</header>\n"
                + "  \n"
                + "\n"
                + "\n"
                + "<article>\n"
                + body
                + "</article>\n"
                + "\n"
                + "<footer>Copyright &copy; W3Schools.com</footer>\n"
                + "\n"
                + "</div>\n"
                + "\n"
                + "</body>\n"
                + "</html>";
//        printhtml.println(htmlheader);
//        printhtml.println(title);
//        printhtml.println(endhead);
//        printhtml.println(body);

        printhtml.println(temp);

//                
        printhtml.close();
        htmlfile.close();
//        txtfile.close();

    }

    void readFile1(String path) throws IOException {
        File fin = new File(path);
        FileInputStream fis = new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));

        String line = null;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }

        br.close();
    }

    public static void main(String[] args) throws IOException {
        HtmlCreater cls = new HtmlCreater();
        cls.create2();
    }
}
