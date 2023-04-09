package com.example.crud.controller;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.adapter.Adapter;
import com.example.crud.entity.Task;
import com.example.crud.model.TaskDaoRepository;

import java.util.ArrayList;
import java.util.List;

public class TasksList extends AppCompatActivity {

    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks_list);

        List<Task> listTask = new TaskDaoRepository(this).findAll();

        // Pegando o Recyclerview
        recyclerView = findViewById(R.id.recyclerViewTasks);

        // Configurar Adapter
        Adapter adapter = new Adapter(listTask);

        // Configurar RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);


//        List<Task> list = new TaskDaoRepository(TasksList.this).findAll();
//        List<String> listString = new ArrayList<>();
//        for (Task task : list) {
//            listString.add(task.toString());
//        }
//        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(TasksList.this, android.R.layout.simple_list_item_1,listString);
//        listView.setAdapter(arrayAdapter);
//        Intent intent = getIntent();
//        if(intent.getBooleanExtra("status",false)){
//            Toast.makeText(TasksList.this, "Nova tarefa adicionada com sucesso!", Toast.LENGTH_SHORT).show();
//        }
    }
}