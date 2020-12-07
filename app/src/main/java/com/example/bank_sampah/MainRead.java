package com.example.bank_sampah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<setor_sampah> ListSetor = new ArrayList<setor_sampah>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        mListView = findViewById(R.id.list_setor);
        ListSetor.clear();

        adapter_off = new CustomListAdapter(this, ListSetor );
        mListView = (ListView)findViewById(R.id.list_setor);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListSetor.clear();

        List<setor_sampah> contacts = db.Readsetor_sampah();
        for (setor_sampah cn : contacts) {
            setor_sampah judulModel = new setor_sampah();
            judulModel.setId((cn.getId()));
            judulModel.setNama(cn.getNama());
            judulModel.setAlamat(cn.getAlamat());
            judulModel.setSampah(cn.getSampah());
            judulModel.setBerat(cn.getBerat());
            ListSetor.add(judulModel);

            Log.d("MainRead", "onCreate: cek list => " + ListSetor.isEmpty());
            if ((ListSetor.isEmpty())) {
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            }
            else {
              //  Toast.makeText(MainRead.this, "Cek Data: " + ListSetor.isEmpty(), Toast.LENGTH_SHORT).show();
            }
        }
}
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long I) {
        Object o = mListView.getItemAtPosition(i);
        setor_sampah obj_itemDetails = (setor_sampah)o;
        // String Sid = obj_itemDetails.getId() ;
        String Snama = obj_itemDetails.getNama();
        String Salamat = obj_itemDetails.getAlamat();
        String Ssampah = obj_itemDetails.getSampah();
        String Sberat   = obj_itemDetails.getBerat();

        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ialamat", Salamat);
        goUpdel.putExtra("Isampah", Ssampah);
        goUpdel.putExtra("Iberat", Sberat);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListSetor.clear();
        mListView.setAdapter(adapter_off);

        List<setor_sampah> contacts = db.Readsetor_sampah();
        for (setor_sampah cn : contacts) {
            setor_sampah judulModel = new setor_sampah();
            judulModel.setId(cn.getId());
            judulModel.setNama(cn.getNama());
            judulModel.setAlamat(cn.getAlamat());
            judulModel.setSampah(cn.getSampah());
            judulModel.setBerat(cn.getBerat());
            ListSetor.add(judulModel);
            if ((ListSetor.isEmpty())) {
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            }
            else {
            }
        }
       // mListView.setAdapter(adapter_off);
    }
}

