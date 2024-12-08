package com.courseproject.model.invoices;

import com.courseproject.exception.fileException.NullFolderException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Invoices {

    public static void sortInvoices() throws NullFolderException {
        String pathInvoices = "/Users/admin/IdeaProjects/data/invoices";
        File folder = new File(pathInvoices);
        File invalidFolder = new File
                ("/Users/admin/IdeaProjects/TeachMeSkills_Final_Assignment/resourses/InvalidDocument");

        File[] folderInvoices = folder.listFiles();
        if (folderInvoices == null) {
            throw new NullFolderException("Folder invoices are equal null.", 920);
        }

        for (File file : folderInvoices) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.contains("2024") && fileName.endsWith("txt")) {
                    System.out.println(fileName + ": валидный инвойс");
                } else {
                    File invalidFile = new File(invalidFolder, fileName); // создает файл с этим же именем но в папке invalidFolder
                    file.renameTo(invalidFile); // перемещает файл в новую папку с новым путем
                }
            }
        }
    }
}
