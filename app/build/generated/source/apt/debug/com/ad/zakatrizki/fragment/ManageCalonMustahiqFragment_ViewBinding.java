// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoRegularEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ManageCalonMustahiqFragment_ViewBinding<T extends ManageCalonMustahiqFragment> implements Unbinder {
  protected T target;

  private View view2131755293;

  private View view2131755301;

  private View view2131755304;

  private View view2131755307;

  @UiThread
  public ManageCalonMustahiqFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.namaCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_calon_mustahiq, "field 'namaCalonMustahiq'", RobotoRegularEditText.class);
    target.alamatCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatCalonMustahiq'", RobotoRegularEditText.class);
    target.noIdentitasCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasCalonMustahiq'", RobotoRegularEditText.class);
    target.noTelpCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpCalonMustahiq'", RobotoRegularEditText.class);
    target.jumlahAnakCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.jumlah_anak_calon_mustahiq, "field 'jumlahAnakCalonMustahiq'", RobotoRegularEditText.class);
    target.alasanPerekomendasiCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alasan_perekomendasi_calon_mustahiq, "field 'alasanPerekomendasiCalonMustahiq'", RobotoRegularEditText.class);
    target.captionImgFoto1 = Utils.findRequiredViewAsType(source, R.id.caption_img_foto_1, "field 'captionImgFoto1'", RobotoRegularEditText.class);
    target.captionImgFoto2 = Utils.findRequiredViewAsType(source, R.id.caption_img_foto_2, "field 'captionImgFoto2'", RobotoRegularEditText.class);
    target.captionImgFoto3 = Utils.findRequiredViewAsType(source, R.id.caption_img_foto_3, "field 'captionImgFoto3'", RobotoRegularEditText.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.imgFoto1 = Utils.findRequiredViewAsType(source, R.id.img_foto_1, "field 'imgFoto1'", ImageView.class);
    target.imgFoto2 = Utils.findRequiredViewAsType(source, R.id.img_foto_2, "field 'imgFoto2'", ImageView.class);
    target.imgFoto3 = Utils.findRequiredViewAsType(source, R.id.img_foto_3, "field 'imgFoto3'", ImageView.class);
    target.statusPernikahanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pernikahan_calon_mustahiq, "field 'statusPernikahanCalonMustahiq'", Spinner.class);
    target.statusTempatTinggalCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_tempat_tinggal_calon_mustahiq, "field 'statusTempatTinggalCalonMustahiq'", Spinner.class);
    target.statusPekerjaanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pekerjaan_calon_mustahiq, "field 'statusPekerjaanCalonMustahiq'", Spinner.class);
    view = Utils.findRequiredView(source, R.id.pick_location, "method 'pickLocation'");
    view2131755293 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.pickLocation();
      }
    });
    view = Utils.findRequiredView(source, R.id.foto_1, "method 'PHOTO_1'");
    view2131755301 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.PHOTO_1();
      }
    });
    view = Utils.findRequiredView(source, R.id.foto_2, "method 'PHOTO_2'");
    view2131755304 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.PHOTO_2();
      }
    });
    view = Utils.findRequiredView(source, R.id.foto_3, "method 'PHOTO_3'");
    view2131755307 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.PHOTO_3();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.namaCalonMustahiq = null;
    target.alamatCalonMustahiq = null;
    target.noIdentitasCalonMustahiq = null;
    target.noTelpCalonMustahiq = null;
    target.jumlahAnakCalonMustahiq = null;
    target.alasanPerekomendasiCalonMustahiq = null;
    target.captionImgFoto1 = null;
    target.captionImgFoto2 = null;
    target.captionImgFoto3 = null;
    target.coordinatorLayout = null;
    target.imgFoto1 = null;
    target.imgFoto2 = null;
    target.imgFoto3 = null;
    target.statusPernikahanCalonMustahiq = null;
    target.statusTempatTinggalCalonMustahiq = null;
    target.statusPekerjaanCalonMustahiq = null;

    view2131755293.setOnClickListener(null);
    view2131755293 = null;
    view2131755301.setOnClickListener(null);
    view2131755301 = null;
    view2131755304.setOnClickListener(null);
    view2131755304 = null;
    view2131755307.setOnClickListener(null);
    view2131755307 = null;

    this.target = null;
  }
}
