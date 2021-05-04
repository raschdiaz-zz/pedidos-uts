package co.edu.uts.sistemas.pedidosuts.database;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import co.edu.uts.sistemas.pedidosuts.model.Product;

public class ProductDAO {
    private final static String id = "id";
    private final static String code = "code";
    private final static String name = "name";
    private final static String price = "price";
    private final static String image = "image";

    public final static String tableName = "products";

    public final static String createTable = "CREATE TABLE "+tableName+" (" +
            ""+id+" INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            ""+code+" TEXT NOT NULL, " +
            ""+name+" TEXT NOT NULL, " +
            ""+price+" INTEGER NOT NULL , " +
            ""+image+" TEXT NOT NULL" +
            ")";

    private DataBase dataBase;

    public ProductDAO(DataBase dataBase) {
        this.dataBase = dataBase;
    }

    public ArrayList<Product> getProducts() {

        SQLiteDatabase sqLiteDatabase = this.dataBase.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query("products", null, "code=? AND name LIKE ?", new String[]{"123", "'%y'"}, null, null, null);

        ArrayList<Product> products = new ArrayList<Product>();

        if(cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String code = cursor.getString(cursor.getColumnIndex("code"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int price = cursor.getInt(cursor.getColumnIndex("price"));
                String image = cursor.getString(cursor.getColumnIndex("image"));

                Product product = new Product(id, code, name, price, image);

                products.add(product);

            } while (cursor.moveToNext());
        }

        return products;
    }

    public boolean addProduct(Product product) {
        boolean flag = false;

        // "INSERT INTO products VALUES (NULL, '123', '123', '123', 'image.png')"

        SQLiteDatabase sqLiteDatabase = this.dataBase.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put("code", product.getCode());
        contentValues.put("name", product.getName());
        contentValues.put("price", product.getPrice());
        contentValues.put("image", product.getImage());

        if(sqLiteDatabase.insert(tableName, null, contentValues) > 0) {
            flag = true;
        }



        return flag;
    }
}
