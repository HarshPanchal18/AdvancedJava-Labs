package org.example.Part2.Assignment4.Q1;

import java.io.FileNotFoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface FileService extends Remote {
    String readFile(String filePath) throws RemoteException, FileNotFoundException;
}