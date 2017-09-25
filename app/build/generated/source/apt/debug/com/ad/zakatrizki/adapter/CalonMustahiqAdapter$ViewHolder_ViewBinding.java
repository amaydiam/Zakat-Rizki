// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.adapter;

import agency.tango.android.avatarview.views.AvatarView;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.joanzapata.iconify.widget.IconButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CalonMustahiqAdapter$ViewHolder_ViewBinding<T extends CalonMustahiqAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public CalonMustahiqAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.fotoProfil = Utils.findRequiredViewAsType(source, R.id.foto_profil, "field 'fotoProfil'", AvatarView.class);
    target.namaCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_calon_mustahiq, "field 'namaCalonMustahiq'", RobotoBoldTextView.class);
    target.alamatCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatCalonMustahiq'", RobotoLightTextView.class);
    target.noIdentitasCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasCalonMustahiq'", RobotoLightTextView.class);
    target.noTelpCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpCalonMustahiq'", RobotoLightTextView.class);
    target.jumlahAnakCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.jumlah_anak_calon_mustahiq, "field 'jumlahAnakCalonMustahiq'", RobotoLightTextView.class);
    target.statusPernikahanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pernikahan_calon_mustahiq, "field 'statusPernikahanCalonMustahiq'", RobotoLightTextView.class);
    target.statusTempatTinggalCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_tempat_tinggal_calon_mustahiq, "field 'statusTempatTinggalCalonMustahiq'", RobotoLightTextView.class);
    target.statusPekerjaanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pekerjaan_calon_mustahiq, "field 'statusPekerjaanCalonMustahiq'", RobotoLightTextView.class);
    target.namaPerekomendasiCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_perekomendasi_calon_mustahiq, "field 'namaPerekomendasiCalonMustahiq'", RobotoLightTextView.class);
    target.alasanPerekomendasiCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alasan_perekomendasi_calon_mustahiq, "field 'alasanPerekomendasiCalonMustahiq'", RobotoLightTextView.class);
    target.statusCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_calon_mustahiq, "field 'statusCalonMustahiq'", RobotoLightTextView.class);
    target.statusMustahiq = Utils.findRequiredViewAsType(source, R.id.status_mustahiq, "field 'statusMustahiq'", RobotoLightTextView.class);
    target.namaAmilZakat = Utils.findRequiredViewAsType(source, R.id.nama_validasi_amil_zakat, "field 'namaAmilZakat'", RobotoLightTextView.class);
    target.namaTypeValidasiMstahiq = Utils.findRequiredViewAsType(source, R.id.nama_type_validasi_mustahiq, "field 'namaTypeValidasiMstahiq'", RobotoLightTextView.class);
    target.waktuTerakhirDonasi = Utils.findRequiredViewAsType(source, R.id.waktu_terakhir_donasi, "field 'waktuTerakhirDonasi'", RobotoLightTextView.class);
    target.btnAction = Utils.findRequiredViewAsType(source, R.id.btn_action, "field 'btnAction'", IconButton.class);
    target.rootParent = Utils.findRequiredViewAsType(source, R.id.root_parent, "field 'rootParent'", CardView.class);
    target.layoutRating = Utils.findRequiredViewAsType(source, R.id.layout_rating, "field 'layoutRating'", LinearLayout.class);
    target.rating = Utils.findRequiredViewAsType(source, R.id.rating, "field 'rating'", AppCompatRatingBar.class);
    target.ratingAmilZakat = Utils.findRequiredViewAsType(source, R.id.rating_amil_zakat, "field 'ratingAmilZakat'", AppCompatRatingBar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.fotoProfil = null;
    target.namaCalonMustahiq = null;
    target.alamatCalonMustahiq = null;
    target.noIdentitasCalonMustahiq = null;
    target.noTelpCalonMustahiq = null;
    target.jumlahAnakCalonMustahiq = null;
    target.statusPernikahanCalonMustahiq = null;
    target.statusTempatTinggalCalonMustahiq = null;
    target.statusPekerjaanCalonMustahiq = null;
    target.namaPerekomendasiCalonMustahiq = null;
    target.alasanPerekomendasiCalonMustahiq = null;
    target.statusCalonMustahiq = null;
    target.statusMustahiq = null;
    target.namaAmilZakat = null;
    target.namaTypeValidasiMstahiq = null;
    target.waktuTerakhirDonasi = null;
    target.btnAction = null;
    target.rootParent = null;
    target.layoutRating = null;
    target.rating = null;
    target.ratingAmilZakat = null;

    this.target = null;
  }
}
