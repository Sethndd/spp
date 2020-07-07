/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;

/**
 *
 * @author midgu
 */
public class PDFCreator {
    
    public static void create(String nameDocument, String content){
    
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, new FileOutputStream(nameDocument));
            document.open();
            Font font = FontFactory.getFont(FontFactory.HELVETICA, 16, BaseColor.BLACK);
            
            Chunk chunk = new Chunk(content, font);
            
            document.add(chunk);
            document.close();
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    
    }
}
