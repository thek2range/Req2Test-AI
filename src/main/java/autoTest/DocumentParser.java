package autoTest;

//Example using Apache POI for a Word document
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import java.io.FileInputStream;
import java.io.IOException;

public class DocumentParser {
 public static String extractText(String filePath) throws IOException {
     FileInputStream fis = new FileInputStream(filePath);
     XWPFDocument document = new XWPFDocument(fis);
     StringBuilder text = new StringBuilder();
     document.getParagraphs().forEach(paragraph -> text.append(paragraph.getText()).append("\n"));
     return text.toString();
 }
}
