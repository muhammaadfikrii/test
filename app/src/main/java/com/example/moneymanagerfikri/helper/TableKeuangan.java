package com.example.moneymanagerfikri.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.moneymanagerfikri.model.Keuangan;

import java.util.ArrayList;
import java.util.List;

public class TableKeuangan extends DbHelper {
    public TableKeuangan(Context context) {
        super(context);
    }
    public void insert(Keuangan keuangan){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "INSERT INTO keuangan(tanggal, masuk, keluar) VALUES(" +
                "'"+keuangan.getTanggal()+"'," +
                "'"+keuangan.getMasuk()+"'," +
                "'"+keuangan.getKeluar()+"')";
        database.execSQL(query);
        database.close();
    }

    public void update(int id, Keuangan keuangan){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "UPDATE keuangan SET " +
                "tanggal = '"+keuangan.getTanggal()+"'," +
                "masuk = '"+keuangan.getMasuk()+"'," +
                "keluar = '"+keuangan.getKeluar()+"'" +
                " WHERE " +
                "id = "+id;
        database.execSQL(query);
        database.close();
    }
    public void delete(int id){
        SQLiteDatabase database = this.getWritableDatabase();
        String query = "DELETE FROM keuangan WHERE id="+id;
        database.execSQL(query);
        database.close();
    }

    public Keuangan get(int id){
        Keuangan keuangan = new Keuangan();
        String query = "SELECT * FROM keuangan WHERE id"+id;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()){
            keuangan.setId(Integer.parseInt(cursor.getString(0)));
            keuangan.setTanggal(cursor.getString(1));
            keuangan.setMasuk(cursor.getString(2));
            keuangan.setKeluar(cursor.getString(3));
        }
        return keuangan;
    }
    public List<Keuangan> getAll(){
        List<Keuangan> keuangan = new ArrayList<>();
        String query = "SELECT * FROM keuangan";
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor cursor = database.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do {
                Keuangan temp = new Keuangan();
                temp.setId(Integer.parseInt(cursor.getString(0)));
                temp.setTanggal(cursor.getString(1));
                temp.setMasuk(cursor.getString(2));
                temp.setKeluar(cursor.getString(3));
                keuangan.add(temp);
            }while (cursor.moveToNext());
        }
        return keuangan;
    }

}
