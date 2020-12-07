package com.example.bank_sampah;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class activity_pemilahan extends AppCompatActivity {
    private RecyclerView recyclerView;
    private sampahAdapter adapter;
    private ArrayList<sampah> SampahArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pemilahan);
        addData();
        recyclerView = findViewById(R.id.recylersampah);
        adapter = new sampahAdapter(SampahArrayList);

        LinearLayoutManager layoutManager = new LinearLayoutManager(activity_pemilahan.this);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);


    }

    private void addData() {
       SampahArrayList = new ArrayList<>();
       SampahArrayList.add(new sampah("kertas / koran","Sampah organik", "2-4 minggu", R.drawable.koran1));
       SampahArrayList.add(new sampah("plastik bungkus", "Sampah Non-organik","10-20 tahun", R.drawable.plastik));
      }

}
