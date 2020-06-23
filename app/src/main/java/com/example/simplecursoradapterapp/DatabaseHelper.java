package com.example.simplecursoradapterapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="userstore3.db"; //название БД
    private static final int SCHEMA=1; //версия БД
    static final String TABLE="users"; //название таблицы в БД

    //название стобцов
    public static final String COLUMN_ID="_id";
    public static final String COLUMN_NAME="name";
    public static final String COLUMN_YEAR="year";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, SCHEMA);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE users (" + COLUMN_ID
                + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_NAME
                + " TEXT, " + COLUMN_YEAR + " INTEGER);");
        //добавление начальных данных
        db.execSQL("INSERT INTO " + TABLE +" (" + COLUMN_NAME
                + ", " + COLUMN_YEAR + ") VALUES ('Том Смит', '1981'),('Гном Смит', '1982'), ('Мом Смит', '1981');");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE);
        onCreate(db);

    }
}
