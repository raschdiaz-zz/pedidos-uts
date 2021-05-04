package co.edu.uts.sistemas.pedidosuts;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import co.edu.uts.sistemas.pedidosuts.database.DataBase;
import co.edu.uts.sistemas.pedidosuts.database.ProductDAO;
import co.edu.uts.sistemas.pedidosuts.model.Product;

public class StorageActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        DataBase dataBase = new DataBase(getApplicationContext());
        ProductDAO productDAO = new ProductDAO(dataBase);
        Product product = new Product("PROD001", "Computador Electronico", 1800000);
        productDAO.addProduct(product);
        product = new Product("PROD002", "Portatil", 1500000);
        productDAO.addProduct(product);
        product = new Product("PROD003", "Tableta", 800000);
        productDAO.addProduct(product);

        ArrayList<Product> products = productDAO.getProducts();
        
    }
}