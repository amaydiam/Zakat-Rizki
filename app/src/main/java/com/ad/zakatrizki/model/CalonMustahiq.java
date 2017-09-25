package com.ad.zakatrizki.model;

import android.os.Parcel;
import android.os.Parcelable;

public class CalonMustahiq implements Parcelable {

    // Attributes

    public String id_calon_mustahiq;
    public String nama_calon_mustahiq;
    public String alamat_calon_mustahiq;
    public String latitude_calon_mustahiq;
    public String longitude_calon_mustahiq;
    public String no_identitas_calon_mustahiq;
    public String no_telp_calon_mustahiq;
    public String jumlah_anak_calon_mustahiq ;
    public String status_pernikahan_calon_mustahiq ;
    public String status_tempat_tinggal_calon_mustahiq;
    public String status_pekerjaan_calon_mustahiq;
    public String id_user_perekomendasi;
    public String nama_perekomendasi_calon_mustahiq;
    public String alasan_perekomendasi_calon_mustahiq;
    public String photo_1;
    public String photo_2;
    public String photo_3;
    public String caption_photo_1;
    public String caption_photo_2;
    public String caption_photo_3;
    public String status_calon_mustahiq;
    public String jumlah_rating;
    public String jumlah_rating_amil_zakat;

    public CalonMustahiq(String id_calon_mustahiq, String nama_calon_mustahiq, String alamat_calon_mustahiq, String latitude_calon_mustahiq, String longitude_calon_mustahiq, String no_identitas_calon_mustahiq, String no_telp_calon_mustahiq,

                         String jumlah_anak_calon_mustahiq ,
                         String status_pernikahan_calon_mustahiq,
                         String status_tempat_tinggal_calon_mustahiq,
                         String status_pekerjaan_calon_mustahiq,
                         String id_user_perekomendasi,
                         String nama_perekomendasi_calon_mustahiq,
                         String alasan_perekomendasi_calon_mustahiq,
                         String photo_1, String photo_2, String photo_3,
                         String caption_photo_1, String caption_photo_2,
                         String caption_photo_3, String status_calon_mustahiq,
                         String jumlah_rating,
                         String jumlah_rating_amil_zakat
    ) {
        this.id_calon_mustahiq = id_calon_mustahiq;
        this.nama_calon_mustahiq = nama_calon_mustahiq;
        this.alamat_calon_mustahiq = alamat_calon_mustahiq;
        this.latitude_calon_mustahiq = latitude_calon_mustahiq;
        this.longitude_calon_mustahiq = longitude_calon_mustahiq;
        this.no_identitas_calon_mustahiq = no_identitas_calon_mustahiq;
        this.no_telp_calon_mustahiq = no_telp_calon_mustahiq;
        this.jumlah_anak_calon_mustahiq = jumlah_anak_calon_mustahiq;
        this.status_pernikahan_calon_mustahiq = status_pernikahan_calon_mustahiq;
        this.status_tempat_tinggal_calon_mustahiq = status_tempat_tinggal_calon_mustahiq;
        this.status_pekerjaan_calon_mustahiq = status_pekerjaan_calon_mustahiq;
        this.id_user_perekomendasi = id_user_perekomendasi;
        this.nama_perekomendasi_calon_mustahiq = nama_perekomendasi_calon_mustahiq;
        this.alasan_perekomendasi_calon_mustahiq = alasan_perekomendasi_calon_mustahiq;
        this.photo_1 = photo_1;
        this.photo_2 = photo_2;
        this.photo_3 = photo_3;
        this.caption_photo_1 = caption_photo_1;
        this.caption_photo_2 = caption_photo_2;
        this.caption_photo_3 = caption_photo_3;
        this.status_calon_mustahiq = status_calon_mustahiq;
        this.jumlah_rating = jumlah_rating;
        this.jumlah_rating_amil_zakat = jumlah_rating_amil_zakat;
    }

    protected CalonMustahiq(Parcel in) {
        id_calon_mustahiq = in.readString();
        nama_calon_mustahiq = in.readString();
        alamat_calon_mustahiq = in.readString();
        latitude_calon_mustahiq = in.readString();
        longitude_calon_mustahiq = in.readString();
        no_identitas_calon_mustahiq = in.readString();
        no_telp_calon_mustahiq = in.readString();
        jumlah_anak_calon_mustahiq = in.readString();
        status_pernikahan_calon_mustahiq = in.readString();
        status_tempat_tinggal_calon_mustahiq = in.readString();
        status_pekerjaan_calon_mustahiq = in.readString();
        id_user_perekomendasi = in.readString();
        nama_perekomendasi_calon_mustahiq = in.readString();
        alasan_perekomendasi_calon_mustahiq = in.readString();
        photo_1 = in.readString();
        photo_2 = in.readString();
        photo_3 = in.readString();
        caption_photo_1 = in.readString();
        caption_photo_2 = in.readString();
        caption_photo_3 = in.readString();
        status_calon_mustahiq = in.readString();
        jumlah_rating = in.readString();
        jumlah_rating_amil_zakat = in.readString();
    }

    public static final Creator<CalonMustahiq> CREATOR = new Creator<CalonMustahiq>() {
        @Override
        public CalonMustahiq createFromParcel(Parcel in) {
            return new CalonMustahiq(in);
        }

        @Override
        public CalonMustahiq[] newArray(int size) {
            return new CalonMustahiq[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id_calon_mustahiq);
        dest.writeString(nama_calon_mustahiq);
        dest.writeString(alamat_calon_mustahiq);
        dest.writeString(latitude_calon_mustahiq);
        dest.writeString(longitude_calon_mustahiq);
        dest.writeString(no_identitas_calon_mustahiq);
        dest.writeString(no_telp_calon_mustahiq);
        dest.writeString(jumlah_anak_calon_mustahiq);
        dest.writeString(status_pernikahan_calon_mustahiq);
        dest.writeString(status_tempat_tinggal_calon_mustahiq);
        dest.writeString(status_pekerjaan_calon_mustahiq);
        dest.writeString(id_user_perekomendasi);
        dest.writeString(nama_perekomendasi_calon_mustahiq);
        dest.writeString(alasan_perekomendasi_calon_mustahiq);
        dest.writeString(photo_1);
        dest.writeString(photo_2);
        dest.writeString(photo_3);
        dest.writeString(caption_photo_1);
        dest.writeString(caption_photo_2);
        dest.writeString(caption_photo_3);
        dest.writeString(status_calon_mustahiq);
        dest.writeString(jumlah_rating);
        dest.writeString(jumlah_rating_amil_zakat);
    }
}
