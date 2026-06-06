package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Server {
    public static void main(String[] args) {
        try {

            //Create Product Object
            ProductImpl p1 = new ProductImpl("Product 1", "Description of Product 1", 10.99);
            ProductImpl p2 = new ProductImpl("Product 2", "Description of Product 2", 10.99);
            ProductImpl p3 = new ProductImpl("Product 3", "Description of Product 3", 10.99);
            ProductImpl p4 = new ProductImpl("Product 4", "Description of Product 4", 10.99);

            //Export p1,p2,p3 and p4 objects using UnicastRemoteObject class
            Product stub1 = (Product) UnicastRemoteObject.exportObject(p1, 0);
            Product stub2 = (Product) UnicastRemoteObject.exportObject(p2, 0);
            Product stub3 = (Product) UnicastRemoteObject.exportObject(p3, 0);
            Product stub4 = (Product) UnicastRemoteObject.exportObject(p4, 0);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
