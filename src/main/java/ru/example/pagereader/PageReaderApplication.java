package ru.example.pagereader;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PageReaderApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(PageReaderApplication.class, args);
        Extension extension = new Extension();
        extension.extension.add(".docx");
        extension.extension.add(".pdf");
        Search search = new Search();
        search.testRoot(extension);
    }
}
