package com.example.narudzbe.narudzbe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

public class DodajNarudzbuActivity extends AppCompatActivity {

    Button btnAddToMain;
    Button btnAddNarudzbaToDb;
    CheckBox chkboxCedevita;
    EditText etBrojCedevita;
    CheckBox chkboxFanta;
    EditText etBrojFanti;
    CheckBox chkboxCocaCola;
    EditText etBrojCocaColi;
    CheckBox chkboxVocni;
    EditText etBrojVocnih;
    CheckBox chkboxOsjecko;
    EditText etBrojOsjecko;
    CheckBox chkboxOzujsko;
    EditText etBrojOzujsko;
    CheckBox chkboxKarlovacko;
    EditText etBrojKarlovacko;
    CheckBox chkboxHeineken;
    EditText etBrojHeineken;
    CheckBox chkboxAmber;
    EditText etBrojAmber;
    CheckBox chkboxCorona;
    EditText etBrojCorona;
    CheckBox chkboxKava;
    EditText etBrojKava;
    CheckBox chkboxCappuccino;
    EditText etBrojCappuccino;
    CheckBox chkboxToplacokolada;
    EditText etBrojToplacokolada;
    CheckBox chkboxFrankovka;
    EditText etBrojFrankovka;
    CheckBox chkboxGrasevina;
    EditText etBrojGrasevina;
    CheckBox chkboxTraminac;
    EditText etBrojTraminac;
    CheckBox chkboxZdrijebcevakrv;
    EditText etBrojZdrijebcevakrv;
    Spinner spStolovi;

