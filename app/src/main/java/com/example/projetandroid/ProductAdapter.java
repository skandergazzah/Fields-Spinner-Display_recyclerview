package com.example.projetandroid;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<Product> listProduct;

    public ProductAdapter() {
        listProduct = new ArrayList<>();
    }

    public void setListProduct(List<Product> listProduct) {
        this.listProduct = listProduct;
        notifyDataSetChanged();
    }

    public void addProduct(Product product) {
        this.listProduct.add(product);
        notifyItemInserted(getItemCount());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        viewHolder.setProduct(listProduct.get(position));
    }

    @Override
    public int getItemCount() {
        return listProduct.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView textName;
        private final TextView textCathegorie;
        private final TextView textCarac;
        private final TextView textPrix;

          public ViewHolder(View view) {
            super(view);
            textName = view.findViewById(R.id.product_nom);
            textCathegorie = view.findViewById(R.id.product_cat);
            textCarac = view.findViewById(R.id.product_carac);
            textPrix = view.findViewById(R.id.product_prix);
        }

        public void setProduct(Product product) {
            textName.setText(product.getNom());
            textCathegorie.setText(product.getCategorie());
            textCarac.setText(product.getCaract());
            textPrix.setText(product.getPrix().toString());
        }
    }
}

