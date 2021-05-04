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

import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ProductAdapter extends BaseAdapter {

    ArrayList<Product> products;
    Context context;

    public ProductAdapter(Context context, ArrayList<Product> products) {
        this.products = products;
        this.context = context;
    }

    @Override
    public int getCount() {
        return this.products.size();
    }

    @Override
    public Object getItem(int position) {
        return this.products.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = LayoutInflater.from(this.context).inflate(R.layout.product_render, null);
        }
        TextView tv_code = convertView.findViewById(R.id.tv_identification);
        TextView tv_name = convertView.findViewById(R.id.tv_name2);
        TextView tv_price = convertView.findViewById(R.id.tv_phone1);
        ImageView iv_image = convertView.findViewById(R.id.iv_client);

        Product product = (Product) this.getItem(position); // Variable cast

        tv_code.setText(product.getCode());
        tv_name.setText(product.getName());
        tv_price.setText(product.getPrice()+"");

        Picasso.get().load(product.getImage()).into(iv_image); // Use Picasso Library to get images

        return convertView;
    }
}
