package org.example.Part2.Assignment4.Q2;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookDb extends Remote {

    String getBookById(int id) throws RemoteException;

}