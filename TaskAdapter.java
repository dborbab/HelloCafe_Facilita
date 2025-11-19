package com.example.facilita;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {
    ArrayList<Task> tasks;

    public TaskAdapter(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        final CheckBox cbDesc;
        final TextView txtQtdTask;


        public ViewHolder(View view) {
            super(view);
            cbDesc = view.findViewById(R.id.cbDesc);
            txtQtdTask = view.findViewById(R.id.tv_QtdTasks);
        }
    }
    @NonNull
    @Override
    public TaskAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tarefa, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TaskAdapter.ViewHolder holder, int position) {
        Task tarefa = tasks.get(position);
        holder.cbDesc.setText(tarefa.getDescription());
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }
}
