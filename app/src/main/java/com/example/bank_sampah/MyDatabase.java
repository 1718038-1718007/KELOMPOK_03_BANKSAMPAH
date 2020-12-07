package com.example.bank_sampah;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "setorsampah.db";
    private static final int DATABASE_VERSION = 1;

    private static final String tb_setor = "tb_setor";

    private static final String tb_str_id = "id";
    private static final String tb_str_nama = "nama";
    private static final String tb_str_alamat = "alamat";
    private static final String tb_str_sampah = "sampah";
    private static final String tb_str_berat = "berat";

    private static final String CREATE_TABLE_SETOR = "CREATE TABLE " +
            tb_setor + "("
            + tb_str_id + " INTEGER PRIMARY KEY,"
            + tb_str_nama + " TEXT,"
            + tb_str_alamat + " TEXT,"
            + tb_str_sampah + " TEXT, "
            + tb_str_berat + " TEXT " + ")";

    public MyDatabase(Context context) {

        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SETOR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void CreateSetor(setor_sampah mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_str_nama, mdNotif.getNama());
        values.put(tb_str_alamat, mdNotif.getAlamat());
        values.put(tb_str_sampah, mdNotif.getSampah());
        values.put(tb_str_berat, mdNotif.getBerat());
        db.insert(tb_setor, null, values);
        db.close();
    }

    public List<setor_sampah> Readsetor_sampah() {
        List<setor_sampah> judulModeList = new ArrayList<setor_sampah>();
        String selectQuery = "SELECT * FROM " + tb_setor;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                setor_sampah mdkontak = new setor_sampah();
                mdkontak.setId(cursor.getString(0));
                mdkontak.setNama(cursor.getString(1));
                mdkontak.setAlamat(cursor.getString(2));
                mdkontak.setSampah(cursor.getString(3));
                mdkontak.setBerat(cursor.getString(4));
                judulModeList.add(mdkontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModeList;
    }

    public int UpdateSetor(setor_sampah mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_str_nama, mdNotif.getNama());
        values.put(tb_str_alamat, mdNotif.getAlamat());
        values.put(tb_str_sampah, mdNotif.getSampah());
        values.put(tb_str_berat, mdNotif.getBerat());
        return db.update(tb_setor, values, tb_str_nama + "=?", new String[]{String.valueOf(mdNotif.getNama())});

    }
    public void DeleteSetor (setor_sampah mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_setor, tb_str_nama+ " = ?",
                new String[]{String.valueOf(mdNotif.getNama())});
        db.close();
}
}

