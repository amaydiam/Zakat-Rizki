// Generated code from Butter Knife. Do not modify!
package com.ad.zakatrizki.fragment;

import agency.tango.android.avatarview.views.AvatarView;
import android.content.res.Resources;
import android.support.annotation.CallSuper;
import android.support.annotation.UiThread;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;
import com.ad.zakatrizki.R;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.github.clans.fab.FloatingActionButton;
import java.lang.IllegalStateException;
import java.lang.Override;

public class CalonMustahiqDetailFragment_ViewBinding<T extends CalonMustahiqDetailFragment> implements Unbinder {
  protected T target;

  private View view2131755380;

  private View view2131755382;

  private View view2131755384;

  private View view2131755383;

  @UiThread
  public CalonMustahiqDetailFragment_ViewBinding(final T target, View source) {
    this.target = target;

    View view;
    target.toolbar = Utils.findRequiredViewAsType(source, R.id.toolbar, "field 'toolbar'", Toolbar.class);
    target.toolbarTextHolder = Utils.findRequiredView(source, R.id.toolbar_text_holder, "field 'toolbarTextHolder'");
    target.toolbarTitle = Utils.findRequiredViewAsType(source, R.id.toolbar_title, "field 'toolbarTitle'", TextView.class);
    target.toolbarSubtitle = Utils.findRequiredViewAsType(source, R.id.toolbar_subtitle, "field 'toolbarSubtitle'", TextView.class);
    target.progressCircle = Utils.findRequiredView(source, R.id.progress_circle, "field 'progressCircle'");
    target.errorMessage = Utils.findRequiredView(source, R.id.error_message, "field 'errorMessage'");
    target.textError = Utils.findRequiredViewAsType(source, R.id.text_error, "field 'textError'", RobotoLightTextView.class);
    view = Utils.findRequiredView(source, R.id.try_again, "field 'tryAgain' and method 'onTryAgainClicked'");
    target.tryAgain = Utils.castView(view, R.id.try_again, "field 'tryAgain'", RobotoBoldTextView.class);
    view2131755380 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.onTryAgainClicked();
      }
    });
    target.movieHolder = Utils.findRequiredViewAsType(source, R.id.movie_detail_holder, "field 'movieHolder'", NestedScrollView.class);
    target.fabNavigasi = Utils.findRequiredViewAsType(source, R.id.fab_navigasi, "field 'fabNavigasi'", FloatingActionButton.class);
    view = Utils.findRequiredView(source, R.id.fab_rating, "field 'fabRating' and method 'AddRating'");
    target.fabRating = Utils.castView(view, R.id.fab_rating, "field 'fabRating'", FloatingActionButton.class);
    view2131755382 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.AddRating();
      }
    });
    view = Utils.findRequiredView(source, R.id.fab_action, "field 'fabAction' and method 'EditMustahiq'");
    target.fabAction = Utils.castView(view, R.id.fab_action, "field 'fabAction'", FloatingActionButton.class);
    view2131755384 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.EditMustahiq();
      }
    });
    view = Utils.findRequiredView(source, R.id.fab_rekomendasi, "field 'fabRekomendasi' and method 'AddRekomendasi'");
    target.fabRekomendasi = Utils.castView(view, R.id.fab_rekomendasi, "field 'fabRekomendasi'", FloatingActionButton.class);
    view2131755383 = view;
    view.setOnClickListener(new DebouncingOnClickListener() {
      @Override
      public void doClick(View p0) {
        target.AddRekomendasi();
      }
    });
    target.layoutRating = Utils.findRequiredViewAsType(source, R.id.layout_rating, "field 'layoutRating'", LinearLayout.class);
    target.rating = Utils.findRequiredViewAsType(source, R.id.rating, "field 'rating'", AppCompatRatingBar.class);
    target.ratingAmilZakat = Utils.findRequiredViewAsType(source, R.id.rating_amil_zakat, "field 'ratingAmilZakat'", AppCompatRatingBar.class);
    target.recyclerView = Utils.findRequiredViewAsType(source, R.id.recyclerview_foto, "field 'recyclerView'", RecyclerView.class);
    target.fotoProfil = Utils.findRequiredViewAsType(source, R.id.foto_profil, "field 'fotoProfil'", AvatarView.class);
    target.namaCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_calon_mustahiq, "field 'namaCalonMustahiq'", RobotoBoldTextView.class);
    target.alamatCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.alamat_calon_mustahiq, "field 'alamatCalonMustahiq'", RobotoLightTextView.class);
    target.noIdentitasCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_identitas_calon_mustahiq, "field 'noIdentitasCalonMustahiq'", RobotoLightTextView.class);
    target.noTelpCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.no_telp_calon_mustahiq, "field 'noTelpCalonMustahiq'", RobotoLightTextView.class);
    target.jumlahAnakCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.jumlah_anak_calon_mustahiq, "field 'jumlahAnakCalonMustahiq'", RobotoLightTextView.class);
    target.statusPernikahanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pernikahan_calon_mustahiq, "field 'statusPernikahanCalonMustahiq'", RobotoLightTextView.class);
    target.statusTempatTinggalCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_tempat_tinggal_calon_mustahiq, "field 'statusTempatTinggalCalonMustahiq'", RobotoLightTextView.class);
    target.statusPekerjaanCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.status_pekerjaan_calon_mustahiq, "field 'statusPekerjaanCalonMustahiq'", RobotoLightTextView.class);
    target.namaPerekomendasiCalonMustahiq = Utils.findRequiredViewAsType(source, R.id.nama_perekomendasi_calon_mustahiq, "field 'namaPerekomendasiCalonMustahiq'", RobotoLightTextView.class);

    Resources res = source.getResources();
    target.isTablet = res.getBoolean(R.bool.is_tablet);
  }

  @Override
  @CallSuper
  public void unbind() {
    T target = this.target;
    if (target == null) throw new IllegalStateException("Bindings already cleared.");

    target.toolbar = null;
    target.toolbarTextHolder = null;
    target.toolbarTitle = null;
    target.toolbarSubtitle = null;
    target.progressCircle = null;
    target.errorMessage = null;
    target.textError = null;
    target.tryAgain = null;
    target.movieHolder = null;
    target.fabNavigasi = null;
    target.fabRating = null;
    target.fabAction = null;
    target.fabRekomendasi = null;
    target.layoutRating = null;
    target.rating = null;
    target.ratingAmilZakat = null;
    target.recyclerView = null;
    target.fotoProfil = null;
    target.namaCalonMustahiq = null;
    target.alamatCalonMustahiq = null;
    target.noIdentitasCalonMustahiq = null;
    target.noTelpCalonMustahiq = null;
    target.jumlahAnakCalonMustahiq = null;
    target.statusPernikahanCalonMustahiq = null;
    target.statusTempatTinggalCalonMustahiq = null;
    target.statusPekerjaanCalonMustahiq = null;
    target.namaPerekomendasiCalonMustahiq = null;

    view2131755380.setOnClickListener(null);
    view2131755380 = null;
    view2131755382.setOnClickListener(null);
    view2131755382 = null;
    view2131755384.setOnClickListener(null);
    view2131755384 = null;
    view2131755383.setOnClickListener(null);
    view2131755383 = null;

    this.target = null;
  }
}
