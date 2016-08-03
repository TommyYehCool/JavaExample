package com.ingenious.test.itextpdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.ListItem;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Section;
import com.itextpdf.text.ZapfDingbatsList;
import com.itextpdf.text.pdf.PdfWriter;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestCreatePdf {
  
  private static Document doc;
  
  private static final String FILE_PATH = "D:\\Test.pdf";
  
  @BeforeClass
  public static void setup() {
    deleteExistedFile();
    
    System.out.println("Prepare to open pdf");
    
    doc = new Document();
    doc.setPageSize(PageSize.A4);
    
    try {
      PdfWriter.getInstance(doc, new FileOutputStream(FILE_PATH)).setInitialLeading(20);
      doc.open();
    } 
    catch (FileNotFoundException e) {
      e.printStackTrace();
    } 
    catch (DocumentException e) {
      e.printStackTrace();
    };
  }
  
  private static void deleteExistedFile() {
    File file = new File(FILE_PATH);
    if (file.exists()) {
      boolean delResult = file.delete();
      if (delResult)
        System.out.println("Delete " + FILE_PATH + " succeed");
    }
  }

  @AfterClass
  public static void teardown() {
    doc.close();
    System.out.println("Create pdf done");
  }

  @Test
  public void testChapter() {
    System.out.println("Prepare to test chapter...");
    
    Paragraph paragraph = new Paragraph();
    paragraph.add(new Phrase("Chapter 1"));
    
    Chapter chap1 = new Chapter(paragraph, 1);

    Section sec1 = chap1.addSection("Download", 2);
    ZapfDingbatsList zapf = new ZapfDingbatsList(40, 30);
    zapf.add(new ListItem("Url"));
    sec1.add(zapf);
    
    Section sec2 = chap1.addSection("Install", 2);
    zapf = new ZapfDingbatsList(40, 30);
    zapf.add(new ListItem("Requirement"));
    sec2.add(zapf);
  
    try {
      doc.add(chap1);
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }

  @Test
  public void testFontAndChunk() {
    System.out.println("Prepare to test font and chunk...");
    
    Font font = new Font(FontFamily.TIMES_ROMAN, 14, Font.BOLD, BaseColor.BLUE);
    try {
      doc.add(new Chunk("Hello World", font));
      doc.add(Chunk.NEWLINE);
      doc.add(new Chunk("This is a testing PDF", font));
      doc.add(Chunk.NEWLINE);
      doc.add(new Paragraph("測試 paragraph"));
    } catch (DocumentException e) {
      e.printStackTrace();
    }
  }
}
