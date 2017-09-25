// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import agency.tango.android.avatarview.views.AvatarView;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LaporanDonasiDetailFragment_ViewBinding<T extends LaporanDonasiDetailFragment> implements Unbinder {
  protected T target;

  private View view2131755380;

  private View view2131755376;

  @UiThread
  public LaporanDonasiDetailFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbarTextHolder = Utils.findRequiredView(source, R.id.toolbar_text_holder, "field 'toolbarTextHolder'");
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbarSubtitle = Utils.findRequiredViewAsType(source, R.id.toolbar_subtitle, "field 'toolbarSubtitle'", TextView.class);
    target.progressCircle = Utils.findRequiredView(source, R.id.progress_circle, "field 'progressCircle'");
    target.errorMessage = Utils.findRequiredView(source, R.id.error_message, "field 'errorMessage'");
    target.textError = Utils.findRequiredViewAsType(source, R.id.text_error, "field 'textError'", RobotoLightTextView.class);
    view = Utils.findRequiredView(source, R.id.try_again, "field 'tryAgain' and method 'onTryAgainClicked'");
    target.tryAgain = Utils.castView(view, R.id.try_again, "field 'tryAgain'", RobotoBoldTextView.class);
    view2131755380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTryAgainClicked();
      }
    });
    target.movieHolder = Utils.findRequiredViewAsType(source, R.id.movie_detail_holder, "field 'movieHolder'", NestedScrollView.class);
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
    view = Utils.findRequiredView(source, R.id.detail_mustahiq, "method 'DetailMustahiq'");
    view2131755376 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.DetailMustahiq();
      }
    });

    Resources res = source.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.toolbarTextHolder = null;
    target.toolbarTitle = null;
    target.toolbarSubtitle = null;
    target.progressCircle = null;
    target.errorMessage = null;
    target.textError = null;
    target.tryAgain = null;
    target.movieHolder = null;
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

    view2131755380.setOnClickListener(null);
    view2131755380 = null;
    view2131755376.setOnClickListener(null);
    view2131755376 = null;

    this.target = null;
  }
}
