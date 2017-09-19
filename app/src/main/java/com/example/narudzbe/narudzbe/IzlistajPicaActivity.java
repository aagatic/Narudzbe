package com.example.narudzbe.narudzbe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class IzlistajPicaActivity extends AppCompatActivity {

    Button btnIzlistajPicaToMain;
    ListView lvPica;
    PicaAdapter picaAdapter;
    String stol;
    TextView tvUkupno;
    int ukupno = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_izlistaj_pica);

        Intent i = getIntent();
        stol = i.getStringExtra("stol");

        initializeIzlistajNarudzbeActivityUI();

        btnIzlistajPicaToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(IzlistajPicaActivity.this, IzlistajNarudzbeActivity.class));
                finish();
            }
        });

/*        btndodajPicaHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Pice pice = new Pice("Stol 8","Pivo","Ozujsko");
                NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                PicaAdapter adapter = (PicaAdapter) lvPica.getAdapter();
                adapter.add(pice);
            }
        });*/

       // Toast.makeText(IzlistajPicaActivity.this, stol,Toast.LENGTH_SHORT).show();
        tvUkupno.setText(String.valueOf(ukupno));
    }

    private void initializeIzlistajNarudzbeActivityUI() {
        btnIzlistajPicaToMain = (Button) findViewById(R.id.btnIzlistajPicaToMain);
        tvUkupno = (TextView) findViewById(R.id.tvUkupno);
        this.lvPica = (ListView) this.findViewById(R.id.lvPica);
        this.picaAdapter = new PicaAdapter(this.loadPica());
        this.lvPica.setAdapter(this.picaAdapter);
    }

    private ArrayList<Pice> loadPica(){
        ArrayList<Pice> pica = NarudzbaDbHelper.getInstance(this).getPicaByStol(stol);
        ukupno = 0;
        for(Pice item: pica){
            ukupno += Integer.parseInt(item.getCijena());
        }
        Log.d("TAG", String.valueOf(ukupno));
        return pica;
    }
}
