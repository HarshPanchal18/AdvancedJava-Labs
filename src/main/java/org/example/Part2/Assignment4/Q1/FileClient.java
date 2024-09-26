package org.example.Part2.Assignment4.Q1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1999);
            FileService fs = (FileService) registry.lookup("FileService");
            String content = fs.readFile("src/main/java/org/example/content.txt");
            System.out.println("File Content:\n" + content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}