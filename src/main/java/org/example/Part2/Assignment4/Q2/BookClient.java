package org.example.Part2.Assignment4.Q2;

import org.example.util.Constant;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.sql.Connection;
import java.sql.DriverManager;

public class BookClient {
    public static void main(String[] args) {

        try {

            Class.forName(Constant.MYSQL_DRIVER);
            Connection connection = DriverManager.getConnection(Constant.BOOK_DB_URL, Constant.DB_USERNAME, Constant.DB_PASSWORD);

            Registry registry = LocateRegistry.getRegistry(Constant.HOST, 1098);

            BookDb stub = (BookDb) registry.lookup(Constant.BOOK_DB);
            stub.getBookById(connection, 1);

        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
        }
    }
}