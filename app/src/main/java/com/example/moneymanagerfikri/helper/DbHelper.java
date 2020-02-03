package com.example.moneymanagerfikri.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    public static  final int DB_VERSION=1;
    public static final String DB_NAME = "keuangandb";
    public DbHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        final String sql = "CREATE TABLE keuangan (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "tanggal TEXT NOT NULL," +
                "MASUK TEXT NOT NULL," +
                "KELUAR TEXT NOT NULL)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS KEUANGAN");
        onCreate(db);
    }
}
