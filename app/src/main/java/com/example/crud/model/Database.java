package com.example.crud.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.crud.adapter.Adapter;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context) {
        super(context, "dbtask", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //sqLiteDatabase.execSQL("create table userTask(idUser integer primary key autoincrement,name varchar(100),email varchar(255),password varchar(20))");
        sqLiteDatabase.execSQL("create table task(idTask integer primary key autoincrement,title varchar(150),message text)");
        Log.d("Criacao De Tabelas Do Banco de Dados","Entrou no método de criar tabelas onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        //sqLiteDatabase.execSQL("drop table if exists userTask");
        sqLiteDatabase.execSQL("drop table if exists task");
        Log.d("Atualizacao Do Banco de Dados","Entrou no método de atualizar onUpgrade");
    }
}
