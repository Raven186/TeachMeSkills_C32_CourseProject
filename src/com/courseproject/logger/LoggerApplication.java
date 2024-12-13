package com.courseproject.logger;

import java.io.IOException;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LoggerApplication {

    public static void main(String[] args) {
        String username = "user";
        String password = "password";

        if (login(username, password)) {
            Logger.actionLogs("User logged in");

            try {
                processFolder("invoices");
                processFolder("orders");
                processFolder("checks");

                Logger.actionLogs("End of work \n----------------------------------------\n");
            } catch (Exception e) {
                Logger.errorLogs("Processing error: " + e.getMessage());
            }
        } else {
            Logger.errorLogs("Login error: incorrect login or password");
        }
    }

    private static boolean login(String username, String password) {
        return "user".equals(username) && "password".equals(password);
    }

    private static void processFolder(String folderName) throws IOException {
        Logger.actionLogs("The path to the folder was obtained: " + folderName);
        Logger.actionLogs("Start processing " + folderName);

        Path folderPath = Paths.get("E:\\TeachMeSkills_Final_Assignment\\resourses\\" + folderName);

        if (!Files.exists(folderPath)) {
            Logger.errorLogs("Folder not found:" + folderName);
            return;
        }

        try (DirectoryStream<Path> files = Files.newDirectoryStream(folderPath)) {
            for (Path file : files) {
                if (Files.isRegularFile(file)) {
                    Logger.actionLogs("File being processed: " + file.getFileName());
                }
            }
        }

        Logger.actionLogs(folderName + " processed");
    }
}

class Logger {

    private static final String ACTION_LOG_PATH = "D:\\Java\\TeachMeSkills_Final_Assignment\\resourses\\loggers\\ActionLogs.txt";
    private static final String ERROR_LOG_PATH = "D:\\Java\\TeachMeSkills_Final_Assignment\\resourses\\loggers\\ErrorsLogs.txt";

    public static void actionLogs(String message) {
        log(ACTION_LOG_PATH, message);
    }

    public static void errorLogs(String message) {
        log(ERROR_LOG_PATH, message);
    }

    private static void log(String path, String message) {
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            String logMessage = timestamp + " - " + message + System.lineSeparator();
            Files.write(Paths.get(path), logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Failed to write log: " + e.getMessage());
        }
    }
}

