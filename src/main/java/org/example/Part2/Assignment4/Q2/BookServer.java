package org.example.Part2.Assignment4.Q2;

import org.example.util.Constant;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            BookDbImpl bd = new BookDbImpl();
            BookDb stub = (BookDb) UnicastRemoteObject.exportObject(bd, 0);

            // LocateRegistry - to create a remote object registry that accepts calls on a specific port.
            // createRegistry() - Create and exports a Registry instance on the local host that accepts requests on the specified port.
            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind(Constant.BOOK_DB, stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}