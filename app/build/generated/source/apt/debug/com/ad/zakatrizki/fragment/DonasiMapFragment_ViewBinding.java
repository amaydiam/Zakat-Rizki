// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.EditText;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.joanzapata.iconify.widget.IconButton;
import com.wang.avi.AVLoadingIndicatorView;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DonasiMapFragment_ViewBinding<T extends DonasiMapFragment> implements Unbinder {
  protected T target;

  private View view2131755273;

  @UiThread
  public DonasiMapFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.search = Utils.findRequiredViewAsType(source, R.id.search, "field 'search'", EditText.class);
    view = Utils.findRequiredView(source, R.id.btn_search, "field 'btnSearch' and method 'Search'");
    target.btnSearch = Utils.castView(view, R.id.btn_search, "field 'btnSearch'", IconButton.class);
    view2131755273 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.Search();
      }
    });
    target.parentSearch = Utils.findRequiredViewAsType(source, R.id.parent_search, "field 'parentSearch'", CardView.class);
    target.btnMyLocation = Utils.findRequiredViewAsType(source, R.id.btn_my_location, "field 'btnMyLocation'", FloatingActionButton.class);
    target.indicatorIdentifyAddress = Utils.findRequiredViewAsType(source, R.id.indicator_identify_address, "field 'indicatorIdentifyAddress'", AVLoadingIndicatorView.class);

    Resources res = source.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.search = null;
    target.btnSearch = null;
    target.parentSearch = null;
    target.btnMyLocation = null;
    target.indicatorIdentifyAddress = null;

    view2131755273.setOnClickListener(null);
    view2131755273 = null;

    this.target = null;
  }
}
