// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class AddRekomendasiFragment_ViewBinding<T extends AddRekomendasiFragment> implements Unbinder {
  protected T target;

  private View view2131755322;

  @UiThread
  public AddRekomendasiFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.rekomendasi, "field 'rekomendasi' and method 'Rekomendasi'");
    target.rekomendasi = Utils.castView(view, R.id.rekomendasi, "field 'rekomendasi'", Button.class);
    view2131755322 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Rekomendasi();
      }
    });
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.rekomendasi = null;
    target.coordinatorLayout = null;

    view2131755322.setOnClickListener(null);
    view2131755322 = null;

    this.target = null;
  }
}
