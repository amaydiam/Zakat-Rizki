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
import com.ad.zakatrizki.widget.RobotoRegularEditText;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LoginFragment_ViewBinding<T extends LoginFragment> implements Unbinder {
  protected T target;

  private View view2131755289;

  private View view2131755290;

  @UiThread
  public LoginFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.username = Utils.findRequiredViewAsType(source, R.id.username, "field 'username'", RobotoRegularEditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", RobotoRegularEditText.class);
    view = Utils.findRequiredView(source, R.id.login, "field 'login' and method 'Login'");
    target.login = Utils.castView(view, R.id.login, "field 'login'", Button.class);
    view2131755289 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Login();
      }
    });
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    view = Utils.findRequiredView(source, R.id.register, "method 'register'");
    view2131755290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.register();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.username = null;
    target.password = null;
    target.login = null;
    target.coordinatorLayout = null;

    view2131755289.setOnClickListener(null);
    view2131755289 = null;
    view2131755290.setOnClickListener(null);
    view2131755290 = null;

    this.target = null;
  }
}
