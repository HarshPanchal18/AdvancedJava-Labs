package org.example.Part2.Assignment4.Q2;

import org.example.util.Constant;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookClient {
    public static void main(String[] args) {

        try {

            Registry registry = LocateRegistry.getRegistry(Constant.HOST, 1098);
            System.out.println("Got registry...");

            BookDb stub = (BookDb) registry.lookup(Constant.BOOK_DB);

            System.out.println("Searching in DB...");

            System.out.println(stub.getBookById(1));

            System.out.println("Exiting...");

        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}