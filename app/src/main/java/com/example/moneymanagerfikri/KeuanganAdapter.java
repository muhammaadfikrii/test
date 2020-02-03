package com.example.moneymanagerfikri;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.moneymanagerfikri.model.Keuangan;

import java.util.List;

public class KeuanganAdapter extends BaseAdapter {
    List<Keuangan> keuangan;
    Context context;
    LayoutInflater inflater;
    public KeuanganAdapter(Context context, List<Keuangan> keuangan){
        this.keuangan = keuangan;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return keuangan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.row_item, null);
        TextView txtTanggal = convertView.findViewById(R.id.txt_tanggal);
        TextView txtMasuk = convertView.findViewById(R.id.txt_masuk);
        TextView txtKeluar = convertView.findViewById(R.id.txt_keluar);

        txtTanggal.setText(keuangan.get(position).getTanggal());
        txtMasuk.setText(keuangan.get(position).getMasuk());
        txtKeluar.setText(keuangan.get(position).getKeluar());
        return convertView;
    }
}
