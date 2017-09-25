// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.joanzapata.iconify.widget.IconTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogViewSinggleImageFragment_ViewBinding<T extends DialogViewSinggleImageFragment> implements Unbinder {
  protected T target;

  private View view2131755357;

  @UiThread
  public DialogViewSinggleImageFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.image = Utils.findRequiredViewAsType(source, R.id.image, "field 'image'", ImageView.class);
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", ProgressBar.class);
    view = Utils.findRequiredView(source, R.id.btn_close, "field 'btnClose' and method 'btnClose'");
    target.btnClose = Utils.castView(view, R.id.btn_close, "field 'btnClose'", IconTextView.class);
    view2131755357 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btnClose();
      }
    });
    target.captionPhoto = Utils.findRequiredViewAsType(source, R.id.caption_photo, "field 'captionPhoto'", RobotoLightTextView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.image = null;
    target.loading = null;
    target.btnClose = null;
    target.captionPhoto = null;

    view2131755357.setOnClickListener(null);
    view2131755357 = null;

    this.target = null;
  }
}
