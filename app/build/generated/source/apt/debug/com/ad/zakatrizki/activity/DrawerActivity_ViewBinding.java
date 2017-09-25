// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import butterknife.Unbinder;
import com.ad.zakatrizki.R;
import java.lang.Deprecated;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DrawerActivity_ViewBinding<T extends DrawerActivity> implements Unbinder {
  protected T target;

  /**
   * @deprecated Use {@link #DrawerActivity_ViewBinding(T, Context)} for direct creation.
   *     Only present for runtime invocation through {@code ButterKnife.bind()}.
   */
  @Deprecated
  @UiThread
  public DrawerActivity_ViewBinding(T target, View source) {
    this(target, source.getContext());
  }

  @UiThread
  public DrawerActivity_ViewBinding(T target, Context context) {
    this.target = target;

    Resources res = context.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    if (this.target == null) throw new IllegalStateException("Bindings already cleared.");

    this.target = null;
  }
}
