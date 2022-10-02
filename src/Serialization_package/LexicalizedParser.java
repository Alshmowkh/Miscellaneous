package Serialization_package;

import edu.stanford.nlp.parser.lexparser.BinaryGrammar;
import edu.stanford.nlp.parser.lexparser.DependencyGrammar;
import edu.stanford.nlp.parser.lexparser.Lexicon;
import edu.stanford.nlp.parser.lexparser.Options;
import edu.stanford.nlp.parser.lexparser.UnaryGrammar;
import edu.stanford.nlp.util.Index;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LexicalizedParser {

    public Lexicon lex;
    public BinaryGrammar bg;
    public UnaryGrammar ug;
    public DependencyGrammar dg;
    public Index<String> stateIndex, wordIndex, tagIndex;

    private Options op;

    public static LexicalizedParser loadModel(String parserFileOrUrl) throws FileNotFoundException, IOException, ClassNotFoundException {
        Options ops = new Options();
        FileInputStream is = new FileInputStream(new File(parserFileOrUrl));
        ObjectInputStream ois = new ObjectInputStream(is);
        LexicalizedParser parser = (LexicalizedParser) ois.readObject();
        ois.close();
        is.close();
        return parser;
    }
       }
