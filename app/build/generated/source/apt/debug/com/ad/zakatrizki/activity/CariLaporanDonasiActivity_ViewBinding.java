// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CariLaporanDonasiActivity_ViewBinding<T extends CariLaporanDonasiActivity> implements Unbinder {
  protected T target;

  @UiThread
  public CariLaporanDonasiActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;

    this.target = null;
  }
}
