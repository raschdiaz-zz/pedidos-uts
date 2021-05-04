package co.edu.uts.sistemas.pedidosuts;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ProductDetailActivity extends AppCompatActivity {

    private Product product;
    private int position;
    private Uri uriImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        this.position = getIntent().getIntExtra("position", -1);
        this.product = Information.products.get(position);
        this.showProductInfo();
        if(checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ||
        checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{
                    Manifest.permission.CAMERA,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, 4000);
        }
        ImageView ivImage = findViewById(R.id.iv_product1);
        ivImage.setOnClickListener(view -> {
            //Toast.makeText(ProductDetailActivity.this, "Image Tap!", Toast.LENGTH_SHORT).show();

            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Images.Media.TITLE, "IMG_PROD_"+product.getCode());

            ProductDetailActivity.this.uriImg = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, ProductDetailActivity.this.uriImg);
            startActivityForResult(intent, 3000);

        });
    }

    private void showProductInfo() {
        EditText code = findViewById(R.id.txt_code);
        EditText name = findViewById(R.id.txt_product);
        EditText price = findViewById(R.id.txt_price);
        code.setText(this.product.getCode()+"");
        name.setText(this.product.getName());
        price.setText(this.product.getPrice()+"");
        ImageView ivImage = findViewById(R.id.iv_product1);
        Picasso.get().load(this.product.getImage()).resize(300, 300).into(ivImage); // Use Picasso Library to get images
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
            this.product.setCode(codeValue);
            this.product.setName(nameValue);
            this.product.setPrice(parsedPriceValue);
            this.product.setImage(this.uriImg.toString());
            setResult(110);
            finish();
        } else {
            Toast.makeText(this, "Por favor ingrese todos los datos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        Information.products.remove(this.position);
        setResult(120);
        finish();
    }

    public void back(View view) {
        setResult(RESULT_CANCELED); finish();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 3000) {
            ImageView ivImage = findViewById(R.id.iv_product1);
            ivImage.setImageURI(this.uriImg);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(350, 350);
            ivImage.setLayoutParams(layoutParams);
        }
    }
}