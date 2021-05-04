package co.edu.uts.sistemas.pedidosuts;

import java.util.ArrayList;

import co.edu.uts.sistemas.pedidosuts.model.Client;
import co.edu.uts.sistemas.pedidosuts.model.Product;

public class Information {

    public static final String user = "hans";
    public static final String password = "1234";
    public static Product product;
    public static final ArrayList<Product> products = new ArrayList<>();
    public static final void loadProducts() {
        Product productOne = new Product("0001", "PC", 1250000);
        products.add(productOne);
        Product productTwo = new Product("0002", "Phone", 700000);
        products.add(productTwo);
    }
    public static Client client;
    public static final ArrayList<Client> clients = new ArrayList<>();
    public static final void loadClients() {
        Client client = new Client(1102372728, "Hans Rasch", "3001234567", "Cra 1 #1-1");
        clients.add(client);
    }
}
