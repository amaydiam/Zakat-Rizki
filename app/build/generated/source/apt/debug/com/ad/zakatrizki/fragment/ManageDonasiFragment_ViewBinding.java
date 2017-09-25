// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoRegularEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ManageDonasiFragment_ViewBinding<T extends ManageDonasiFragment> implements Unbinder {
  protected T target;

  @UiThread
  public ManageDonasiFragment_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.namaMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_calon_mustahiq, "field 'namaMustahiq'", RobotoRegularEditText.class);
    target.alamatMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatMustahiq'", RobotoRegularEditText.class);
    target.noIdentitasMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasMustahiq'", RobotoRegularEditText.class);
    target.noTelpMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpMustahiq'", RobotoRegularEditText.class);
    target.statusMustahiq = Utils.findRequiredViewAsType(source, R.id.status_calon_mustahiq, "field 'statusMustahiq'", RadioGroup.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.aktif = Utils.findRequiredViewAsType(source, R.id.aktif, "field 'aktif'", RadioButton.class);
    target.tidakAktif = Utils.findRequiredViewAsType(source, R.id.tidak_aktif, "field 'tidakAktif'", RadioButton.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.namaMustahiq = null;
    target.alamatMustahiq = null;
    target.noIdentitasMustahiq = null;
    target.noTelpMustahiq = null;
    target.statusMustahiq = null;
    target.coordinatorLayout = null;
    target.aktif = null;
    target.tidakAktif = null;

    this.target = null;
  }
}
