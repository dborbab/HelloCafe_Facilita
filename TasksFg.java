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

public class TasksFg extends Fragment {

    RecyclerView rvTarefas;
    TextView tvQtdTask;

    public TasksFg() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_tasks, container, false);

        rvTarefas = view.findViewById(R.id.rvTarefas);
        tvQtdTask = view.findViewById(R.id.tv_QtdTasks);

        rvTarefas.setLayoutManager(
                new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false)
        );

        getTasks();
        return view;
    }

    private void getTasks() {
        Call<TaskResponse> call = RetrofitClient.getInstance().getMyApi().getTasks(1);

        call.enqueue(new Callback<TaskResponse>() {
            @Override
            public void onResponse(Call<TaskResponse> call, Response<TaskResponse> response) {
                if (response.isSuccessful()) {
                    List<Task> tarefas = response.body().getData();

                    TaskAdapter adapter = new TaskAdapter((ArrayList<Task>) tarefas);
                    rvTarefas.setAdapter(adapter);

                    tvQtdTask.setText("" + adapter.getItemCount());
                } else {
                    Log.e("API_ERROR", "Erro na resposta: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<TaskResponse> call, Throwable t) {
                Log.e("API_ERROR", "Falha na requisição: " + t.getMessage());
            }
        });
    }
}
