// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class Step2AddBuktiPembayaranFragment_ViewBinding<T extends Step2AddBuktiPembayaranFragment> implements Unbinder {
  protected T target;

  private View view2131755353;

  private View view2131755354;

  @UiThread
  public Step2AddBuktiPembayaranFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.fotoBuktiPembayaran = Utils.findRequiredViewAsType(source, R.id.foto_bukti_pembayaran, "field 'fotoBuktiPembayaran'", ImageView.class);
    view = Utils.findRequiredView(source, R.id.btn_upload, "field 'btnUpload' and method 'Upload'");
    target.btnUpload = Utils.castView(view, R.id.btn_upload, "field 'btnUpload'", Button.class);
    view2131755353 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Upload();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_save, "field 'btnSave' and method 'Save'");
    target.btnSave = Utils.castView(view, R.id.btn_save, "field 'btnSave'", Button.class);
    view2131755354 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Save();
      }
    });
    target.parentLayout = Utils.findRequiredViewAsType(source, R.id.parent_layout, "field 'parentLayout'", LinearLayout.class);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.fotoBuktiPembayaran = null;
    target.btnUpload = null;
    target.btnSave = null;
    target.parentLayout = null;

    view2131755353.setOnClickListener(null);
    view2131755353 = null;
    view2131755354.setOnClickListener(null);
    view2131755354 = null;

    this.target = null;
  }
}
