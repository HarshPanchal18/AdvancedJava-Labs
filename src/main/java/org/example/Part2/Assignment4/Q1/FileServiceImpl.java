package org.example.Part2.Assignment4.Q1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class FileServiceImpl extends UnicastRemoteObject implements FileService {

    public FileServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public String readFile(String filePath) throws RemoteException {
        StringBuilder content = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RemoteException("Error while reading file: " + e.getMessage());
        }

        return content.toString();
    }
}