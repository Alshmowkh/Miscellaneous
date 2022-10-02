package Rhe_Package;

import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class GlossaryExtractor {

    static String sourceDic = "./Shom_lib/Babylon Glossary/Babylon_Arabic_English2.xml";
    static String glossaryFile = "./Shom_lib/Babylon Glossary/Babylon_Glossary2.xml";

    static void print(Object str) {
        System.out.println(str);
    }

    static void extractor() throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException {
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(new File(sourceDic));

        Document docTgt = db.newDocument();
        Element entriesNode = docTgt.createElement("entries");
        Element entryNode;// = docTgt.createElement("entry");
        
        Element root = doc.getDocumentElement();
        XPath xpath = XPathFactory.newInstance().newXPath();
        NodeList entrs = (NodeList) xpath.evaluate("//idx_entry", root, XPathConstants.NODESET);
        print(entrs.getLength());
        int id = 0;
        String arb, eng;
        for (int i = 0; i < entrs.getLength(); i++) {
            NodeList childs = entrs.item(i).getChildNodes();
            id++;
            eng = childs.item(3).getChildNodes().item(0).getChildNodes().item(0).getChildNodes().item(0).getTextContent();
            arb = childs.item(1).getTextContent().trim();
            Boolean hasInfl = false;
            if (childs.item(1).getChildNodes().getLength() > 1) {
                if (childs.item(1).getChildNodes().item(1).getChildNodes().getLength() > 1) {
                    hasInfl = true;
                    //get entry inflections
//                for (int j = 0; j < childs.item(1).getChildNodes().item(1).getChildNodes().getLength(); j++) {
//                    if(childs.item(1).getChildNodes().item(1).getChildNodes().item(j).getNodeType() == Element.ELEMENT_NODE)
//                    print(childs.item(1).getChildNodes().item(1).getChildNodes().item(j).getAttributes().getNamedItem("value").getNodeValue());
                }
            }
//            System.out.println(id + "\t" + hasInfl + "\t" + arb + "\t" + eng);
            //saveing to babylon glossary

            entryNode = docTgt.createElement("entry");
            entryNode.setAttribute("id", id + "");
            entryNode.setAttribute("arb", arb);
            entryNode.setAttribute("eng", eng);
            entryNode.setAttribute("infl", hasInfl + "");
            entriesNode.appendChild(entryNode);
        }
        
        docTgt.appendChild(entriesNode);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        DOMSource dom = new DOMSource(docTgt);

        StreamResult sr = new StreamResult(new File(glossaryFile));
        t.transform(dom, sr);
    }

    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException, TransformerException {
        extractor();
    }
}
