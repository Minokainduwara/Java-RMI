package server;

import java.rmi.RemoteException;

public class Server {
    public static void main(String[] args) {
        try {

            //Create Product Object
            ProductImpl p1 = new ProductImpl("Product 1", "Description of Product 1", 10.99);
            ProductImpl p2 = new ProductImpl("Product 2", "Description of Product 2", 10.99);
            ProductImpl p3 = new ProductImpl("Product 3", "Description of Product 3", 10.99);
            ProductImpl p4 = new ProductImpl("Product 4", "Description of Product 4", 10.99);
        } catch (RemoteException e) {
            throw new RuntimeException(e);
        }
    }
}
