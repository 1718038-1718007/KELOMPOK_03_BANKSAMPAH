package com.example.bank_sampah;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText Enama,Ealamat, Esampah, EBerat,Eid;
    private String Snama,Salamat, Ssampah, Sberat,Sid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);

        db = new MyDatabase(this);
        Eid = (EditText) findViewById(R.id.create_id);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ealamat = (EditText) findViewById(R.id.create_alamat);
        Esampah = (EditText) findViewById(R.id.create_sampah);
        EBerat = (EditText) findViewById(R.id.create_berat);

        Button btnCreate = (Button) findViewById(R.id.setor);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Sid = String.valueOf(Eid.getText());
                Snama = String.valueOf(Enama.getText());
                Salamat = String.valueOf(Ealamat.getText());
                Ssampah = String.valueOf(Esampah.getText());
                Sberat = String.valueOf(EBerat.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                } else if (Salamat.equals("")){
                    Ealamat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi alamat",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Ssampah.equals("")){
                    Esampah.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Jenis Sampah",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sberat.equals("")){
                    EBerat.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Berat Sampah",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Eid.setText("");
                    Enama.setText("");
                    Ealamat.setText("");
                    Esampah.setText("");
                    EBerat.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreateSetor(new setor_sampah(Sid, Snama, Salamat, Ssampah, Sberat));
                    Intent a = new Intent(MainCreate.this, Home.class);
                    startActivity(a);
                }
            }
        });
    }
}