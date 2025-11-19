package com.example.facilita;

//cuidado com o package de vocês. Não apaguem ele.

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView txtNome;
        final TextView txtCategoria;
        final TextView txtQtdProd;
        String categoria;

        public ViewHolder(View view) {
            super(view);
            txtNome = view.findViewById(R.id.tvNomeProduto);
            txtCategoria = view.findViewById(R.id.tvCategoriaProduto);
            txtQtdProd = view.findViewById(R.id.tv_QtdProd);
        }
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_produto, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Product produto = products.get(position);
        holder.txtNome.setText(produto.getName());


        if (produto.getCategory_id() == 1) {
            holder.categoria = "doce";
        }
        if (produto.getCategory_id() == 2) {
            holder.categoria = "salgado";
        }
        if (produto.getCategory_id() == 3) {
            holder.categoria = "bebida";
        }

        holder.txtCategoria.setText(holder.categoria);
    }

    @Override
    public int getItemCount() {
        return products.size();
    }
}
