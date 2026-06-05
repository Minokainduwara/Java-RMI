package server;

import java.rmi.RemoteException;

public class ProductImpl implements Product {
    private String name;
    private String description;
    private double price;

    public ProductImpl(String name, String description, double price) throws RemoteException {
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public String getName() throws RemoteException {
        return this.name;
    }

    public String getDescription() throws RemoteException {
        return this.description;
    }

    public double getPrice() throws RemoteException {
        return this.price;
    }


}
