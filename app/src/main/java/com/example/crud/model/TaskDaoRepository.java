package com.example.crud.model;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.crud.adapter.Adapter;
import com.example.crud.entity.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskDaoRepository {

    private static Database database;
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

    public boolean update(Task task){
        sqLiteDatabase = database.getWritableDatabase();
        if(task.getIdTask() != null){
            ContentValues contentValues = new ContentValues();
            contentValues.put("idTask",task.getIdTask());
            contentValues.put("title",task.getTitle());
            contentValues.put("message",task.getTask());
            int result = sqLiteDatabase.update("task",contentValues,"where idTask = ?",new String[task.getIdTask()]);
            if(result != -1) {
                return true;
            }
        }
        return false;
    }

    public boolean delete(int idTask){
        sqLiteDatabase = database.getWritableDatabase();
        if((Integer)idTask != null){
            int result = sqLiteDatabase.delete("task","where idTask = ?",new String[idTask]);
            if(result != -1){
                return true;
            }
        }
        return false;
    }

}
