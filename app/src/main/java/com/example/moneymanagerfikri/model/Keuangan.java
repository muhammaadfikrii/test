package com.example.moneymanagerfikri.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Keuangan implements Parcelable {
    private int id;
    private String tanggal;
    private String masuk;
    private String keluar;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getMasuk() {
        return masuk;
    }

    public void setMasuk(String masuk) {
        this.masuk = masuk;
    }

    public String getKeluar() {
        return keluar;
    }

    public void setKeluar(String keluar) {
        this.keluar = keluar;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.tanggal);
        dest.writeString(this.masuk);
        dest.writeString(this.keluar);
    }

    public Keuangan() {
    }

    protected Keuangan(Parcel in) {
        this.id = in.readInt();
        this.tanggal = in.readString();
        this.masuk = in.readString();
        this.keluar = in.readString();
    }

    public static final Parcelable.Creator<Keuangan> CREATOR = new Parcelable.Creator<Keuangan>() {
        @Override
        public Keuangan createFromParcel(Parcel source) {
            return new Keuangan(source);
        }

        @Override
        public Keuangan[] newArray(int size) {
            return new Keuangan[size];
        }
    };
}
