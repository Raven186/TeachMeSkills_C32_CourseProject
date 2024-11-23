package com.courseproject.documentprocessing;

import com.courseproject.exception.fileException.NullFolderException;
import com.courseproject.model.checks.Checks;
import com.courseproject.model.order.Order;
import com.courseproject.model.invoices.Invoices;

import java.io.File;

public class SorterDocuments {

    public static void sorterDocuments(String path) throws NullFolderException {

        File mainFolder = new File(path); // приводим главный путь к главной папке

        File[] subfolders = mainFolder.listFiles(); // создаем массив подпапок в главной папке
        if (subfolders == null) {
            throw new NullFolderException("SubFolders are equal null.", 909);
        }

        for (File folder : subfolders) {
            String folderName = folder.getName().toLowerCase(); // получаем имя папки приводя к нижнему регистру

            if (folderName.contains("orders")) {
                Order.sortOrders();
            }
            if(folderName.contains("invoices")){
                Invoices.sortInvoices();
            }
            if(folderName.contains("checks")){
                Checks.sortChecks();
           }
        }
    }
}


