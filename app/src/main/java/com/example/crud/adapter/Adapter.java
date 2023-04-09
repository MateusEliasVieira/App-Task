package com.example.crud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crud.R;
import com.example.crud.controller.MainActivity;
import com.example.crud.controller.TasksList;
import com.example.crud.entity.Task;
import com.example.crud.model.Database;
import com.example.crud.model.TaskDaoRepository;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> {

    private List<Task> listTask;
    public Adapter(List<Task> listTask){
        this.listTask = listTask;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemViewList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_list_task, parent, false);
        return new MyViewHolder(itemViewList);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Task task = this.listTask.get(position);
        holder.textViewTitle.setText("Título: "+task.getTitle());
        holder.textViewTask.setText("Tarefa: "+task.getTask());
        // Dar ações aos buttons aqui
    }

    @Override
    public int getItemCount() {
        return this.listTask.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView textViewTitle;
        TextView textViewTask;
        Button buttonDelete;
        Button buttonUpdate;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = (TextView) itemView.findViewById(R.id.textViewTitle);
            textViewTask = (TextView) itemView.findViewById(R.id.textViewTask);
            buttonDelete = (Button) itemView.findViewById(R.id.buttonDelete);
            buttonUpdate = (Button) itemView.findViewById(R.id.buttonUpdate);
        }

    }


}
