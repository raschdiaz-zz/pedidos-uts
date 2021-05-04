package co.edu.uts.sistemas.pedidosuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ProductActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
    }

    public void save(View view) {
        EditText code = findViewById(R.id.txt_code);
        EditText name = findViewById(R.id.txt_product);
        EditText price = findViewById(R.id.txt_price);

        String codeValue = code.getText().toString();
        String nameValue = name.getText().toString();
        String priceValue = price.getText().toString();
        if(codeValue.length() > 0 && nameValue.length() > 0 && priceValue.length() > 0) {
            int parsedPriceValue = Integer.parseInt(priceValue);
            Information.products.add(new Product(codeValue, nameValue, parsedPriceValue));
            setResult(RESULT_OK);
            finish();
            //Intent intent = new Intent(ProductActivity.this, MenuActivity.class);
            /*Intent intent = new Intent();
            intent.putExtra("code", codeValue);
            intent.putExtra("name", nameValue);
            intent.putExtra("price", parsedPriceValue);*/
            //startActivity(intent);
            //setResult(RESULT_OK, intent);
        } else {
            Toast.makeText(this, "Por favor ingrese todos los datos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}