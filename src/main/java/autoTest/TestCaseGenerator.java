package autoTest;

import java.util.ArrayList;
import java.util.List;

public class TestCaseGenerator {
    public static List<String> generateTestCases(List<String> requirements) {
        List<String> testCases = new ArrayList<>();
        int testCaseId = 1;

        for (String requirement : requirements) {
            String testCase = "Test Case " + testCaseId++ + ": " + requirement;
            testCases.add(testCase);
        }
        return testCases;
    }
}
