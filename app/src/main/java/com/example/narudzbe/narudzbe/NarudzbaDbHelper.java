package com.example.narudzbe.narudzbe;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import javax.xml.validation.Schema;


public class NarudzbaDbHelper extends SQLiteOpenHelper {

    private static NarudzbaDbHelper narudzbaDBHelper = null;
    private static final String CREATE_TABLE_NARUDZBE = "CREATE TABLE " + Schema.TABLE_NARUDZBE +
            " (" + Schema.STOL + " TEXT);";
    private static final String DROP_TABLE_NARUDZBE = "DROP TABLE IF EXISTS " + Schema.TABLE_NARUDZBE;
    private static final String CREATE_TABLE_PICA = "CREATE TABLE " + Schema.TABLE_PICA +
            " (" + Schema.NARUDZBA + " TEXT," + Schema.KATEGORIJA + " TEXT," + Schema.IME + " TEXT," +
             Schema.CIJENA + " TEXT);";
    private static final String DROP_TABLE_PICA = "DROP TABLE IF EXISTS " + Schema.TABLE_PICA;
    private static final String SELECT_ALL_NARUDZBA = "SELECT " + Schema.STOL +  " FROM " + Schema.TABLE_NARUDZBE;
    private static final String SELECT_ALL_PICA = "SELECT "  + Schema.NARUDZBA + "," +
            Schema.KATEGORIJA + "," + Schema.IME +  " FROM " + Schema.TABLE_PICA;

    private NarudzbaDbHelper (Context context){
        super(context.getApplicationContext(),Schema.DATABASE_NAME,null,Schema.SCHEMA_VERSION);
    }

    public static synchronized NarudzbaDbHelper getInstance(Context context){
        if(narudzbaDBHelper == null){
            narudzbaDBHelper = new NarudzbaDbHelper(context);
        }
        return narudzbaDBHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_NARUDZBE);
        db.execSQL(CREATE_TABLE_PICA);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_NARUDZBE);
        db.execSQL(DROP_TABLE_PICA);
        this.onCreate(db);
    }

    public ArrayList<Narudzba> getAllNarudzbe(){
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor narudzbaCursor = writeableDatabase.rawQuery(SELECT_ALL_NARUDZBA,null);
        ArrayList<Narudzba> narudzbe = new ArrayList<>();
        if(narudzbaCursor.moveToFirst()){
            do{
                String stol = narudzbaCursor.getString(0);
                narudzbe.add(new Narudzba(stol));
            }while(narudzbaCursor.moveToNext());
        }
        narudzbaCursor.close();
        writeableDatabase.close();
        return narudzbe;
    }


    public ArrayList<Pice> getAllPica(){
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor piceCursor = writeableDatabase.rawQuery(SELECT_ALL_PICA,null);
        ArrayList<Pice> pica = new ArrayList<>();
        if(piceCursor.moveToFirst()){
            do{
                String narudzba = piceCursor.getString(0);
                String kategorija = piceCursor.getString(1);
                String ime = piceCursor.getString(2);
                String cijena = piceCursor.getString(3);
                pica.add(new Pice(narudzba,kategorija,ime,cijena));
            }while(piceCursor.moveToNext());
        }
        piceCursor.close();
        writeableDatabase.close();
        return pica;
    }

    public ArrayList<Pice> getPicaByStol(String stol){
        String selectQuery = "SELECT * FROM " + Schema.TABLE_PICA + " WHERE " + Schema.NARUDZBA + " = '" + stol + "';";
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor piceCursor = writeableDatabase.rawQuery(selectQuery,null);
        ArrayList<Pice> pica = new ArrayList<>();
        if(piceCursor.moveToFirst()){
            do{
                String narudzba = piceCursor.getString(0);
                String kategorija = piceCursor.getString(1);
                String ime = piceCursor.getString(2);
                String cijena = piceCursor.getString(3);
                pica.add(new Pice(narudzba,kategorija,ime,cijena));
            }while(piceCursor.moveToNext());
        }
        piceCursor.close();
        writeableDatabase.close();
        return pica;
    }

    public boolean isNarudzbaAdded(String stol){
        String selectQuery = "SELECT * FROM " + Schema.TABLE_NARUDZBE + " WHERE " + Schema.STOL + " = '" + stol + "';";
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        Cursor narudzbaCursor = writeableDatabase.rawQuery(selectQuery,null);
        ArrayList<Narudzba> narudzbe = new ArrayList<>();
        if(narudzbaCursor.moveToFirst()){
            do{
                String naruceno = narudzbaCursor.getString(0);
                narudzbe.add(new Narudzba(naruceno));
            }while(narudzbaCursor.moveToNext());
        }
        narudzbaCursor.close();
        writeableDatabase.close();

        return narudzbe.isEmpty();
    }

    public void insertNarudzba(Narudzba narudzba){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.STOL, narudzba.getStol());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_NARUDZBE, Schema.STOL, contentValues);
        writeableDatabase.close();
    }

    public void insertPice(Pice pice){
        ContentValues contentValues = new ContentValues();
        contentValues.put(Schema.NARUDZBA, pice.getNarudzba());
        contentValues.put(Schema.KATEGORIJA, pice.getKategorija());
        contentValues.put(Schema.IME, pice.getIme());
        contentValues.put(Schema.CIJENA, pice.getCijena());
        SQLiteDatabase writeableDatabase = this.getWritableDatabase();
        writeableDatabase.insert(Schema.TABLE_PICA, Schema.NARUDZBA, contentValues);
        writeableDatabase.close();
    }

    public void deleteNarudzbaByStol(String stol) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + Schema.TABLE_NARUDZBE + " WHERE "+ Schema.STOL + "='" + stol + "'");
        db.close();
    }

    public void deletePicaByStol(String stol) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM " + Schema.TABLE_PICA + " WHERE "+ Schema.NARUDZBA + "='" + stol + "'");
        db.close();
    }

    public static class Schema{
        private static final int SCHEMA_VERSION = 1;
        private static final String DATABASE_NAME = "narudzbe.db";
        static final String TABLE_NARUDZBE = "narudzbe";
        static final String TABLE_PICA = "pica";
        static final String STOL = "stol";
        static final String NARUDZBA = "narudzba";
        static final String KATEGORIJA = "kategorija";
        static final String IME = "ime";
        static final String CIJENA = "cijena";
    }
}
