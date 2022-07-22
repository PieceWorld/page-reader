package ru.example.pagereader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Search {

    Extension extension;

    public void testRoot(Extension extension) {
        this.extension = extension;
        String src = "C:\\Users\\Admin\\Desktop\\TestPapka";
        List<File> directories = new ArrayList<>();
        directories.add(new File(src));
        ArrayList<File> fileList = new ArrayList<>();
        fileList = searchFiles(directories, fileList);
        getOutput(fileList);
    }

    private void getOutput(List<File> fileList) {
        System.out.println("Количество документов " + fileList.size());
        System.out.println("Количество страниц в файлах docx " + PagesDocx.pagesDocx(fileList));
        System.out.println("Количество страниц в файлах pdf " + PagesPDF.pagesPDF(fileList));

    }

    private ArrayList<File> searchFiles(List<File> directories, List<File> fileList) {
        for (File files : directories) {
            if (files.isDirectory()) {
                File[] directoryFiles = files.listFiles();
                if (directoryFiles != null) {
                    for (File file : directoryFiles) {
                        if (file.isDirectory()) {
                            List<File> innerDirectories = new ArrayList<>();
                            innerDirectories.add(file);
                            fileList.addAll(searchFiles(innerDirectories, fileList));
                        } else {
                            for (String extension1 : this.extension.extension) {
                                if ((file.getName().toLowerCase().endsWith(extension1)))
                                    fileList.add(file);
                            }
                        }
                    }
                }
            }
        }
    return (ArrayList<File>) fileList;
    }
}