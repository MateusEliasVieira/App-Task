package com.example.crud.controller;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.crud.R;
import com.example.crud.adapter.Adapter;
import com.example.crud.entity.Task;
import com.example.crud.model.TaskDaoRepository;

public class MainActivity extends AppCompatActivity {

    private EditText editTextTitle;
    private EditText editTextTask;
    private Button buttonSave;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextTask = findViewById(R.id.editTextTask);
        buttonSave = findViewById(R.id.buttonSave);

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String title = editTextTitle.getText().toString();
                String task = editTextTask.getText().toString();
                if(!title.isEmpty() && !task.isEmpty()){
                    // ok
                    Task newtask = new Task();
                    newtask.setTitle(title);
                    newtask.setTask(task);
                    // add to database
                    if(new TaskDaoRepository(MainActivity.this).save(newtask)){
                        cleanViews();
                        Intent intent = new Intent(MainActivity.this,TasksList.class);
                        Bundle bundle = new Bundle();
                        bundle.putBoolean("status",true);
                        intent.putExtras(bundle);
                        startActivity(intent);
                    }else{
                        Toast.makeText(MainActivity.this,
                                "Houve um problema ao salvar sua nova tarefa!",
                                Toast.LENGTH_SHORT).show();
                    }
                }else{
                    createDialogMessage("Aviso",
                            "Todos os campos são obrigatórios!",
                            "OK");
                }
            }
        });
    }

    private void createDialogMessage(String title, String message, String button){
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        alert.setTitle(title);
        alert.setMessage(message);
        alert.setNeutralButton(button,null);
        alert.show();
    }

    private void cleanViews(){
        editTextTitle.setText("");
        editTextTask.setText("");
    }

}