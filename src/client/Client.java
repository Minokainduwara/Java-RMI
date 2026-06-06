package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) {
        try {
            // Locate the registry
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",1099);

            // Get the reference of exported object from RMI Registry
            Product laptop = (Product)registry.lookup("Product1");
            Product laptop2 = (Product)registry.lookup("Product2");
            Product laptop3 = (Product)registry.lookup("Product3");
            Product laptop4 = (Product)registry.lookup("Product4");

            //Now we can invoke the method of the reference objects.
            System.out.println("Product Name: " + laptop.getName());
            System.out.println("Product Description: " + laptop.getDescription());
            System.out.println("Product Price: " + laptop.getPrice());

        } catch (RemoteException e) {
            throw new RuntimeException(e);
        } catch (NotBoundException e) {
            throw new RuntimeException(e);
        }

    }
}
