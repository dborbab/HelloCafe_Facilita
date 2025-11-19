package com.example.facilita;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductsFg extends Fragment {

    RecyclerView rvProdutos;
    TextView tvQtd;

    public ProductsFg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_products, container, false);

        rvProdutos = view.findViewById(R.id.rvProdutos);
        tvQtd = view.findViewById(R.id.tv_QtdProd);

        rvProdutos.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
        );

        getProducts();
        return view;
    }

    private void getProducts() {
        Call<ProductResponse> call = RetrofitClient.getInstance().getMyApi().getProducts(1);

        call.enqueue(new Callback<ProductResponse>() {
            @Override
            public void onResponse(Call<ProductResponse> call, Response<ProductResponse> response) {
                if (response.isSuccessful()) {
                    List<Product> produtos = response.body().getData();

                    ProductAdapter adapter = new ProductAdapter((ArrayList<Product>) produtos);
                    rvProdutos.setAdapter(adapter);

                    tvQtd.setText("" + adapter.getItemCount());
                } else {
                    Log.e("API_ERROR", "Erro na resposta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<ProductResponse> call, Throwable t) {
                Log.e("API_ERROR", "Falha na requisição: " + t.getMessage());
            }
        });
    }
}
