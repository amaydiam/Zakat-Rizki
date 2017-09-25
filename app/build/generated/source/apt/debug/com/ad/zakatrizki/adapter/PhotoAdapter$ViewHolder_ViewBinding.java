// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.adapter;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import butterknife.Unbinder;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class PhotoAdapter$ViewHolder_ViewBinding<T extends PhotoAdapter.ViewHolder> implements Unbinder {
  protected T target;

  @UiThread
  public PhotoAdapter$ViewHolder_ViewBinding(T target, View source) {
    this.target = target;

    target.photo = Utils.findRequiredViewAsType(source, R.id.photo, "field 'photo'", ImageView.class);
    target.captionPhoto = Utils.findRequiredViewAsType(source, R.id.caption_photo, "field 'captionPhoto'", RobotoBoldTextView.class);
    target.rootParent = Utils.findRequiredViewAsType(source, R.id.root_parent, "field 'rootParent'", CardView.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.photo = null;
    target.captionPhoto = null;
    target.rootParent = null;

    this.target = null;
  }
}
