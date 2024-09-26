package org.example.Part2.Assignment4.Q1;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class FileServer {
    public static void main(String[] args) {
        try {
            FileService fs = new FileServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1999);
            registry.rebind("FileService", fs);
            System.out.println("File server is ready.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}