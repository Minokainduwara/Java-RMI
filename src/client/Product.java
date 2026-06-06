package client;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Product extends Remote {
    // Define API

    String getName() throws RemoteException;
    String getDescription() throws RemoteException;
    double getPrice() throws RemoteException;
}
