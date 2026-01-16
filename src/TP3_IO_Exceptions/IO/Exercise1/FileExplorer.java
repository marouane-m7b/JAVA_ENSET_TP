package TP3_IO_Exceptions.IO.Exercise1;

import java.io.File;
import java.util.Scanner;

public class FileExplorer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("The specified path is not a valid directory.");
        } else {
            System.out.println("Listing contents of: " + path);
            File[] files = directory.listFiles();
            
            if (files != null) {
                for (File file : files) {
                    String type = file.isDirectory() ? "<DIR>" : "<FILE>";
                    StringBuilder permissions = new StringBuilder();
                    
                    permissions.append(file.canRead() ? "r" : "-");
                    permissions.append(file.canWrite() ? "w" : "-");
                    permissions.append(file.isHidden() ? "h" : "-");

                    System.out.printf("%s %s %s%n", file.getName(), type, permissions.toString());
                }
            }
        }
        
        scanner.close();
    }
}
