package autoTest;

import java.util.List;
import java.util.ArrayList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import opennlp.tools.sentdetect.SentenceModel;

public class RequirementExtractor {
    public static List<String> extractFunctionalRequirements(String text, SentenceModel sentenceModel) {
        List<String> requirements = new ArrayList<>();
        String[] sentences = NLPProcessor.detectSentences(text, sentenceModel);

        for (String sentence : sentences) {
            if (sentence.contains("must") || sentence.contains("should") || sentence.contains("shall")) {
                requirements.add(sentence);
            }
        }
        return requirements;
    }
}
