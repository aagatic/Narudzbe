package com.example.narudzbe.narudzbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class IzlistajNarudzbeActivity extends AppCompatActivity {

    Button btnIzlistajToMain;
    ListView lvNarudzbe;
    NarudzbaAdapter narudzbaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izlistaj_narudzbe);

        NarudzbaDbHelper.getInstance(getApplicationContext());
        this.initializeIzlistajNarudzbeActivityUI();

        btnIzlistajToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IzlistajNarudzbeActivity.this, MainActivity.class));
                finish();
            }
        });

        lvNarudzbe.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                NarudzbaAdapter adapter = (NarudzbaAdapter) lvNarudzbe.getAdapter();
                Narudzba selected = (Narudzba) adapter.getItem(position);

                Intent i = new Intent (IzlistajNarudzbeActivity.this, IzlistajPicaActivity.class);
                i.putExtra("stol", selected.getStol());
                startActivity(i);
                //Toast.makeText(IzlistajNarudzbeActivity.this, selected.toString(),Toast.LENGTH_SHORT).show();
            }
        });

        lvNarudzbe.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                NarudzbaAdapter adapter = (NarudzbaAdapter) lvNarudzbe.getAdapter();
                Narudzba selected = (Narudzba) adapter.getItem(position);

                NarudzbaDbHelper.getInstance(getApplicationContext()).deleteNarudzbaByStol(selected.getStol().toString());
                NarudzbaDbHelper.getInstance(getApplicationContext()).deletePicaByStol(selected.getStol().toString());

                narudzbaAdapter.deleteAt(position);
                return true;
            }
        });
    }

    private void initializeIzlistajNarudzbeActivityUI() {
        btnIzlistajToMain = (Button) findViewById(R.id.btnIzlistajToMain);
        this.lvNarudzbe = (ListView) this.findViewById(R.id.lvNarudzbe);
        this.narudzbaAdapter = new NarudzbaAdapter(this.loadNarudzbe());
        this.lvNarudzbe.setAdapter(this.narudzbaAdapter);
    }

    private ArrayList<Narudzba> loadNarudzbe(){
        return NarudzbaDbHelper.getInstance(this).getAllNarudzbe();
    }
}
