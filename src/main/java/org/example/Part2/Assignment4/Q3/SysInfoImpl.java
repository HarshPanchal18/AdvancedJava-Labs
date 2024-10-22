package org.example.Part2.Assignment4.Q3;

import java.io.File;
import java.rmi.RemoteException;

public class SysInfoImpl implements SysInfo {

    protected SysInfoImpl() throws RemoteException {
        super();
    }

    @Override
    public String getOsVersion() throws RemoteException {
        return System.getProperty("os.version");
    }

    @Override
    public long getTotalDiskSpace() throws RemoteException {
        return new File("/").getTotalSpace();
    }

    @Override
    public long getFreeDiskSpace() throws RemoteException {
        return new File("/").getFreeSpace();
    }

    @Override
    public long getUsedDiskSpace() throws RemoteException {
        return new File("/").getUsableSpace();
    }

    @Override
    public long getTotalMemory() throws RemoteException {
        return Runtime.getRuntime().totalMemory();
    }

    @Override
    public long getUsedMemory() throws RemoteException {
        return getTotalMemory() - getFreeMemory();
    }

    @Override
    public long getFreeMemory() throws RemoteException {
        return Runtime.getRuntime().freeMemory();
    }

}