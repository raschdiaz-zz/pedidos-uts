package co.edu.uts.sistemas.pedidosuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ProductsActivity extends AppCompatActivity {


    ProductAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_products);
        if(Information.products.size() > 0) {
            ListView listView = findViewById(R.id.lst_products);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ProductsActivity.this, ProductDetailActivity.class);
                    intent.putExtra("position", position);
                    startActivityForResult(intent, 110);
                }
            });

            /*this.arrayAdapter = new ArrayAdapter<>(
              ProductsActivity.this,
              android.R.layout.simple_list_item_1,
                    Information.products
            );*/
            this.arrayAdapter = new ProductAdapter(getApplicationContext(), Information.products);
            listView.setAdapter(arrayAdapter);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // code 110 Edit
        // code 120 Delete
        if(requestCode == 110 || requestCode == 120) {
            this.arrayAdapter.notifyDataSetChanged();
        }
    }

    public void back(View view) {
        finish();
    }
}