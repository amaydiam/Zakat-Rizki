// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoRegularTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ManageMustahiqFragment_ViewBinding<T extends ManageMustahiqFragment> implements Unbinder {
  protected T target;

  private View view2131755311;

  @UiThread
  public ManageMustahiqFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.calonMustahiq = Utils.findRequiredViewAsType(source, R.id.calon_mustahiq, "field 'calonMustahiq'", LinearLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_pilih_calon_mustahiq, "field 'btnPilihCalonMustahiq' and method 'Pick'");
    target.btnPilihCalonMustahiq = Utils.castView(view, R.id.btn_pilih_calon_mustahiq, "field 'btnPilihCalonMustahiq'", Button.class);
    view2131755311 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Pick();
      }
    });
    target.alamatCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatCalonMustahiq'", RobotoRegularTextView.class);
    target.noIdentitasCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasCalonMustahiq'", RobotoRegularTextView.class);
    target.noTelpCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpCalonMustahiq'", RobotoRegularTextView.class);
    target.jumlahAnakCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.jumlah_anak_calon_mustahiq, "field 'jumlahAnakCalonMustahiq'", RobotoRegularTextView.class);
    target.statusPernikahanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pernikahan_calon_mustahiq, "field 'statusPernikahanCalonMustahiq'", RobotoRegularTextView.class);
    target.aktif = Utils.findRequiredViewAsType(source, R.id.aktif, "field 'aktif'", RadioButton.class);
    target.tidakAktif = Utils.findRequiredViewAsType(source, R.id.tidak_aktif, "field 'tidakAktif'", RadioButton.class);
    target.statusMustahiq = Utils.findRequiredViewAsType(source, R.id.status_mustahiq, "field 'statusMustahiq'", RadioGroup.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.calonMustahiq = null;
    target.btnPilihCalonMustahiq = null;
    target.alamatCalonMustahiq = null;
    target.noIdentitasCalonMustahiq = null;
    target.noTelpCalonMustahiq = null;
    target.jumlahAnakCalonMustahiq = null;
    target.statusPernikahanCalonMustahiq = null;
    target.aktif = null;
    target.tidakAktif = null;
    target.statusMustahiq = null;
    target.coordinatorLayout = null;

    view2131755311.setOnClickListener(null);
    view2131755311 = null;

    this.target = null;
  }
}