    CheckBox chkboxSokovi;
    CheckBox chkboxPiva;
    CheckBox chkboxVina;
    CheckBox chkboxTopliNapitci;
    LinearLayout layoutOdaberiSokove;
    LinearLayout layoutOdaberiPiva;
    LinearLayout layoutOdaberiTopleNapitke;
    LinearLayout layoutOdaberiVina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodaj_narudzbu);

        NarudzbaDbHelper.getInstance(getApplicationContext());
        initializeDodajNarudzbuActivityUI();



        btnAddNarudzbaToDb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String selectedStol = spStolovi.getSelectedItem().toString();
                if(!NarudzbaDbHelper.getInstance(getApplicationContext()).isNarudzbaAdded(selectedStol)) {
                    Toast.makeText(DodajNarudzbuActivity.this,"Narudzba za taj stol je vec dodana. Potrebno ju" +
                            " je obrisati prije dodavanja nove.", Toast.LENGTH_LONG).show();
                }
                else {
                    Narudzba narudzba = new Narudzba(selectedStol);
                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertNarudzba(narudzba);

                    if(chkboxPiva.isChecked()) {
                        //Toast.makeText(DodajNarudzbuActivity.this,"Zelim dodat pivicu", Toast.LENGTH_SHORT).show();
                        if(chkboxOsjecko.isChecked()){
                            int brOsjecko = Integer.valueOf(etBrojOsjecko.getText().toString());
                            if(brOsjecko < 1 || brOsjecko > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj osjecko piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brOsjecko; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Osjecko","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxOzujsko.isChecked()){
                            int brOzujsko = Integer.valueOf(etBrojOzujsko.getText().toString());
                            if(brOzujsko < 1 || brOzujsko > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj ozujsko piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brOzujsko; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Ozujsko","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxKarlovacko.isChecked()){
                            int brKarlovacko = Integer.valueOf(etBrojKarlovacko.getText().toString());
                            if(brKarlovacko < 1 || brKarlovacko > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj karlovacko piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brKarlovacko; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Karlovacko","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxHeineken.isChecked()){
                            int brHeineken = Integer.valueOf(etBrojHeineken.getText().toString());
                            if(brHeineken < 1 || brHeineken > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj heineken piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brHeineken; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Heineken","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxAmber.isChecked()){
                            int brAmber = Integer.valueOf(etBrojAmber.getText().toString());
                            if(brAmber < 1 || brAmber > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj amber piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brAmber; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Amber","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxCorona.isChecked()){
                            int brCorona = Integer.valueOf(etBrojCorona.getText().toString());
                            if(brCorona < 1 || brCorona > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj corona piva.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brCorona; i++){
                                    Pice pice = new Pice(selectedStol, "Pivo", "Amber","11");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                    }
                    if(chkboxVina.isChecked()) {
                        //Toast.makeText(DodajNarudzbuActivity.this,"Zelim dodat vino", Toast.LENGTH_SHORT).show();
                        if(chkboxFrankovka.isChecked()){
                            int brFrankovka = Integer.valueOf(etBrojFrankovka.getText().toString());
                            if(brFrankovka < 1 || brFrankovka > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj frankovka vina.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brFrankovka; i++){
                                    Pice pice = new Pice(selectedStol, "Vino", "Frankovka","70");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxGrasevina.isChecked()){
                            int brGrasevina = Integer.valueOf(etBrojGrasevina.getText().toString());
                            if(brGrasevina < 1 || brGrasevina > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj grasevina vina.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brGrasevina; i++){
                                    Pice pice = new Pice(selectedStol, "Vino", "Grasevina","70");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxTraminac.isChecked()){
                            int brTraminac = Integer.valueOf(etBrojTraminac.getText().toString());
                            if(brTraminac < 1 || brTraminac > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj traminac vina.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brTraminac; i++){
                                    Pice pice = new Pice(selectedStol, "Vino", "Traminac","70");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxZdrijebcevakrv.isChecked()){
                            int brZdrijepcevaKrv = Integer.valueOf(etBrojZdrijebcevakrv.getText().toString());
                            if(brZdrijepcevaKrv < 1 || brZdrijepcevaKrv > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj zdrijebceva krv vina.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brZdrijepcevaKrv; i++){
                                    Pice pice = new Pice(selectedStol, "Vino", "Zdrijebceva krv","70");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                    }
                    if(chkboxTopliNapitci.isChecked()) {
                        //Toast.makeText(DodajNarudzbuActivity.this,"Zelim dodat topli napitak", Toast.LENGTH_SHORT).show();
                        if(chkboxKava.isChecked()){
                            int brKava = Integer.valueOf(etBrojKava.getText().toString());
                            if(brKava < 1 || brKava > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj kava.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brKava; i++){
                                    Pice pice = new Pice(selectedStol, "Topli napitak", "Kava","9");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxCappuccino.isChecked()){
                            int brCappuccina = Integer.valueOf(etBrojCappuccino.getText().toString());
                            if(brCappuccina < 1 || brCappuccina > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj cappuccina.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brCappuccina; i++){
                                    Pice pice = new Pice(selectedStol, "Topli napitak", "Cappuccino","9");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxToplacokolada.isChecked()){
                            int brTopla = Integer.valueOf(etBrojToplacokolada.getText().toString());
                            if(brTopla < 1 || brTopla > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj toplih cokolada.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brTopla; i++){
                                    Pice pice = new Pice(selectedStol, "Topli napitak", "Topla cokolada","9");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                    }
                    if(chkboxSokovi.isChecked()) {
                        //Toast.makeText(DodajNarudzbuActivity.this,"Zelim dodat sok", Toast.LENGTH_SHORT).show();
                        if(chkboxCedevita.isChecked()){
                            int brCedevita = Integer.valueOf(etBrojCedevita.getText().toString());
                            if(brCedevita < 1 || brCedevita > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj cedevita.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brCedevita; i++){
                                    Pice pice = new Pice(selectedStol, "Sok", "Cedevita","10");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxFanta.isChecked()){
                            int brFanta = Integer.valueOf(etBrojFanti.getText().toString());
                            if(brFanta < 1 || brFanta > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj fanti.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brFanta; i++){
                                    Pice pice = new Pice(selectedStol, "Sok", "Fanta","10");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxCocaCola.isChecked()){
                            int brCocaCola = Integer.valueOf(etBrojCocaColi.getText().toString());
                            if(brCocaCola < 1 || brCocaCola > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj coli.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brCocaCola; i++){
                                    Pice pice = new Pice(selectedStol, "Sok", "Coca Cola","10");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                        if(chkboxVocni.isChecked()){
                            int brVocni = Integer.valueOf(etBrojVocnih.getText().toString());
                            if(brVocni < 1 || brVocni > 20){
                                Toast.makeText(DodajNarudzbuActivity.this,"Nemoguce unijeti toliki" +
                                        " broj vocnih sokova.", Toast.LENGTH_LONG).show();
                            }
                            else {
                                for (int i = 0; i < brVocni; i++){
                                    Pice pice = new Pice(selectedStol, "Sok", "Vocni","10");
                                    NarudzbaDbHelper.getInstance(getApplicationContext()).insertPice(pice);
                                }
                            }
                        }
                    }
                    finish();
                }
            }
        });

        btnAddToMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DodajNarudzbuActivity.this, MainActivity.class));
                finish();
            }
        });

        chkboxPiva.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkboxPiva.isChecked()) {
                    layoutOdaberiPiva.setVisibility(View.VISIBLE);
                }
                else {
                    layoutOdaberiPiva.setVisibility(View.INVISIBLE);
                }
            }
        });

        chkboxVina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkboxVina.isChecked()) {
                    layoutOdaberiVina.setVisibility(View.VISIBLE);
                }
                else {
                    layoutOdaberiVina.setVisibility(View.INVISIBLE);
                }
            }
        });

        chkboxTopliNapitci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkboxTopliNapitci.isChecked()) {
                    layoutOdaberiTopleNapitke.setVisibility(View.VISIBLE);
                }
                else {
                    layoutOdaberiTopleNapitke.setVisibility(View.INVISIBLE);
                }
            }
        });

        chkboxSokovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(chkboxSokovi.isChecked()) {
                    layoutOdaberiSokove.setVisibility(View.VISIBLE);
                }
                else {
                    layoutOdaberiSokove.setVisibility(View.INVISIBLE);
                }
            }
        });
    }

    private void initializeDodajNarudzbuActivityUI(){
        btnAddToMain = (Button) findViewById(R.id.btnAddToMain);
        btnAddNarudzbaToDb = (Button) findViewById(R.id.btnAddNarudzbaToDb);
        chkboxSokovi = (CheckBox) findViewById(R.id.chkboxSokovi);
        chkboxPiva = (CheckBox) findViewById(R.id.chkboxPiva);
        chkboxVina = (CheckBox) findViewById(R.id.chkboxVina);
        chkboxTopliNapitci = (CheckBox) findViewById(R.id.chkboxTopliNapitci);
        layoutOdaberiPiva = (LinearLayout) findViewById(R.id.layoutOdaberiPiva);
        layoutOdaberiSokove = (LinearLayout) findViewById(R.id.layoutOdaberiSokove);
        layoutOdaberiTopleNapitke = (LinearLayout) findViewById(R.id.layoutOdaberiTopleNapitke);
        layoutOdaberiVina = (LinearLayout) findViewById(R.id.layoutOdaberiVina);
        spStolovi = (Spinner) findViewById(R.id.spStolovi);

        chkboxCedevita = (CheckBox) findViewById(R.id.chkboxCedevita);
        etBrojCedevita = (EditText) findViewById(R.id.etBrojCedevita);
        chkboxFanta  = (CheckBox) findViewById(R.id.chkboxFanta);
        etBrojFanti = (EditText) findViewById(R.id.etBrojFanti);
        chkboxCocaCola  = (CheckBox) findViewById(R.id.chkboxCocaCola);
        etBrojCocaColi = (EditText) findViewById(R.id.etBrojCocaColi);
        chkboxVocni = (CheckBox) findViewById(R.id.chkboxVocni);
        etBrojVocnih = (EditText) findViewById(R.id.etBrojVocnih);
        chkboxOsjecko  = (CheckBox) findViewById(R.id.chkboxOsjecko);
        etBrojOsjecko = (EditText) findViewById(R.id.etBrojOsjecko);
        chkboxOzujsko = (CheckBox) findViewById(R.id.chkboxOzujsko);
        etBrojOzujsko = (EditText) findViewById(R.id.etBrojOzujsko);
        chkboxKarlovacko  = (CheckBox) findViewById(R.id.chkboxKarlovacko);
        etBrojKarlovacko = (EditText) findViewById(R.id.etBrojKarlovacko);
        chkboxHeineken = (CheckBox) findViewById(R.id.chkboxHeineken);
        etBrojHeineken = (EditText) findViewById(R.id.etBrojHeineken);
        chkboxAmber  = (CheckBox) findViewById(R.id.chkboxAmber);
        etBrojAmber = (EditText) findViewById(R.id.etBrojAmber);
        chkboxCorona = (CheckBox) findViewById(R.id.chkboxCorona);
        etBrojCorona = (EditText) findViewById(R.id.etBrojCorona);
        chkboxKava  = (CheckBox) findViewById(R.id.chkboxKava);
        etBrojKava = (EditText) findViewById(R.id.etBrojKava);
        chkboxCappuccino = (CheckBox) findViewById(R.id.chkboxCappuccino);
        etBrojCappuccino = (EditText) findViewById(R.id.etBrojCappuccino);
        chkboxToplacokolada  = (CheckBox) findViewById(R.id.chkboxToplacokolada);
        etBrojToplacokolada = (EditText) findViewById(R.id.etBrojToplacokolada);
        chkboxFrankovka = (CheckBox) findViewById(R.id.chkboxFrankovka);
        etBrojFrankovka = (EditText) findViewById(R.id.etBrojFrankovka);
        chkboxGrasevina  = (CheckBox) findViewById(R.id.chkboxGrasevina);
        etBrojGrasevina = (EditText) findViewById(R.id.etBrojGrasevina);
        chkboxZdrijebcevakrv = (CheckBox) findViewById(R.id.chkboxZdrijebcevakrv);
        etBrojZdrijebcevakrv = (EditText) findViewById(R.id.etBrojZdrijebcevakrv);
        chkboxTraminac  = (CheckBox) findViewById(R.id.chkboxTraminac);
        etBrojTraminac = (EditText) findViewById(R.id.etBrojTraminac);

    }
}
