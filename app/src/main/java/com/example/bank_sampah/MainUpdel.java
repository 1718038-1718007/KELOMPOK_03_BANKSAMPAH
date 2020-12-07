package com.example.bank_sampah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String Sid,Snama,Salamat,Ssampah,Sberat;
    private EditText Eid,Enama,Ealamat,Esampah,Eberat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
       // Sid = i.getStringExtra("Iid");
        Snama = i.getStringExtra("Inama");
        Salamat = i.getStringExtra("Ialamat");
        Ssampah = i.getStringExtra("Isampah");
        Sberat = i.getStringExtra("Iberat");
        Enama =(EditText)findViewById(R.id.updel_nama);
        Ealamat=(EditText)findViewById(R.id.updel_alamat);
        Esampah = (EditText) findViewById(R.id.updel_sampah);
        Eberat = (EditText) findViewById(R.id.updel_berat);
        Enama.setText(Snama);
        Ealamat.setText(Salamat);
        Esampah.setText(Ssampah);
        Eberat.setText(Sberat);
        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Ssampah = String.valueOf(Esampah.getText());
                Sberat = String.valueOf(Eberat.getText());
                if ((Snama.equals(""))) {
                    Enama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama anda", Toast.LENGTH_SHORT).show();
                }
                if ((Salamat.equals(""))) {
                    Ealamat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama anda", Toast.LENGTH_SHORT).show();
                }
                if ((Ssampah.equals(""))) {
                    Esampah.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama anda", Toast.LENGTH_SHORT).show();
                }
                if ((Sberat.equals(""))) {
                    Eberat.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi nama anda", Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdateSetor(new setor_sampah(Sid, Snama, Salamat, Ssampah, Sberat));
                    Toast.makeText(MainUpdel.this, "Data telah diUpdate", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }

        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.DeleteSetor(new setor_sampah(Sid, Snama, Salamat,Ssampah, Sberat));
                Toast.makeText(MainUpdel.this, "data telah di delete", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

}
