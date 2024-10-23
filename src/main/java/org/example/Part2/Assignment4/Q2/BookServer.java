package org.example.Part2.Assignment4.Q2;

import org.example.util.Constant;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class BookServer {

    public static void main(String[] args) {

        try {

            BookDbImpl bd = new BookDbImpl();

            // .exportObject(): Remote - Exports the remote object to make it available to receive incoming calls, using the supplied port.
            BookDb stub = (BookDb) UnicastRemoteObject.exportObject(bd, 1098);

            // LocateRegistry - to create a remote object registry that accepts calls on a specific port.
            // createRegistry() - Create and exports a Registry instance on the localhost that accepts requests on the specified port.
            Registry registry = LocateRegistry.createRegistry(1098);

            // rebind() - Replaces the binding for the specified name in this registry
            registry.rebind(Constant.BOOK_DB, stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}