package miscellaneous;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class ExcelReader {

    String source;
    FileInputStream fis;
    File file;
    Workbook workbook;
    Sheet sheet;
    Row row;

    public ExcelReader() {
        source = "F:\\Teaching\\Courses\\Digital & Logic design\\2016\\Official Affairs\\الكشوفات";
    }

    List<String> getSheetRows(File fil) throws FileNotFoundException, IOException {
        fis = new FileInputStream(fil);
        workbook = new HSSFWorkbook(fis);
        sheet = workbook.getSheetAt(0);
        int numbers = sheet.getPhysicalNumberOfRows();
        List<String> names = new ArrayList();
        for (int i = 10; i < numbers - 10; i++) {
            String cell = sheet.getRow(i).getCell(1).getStringCellValue().trim();
            if ("".equals(cell)) {
            } else {

                names.add(cell);
            }
        }
        return names;
    }

    List<File> getListFiles(String path) {

        File[] files = new File(path).listFiles();
        List<File> listFiles = new ArrayList();
        for (File f : files) {
            if (f.isFile()) {
                if (isXSL(f)) {
                    listFiles.add(f);

                }
            } else {
                List<File> nestedFile = getListFiles(f.getPath());
                listFiles.addAll(nestedFile);
            }
        }
        return listFiles;
    }

    Boolean isXSL(File f) {
        String ext = f.getPath().split("\\.")[1];
        return ext.equals("xls") | ext.equals("xlsx");
    }

    List<String> getNamesFromXLS(String folder) throws IOException {
        List<File> listFiles = this.getListFiles(folder);
        List<String> listNames = new ArrayList();
        for (File f : listFiles) {
            listNames.addAll(this.getSheetRows(f));
        }
        return listNames;
    }

    String[] splitNames(String name) {
        return name.split(" ");
    }

    List<String> noDuplicate(List<String> names) {
        List<String> pureNames = new ArrayList();
        names.stream().map((s) -> this.splitNames(s)).forEach((singles) -> {
            for (String si : singles) {
                if (!pureNames.contains(si)) {
                    pureNames.add(si);
                }
            }
        });
        return pureNames;
    }

    void writeToXML(List<String> listnames) throws TransformerConfigurationException, TransformerException, ParserConfigurationException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();

        Element roots = doc.createElement("names");
        Element root;
        int id = 0;
        for (String s : listnames) {
            if (!"".equals(s.trim())) {
                root = doc.createElement("name");
                root.setAttribute("id", ++id + "");
                root.setAttribute("value", s);
                roots.appendChild(root);
            }
        }
        doc.appendChild(roots);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();

        doc.setXmlStandalone(true);
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setOutputProperty(OutputKeys.VERSION, "1.0");
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource dom = new DOMSource(doc);
        StreamResult sr = new StreamResult(new File("F:\\Master\\Thesis\\Tools\\Lexicons\\Collections\\Person_names.xml"));
        t.transform(dom, sr);
        System.out.println("------------------------have writen done----------------------");
    }

    public static void main(String[] args) throws IOException, TransformerException, TransformerConfigurationException, ParserConfigurationException {
        ExcelReader cls = new ExcelReader();
//        cls.getSheetRows();
//        List<String> temp = cls.getSheetRows(new File("./Shom_lib/2016_2017_2_1_AM_CS_التصميم المنطقي الرقمي.xls"));
        List<String> temp = cls.getNamesFromXLS(cls.source);
        List<String> noDupl = cls.noDuplicate(temp);
        cls.writeToXML(noDupl);
//        noDupl.stream().forEach((n) -> {
//            System.out.println(n);
//        });
//        System.out.println(temp.size());
    }
}
