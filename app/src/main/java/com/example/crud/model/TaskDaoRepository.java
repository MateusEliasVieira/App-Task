package com.example.crud.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.crud.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDaoRepository {

    private Database database;
    private SQLiteDatabase sqLiteDatabase;

    public TaskDaoRepository(Context context){
        database = new Database(context);
    }

    public boolean save(Task task){
        sqLiteDatabase = database.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title",task.getTitle());
        contentValues.put("message",task.getTask());
        Long result = sqLiteDatabase.insert("task",
                null,
                contentValues);
        if(result != -1){
            return true;
        }
        return false;
    }

    @SuppressLint("Range")
    public List<Task> findAll(){
        sqLiteDatabase = database.getReadableDatabase();
        List<Task> list = new ArrayList<Task>();
        Cursor cursor = sqLiteDatabase.rawQuery("select * from task",null);
        while(cursor.moveToNext()){
            Task task = new Task();
            task.setIdTask(Integer.parseInt(cursor.getString(cursor.getColumnIndex("idTask"))));
            task.setTitle(cursor.getString(cursor.getColumnIndex("title")));
            task.setTask(cursor.getString(cursor.getColumnIndex("message")));
            list.add(task);
            Log.d("tarefas",task.toString());
        }
        return list;
    }
}