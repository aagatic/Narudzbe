package com.example.narudzbe.narudzbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnAddNarudzba;
    Button btnEnlistNarudzbe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeMainActivityUI();

        btnAddNarudzba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(MainActivity.this, "Pozdrav" ,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(MainActivity.this, DodajNarudzbuActivity.class));
            }
        });

        btnEnlistNarudzbe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, IzlistajNarudzbeActivity.class));
            }
        });
    }

    private void initializeMainActivityUI() {
        btnAddNarudzba = (Button) findViewById(R.id.btnAddNarudzba);
        btnEnlistNarudzbe = (Button) findViewById(R.id.btnEnlistNarudzbe);
    }
}
