// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddValidasiFragment_ViewBinding<T extends AddValidasiFragment> implements Unbinder {
  protected T target;

  private View view2131755324;

  private View view2131755323;

  @UiThread
  public AddValidasiFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.validasi, "field 'validasi' and method 'Validasi'");
    target.validasi = Utils.castView(view, R.id.validasi, "field 'validasi'", Button.class);
    view2131755324 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Validasi();
      }
    });
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    view = Utils.findRequiredView(source, R.id.type_validasi_mustahiq, "field 'typeValidasi' and method 'spinnerItemSelected'");
    target.typeValidasi = Utils.castView(view, R.id.type_validasi_mustahiq, "field 'typeValidasi'", Spinner.class);
    view2131755323 = view;
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

    target.toolbar = null;
    target.validasi = null;
    target.coordinatorLayout = null;
    target.typeValidasi = null;

    view2131755324.setOnClickListener(null);
    view2131755324 = null;
    ((AdapterView<?>) view2131755323).setOnItemSelectedListener(null);
    view2131755323 = null;

    this.target = null;
  }
}
