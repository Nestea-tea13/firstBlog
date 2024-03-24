package com.exampleblog.firstblog.services;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.exampleblog.firstblog.Questionnaire.QuestionnaireData;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Service
public class PDFGeneratorService {

    public void export(HttpServletResponse response) throws IOException {
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, response.getOutputStream());
 
        document.open();

        Font fontHeader = FontFactory.getFont("times.ttf","cp1251", BaseFont.EMBEDDED); //FontFactory.TIMES_BOLD
        fontHeader.setSize(22);
 
        Paragraph headerParagraph = new Paragraph("Шаблон опросника", fontHeader);
        headerParagraph.setAlignment(Paragraph.ALIGN_CENTER);
 
        Font fontParagraph = FontFactory.getFont("times.ttf","cp1251", BaseFont.EMBEDDED); //FontFactory.TIMES
        fontParagraph.setSize(14);
 
        Paragraph pdfParagraph = new Paragraph("", fontParagraph);
        pdfParagraph.setAlignment(Paragraph.ALIGN_LEFT);

        for(int i = 1; i <= QuestionnaireData.Questions.length; i++) { 
            pdfParagraph.add(i + ") " + QuestionnaireData.Questions[i - 1] +"\n"); 
            for(int j = 1; j <= QuestionnaireData.AnswerOptions[i - 1].length; j++) {
                pdfParagraph.add(j + ". " + QuestionnaireData.AnswerOptions[i - 1][j - 1] +"\n");
            }
        }
         
        document.add(headerParagraph);
        document.add(pdfParagraph);

        document.close();
    }

}
