package com.example.bank_sampah;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class Home extends AppCompatActivity{

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_home);
        }
    public void setor_sampah(View view){
        Intent a = new Intent(Home.this, MainCreate.class);
        startActivity(a);
    }

    public void btn_read(View view){
        Intent b = new Intent(Home.this, MainRead.class);
        startActivity(b);
    }
    public void pilah(View view){
            Intent d = new Intent(Home.this, activity_pemilahan.class);
            startActivity(d);
    }

    public void showabout() {
        setContentView(R.layout.activity_about);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }
    public void setMode(int selectedMode) {
        switch (selectedMode) {
            case R.id.about:
                showabout();
                break;
        }
    }
}
