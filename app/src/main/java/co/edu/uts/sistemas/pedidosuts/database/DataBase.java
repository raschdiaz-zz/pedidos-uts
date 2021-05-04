package co.edu.uts.sistemas.pedidosuts.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBase extends SQLiteOpenHelper {

    private final static String databaseName = "pedidos_uts.db";
    private final static int databaseVersion = 1;

    public DataBase(@Nullable Context context/*, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version*/) {
        super(context, databaseName, null, databaseVersion/*, name, factory, version*/);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //String query = "CREATE TABLE products (id INTEGER NOT NULL, code TEXT NOT NULL, name TEXT NOT NULL, price INTEGER NOT NULL)";
        sqLiteDatabase.execSQL(ProductDAO.createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE "+ProductDAO.tableName);
        onCreate(sqLiteDatabase);
    }
}
