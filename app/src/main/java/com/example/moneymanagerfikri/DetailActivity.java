package com.example.moneymanagerfikri;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.moneymanagerfikri.R;
import com.example.moneymanagerfikri.model.Keuangan;

public class DetailActivity extends AppCompatActivity {
    TextView txtTanggal, txtMasuk, txtKeluar, txtTotal;
    Keuangan keuangan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtKeluar = findViewById(R.id.txt_keluar);
        txtMasuk= findViewById(R.id.txt_masuk);
        txtTanggal = findViewById(R.id.txt_tanggal);
        txtTotal = findViewById(R.id.txt_total);
        keuangan = getIntent().getParcelableExtra("keuangan");

        txtTanggal.setText(keuangan.getTanggal());
        txtMasuk.setText(keuangan.getMasuk());
        txtKeluar.setText(keuangan.getKeluar());
        int total = Integer.parseInt(keuangan.getMasuk()) - Integer.parseInt(keuangan.getKeluar());
        txtTotal.setText(""+total);
    }
}
