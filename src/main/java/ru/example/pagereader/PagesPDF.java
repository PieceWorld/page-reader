package ru.example.pagereader;

import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class PagesPDF {
    public static int pagesPDF(List<File> fileList) {
        int numberPagesPDF = 0;
        PdfDocument pdfDoc = null;

        for (File file:fileList) {
            if ((file.getName().toLowerCase().endsWith(".pdf"))){
                try {
                    pdfDoc = new PdfDocument(new PdfReader(file.getAbsolutePath()));
                    numberPagesPDF += pdfDoc.getNumberOfPages();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return numberPagesPDF;
    }
}
