package org.example.Part2.Assignment4.Q3;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SysInfo extends Remote {
    String getOsVersion() throws RemoteException;

    long getTotalDiskSpace() throws RemoteException;

    long getFreeDiskSpace() throws RemoteException;

    long getUsedDiskSpace() throws RemoteException;

    long getTotalMemory() throws RemoteException;

    long getFreeMemory() throws RemoteException;

    long getUsedMemory() throws RemoteException;
}