package org.example.Part2.Assignment4.RmiDemo;

import java.rmi.RemoteException;

public class AdderImpl implements Adder {
    public AdderImpl() throws RemoteException { super(); }

    @Override
    public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}