package com.example.bank_sampah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DataHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "setorsampah.db";
    private static final int DATABASE_VERSION = 1;
    public  DataHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);   ;
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table setor(no integer primary key, nama text null, alamat text null, sampah text null, berat text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);
        sql = "INSERT INTO setorsampah (no, nama, alamat, sampah, berat) VALUES ('1', 'kiki', 'Jln.golf', 'plastik bungkus','5');";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

}
