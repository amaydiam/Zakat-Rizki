// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.JazzyViewPager;
import java.lang.IllegalStateException;
import java.lang.Override;

public class ActionDonasiBaruActivity_ViewBinding<T extends ActionDonasiBaruActivity> implements Unbinder {
  protected T target;

  @UiThread
  public ActionDonasiBaruActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.mPager = Utils.findRequiredViewAsType(source, R.id.pager, "field 'mPager'", JazzyViewPager.class);
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.tabLayout = Utils.findRequiredViewAsType(source, R.id.tabs, "field 'tabLayout'", TabLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.mPager = null;
    target.toolbar = null;
    target.tabLayout = null;

    this.target = null;
  }
}
