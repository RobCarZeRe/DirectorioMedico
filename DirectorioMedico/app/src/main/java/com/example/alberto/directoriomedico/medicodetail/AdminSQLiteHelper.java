package com.example.alberto.directoriomedico.medicodetail;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.Toast;


import java.util.ArrayList;

public class AdminSQLiteHelper extends SQLiteOpenHelper {

    String codoc;

    public AdminSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table pacientes(codigo int primary key, nombre text, peso int, codoc  text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

/*
    public ArrayList llenar_lv(){



        ArrayList<String> lista = new ArrayList<>();
        SQLiteDatabase database = this.getWritableDatabase();
        String q = "Select * from pacientes";
        Cursor registro = database.rawQuery(q,null);
        if(registro.moveToFirst()){
            do{
                lista.add(registro.getString(1));
            }while(registro.moveToNext());
        }
        return lista;
    }
*/


}
