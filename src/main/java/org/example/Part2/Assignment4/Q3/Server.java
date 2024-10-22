package org.example.Part2.Assignment4.Q3;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            SysInfoImpl si = new SysInfoImpl();
            SysInfo stub = (SysInfo) UnicastRemoteObject.exportObject(si, 0);

            Registry registry = LocateRegistry.createRegistry(1098);
            registry.rebind("SysInfo", stub);

            System.out.println("Server ready");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}