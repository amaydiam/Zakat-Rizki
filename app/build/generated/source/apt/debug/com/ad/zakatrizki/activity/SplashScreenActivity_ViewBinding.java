// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.activity;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class SplashScreenActivity_ViewBinding<T extends SplashScreenActivity> implements Unbinder {
  protected T target;

  @UiThread
  public SplashScreenActivity_ViewBinding(T target, View source) {
    this.target = target;

    target.logo = Utils.findRequiredViewAsType(source, R.id.logo, "field 'logo'", ImageView.class);
    target.versionApp = Utils.findRequiredViewAsType(source, R.id.version_app, "field 'versionApp'", TextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.logo = null;
    target.versionApp = null;

    this.target = null;
  }
}
