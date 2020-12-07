package com.example.bank_sampah;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
//    String[] setor;
//    ListView Listview01;
//    Menu menu;
//    protected Cursor cursor;
//    DataHelper dbcenter;
//    public static MainActivity ma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void home(View view) {
        Intent c = new Intent(MainActivity.this, Home.class);
        startActivity(c);
    }


}
