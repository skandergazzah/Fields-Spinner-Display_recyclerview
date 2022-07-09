package com.example.projetandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class DB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "ProductManager";
    private static final String TABLE_Product = "Products";
    private static final String KEY_ID = "Id";
    private static final String KEY_Nom = "Name";
    private static final String KEY_Categorie = "Categories";
    private static final String KEY_Caract = "Caract";
    private static final String KEY_Prix = "Prix";


    public DB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_Product_TABLE = "CREATE TABLE " + TABLE_Product + " ("
                + KEY_ID + " INTEGER PRIMARY KEY, " + KEY_Nom +
                " TEXT, " + KEY_Categorie + " TEXT, " + KEY_Caract + " TEXT, "
                + KEY_Prix + " DOUBLE" + ")";

        db.execSQL(CREATE_Product_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Product);
        onCreate(db);

    }

    void addProdcut(Product product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_Nom, product.getNom());
        values.put(KEY_Categorie, product.getCategorie());
        values.put(KEY_Caract, product.getCaract());
        values.put(KEY_Prix, product.getPrix());


        db.insert(TABLE_Product, null, values);

        db.close();
    }


    public List<Product> getAllProct() {
        SQLiteDatabase db = this.getReadableDatabase();
        List<Product> prodList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_Product;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Product produit = new Product();
                produit.setId(Integer.parseInt((cursor.getString(0))));
                produit.setNom(cursor.getString(1));

                produit.setCategorie(cursor.getString(2));
                produit.setCaract(cursor.getString(3));
                produit.setPrix(Double.parseDouble((cursor.getString(4))));


                prodList.add(produit);


            } while (cursor.moveToNext());
        }
        return prodList;
    }
}
