package ru.example.pagereader;

import lombok.Data;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

@Data
public class PagesDocx {
    public static int pagesDocx(List<File> fileList) {
        int numberPagesDocx = 0;
        FileInputStream fis = null;
        XWPFDocument doc = null;

        for (File file : fileList) {
            if ((file.getName().toLowerCase().endsWith(".docx"))) {
                try {
                    fis = new FileInputStream(file.getAbsolutePath());
                    doc = new XWPFDocument(fis);
                    } catch (IOException e) {
                    e.printStackTrace();
                }
                numberPagesDocx += doc.getProperties().getExtendedProperties().getUnderlyingProperties().getPages();
            }
        }
        return numberPagesDocx;
    }
}