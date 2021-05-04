package co.edu.uts.sistemas.pedidosuts;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import co.edu.uts.sistemas.pedidosuts.model.Client;

public class ClientDetailActivity extends AppCompatActivity {

    private Client client;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_client_detail);
        this.position = getIntent().getIntExtra("position", -1);
        this.client = Information.clients.get(position);
        this.showClientInfo();
    }

    private void showClientInfo() {
        EditText identificationField = findViewById(R.id.et_id);
        EditText nameField = findViewById(R.id.et_name);
        EditText phoneField = findViewById(R.id.et_phone);
        EditText addressField = findViewById(R.id.et_address);
        identificationField.setText(this.client.getId()+"");
        nameField.setText(this.client.getName());
        phoneField.setText(this.client.getPhone());
        addressField.setText(this.client.getAddress());
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
            this.client.setId(Integer.parseInt(identificationValue));
            this.client.setName(nameValue);
            this.client.setPhone(phoneValue);
            this.client.setAddress(addressValue);
            setResult(210);
            finish();
        } else {
            Toast.makeText(this, "Por favor ingrese todos los datos.", Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(View view) {
        Information.clients.remove(this.position);
        setResult(220);
        finish();
    }

    public void back(View view) {
        setResult(RESULT_CANCELED);
        finish();
    }
}