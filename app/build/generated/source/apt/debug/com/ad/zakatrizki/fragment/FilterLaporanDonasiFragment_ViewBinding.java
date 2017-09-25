// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import java.lang.IllegalStateException;
import java.lang.Override;

public class FilterLaporanDonasiFragment_ViewBinding<T extends FilterLaporanDonasiFragment> implements Unbinder {
  protected T target;

  private View view2131755265;

  private View view2131755268;

  private View view2131755269;

  @UiThread
  public FilterLaporanDonasiFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    view = Utils.findRequiredView(source, R.id.tahun, "field 'tahun' and method 'spinnerItemSelected'");
    target.tahun = Utils.castView(view, R.id.tahun, "field 'tahun'", Spinner.class);
    view2131755265 = view;
    ((AdapterView<?>) view).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> p0, View p1, int p2, long p3) {
        target.spinnerItemSelected(Utils.<Spinner>castParam(p0, "onItemSelected", 0, "spinnerItemSelected", 0), p2);
      }

      @Override
      public void onNothingSelected(AdapterView<?> p0) {
      }
    });
    target.bulan = Utils.findRequiredViewAsType(source, R.id.bulan, "field 'bulan'", Spinner.class);
    target.layoutBulan = Utils.findRequiredViewAsType(source, R.id.layout_bulan, "field 'layoutBulan'", LinearLayout.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    view = Utils.findRequiredView(source, R.id.btn_set, "field 'btnSet' and method 'Send'");
    target.btnSet = Utils.castView(view, R.id.btn_set, "field 'btnSet'", Button.class);
    view2131755268 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Send();
      }
    });
    view = Utils.findRequiredView(source, R.id.btn_clear, "field 'btnClear' and method 'RESET'");
    target.btnClear = Utils.castView(view, R.id.btn_clear, "field 'btnClear'", Button.class);
    view2131755269 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.RESET();
      }
    });
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.tahun = null;
    target.bulan = null;
    target.layoutBulan = null;
    target.coordinatorLayout = null;
    target.btnSet = null;
    target.btnClear = null;

    ((AdapterView<?>) view2131755265).setOnItemSelectedListener(null);
    view2131755265 = null;
    view2131755268.setOnClickListener(null);
    view2131755268 = null;
    view2131755269.setOnClickListener(null);
    view2131755269 = null;

    this.target = null;
  }
}
