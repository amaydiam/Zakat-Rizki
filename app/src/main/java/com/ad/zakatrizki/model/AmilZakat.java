package com.ad.zakatrizki.model;

import android.os.Parcel;
import android.os.Parcelable;

public class AmilZakat implements Parcelable {

    // Attributes
    public String id_amil_zakat;
    public String nama_validasi_amil_zakat;
    public String nama_type_validasi_mustahiq;

    // Constructor
    public AmilZakat(String id_amil_zakat, String nama_validasi_amil_zakat, String nama_type_validasi_mustahiq) {
        this.id_amil_zakat = id_amil_zakat;
        this.nama_validasi_amil_zakat = nama_validasi_amil_zakat;
        this.nama_type_validasi_mustahiq = nama_type_validasi_mustahiq;
    }
    public AmilZakat(Parcel in) {
        this.id_amil_zakat = in.readString();
        this.nama_validasi_amil_zakat = in.readString();
        this.nama_type_validasi_mustahiq = in.readString();
    }

    // Parcelable Creator
    public static final Creator CREATOR = new Creator() {
        public AmilZakat createFromParcel(Parcel in) {
            return new AmilZakat(in);
        }
        public AmilZakat[] newArray(int size) {
            return new AmilZakat[size];
        }
    };

    // Parcelling methods
    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(id_amil_zakat);
        out.writeString(nama_validasi_amil_zakat);
        out.writeString(nama_type_validasi_mustahiq);
    }
    @Override
    public int describeContents() {
        return 0;
    }
}
