package co.edu.uts.sistemas.pedidosuts;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uts.sistemas.pedidosuts.model.Client;
import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ClientActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client);
    }

    public void save(View view) {
        EditText identificationField = findViewById(R.id.et_id);
        EditText nameField = findViewById(R.id.et_name);
        EditText phoneField = findViewById(R.id.et_phone);
        EditText addressField = findViewById(R.id.et_address);

        String identificationValue = identificationField.getText().toString();
        String nameValue = nameField.getText().toString();
        String phoneValue = phoneField.getText().toString();
        String addressValue = addressField.getText().toString();
        if(identificationValue.length() > 0 && nameValue.length() > 0 && phoneValue.length() > 0 && addressValue.length() > 0) {
            Information.clients.add(new Client(Integer.parseInt(identificationValue), nameValue, phoneValue, addressValue));
            setResult(RESULT_OK);
            finish();
        } else {
            Toast.makeText(this, "Por favor ingrese todos los datos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void back(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}