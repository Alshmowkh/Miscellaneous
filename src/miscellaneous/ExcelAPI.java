/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package miscellaneous;

import java.io.File;
import java.io.IOException;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 *
 * @author bakee
 */
public class ExcelAPI {

    private void ini() {
        //create workbook
        WritableWorkbook wwb;
        try {
            wwb = Workbook.createWorkbook(new File("F:\\Master\\Thesis\\Prototype\\Dataset\\awn.xls"));
            //create sheet
            WritableSheet sheet = wwb.createSheet("words", 0);
            //add something into sheet 0
            Label lbl = new Label(0, 0, "word");
            sheet.addCell(lbl);
            lbl = new Label(0, 1, "1");
            sheet.addCell(lbl);
            lbl = new Label(1, 0, "result");
            sheet.addCell(lbl);
            wwb.write();
            wwb.close();
        } catch (IOException | WriteException ex) {

        }
    }

    public static void main(String[] args) {
        ExcelAPI ex = new ExcelAPI();
        ex.ini();
    }
}
