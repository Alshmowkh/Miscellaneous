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
public class CMD_Exec {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

//        String command="tasklist > H:\\tasklist.txt";
        String fullcmd="cmd /c dir H:\\";
        //---------------- Full windows command fragmentations"
        String Precommand="cmd /c";
        String doscommand="dir";
        String directory="H:\\";
        //------------------ end block
        String cmd2="dir";
        String command="java -Xmx2500m -Xms2500m -XX:NewRatio=3 -jar MADAMIRA-release-20150421-2.1.jar -i samples\\xml\\SampleInputFile11.xml  -o  samples\\xml\\SampleOutputFile11.xml";
//        String root="/c";
        String root="F:\\Master\\Thesis\\Tools\\Madamira\\MADAMIRA-release-20150421-2.1";
        String[] cmd = {"cmd.exe",root, cmd2};
        
        //----------------Process
        Process p = Runtime.getRuntime().exec("cmd /c java -version");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String temp = "";
        while ((temp = input.readLine()) != null) {
            System.out.println(temp);
        }

        input.close();
    }

}
