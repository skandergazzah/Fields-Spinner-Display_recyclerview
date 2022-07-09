package com.example.projetandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AjoutActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout);

        DB db = new DB(this);
//        Log.d("insertion", "onCreate: insérer un étudiant ");
//        db.addProdcut(new Product());
//
//        Log.d("lecture", "onCreate: lire tous les etudiants ");
//        List<Product> produits=db.getAllProct();
//
//        for (Product ED : produits) {
//            String log = "Id: " + ED.getId() + " ,Nom: " + ED.getNom() + " ,Categorie: " +
//                    ED.getCategorie()+ "Caracteristique: " + ED.getCaract() +"Prix: " + ED.getPrix() ;
//            // Ecrire tous les étuiants dans le log
//            Log.d("Name: ", log);
//        }

        Button ajout = findViewById(R.id.ajout_button);
        EditText nom = findViewById(R.id.editTextTextPerson);
        EditText caracteristique = findViewById(R.id.editTextTextPersonName);
        EditText prix = findViewById(R.id.editTextTextPersonName3);
        Spinner s = findViewById(R.id.nature_metalId);

        RecyclerView listProducts = findViewById(R.id.rvProducts);
        ProductAdapter productAdapter = new ProductAdapter();
        listProducts.setAdapter(productAdapter);
        List<Product> produits = db.getAllProct();

        if (produits != null && !produits.isEmpty()) {
            productAdapter.setListProduct(produits);
        }

        ajout.setOnClickListener(view -> {

            String name = nom.getText().toString();
            String carac = caracteristique.getText().toString();
            Double p = Double.parseDouble(prix.getText().toString());


            String lambda = "";
            if (s.getSelectedItem().equals("Plomb")) lambda = "Plomb";
            if (s.getSelectedItem().equals("Zinc")) lambda = "Zinc";
            if (s.getSelectedItem().equals("Aluminium")) lambda = "Aluminium";
            if (s.getSelectedItem().equals("Cuivre")) lambda = "Cuivre";
            if (s.getSelectedItem().equals("Acier")) lambda = "Acier";
            if (s.getSelectedItem().equals("Laiton")) lambda = "Laiton";
            if (s.getSelectedItem().equals("Verre")) lambda = "Verre";

            Product produit = new Product(name, lambda, carac, p);
            db.addProdcut(produit);
            productAdapter.addProduct(produit);
        });
    }
}