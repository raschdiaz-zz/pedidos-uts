package co.edu.uts.sistemas.pedidosuts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        String name = getIntent().getStringExtra("name");
        String surname = getIntent().getStringExtra("surname");
        int age = getIntent().getIntExtra("age", 0);
        if(name != null && surname != null && age != 0) {
            TextView txtWelcome = findViewById(R.id.txt_message);
            txtWelcome.append("\n"+name+"\n"+surname+"\n"+age);
        }
        if(Information.products.size() == 0) {
            //TextView lblProduct = findViewById(R.id.lbl_product);
            //lblProduct.setText(Information.product.toString());
            Information.loadProducts();
        }
        if(Information.clients.size() == 0) {
            //TextView lblProduct = findViewById(R.id.lbl_product);
            //lblProduct.setText(Information.product.toString());
            Information.loadClients();
        }
        this.showProductsLength();
        this.showClientsLength();
    }

    public void execute(View view) {

        switch (view.getId()) {
            case R.id.btn_logout: {
                finish();
                break;
            }
            case R.id.btn_product: {
                Intent intent = new Intent(MenuActivity.this, ProductActivity.class);
                //startActivity(intent);
                // Code 100: Add
                // Code 110: Edit
                // Code 120: Delete
                // Code 130: List
                startActivityForResult(intent, 100);
                break;
            }
            case R.id.btn_products: {
                Intent intent = new Intent(MenuActivity.this, ProductsActivity.class);
                startActivityForResult(intent, 130);
                break;
            }
            case R.id.btn_client: {
                Intent intent = new Intent(MenuActivity.this, ClientActivity.class);
                startActivityForResult(intent, 200);
                break;
            }
            case R.id.btn_clients: {
                Intent intent = new Intent(MenuActivity.this, ClientsActivity.class);
                startActivityForResult(intent, 230);
                break;
            }
            case R.id.btn_storage: {
                Intent intent = new Intent(MenuActivity.this, StorageActivity.class);
                startActivityForResult(intent, 230);
                break;
            }
            default:
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        this.showClientsLength();
        this.showProductsLength();
    }

    private void showProductsLength() {
        Button btn = findViewById(R.id.btn_products);
        int quantity = Information.products.size();
        btn.setText("Mostrar Productos ("+quantity+")");
    }

    private void showClientsLength() {
        Button btn = findViewById(R.id.btn_clients);
        int quantity = Information.clients.size();
        btn.setText("Mostrar Clientes ("+quantity+")");
    }
}