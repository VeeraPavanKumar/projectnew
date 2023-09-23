package hTML1;

import org.jsoup.Jsoup;
import org.jsoup.helper.W3CDom;
import org.jsoup.nodes.Document;
import com.openhtmltopdf.pdfboxout.PdfRendererBuilder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class HtmlToPdfConvertor1 {
    public static void main(String[] args) throws Exception {
        String htmlFilePath = "C:\\Users\\Administrator\\Downloads\\htmlcss.html";

        try {
            Document doc = Jsoup.parse(new File(htmlFilePath), "UTF-8");

            String outputFilePath = "C:\\Users\\Administrator\\Documents\\pp.pdf";

            try (OutputStream os = new FileOutputStream(outputFilePath)) {
                PdfRendererBuilder builder = new PdfRendererBuilder();
                builder.withW3cDocument(new W3CDom().fromJsoup(doc), "/");
                builder.toStream(os); 
                builder.run();
            }

            System.out.println("PDF file generated at: " + outputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
            System.err.println("Error: Unable to load or process the HTML file.");
        }
    }
}