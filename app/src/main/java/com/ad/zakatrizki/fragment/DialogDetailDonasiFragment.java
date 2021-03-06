package com.ad.zakatrizki.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.model.LaporanDonasi;
import com.ad.zakatrizki.utils.Menus;
import com.ad.zakatrizki.utils.TextUtils;
import com.ad.zakatrizki.utils.Utils;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.MaterialIcons;

import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class DialogDetailDonasiFragment extends DialogFragment {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.foto_profil_muzaki)
    AvatarView fotoProfilMuzaki;
    @BindView(R.id.nama_muzaki)
    RobotoBoldTextView namaMuzaki;
    @BindView(R.id.alamat_muzaki)
    RobotoLightTextView alamatMuzaki;
    @BindView(R.id.no_identitas_muzaki)
    RobotoLightTextView noIdentitasMuzaki;
    @BindView(R.id.no_telp_muzaki)
    RobotoLightTextView noTelpMuzaki;
    @BindView(R.id.status_muzaki)
    RobotoLightTextView statusMuzaki;
    @BindView(R.id.foto_profil_mustahiq)
    AvatarView fotoProfilMustahiq;
    @BindView(R.id.nama_calon_mustahiq)
    RobotoBoldTextView namaMustahiq;
    @BindView(R.id.alamat_calon_mustahiq)
    RobotoLightTextView alamatMustahiq;
    @BindView(R.id.no_identitas_calon_mustahiq)
    RobotoLightTextView noIdentitasMustahiq;
    @BindView(R.id.no_telp_calon_mustahiq)
    RobotoLightTextView noTelpMustahiq;
    @BindView(R.id.jumlah_anak_calon_mustahiq)
    RobotoLightTextView jumlahAnakCalonMustahiq;
    @BindView(R.id.status_pernikahan_calon_mustahiq)
    RobotoLightTextView statusPernikahanCalonMustahiq;
    @BindView(R.id.status_tempat_tinggal_calon_mustahiq)
    RobotoLightTextView statusTempatTinggalCalonMustahiq;
    @BindView(R.id.status_pekerjaan_calon_mustahiq)
    RobotoLightTextView statusPekerjaanCalonMustahiq;
    @BindView(R.id.status_calon_mustahiq)
    RobotoLightTextView statusMustahiq;
    @BindView(R.id.nama_validasi_amil_zakat)
    RobotoLightTextView namaAmilZakat;
    @BindView(R.id.nama_type_validasi_mustahiq)
    RobotoLightTextView namaTypeValidasiMstahiq;
    @BindView(R.id.jumlah_donasi)
    RobotoLightTextView jumlahDonasi;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private Unbinder butterKnife;

    private LaporanDonasi laporanDonasi;
    private PicassoLoader imageLoader;

    public DialogDetailDonasiFragment() {

    }

    void Action(int id) {
        switch (id) {

            case Menus.SEND:

                break;
            case Menus.DELETE:
                break;
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void setData(LaporanDonasi laporanDonasi) {
        this.laporanDonasi = laporanDonasi;
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_dialog_detail_donasi, container);

        butterKnife = ButterKnife.bind(this, view);

        imageLoader = new PicassoLoader();
        toolbar.setTitle("Detail Donasi");
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Action(item.getItemId());
                return true;
            }
        });
        toolbar.setNavigationIcon(
                new IconDrawable(getActivity(), MaterialIcons.md_close)
                        .colorRes(R.color.white)
                        .actionBarSize());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        toolbar.inflateMenu(R.menu.menu_manage);
        Menu menu = toolbar.getMenu();
        MenuItem _send = menu.findItem(Menus.SEND);
        MenuItem _delete = menu.findItem(Menus.DELETE);

        _send.setVisible(false);
        _delete.setVisible(false);


        imageLoader.loadImage(fotoProfilMuzaki, laporanDonasi.nama_muzaki, laporanDonasi.nama_muzaki);
        namaMuzaki.setText("Nama : " + laporanDonasi.nama_muzaki);
        alamatMuzaki.setText("Alamat : " + (TextUtils.isNullOrEmpty(laporanDonasi.alamat_muzaki) ? "-" : laporanDonasi.alamat_muzaki));
        noIdentitasMuzaki.setText("No Identitas : " + (TextUtils.isNullOrEmpty(laporanDonasi.no_identitas_muzaki) ? "-" : laporanDonasi.no_identitas_muzaki));
        noTelpMuzaki.setText("No Telp : " + (TextUtils.isNullOrEmpty(laporanDonasi.no_telp_muzaki) ? "-" : laporanDonasi.no_telp_muzaki));
        statusMuzaki.setText(Html.fromHtml("Status Aktif : " + (laporanDonasi.status_muzaki.equalsIgnoreCase("aktif") ? "<font color='#002800'>Aktif</font>" : "<font color='red'>Tidak Aktif</font>")));


        jumlahDonasi.setText(Html.fromHtml("Jumlah Donasi : Rp. " + Utils.Rupiah(laporanDonasi.jumlah_donasi)));


        imageLoader.loadImage(fotoProfilMustahiq, laporanDonasi.nama_calon_mustahiq, laporanDonasi.nama_calon_mustahiq);
        namaMustahiq.setText("Nama : " + laporanDonasi.nama_calon_mustahiq);
        alamatMustahiq.setText("Alamat : " + (TextUtils.isNullOrEmpty(laporanDonasi.alamat_calon_mustahiq) ? "-" : laporanDonasi.alamat_calon_mustahiq));
        noIdentitasMustahiq.setText("No Identitas : " + (TextUtils.isNullOrEmpty(laporanDonasi.no_identitas_calon_mustahiq) ? "-" : laporanDonasi.no_identitas_calon_mustahiq));
        noTelpMustahiq.setText("No Telp : " + (TextUtils.isNullOrEmpty(laporanDonasi.no_telp_calon_mustahiq) ? "-" : laporanDonasi.no_telp_calon_mustahiq));
        jumlahAnakCalonMustahiq.setText("Jumlah Anak : " + (TextUtils.isNullOrEmpty(laporanDonasi.jumlah_anak_calon_mustahiq) ? "-" : laporanDonasi.jumlah_anak_calon_mustahiq));
        statusPernikahanCalonMustahiq.setText("Status Pernikahan : " + (TextUtils.isNullOrEmpty(laporanDonasi.status_pernikahan_calon_mustahiq) ? "-" : laporanDonasi.status_pernikahan_calon_mustahiq));
        statusTempatTinggalCalonMustahiq.setText("Status Tempat Tinggal : " + (TextUtils.isNullOrEmpty(laporanDonasi.status_tempat_tinggal_calon_mustahiq) ? "-" : laporanDonasi.status_tempat_tinggal_calon_mustahiq));
        statusPekerjaanCalonMustahiq.setText("Status Pekerjaan : " + (TextUtils.isNullOrEmpty(laporanDonasi.status_pekerjaan_calon_mustahiq) ? "-" : laporanDonasi.status_pekerjaan_calon_mustahiq));
        statusMustahiq.setText(Html.fromHtml("Status Aktif : " + (laporanDonasi.status_calon_mustahiq.equalsIgnoreCase("aktif") ? "<font color='#002800'>Aktif</font>" : "<font color='red'>Tidak Aktif</font>")));
        namaAmilZakat.setText("Validasi Amil Zakat Zakat : " + laporanDonasi.nama_validasi_amil_zakat);
        namaTypeValidasiMstahiq.setText("Type Validasi : " + laporanDonasi.nama_type_validasi_mustahiq);


        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return view;
    }


}