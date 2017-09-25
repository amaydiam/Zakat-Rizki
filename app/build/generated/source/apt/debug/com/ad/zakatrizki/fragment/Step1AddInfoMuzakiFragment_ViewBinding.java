// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import agency.tango.android.avatarview.views.AvatarView;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.ad.zakatrizki.widget.RobotoRegularEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Step1AddInfoMuzakiFragment_ViewBinding<T extends Step1AddInfoMuzakiFragment> implements Unbinder {
  protected T target;

  private View view2131755351;

  private View view2131755350;

  @UiThread
  public Step1AddInfoMuzakiFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.namaMuzaki = Utils.findRequiredViewAsType(source, R.id.nama_muzaki, "field 'namaMuzaki'", RobotoRegularEditText.class);
    target.alamatMuzaki = Utils.findRequiredViewAsType(source, R.id.alamat_muzaki, "field 'alamatMuzaki'", RobotoRegularEditText.class);
    target.noIdentitasMuzaki = Utils.findRequiredViewAsType(source, R.id.no_identitas_muzaki, "field 'noIdentitasMuzaki'", RobotoRegularEditText.class);
    target.noTelpMuzaki = Utils.findRequiredViewAsType(source, R.id.no_telp_muzaki, "field 'noTelpMuzaki'", RobotoRegularEditText.class);
    target.idMustahiq = Utils.findRequiredViewAsType(source, R.id.id_mustahiq, "field 'idMustahiq'", RobotoRegularEditText.class);
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
    target.namaAmilZakat = Utils.findRequiredViewAsType(source, R.id.nama_validasi_amil_zakat, "field 'namaAmilZakat'", RobotoLightTextView.class);
    target.namaTypeValidasiMstahiq = Utils.findRequiredViewAsType(source, R.id.nama_type_validasi_mustahiq, "field 'namaTypeValidasiMstahiq'", RobotoLightTextView.class);
    target.statusMustahiq = Utils.findRequiredViewAsType(source, R.id.status_mustahiq, "field 'statusMustahiq'", RobotoLightTextView.class);
    target.waktuTerakhirDonasi = Utils.findRequiredViewAsType(source, R.id.waktu_terakhir_donasi, "field 'waktuTerakhirDonasi'", RobotoLightTextView.class);
    target.jumlahDonasi = Utils.findRequiredViewAsType(source, R.id.jumlah_donasi, "field 'jumlahDonasi'", RobotoRegularEditText.class);
    view = Utils.findRequiredView(source, R.id.btn_step_2, "field 'btnStep2' and method 'Step2'");
    target.btnStep2 = Utils.castView(view, R.id.btn_step_2, "field 'btnStep2'", Button.class);
    view2131755351 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Step2();
      }
    });
    target.parentLayout = Utils.findRequiredViewAsType(source, R.id.parent_layout, "field 'parentLayout'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.id_amil_zakat, "field 'idAmilZakat' and method 'spinnerItemSelected'");
    target.idAmilZakat = Utils.castView(view, R.id.id_amil_zakat, "field 'idAmilZakat'", Spinner.class);
    view2131755350 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.spinnerItemSelected(Utils.<Spinner>castParam(p0, "onItemSelected", 0, "spinnerItemSelected", 0), p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.namaMuzaki = null;
    target.alamatMuzaki = null;
    target.noIdentitasMuzaki = null;
    target.noTelpMuzaki = null;
    target.idMustahiq = null;
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
    target.namaAmilZakat = null;
    target.namaTypeValidasiMstahiq = null;
    target.statusMustahiq = null;
    target.waktuTerakhirDonasi = null;
    target.jumlahDonasi = null;
    target.btnStep2 = null;
    target.parentLayout = null;
    target.idAmilZakat = null;

    view2131755351.setOnClickListener(null);
    view2131755351 = null;
    ((AdapterView<?>) view2131755350).setOnItemSelectedListener(null);
    view2131755350 = null;

    this.target = null;
  }
}
