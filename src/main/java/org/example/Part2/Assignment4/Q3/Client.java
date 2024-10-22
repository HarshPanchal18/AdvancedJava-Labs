package org.example.Part2.Assignment4.Q3;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {

    public static void main(String[] args) {

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1", 1098);

            SysInfo stub = (SysInfo) registry.lookup("SysInfo");

            String osVersion = stub.getOsVersion();
            System.out.println("OS Version: " + osVersion);

            long response = stub.getTotalDiskSpace();
            System.out.println("Free disk space: " + response);

            response = stub.getFreeDiskSpace();
            System.out.println("Free disk space: " + response);

            response = stub.getUsedDiskSpace();
            System.out.println("Used disk space: " + response);

            response = stub.getTotalMemory();
            System.out.println("Total memory: " + response);

            response = stub.getFreeMemory();
            System.out.println("Free memory: " + response);

            response = stub.getUsedMemory();
            System.out.println("Used memory: " + response);

        } catch (RemoteException e) {
            System.err.println("Remote exception: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Client exception: " + e.getMessage());
            System.out.println(e.getMessage());
        }
    }
}