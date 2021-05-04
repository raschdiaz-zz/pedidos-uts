package co.edu.uts.sistemas.pedidosuts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.edu.uts.sistemas.pedidosuts.model.Client;

public class ClientAdapter extends BaseAdapter {

    ArrayList<Client> clients;
    Context context;

    public ClientAdapter(Context context, ArrayList<Client> clients) {
        this.clients = clients;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.clients.size();
    }

    @Override
    public Object getItem(int position) {
        return this.clients.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.client_render, null);
        }
        TextView tv_identification = convertView.findViewById(R.id.tv_identification);
        TextView tv_name2 = convertView.findViewById(R.id.tv_name2);
        TextView tv_phone1 = convertView.findViewById(R.id.tv_phone1);
        TextView tv_address1 = convertView.findViewById(R.id.tv_address1);
        ImageView iv_client = convertView.findViewById(R.id.iv_client);

        Client client = (Client) this.getItem(position); // Variable cast

        tv_identification.setText(client.getId()+"");
        tv_name2.setText(client.getName());
        tv_phone1.setText(client.getPhone());
        tv_address1.setText(client.getAddress());

        Picasso.get().load(client.getImage()).into(iv_client); // Use Picasso Library to get images

        return convertView;
    }
}
