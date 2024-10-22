package org.example.Part2.Assignment4.RmiDemo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class MyClient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1098);

            Adder stub = (Adder) registry.lookup("Adder");

            int response = stub.add(4, 8);
            System.out.println("Response: " + response);
        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}