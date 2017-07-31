package com.ad.zakatrizki.utils;

import android.content.Context;
import android.content.SharedPreferences;

import com.ad.zakatrizki.Zakat;

public final class Prefs {

    public static SharedPreferences get(final Context context) {
        return context.getSharedPreferences("com.ad.zakatrizki",
                Context.MODE_PRIVATE);
    }

    public static String getPref(final Context context, String pref, String def) {
        SharedPreferences prefs = Prefs.get(context);
        String val = prefs.getString(pref, def);

        if (TextUtils.isNullOrEmpty(val))
            return def;
        else
            return val;
    }

    public static void putPref(final Context context, String pref, String val) {
        SharedPreferences prefs = Prefs.get(context);
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString(pref, val);
        editor.apply();
    }


    //set URL
    public static String getUrl(final Context context) {
        String e = Prefs.getPref(context, Zakat.URL, null);
        return e;
    }

    public static void putUrl(final Context context, String url) {
        Prefs.putPref(context, Zakat.URL, url);
    }

    // last selected
    public static int getLastSelected(final Context context) {
        String e = Prefs.getPref(context, Zakat.LAST_SELECTED, String.valueOf(Zakat.VIEW_TYPE_MUSTAHIQ));
        return Integer.parseInt(e);
    }

    public static void putLastSelected(final Context context, int view_type) {
        Prefs.putPref(context, Zakat.LAST_SELECTED, String.valueOf(view_type));
    }

    // last selected
    public static boolean getLogin(final Context context) {
        String e = Prefs.getPref(context, Zakat.LOGIN, "false");
        return Boolean.parseBoolean(e);
    }

    public static void putLogin(final Context context, boolean login) {
        Prefs.putPref(context, Zakat.LOGIN, String.valueOf(login));
    }

    public static String getIdUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.ID_USER, null);
        return e;
    }

    public static void putIdUser(final Context context, String id_user) {
        Prefs.putPref(context, Zakat.ID_USER, id_user);
    }

    public static String getTipeUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.TIPE_USER, "3");
        return e;
    }

    public static void putTipeUser(final Context context, String tipe_user) {
        Prefs.putPref(context, Zakat.TIPE_USER, tipe_user);
    }

    public static String getNamaUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.NAMA_USER, null);
        return e;
    }

    public static void putNamaUser(final Context context, String id_user) {
        Prefs.putPref(context, Zakat.NAMA_USER, id_user);
    }
    public static String getAlamatUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.ALAMAT_USER, null);
        return e;
    }

    public static void putAlamatUser(final Context context, String id_user) {
        Prefs.putPref(context, Zakat.ALAMAT_USER, id_user);
    }
    public static String getNomorIdentitasUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.NOMOR_IDENTITAS_USER, null);
        return e;
    }

    public static void putNomorIdentitasUser(final Context context, String id_user) {
        Prefs.putPref(context, Zakat.NOMOR_IDENTITAS_USER, id_user);
    }
    public static String getNomorTelpUser(final Context context) {
        String e = Prefs.getPref(context, Zakat.NOMOR_TELP_USER, null);
        return e;
    }

    public static void getIdAmilZakat(final Context context, String id_amil_zakat) {
        Prefs.putPref(context, Zakat.ID_AMIL_ZAKAT, id_amil_zakat);
    }

    public static void putIdAmilZakat(final Context context, String id_amil_zakat) {
        Prefs.putPref(context, Zakat.ID_AMIL_ZAKAT, id_amil_zakat);
    }

    public static void getIdBadanAmilZakat(final Context context, String id_badan_amil_zakat) {
        Prefs.putPref(context, Zakat.ID_BADAN_AMIL_ZAKAT, id_badan_amil_zakat);
    }

    public static void putIdBadanAmilZakat(final Context context, String id_badan_amil_zakat) {
        Prefs.putPref(context, Zakat.ID_BADAN_AMIL_ZAKAT, id_badan_amil_zakat);
    }

    public static void getNamaAmilZakat(final Context context, String id_badan_amil_zakat) {
        Prefs.putPref(context, Zakat.NAMA_BADAN_AMIL_ZAKAT, id_badan_amil_zakat);
    }

    public static void putNamaAmilZakat(final Context context, String id_badan_amil_zakat) {
        Prefs.putPref(context, Zakat.NAMA_BADAN_AMIL_ZAKAT, id_badan_amil_zakat);
    }


    public static void putNomorTelpUser(final Context context, String id_user) {
        Prefs.putPref(context, Zakat.NOMOR_TELP_USER, id_user);
    }

}