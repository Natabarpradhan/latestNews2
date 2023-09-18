package crudoperation.Service;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

@Service
public class PdfService {
    private Logger logger= LoggerFactory.getLogger(PdfService.class);
   public ByteArrayInputStream createPdf() {
       logger.info("create PDF Started:");
       String title = "Welcome to my world";
       String content = "please provide technical content";
       ByteArrayOutputStream out = new ByteArrayOutputStream();

       Document document = new Document();
       PdfWriter.getInstance(document, out);
       document.open();
       Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
       Paragraph titlepara = new Paragraph(title, titleFont);
       titlepara.setAlignment(Element.ALIGN_CENTER);
       document.add(titlepara);
       Font paraFont = FontFactory.getFont(FontFactory.HELVETICA, 18);
       Paragraph paragraph = new Paragraph(content);
       paragraph.add(new Chunk("  this is the greate idea when i plaing it will be greate "));
       document.add(paragraph);
       document.close();
       return new ByteArrayInputStream(out.toByteArray());


   }
}
