package miscellaneous;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
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
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XMLFileCreate {

    String directory = "F:\\Master\\Thesis\\Implementations\\Rhe_Processes\\Rhe_lib\\Clauses";
    DocumentBuilderFactory dbf;
    DocumentBuilder db;
    Document doc;

    public XMLFileCreate() throws ParserConfigurationException {
        dbf = DocumentBuilderFactory.newInstance();
        db = dbf.newDocumentBuilder();
        doc = db.newDocument();
    }

    Element createBody() throws ParserConfigurationException {
        Element root = doc.createElement("Rhetorical_Corpora");
        // create elements
        Element documents = doc.createElement("documents");
        Element document = doc.createElement("document");
        Element sentences = doc.createElement("sentences");
        Element sentence = doc.createElement("sentence");
        Element clauses = doc.createElement("clauses");
        Element clause = doc.createElement("clause");
        Element words = doc.createElement("words");
        Element word = doc.createElement("word");
        Element morphemes = doc.createElement("morphemes");
        Element morph = doc.createElement("morph");
        //set attributes
        document.setAttribute("id", "");
        sentence.setAttribute("id", "");
        clause.setAttribute("id", "");
        clause.setAttribute("value", "");
        word.setAttribute("id", "");
        word.setAttribute("value", "");
        morph.setAttribute("id", "");
        morph.setAttribute("tag", "");
        morph.setAttribute("value", "");
        //binding
        morphemes.appendChild(morph);
        word.appendChild(morphemes);
        words.appendChild(word);
        clause.appendChild(words);
        clauses.appendChild(clause);
        sentence.appendChild(clauses);
        sentences.appendChild(sentence);
        document.appendChild(sentences);
        documents.appendChild(document);
        root.appendChild(documents);
        if (root.getChildNodes().getLength() >= 1) {
            System.out.println("more than 2");
        }
        return root;
    }

    void writeXML() throws TransformerException, ParserConfigurationException {
        doc.setXmlStandalone(true);

        doc.appendChild(createBody());
        //save xml doc
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();

        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        DOMSource dom = new DOMSource(doc);
        StreamResult sr = new StreamResult(new File(directory + "\\xmlFile.xml"));
        t.transform(dom, sr);
    }

    void intended() throws ParserConfigurationException, SAXException, IOException, TransformerException {
        String path = "F:\\Master\\Thesis\\Implementations\\SAARR\\Rhe_lib\\Corpus\\Corpora 04\\ESFdoc.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();

        File file = new File(path);
//        StringReader strRdr = new StringReader(path);
//        InputSource in = new InputSource(file);

        doc = builder.parse(file);

        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer t = tf.newTransformer();
        tf.setAttribute("indent-number", 2);
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

        t.transform(new DOMSource(doc), new StreamResult(System.out));

    }

    public static void main(String[] args) throws ParserConfigurationException, TransformerConfigurationException, TransformerException, IOException, SAXException {
        XMLFileCreate cls = new XMLFileCreate();
        cls.intended();
    }
}
