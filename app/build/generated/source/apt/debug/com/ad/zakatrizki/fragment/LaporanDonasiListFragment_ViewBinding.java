// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.joanzapata.iconify.widget.IconButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class LaporanDonasiListFragment_ViewBinding<T extends LaporanDonasiListFragment> implements Unbinder {
  protected T target;

  private View view2131755281;

  private View view2131755380;

  private View view2131755274;

  private View view2131755273;

  @UiThread
  public LaporanDonasiListFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerView'", RecyclerView.class);
    target.swipeContainer = Utils.findRequiredViewAsType(source, R.id.swipe_container, "field 'swipeContainer'", SwipeRefreshLayout.class);
    target.progressMoreData = Utils.findRequiredViewAsType(source, R.id.progress_more_data, "field 'progressMoreData'", ProgressBar.class);
    target.noData = Utils.findRequiredViewAsType(source, R.id.no_data, "field 'noData'", IconButton.class);
    view = Utils.findRequiredView(source, R.id.fab_scroll_up, "field 'fabScrollUp' and method 'ScrollUp'");
    target.fabScrollUp = Utils.castView(view, R.id.fab_scroll_up, "field 'fabScrollUp'", FloatingActionButton.class);
    view2131755281 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.ScrollUp();
      }
    });
    target.fabAction = Utils.findRequiredViewAsType(source, R.id.fab_action, "field 'fabAction'", com.github.clans.fab.FloatingActionButton.class);
    target.coordinatorLayout = Utils.findRequiredViewAsType(source, R.id.coordinatorLayout, "field 'coordinatorLayout'", CoordinatorLayout.class);
    target.errorMessage = Utils.findRequiredView(source, R.id.error_message, "field 'errorMessage'");
    target.loading = Utils.findRequiredViewAsType(source, R.id.loading, "field 'loading'", ProgressBar.class);
    target.textError = Utils.findRequiredViewAsType(source, R.id.text_error, "field 'textError'", TextView.class);
    view = Utils.findRequiredView(source, R.id.try_again, "field 'tryAgain' and method 'TryAgain'");
    target.tryAgain = Utils.castView(view, R.id.try_again, "field 'tryAgain'", TextView.class);
    view2131755380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.TryAgain();
      }
    });
    target.search = Utils.findRequiredViewAsType(source, R.id.search, "field 'search'", EditText.class);
    target.parentSearch = Utils.findRequiredViewAsType(source, R.id.parent_search, "field 'parentSearch'", CardView.class);
    view = Utils.findRequiredView(source, R.id.btn_filter, "field 'btnFilter' and method 'setBtnFilter'");
    target.btnFilter = Utils.castView(view, R.id.btn_filter, "field 'btnFilter'", IconButton.class);
    view2131755274 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.setBtnFilter();
      }
    });
    target.ketFilter = Utils.findRequiredViewAsType(source, R.id.ket_filter, "field 'ketFilter'", TextView.class);
    view = Utils.findRequiredView(source, R.id.btn_search, "method 'btn_search'");
    view2131755273 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.btn_search();
      }
    });

    Resources res = source.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.recyclerView = null;
    target.swipeContainer = null;
    target.progressMoreData = null;
    target.noData = null;
    target.fabScrollUp = null;
    target.fabAction = null;
    target.coordinatorLayout = null;
    target.errorMessage = null;
    target.loading = null;
    target.textError = null;
    target.tryAgain = null;
    target.search = null;
    target.parentSearch = null;
    target.btnFilter = null;
    target.ketFilter = null;

    view2131755281.setOnClickListener(null);
    view2131755281 = null;
    view2131755380.setOnClickListener(null);
    view2131755380 = null;
    view2131755274.setOnClickListener(null);
    view2131755274 = null;
    view2131755273.setOnClickListener(null);
    view2131755273 = null;

    this.target = null;
  }
}
