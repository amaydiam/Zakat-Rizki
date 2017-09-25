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

public class RegisterFragment_ViewBinding<T extends RegisterFragment> implements Unbinder {
  protected T target;

  private View view2131755290;

  @UiThread
  public RegisterFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.nama = Utils.findRequiredViewAsType(source, R.id.nama, "field 'nama'", RobotoRegularEditText.class);
    target.alamat = Utils.findRequiredViewAsType(source, R.id.alamat, "field 'alamat'", RobotoRegularEditText.class);
    target.no_telp = Utils.findRequiredViewAsType(source, R.id.no_telp, "field 'no_telp'", RobotoRegularEditText.class);
    target.no_identitas = Utils.findRequiredViewAsType(source, R.id.no_identitas, "field 'no_identitas'", RobotoRegularEditText.class);
    target.username = Utils.findRequiredViewAsType(source, R.id.username, "field 'username'", RobotoRegularEditText.class);
    target.password = Utils.findRequiredViewAsType(source, R.id.password, "field 'password'", RobotoRegularEditText.class);
    view = Utils.findRequiredView(source, R.id.register, "field 'register' and method 'Register'");
    target.register = Utils.castView(view, R.id.register, "field 'register'", Button.class);
    view2131755290 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Register();
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
    target.nama = null;
    target.alamat = null;
    target.no_telp = null;
    target.no_identitas = null;
    target.username = null;
    target.password = null;
    target.register = null;
    target.coordinatorLayout = null;

    view2131755290.setOnClickListener(null);
    view2131755290 = null;

    this.target = null;
  }
}
