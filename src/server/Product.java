package server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    // Define API

    public String getName() throws RemoteException;
    public String getDescription() throws RemoteException;
    public double getPrice () throws RemoteException;
}
