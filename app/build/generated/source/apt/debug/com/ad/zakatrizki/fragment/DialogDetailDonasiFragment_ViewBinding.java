// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import agency.tango.android.avatarview.views.AvatarView;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogDetailDonasiFragment_ViewBinding<T extends DialogDetailDonasiFragment> implements Unbinder {
  protected T target;

  @UiThread
  public DialogDetailDonasiFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.fotoProfilMuzaki = Utils.findRequiredViewAsType(source, R.id.foto_profil_muzaki, "field 'fotoProfilMuzaki'", AvatarView.class);
    target.namaMuzaki = Utils.findRequiredViewAsType(source, R.id.nama_muzaki, "field 'namaMuzaki'", RobotoBoldTextView.class);
    target.alamatMuzaki = Utils.findRequiredViewAsType(source, R.id.alamat_muzaki, "field 'alamatMuzaki'", RobotoLightTextView.class);
    target.noIdentitasMuzaki = Utils.findRequiredViewAsType(source, R.id.no_identitas_muzaki, "field 'noIdentitasMuzaki'", RobotoLightTextView.class);
    target.noTelpMuzaki = Utils.findRequiredViewAsType(source, R.id.no_telp_muzaki, "field 'noTelpMuzaki'", RobotoLightTextView.class);
    target.statusMuzaki = Utils.findRequiredViewAsType(source, R.id.status_muzaki, "field 'statusMuzaki'", RobotoLightTextView.class);
    target.fotoProfilMustahiq = Utils.findRequiredViewAsType(source, R.id.foto_profil_mustahiq, "field 'fotoProfilMustahiq'", AvatarView.class);
    target.namaMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_calon_mustahiq, "field 'namaMustahiq'", RobotoBoldTextView.class);
    target.alamatMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatMustahiq'", RobotoLightTextView.class);
    target.noIdentitasMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasMustahiq'", RobotoLightTextView.class);
    target.noTelpMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpMustahiq'", RobotoLightTextView.class);
    target.jumlahAnakCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.jumlah_anak_calon_mustahiq, "field 'jumlahAnakCalonMustahiq'", RobotoLightTextView.class);
    target.statusPernikahanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pernikahan_calon_mustahiq, "field 'statusPernikahanCalonMustahiq'", RobotoLightTextView.class);
    target.statusTempatTinggalCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_tempat_tinggal_calon_mustahiq, "field 'statusTempatTinggalCalonMustahiq'", RobotoLightTextView.class);
    target.statusPekerjaanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pekerjaan_calon_mustahiq, "field 'statusPekerjaanCalonMustahiq'", RobotoLightTextView.class);
    target.statusMustahiq = Utils.findRequiredViewAsType(source, R.id.status_calon_mustahiq, "field 'statusMustahiq'", RobotoLightTextView.class);
    target.namaAmilZakat = Utils.findRequiredViewAsType(source, R.id.nama_validasi_amil_zakat, "field 'namaAmilZakat'", RobotoLightTextView.class);
    target.namaTypeValidasiMstahiq = Utils.findRequiredViewAsType(source, R.id.nama_type_validasi_mustahiq, "field 'namaTypeValidasiMstahiq'", RobotoLightTextView.class);
    target.jumlahDonasi = Utils.findRequiredViewAsType(source, R.id.jumlah_donasi, "field 'jumlahDonasi'", RobotoLightTextView.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.fotoProfilMuzaki = null;
    target.namaMuzaki = null;
    target.alamatMuzaki = null;
    target.noIdentitasMuzaki = null;
    target.noTelpMuzaki = null;
    target.statusMuzaki = null;
    target.fotoProfilMustahiq = null;
    target.namaMustahiq = null;
    target.alamatMustahiq = null;
    target.noIdentitasMustahiq = null;
    target.noTelpMustahiq = null;
    target.jumlahAnakCalonMustahiq = null;
    target.statusPernikahanCalonMustahiq = null;
    target.statusTempatTinggalCalonMustahiq = null;
    target.statusPekerjaanCalonMustahiq = null;
    target.statusMustahiq = null;
    target.namaAmilZakat = null;
    target.namaTypeValidasiMstahiq = null;
    target.jumlahDonasi = null;
    target.coordinatorLayout = null;

    this.target = null;
  }
}
