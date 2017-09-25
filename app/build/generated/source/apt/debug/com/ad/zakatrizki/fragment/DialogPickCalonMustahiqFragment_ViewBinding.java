// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.joanzapata.iconify.widget.IconButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class DialogPickCalonMustahiqFragment_ViewBinding<T extends DialogPickCalonMustahiqFragment> implements Unbinder {
  protected T target;

  private View view2131755380;

  @UiThread
  public DialogPickCalonMustahiqFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview, "field 'recyclerView'", RecyclerView.class);
    target.swipeContainer = Utils.findRequiredViewAsType(source, R.id.swipe_container, "field 'swipeContainer'", SwipeRefreshLayout.class);
    target.progressMoreData = Utils.findRequiredViewAsType(source, R.id.progress_more_data, "field 'progressMoreData'", ProgressBar.class);
    target.noData = Utils.findRequiredViewAsType(source, R.id.no_data, "field 'noData'", IconButton.class);
    target.fabScrollUp = Utils.findRequiredViewAsType(source, R.id.fab_scroll_up, "field 'fabScrollUp'", FloatingActionButton.class);
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
    target.parentSearch = Utils.findRequiredViewAsType(source, R.id.parent_search, "field 'parentSearch'", CardView.class);

    Resources res = source.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.recyclerView = null;
    target.swipeContainer = null;
    target.progressMoreData = null;
    target.noData = null;
    target.fabScrollUp = null;
    target.errorMessage = null;
    target.loading = null;
    target.textError = null;
    target.tryAgain = null;
    target.parentSearch = null;

    view2131755380.setOnClickListener(null);
    view2131755380 = null;

    this.target = null;
  }
}
