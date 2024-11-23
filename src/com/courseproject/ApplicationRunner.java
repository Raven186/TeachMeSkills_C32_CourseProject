package com.courseproject;

import com.courseproject.exception.fileException.NullFolderException;
import com.courseproject.documentprocessing.SorterDocuments;

import java.io.IOException;
import java.util.Scanner;

public class ApplicationRunner {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the file: ");
        String path = scanner.nextLine();
        scanner.close();
        try {
            SorterDocuments.sorterDocuments(path);
        } catch (NullFolderException e) {
            System.out.println(e.getMessage());
        }
    }
}
