package co.edu.uts.sistemas.pedidosuts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i("Estado", "Método onCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Estado", "Método onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Estado", "Método onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Estado", "Método onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Estado", "Método onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Estado", "Método onDestroy()");
    }

    public void salir(View view) {
        finish();
    }

    public void ingresar(View view) {

        EditText txtUsername = findViewById(R.id.txt_username);
        EditText txtPassword = findViewById(R.id.txt_password);

        String username = txtUsername.getText().toString();
        String password = txtPassword.getText().toString();

        if(Information.user.equals(username) && Information.password.equals(password)) {
            Toast.makeText(this, "Usuario y contraseña válidos", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(MainActivity.this, MenuActivity.class);
            intent.putExtra("name", "Hans Smüller");
            intent.putExtra("surname", "Rasch Diaz");
            intent.putExtra("age", 27);
            startActivity(intent);
            //finish();
        } else {
            Toast.makeText(this, "Usuario y contraseña inválidos", Toast.LENGTH_LONG).show();
        }
    }
}