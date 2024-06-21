package autoTest;

import opennlp.tools.sentdetect.SentenceDetectorME;
import opennlp.tools.sentdetect.SentenceModel;
import opennlp.tools.tokenize.SimpleTokenizer;
import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

import java.io.FileInputStream;
import java.io.IOException;

public class NLPProcessor {
    public static String[] tokenize(String text) {
        SimpleTokenizer tokenizer = SimpleTokenizer.INSTANCE;
        return tokenizer.tokenize(text);
    }

    public static SentenceModel loadSentenceModel(String modelPath) throws IOException {
        try (FileInputStream modelIn = new FileInputStream(modelPath)) {
            return new SentenceModel(modelIn);
        }
    }

    public static String[] detectSentences(String text, SentenceModel model) {
        SentenceDetectorME detector = new SentenceDetectorME(model);
        return detector.sentDetect(text);
    }

    public static String[] posTag(String[] tokens, POSModel model) {
        POSTaggerME tagger = new POSTaggerME(model);
        return tagger.tag(tokens);
    }
}
