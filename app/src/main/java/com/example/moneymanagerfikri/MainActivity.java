package com.example.moneymanagerfikri;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import com.example.moneymanagerfikri.helper.TableKeuangan;
import com.example.moneymanagerfikri.model.Keuangan;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText etTanggal, etMasuk, etKeluar ;
    Button btnSimpan, btnUpdate, btnHapus;
    ListView lvKeuangan;
    List<Keuangan> keuangan;
    TableKeuangan tableKeuangan;
    KeuanganAdapter adapter;
    int itemIdSelected = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        keuangan = new ArrayList<>();

        etTanggal = findViewById(R.id.et_tanggal);
        etMasuk = findViewById(R.id.et_masuk);

        btnSimpan = findViewById(R.id.btn_save);
        btnUpdate = findViewById(R.id.btn_update);
        etKeluar = findViewById(R.id.et_keluar);
        btnHapus = findViewById(R.id.btn_delete);
        lvKeuangan = findViewById(R.id.lv_keuangan);

        tableKeuangan = new TableKeuangan(this);
        keuangan.addAll(tableKeuangan.getAll());
        adapter = new KeuanganAdapter(this, keuangan);
        lvKeuangan.setAdapter(adapter);
        etTanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePick();
            }
        });
        btnSimpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });

        btnHapus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
            }
        });

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                update();
            }
        });
        lvKeuangan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                setViewData(keuangan.get(position));
                return false;
            }
        });
        lvKeuangan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                intent.putExtra("keuangan", keuangan.get(position));
                startActivity(intent);
            }
        });
    }
    public void refresh(){
        keuangan.clear();
        keuangan.addAll(tableKeuangan.getAll());
        adapter = new KeuanganAdapter(this, keuangan);
        lvKeuangan.setAdapter(adapter);
    }
    public void clear(){
        etTanggal.setText("");
        etMasuk.setText("");
        etKeluar.setText("");
    }
    public void update(){
        Keuangan tmp = new Keuangan();
        tmp.setTanggal(etTanggal.getText().toString());
        tmp.setMasuk(etMasuk.getText().toString());
        tmp.setKeluar(etKeluar.getText().toString());
        tableKeuangan.update(itemIdSelected,tmp);
        clear();
        refresh();
    }
    public void save(){
        Keuangan tmp = new Keuangan();
        tmp.setTanggal(etTanggal.getText().toString());
        tmp.setMasuk(etMasuk.getText().toString());
        tmp.setKeluar(etKeluar.getText().toString());
        tableKeuangan.insert(tmp);
        clear();
        refresh();
    }
    public void delete(){
        Keuangan tmp = new Keuangan();
        tmp.setTanggal(etTanggal.getText().toString());
        tmp.setMasuk(etMasuk.getText().toString());
        tmp.setKeluar(etKeluar.getText().toString());
        tableKeuangan.delete(itemIdSelected);
        clear();
        refresh();
    }
    public void setViewData(Keuangan tmp){
        itemIdSelected = tmp.getId();
        etTanggal.setText(tmp.getTanggal());
        etMasuk.setText(tmp.getMasuk());
        etKeluar.setText(tmp.getKeluar());
    }

    public void datePick(){
        final Calendar calendar = Calendar.getInstance();
        int mYear = calendar.get(Calendar.YEAR);
        int mMonth = calendar.get(Calendar.MONTH);
        int mDay = calendar.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                etTanggal.setText(i+"-"+i1+"-"+i2);
            }
        },mYear,mMonth,mDay);
        datePickerDialog.show();
    }
}

