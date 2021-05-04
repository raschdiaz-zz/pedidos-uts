package co.edu.uts.sistemas.pedidosuts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import co.edu.uts.sistemas.pedidosuts.model.Client;

public class ClientsActivity extends AppCompatActivity {

    //ArrayAdapter<Client> arrayAdapter;
    ClientAdapter arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clients);
        if(Information.clients.size() > 0) {
            ListView listView = findViewById(R.id.lv_clients);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(ClientsActivity.this, ClientDetailActivity.class);
                    intent.putExtra("position", position);
                    startActivityForResult(intent, 210);
                }
            });

            /*this.arrayAdapter = new ArrayAdapter<>(
                    ClientsActivity.this,
                    android.R.layout.simple_list_item_1,
                    Information.clients
            );*/
            this.arrayAdapter = new ClientAdapter(getApplicationContext(), Information.clients);
            listView.setAdapter(arrayAdapter);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // code 210 Edit
        // code 220 Delete
        if(requestCode == 210 || requestCode == 220) {
            this.arrayAdapter.notifyDataSetChanged();
        }
    }

    public void back(View view) {
        finish();
    }
}