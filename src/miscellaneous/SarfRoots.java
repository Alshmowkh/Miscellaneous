package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SarfRoots {

    String folder;
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    public SarfRoots() throws ParserConfigurationException {
        folder = "F:\\Master\\Thesis\\Tools\\Conjugation\\Sarf_Arabic_Morphology_System\\Alshmowkh_Reference\\db";
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();

    }

    boolean isXML(File f) {
        return f.getPath().split("\\.")[1].trim().equals("xml");
    }

    boolean hasRoots(File f) throws SAXException, IOException {
        doc = db.parse(f);
        Element roots = doc.getDocumentElement();
        return roots.getNodeName().trim().equals("roots");
    }

    List<File> getAllFiles(String path) throws SAXException, IOException {
        File[] fs = new File(path).listFiles();

        List<File> listfs = new ArrayList();
        for (File f : fs) {
            if (f.isFile()) {
                if (isXML(f)) {
                    if (hasRoots(f)) {
                        listfs.add(f);
                    }
                }
            } else {
                listfs.addAll(getAllFiles(f.getPath()));
            }
        }
        return listfs;
    }

    boolean hasC4(NamedNodeMap attrs) {
        Boolean has = false;
        for (int i = 0; i < attrs.getLength(); i++) {
            String chr = attrs.item(i).getNodeName();
            if (chr.trim().equals("c4")) {
                has = true;
            }
        }
        return has;
    }

    List<String> getRoots(File f) throws SAXException, IOException {
        doc = db.parse(f);
        NodeList rootNodes = doc.getElementsByTagName("root");
        List<String> roots = new ArrayList();
        for (int i = 0; i < rootNodes.getLength(); i++) {
            NamedNodeMap chars = rootNodes.item(i).getAttributes();
            String concaret = chars.getNamedItem("c1").getNodeValue()
                    + chars.getNamedItem("c2").getNodeValue()
                    + chars.getNamedItem("c3").getNodeValue();
            if (hasC4(chars)) {
                concaret = concaret + chars.getNamedItem("c4").getNodeValue();
            }
            roots.add(concaret);
        }
        return roots;
    }

    void writeToXML(List<String> listroots) throws TransformerConfigurationException, TransformerException {
        doc = db.newDocument();
        
        Element roots = doc.createElement("roots");
        Element root;
        int id=0;
        for (String s : listroots) {
            root=doc.createElement("root");
            root.setAttribute("id", ++id +"");
            root.setAttribute("value", s);
            roots.appendChild(root);
        }
        doc.appendChild(roots);
        
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        
//        doc.setXmlStandalone(true);
        t.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
        t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
        t.setOutputProperty(OutputKeys.VERSION, "1.0");
        t.setOutputProperty(OutputKeys.INDENT, "yes");

        DOMSource dom = new DOMSource(doc);
        StreamResult sr = new StreamResult(new File(folder+"\\allroots.xml"));
        t.transform(dom, sr);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, TransformerException {
        SarfRoots cls = new SarfRoots();
        List<File> listfs = cls.getAllFiles(cls.folder);
        List<String> roots = new ArrayList();
        for (File f : listfs) {
            roots.addAll(cls.getRoots(f));
        }
        System.out.println(roots.size());
        for (int i = 0; i < 10; i++) {
            System.out.println(roots.get(i));
        }
        cls.writeToXML(roots);

    }
}
