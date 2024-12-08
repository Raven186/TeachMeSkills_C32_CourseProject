package com.courseproject.model.checks;

import com.courseproject.exception.fileException.NullFolderException;

import java.io.File;

public class Checks {

    public static void sortChecks() throws NullFolderException {
        String pathChecks = "/Users/admin/IdeaProjects/data/checks";
        File folder = new File(pathChecks);
        File invalidFolder = new File
                ("/Users/admin/IdeaProjects/TeachMeSkills_Final_Assignment/resourses/InvalidDocument");

        File[] folderChecks = folder.listFiles();
        if (folderChecks == null) {
            throw new NullFolderException("Folder checks are equal null.", 930);
        }

        for (File file : folderChecks) {
            if (file.isFile()) {
                String fileName = file.getName();
                if (fileName.startsWith("2024") && fileName.endsWith("txt")) {
                    System.out.println(fileName + ": валидный чек");
                } else {
                    File invalidFile = new File(invalidFolder, fileName); // создает файл InvalidFile с этим же именем но в папке invalidFolder
                    file.renameTo(invalidFile); // перемещает файл в новую папку с новым путем
                }
            }
        }
    }
}
