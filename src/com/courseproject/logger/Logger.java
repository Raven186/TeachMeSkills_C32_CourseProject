package com.courseproject.logger;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class Logger {

    public static void actionLogs(String message){

        String path = "/Users/admin/IdeaProjects/data/logger/ActionLogs.txt";
        try {
            List<String> lines = new ArrayList<>();
            lines.add(message);
            Files.write(Paths.get(path), lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void errorLogs(String message){

        String path = "/Users/admin/IdeaProjects/data/logger/ErrorLogs.txt";
        try {
            List<String> lines = new ArrayList<>();
            lines.add(message);
            Files.write(Paths.get(path), lines, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
