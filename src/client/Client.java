package client;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Get the reference of exported object from RMI Registry
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }

    }
}
