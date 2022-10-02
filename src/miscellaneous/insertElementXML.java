package miscellaneous;

import java.io.File;
import java.io.IOException;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

public class insertElementXML {

    String directory = "Shom_lib\\xmlfile2.xml";
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    public void XMLFileParse() throws ParserConfigurationException, SAXException, IOException {
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.parse(new File(directory));
        
    }

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerConfigurationException, TransformerException {
        insertElementXML cls=new insertElementXML();
        cls.XMLFileParse();
        Element root=(Element)cls.doc.getElementsByTagName("out_seg").item(0);
        Node newnode=cls.doc.createElement("aden");
        root.appendChild(newnode);
        
        
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();

        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource dom = new DOMSource(cls.doc);
        StreamResult sr = new StreamResult(new File("Shom_lib\\xmlFileOut.xml"));
        t.transform(dom, sr);
//        System.out.println(root.getChildNodes().item(1));
        
        
    }
}
