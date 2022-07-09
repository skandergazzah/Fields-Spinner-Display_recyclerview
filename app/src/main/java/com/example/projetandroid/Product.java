package com.example.projetandroid;

public class Product {
    int Id;
    String Nom;
    String Categorie;
    String Caract;
    Double Prix;

    public Product(int id, String nom, String categorie, String caract, Double prix) {
        Id = id;
        Nom = nom;
        Categorie = categorie;
        Caract = caract;
        Prix = prix;
    }

    public Product(String nom, String categorie, String caract, Double prix) {
        Nom = nom;
        Categorie = categorie;
        Caract = caract;
        Prix = prix;
    }

    public Product() {
    }

    public int getId() {
        return Id;
    }

    public String getNom() {
        return Nom;
    }

    public String getCategorie() {
        return Categorie;
    }

    public String getCaract() {
        return Caract;
    }

    public Double getPrix() {
        return Prix;
    }

    public void setId(int id) {
        Id = id;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public void setCategorie(String categorie) {
        Categorie = categorie;
    }

    public void setCaract(String caract) {
        Caract = caract;
    }

    public void setPrix(Double prix) {
        Prix = prix;
    }
}
