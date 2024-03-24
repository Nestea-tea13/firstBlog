package com.exampleblog.firstblog.controllers;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.exampleblog.firstblog.services.PDFGeneratorService;

import jakarta.servlet.http.HttpServletResponse;

@Controller
public class PDFExportController {
    
    @Autowired
    PDFGeneratorService pdfGeneratorService;
 
    @GetMapping("/exportpdf")
    public String createPDF(HttpServletResponse response, Model model) throws IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd:hh:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
 
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
 
        pdfGeneratorService.export(response);
        return "redirect:/about";
    }
}
