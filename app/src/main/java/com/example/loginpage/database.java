package com.example.loginpage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class database extends SQLiteOpenHelper {

    private SQLiteDatabase MyDatabase;
    public static final String databaseName = "SignUp";

    public database(@Nullable Context context) {
        super(context, "SignUp", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        MyDatabase.execSQL("Create Table kullanicilar(username TEXT primary key, password TEXT)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {
        MyDatabase.execSQL("Drop Table if exists kullanicilar");
    }

    public Boolean dbEkle(String username, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("password", password);
        long result = MyDatabase.insert("kullanicilar", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean kullaniciAdiKontrol(String username) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where username = ?", new String[]{username});

        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean sifreKontrol(String username, String password) {
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from kullanicilar where username = ? and password = ?", new String[]{username, password});

        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
