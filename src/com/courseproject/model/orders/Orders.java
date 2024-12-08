package com.courseproject.model.orders;

import com.courseproject.exception.fileException.NullFolderException;

import java.io.File;

public class Orders {
    public static void sortOrders() throws NullFolderException {
        String pathOrder = "/Users/admin/IdeaProjects/data/orders";
        File folder = new File(pathOrder);
        File invalidFolder = new File
                ("/Users/admin/IdeaProjects/TeachMeSkills_Final_Assignment/resourses/InvalidDocument");

        File[] folderOrders = folder.listFiles();
        if (folderOrders == null) {
            throw new NullFolderException("Folder orders are equal null.", 910);
        }

        for (File file : folderOrders) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.startsWith("2024") && fileName.endsWith("txt")) {
                    System.out.println(fileName + ": валидный ордер");
                } else {
                    File invalidFile = new File(invalidFolder, fileName); // создает файл с этим же именем но в папке invalidFolder
                    file.renameTo(invalidFile); // перемещает файл в новую папку с новым путем
                }
            }
        }
    }
}

