package autoTest;

import java.io.IOException;
import java.util.List;
import opennlp.tools.sentdetect.SentenceModel;
//https://opennlp.apache.org/models.html
public class Main {
    public static void main(String[] args) {
        try {
            String filePath = "C:\\Users\\phalg\\eclipse-workspace\\autoTest\\src\\test\\resources\\srs_example_2010_group2.docx";
            String modelPath = "C:\\Users\\phalg\\eclipse-workspace\\autoTest\\src\\test\\resources\\opennlp-en-ud-ewt-sentence-1.0-1.9.3.bin"; // Path to the sentence detection model

            String text = DocumentParser.extractText(filePath);

            // Load the sentence model
            SentenceModel sentenceModel = NLPProcessor.loadSentenceModel(modelPath);

            List<String> requirements = RequirementExtractor.extractFunctionalRequirements(text, sentenceModel);
            List<String> testCases = TestCaseGenerator.generateTestCases(requirements);

            for (String testCase : testCases) {
                System.out.println(testCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
