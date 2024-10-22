package org.example.Part2.Assignment4.RmiDemo;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class MyServer {
    public static void main(String[] args) {
        try {

            AdderImpl adderImpl = new AdderImpl();
            Adder stub = (Adder) UnicastRemoteObject.exportObject(adderImpl, 0);

            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("Adder", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}