package com.ad.zakatrizki.fragment;

import android.app.Application;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.AppCompatRatingBar;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.adapter.PhotoAdapter;
import com.ad.zakatrizki.model.CalonMustahiq;
import com.ad.zakatrizki.model.Mustahiq;
import com.ad.zakatrizki.model.Photo;
import com.ad.zakatrizki.model.Refresh;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.Prefs;
import com.ad.zakatrizki.utils.TextUtils;
import com.ad.zakatrizki.widget.RobotoBoldTextView;
import com.ad.zakatrizki.widget.RobotoLightTextView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.MaterialIcons;
import com.sdsmdg.tastytoast.TastyToast;

import org.greenrobot.eventbus.EventBus;
import org.json.JSONObject;

import java.util.ArrayList;

import agency.tango.android.avatarview.loader.PicassoLoader;
import agency.tango.android.avatarview.views.AvatarView;
import butterknife.BindBool;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class CalonMustahiqDetailFragment extends Fragment
        implements ManageCalonMustahiqFragment.AddEditCalonMustahiqListener, OnMapReadyCallback,
        CustomVolley.OnCallbackResponse, AddRatingFragment.RatingListener,
        AddValidasiFragment.ValidasiListener,
        AddRekomendasiFragment.RekomendasiListener,
        PhotoAdapter.OnPhotoItemClickListener {

    private static final String TAG_DETAIL = "TAG_DETAIL";
    @BindBool(R.bool.is_tablet)
    boolean isTablet;
    // Toolbar
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.toolbar_text_holder)
    View toolbarTextHolder;
    @BindView(R.id.toolbar_title)
    TextView toolbarTitle;
    @BindView(R.id.toolbar_subtitle)
    TextView toolbarSubtitle;
    // Main views
    @BindView(R.id.progress_circle)
    View progressCircle;
    @BindView(R.id.error_message)
    View errorMessage;
    @BindView(R.id.text_error)
    RobotoLightTextView textError;
    @BindView(R.id.try_again)
    RobotoBoldTextView tryAgain;
    @BindView(R.id.movie_detail_holder)
    NestedScrollView movieHolder;


    @BindView(R.id.fab_navigasi)
    FloatingActionButton fabNavigasi;
    @BindView(R.id.fab_rating)
    FloatingActionButton fabRating;
    @BindView(R.id.fab_action)
    FloatingActionButton fabAction;
    @BindView(R.id.fab_rekomendasi)
    FloatingActionButton fabRekomendasi;

    @BindView(R.id.layout_rating)
    LinearLayout layoutRating;


    @BindView(R.id.rating)
    AppCompatRatingBar rating;



    @BindView(R.id.rating_amil_zakat)
    AppCompatRatingBar ratingAmilZakat;

    @BindView(R.id.recyclerview_foto)
    RecyclerView recyclerView;

    private ArrayList<Photo> dataPhotos = new ArrayList<>();
    private PhotoAdapter adapterPhoto;
    private LinearLayoutManager mLayoutManager;

    @OnClick(R.id.fab_rekomendasi)
    void AddRekomendasi() {
        FragmentManager fragmentManager = getChildFragmentManager();
        if (Prefs.getLogin(getActivity())) {
            if (Prefs.getTipeUser(getActivity()).equalsIgnoreCase("1")) {
                AddValidasiFragment add = new AddValidasiFragment();
                add.setTargetFragment(this, 0);
                add.setData(calonMustahiq);
                add.show(fragmentManager, "Add Validasi");
            } else {
                AddRekomendasiFragment add = new AddRekomendasiFragment();
                add.setTargetFragment(this, 0);
                add.setData(calonMustahiq);
                add.show(fragmentManager, "Add Rekomendasi");
            }
        }
    }


    @OnClick(R.id.fab_rating)
    void AddRating() {
        FragmentManager fragmentManager = getChildFragmentManager();
        AddRatingFragment add = new AddRatingFragment();
        add.setTargetFragment(this, 0);
        add.setData(calonMustahiq);
        add.show(fragmentManager, "Add Rating");
    }

    @BindView(R.id.foto_profil)
    AvatarView fotoProfil;
    @BindView(R.id.nama_calon_mustahiq)
    RobotoBoldTextView namaCalonMustahiq;
    @BindView(R.id.alamat_calon_mustahiq)
    RobotoLightTextView alamatCalonMustahiq;
    @BindView(R.id.no_identitas_calon_mustahiq)
    RobotoLightTextView noIdentitasCalonMustahiq;
    @BindView(R.id.no_telp_calon_mustahiq)
    RobotoLightTextView noTelpCalonMustahiq;
    @BindView(R.id.jumlah_anak_calon_mustahiq)
    RobotoLightTextView jumlahAnakCalonMustahiq;
    @BindView(R.id.status_pernikahan_calon_mustahiq)
    RobotoLightTextView statusPernikahanCalonMustahiq;
    @BindView(R.id.status_tempat_tinggal_calon_mustahiq)
    RobotoLightTextView statusTempatTinggalCalonMustahiq;
    @BindView(R.id.status_pekerjaan_calon_mustahiq)
    RobotoLightTextView statusPekerjaanCalonMustahiq;
    @BindView(R.id.nama_perekomendasi_calon_mustahiq)
    RobotoLightTextView namaPerekomendasiCalonMustahiq;
    private ProgressDialog dialogProgress;
    private Unbinder unbinder;
    private String id;
    private CalonMustahiq calonMustahiq;
    private PicassoLoader imageLoader;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private GoogleMap mMap;

    @OnClick(R.id.fab_action)
    void EditMustahiq() {

        FragmentManager fragmentManager = getChildFragmentManager();
        ManageCalonMustahiqFragment manageMustahiq = new ManageCalonMustahiqFragment();
        manageMustahiq.setTargetFragment(this, 0);
        manageMustahiq.setCancelable(false);
        manageMustahiq.setDialogTitle("Calon Mustahiq");
        manageMustahiq.setAction("edit");
        manageMustahiq.setData(calonMustahiq);
        manageMustahiq.show(fragmentManager, "Manage Calon Mustahiq");
    }

    // Fragment lifecycle
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_calon_mustahiq_detail, container, false);
        unbinder = ButterKnife.bind(this, v);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        imageLoader = new PicassoLoader();

        // Setup toolbar
        toolbar.setTitle(R.string.loading);
        if (!isTablet) {
            toolbar.setNavigationIcon(ContextCompat.getDrawable(getActivity(), R.drawable.action_home));
            toolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().finish();
                }
            });
        }


        //inisial adapterMustahiq
        adapterPhoto = new PhotoAdapter(getActivity(), dataPhotos);
        adapterPhoto.setOnPhotoItemClickListener(this);

        //recyclerView
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setHasFixedSize(true);

        //inisial layout manager
       /* int grid_column_count = getResources().getInteger(R.integer.grid_column_count);
        StaggeredGridLayoutManager mLayoutManager = new StaggeredGridLayoutManager(grid_column_count, StaggeredGridLayoutManager.VERTICAL);
*/

        //   final LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        //  mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        mLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

        // set layout manager
        recyclerView.setLayoutManager(mLayoutManager);

        // set adapterPhoto
        recyclerView.setAdapter(adapterPhoto);

        //setup fab
        fabAction.setImageDrawable(
                new IconDrawable(getActivity(), MaterialIcons.md_edit)
                        .colorRes(R.color.white)
                        .actionBarSize());
        fabNavigasi.setVisibility(View.GONE);
        fabRating.setImageDrawable(
                new IconDrawable(getActivity(), MaterialIcons.md_star)
                        .colorRes(R.color.white)
                        .actionBarSize());

        fabRekomendasi.setImageDrawable(
                new IconDrawable(getActivity(), MaterialIcons.md_check)
                        .colorRes(R.color.white)
                        .actionBarSize());

        // Download calon_mustahiq details if new instance, else restore from saved instance
        if (savedInstanceState == null || !(savedInstanceState.containsKey(Zakat.CALON_MUSTAHIQ_ID)
                && savedInstanceState.containsKey(Zakat.CALON_MUSTAHIQ_OBJECT))) {
            id = getArguments().getString(Zakat.CALON_MUSTAHIQ_ID);
            if (TextUtils.isNullOrEmpty(id)) {
                progressCircle.setVisibility(View.GONE);
                toolbarTextHolder.setVisibility(View.GONE);
                toolbar.setTitle("");
            } else {
                downloadLokasiDetails(id);
            }
        } else {
            id = savedInstanceState.getString(Zakat.CALON_MUSTAHIQ_ID);
            calonMustahiq = savedInstanceState.getParcelable(Zakat.CALON_MUSTAHIQ_OBJECT);
            onDownloadSuccessful();
        }

        return v;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Send screen id_user_kru to analytics
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (calonMustahiq != null && id != null) {
            outState.putString(Zakat.CALON_MUSTAHIQ_ID, id);
            outState.putParcelable(Zakat.CALON_MUSTAHIQ_OBJECT, calonMustahiq);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        if (queue != null) {
            queue.cancelAll(TAG_DETAIL);
        }

    }


    // JSON parsing and display
    private void downloadLokasiDetails(String id) {
        String urlToDownload = ApiHelper.getCalonMustahiqDetailLink(getActivity(), id);
        queue = customVolley.Rest(Request.Method.GET, urlToDownload, null, TAG_DETAIL);
    }

    private void onDownloadSuccessful() {

        // Toggle visibility
        progressCircle.setVisibility(View.GONE);
        errorMessage.setVisibility(View.GONE);
        movieHolder.setVisibility(View.VISIBLE);
        if (calonMustahiq.id_user_perekomendasi.equalsIgnoreCase(Prefs.getIdUser(getActivity()))) {
            fabAction.setVisibility(View.VISIBLE);
        }

        if (Prefs.getLogin(getActivity())) {
            fabRekomendasi.setVisibility(View.VISIBLE);
        } else
            fabRekomendasi.setVisibility(View.GONE);

        fabRating.setVisibility(View.VISIBLE);

        toolbar.setTitle(calonMustahiq.nama_calon_mustahiq);
        toolbarTextHolder.setVisibility(View.GONE);

        imageLoader.loadImage(fotoProfil, calonMustahiq.nama_calon_mustahiq, calonMustahiq.nama_calon_mustahiq);
        namaCalonMustahiq.setText("Nama : " + calonMustahiq.nama_calon_mustahiq);
        alamatCalonMustahiq.setText("Alamat : " + (TextUtils.isNullOrEmpty(calonMustahiq.alamat_calon_mustahiq) ? "-" : calonMustahiq.alamat_calon_mustahiq));
        noIdentitasCalonMustahiq.setText("No Identitas : " + (TextUtils.isNullOrEmpty(calonMustahiq.no_identitas_calon_mustahiq) ? "-" : calonMustahiq.no_identitas_calon_mustahiq));
        noTelpCalonMustahiq.setText("No Telp : " + (TextUtils.isNullOrEmpty(calonMustahiq.no_telp_calon_mustahiq) ? "-" : calonMustahiq.no_telp_calon_mustahiq));
        jumlahAnakCalonMustahiq.setText("Jumlah Anak : " + (TextUtils.isNullOrEmpty(calonMustahiq.jumlah_anak_calon_mustahiq) ? "-" : calonMustahiq.jumlah_anak_calon_mustahiq));
        statusPernikahanCalonMustahiq.setText("Status Pernikahan : " + (TextUtils.isNullOrEmpty(calonMustahiq.status_pernikahan_calon_mustahiq) ? "-" : calonMustahiq.status_pernikahan_calon_mustahiq));

        statusTempatTinggalCalonMustahiq.setText("Status Tempat Tinggal : " + (TextUtils.isNullOrEmpty(calonMustahiq.status_tempat_tinggal_calon_mustahiq) ? "-" : calonMustahiq.status_tempat_tinggal_calon_mustahiq));
        statusPekerjaanCalonMustahiq.setText("Status Pekerjaan : " + (TextUtils.isNullOrEmpty(calonMustahiq.status_pekerjaan_calon_mustahiq) ? "-" : calonMustahiq.status_pekerjaan_calon_mustahiq));
        namaPerekomendasiCalonMustahiq.setText("Nama Perekomendasi : " + (TextUtils.isNullOrEmpty(calonMustahiq.nama_perekomendasi_calon_mustahiq) ? "-" : calonMustahiq.nama_perekomendasi_calon_mustahiq));

        layoutRating.setVisibility(View.VISIBLE);
        Log.v("calonMustahiq.jumlah_rating", calonMustahiq.jumlah_rating + "");
        float rt = 0;
        try {

            rt = Float.parseFloat(calonMustahiq.jumlah_rating);
        } catch (Exception ignored) {
        }
        rating.setRating(rt);

        float rtam = 0;
        try {

            rtam = Float.parseFloat(calonMustahiq.jumlah_rating_amil_zakat);
        } catch (Exception ignored) {
        }
        ratingAmilZakat.setRating(rtam);

        dataPhotos.clear();
        adapterPhoto.delete_all();

        dataPhotos.add(new Photo(calonMustahiq.photo_1, calonMustahiq.caption_photo_1));
        dataPhotos.add(new Photo(calonMustahiq.photo_2, calonMustahiq.caption_photo_2));
        dataPhotos.add(new Photo(calonMustahiq.photo_3, calonMustahiq.caption_photo_3));

        adapterPhoto.notifyDataSetChanged();

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.map);
        mapView = mapFragment.getView();
        mapFragment.getMapAsync(CalonMustahiqDetailFragment.this);

    }


    private View mapView;


    private void onDownloadFailed() {
        errorMessage.setVisibility(View.VISIBLE);
        progressCircle.setVisibility(View.GONE);
        movieHolder.setVisibility(View.GONE);
        fabRating.setVisibility(View.GONE);
        fabRekomendasi.setVisibility(View.GONE);
        toolbarTextHolder.setVisibility(View.GONE);
        toolbar.setTitle("");
    }

    private void onNotAvailable(String message) {
        errorMessage.setVisibility(View.VISIBLE);
        textError.setText(message);
        tryAgain.setVisibility(View.GONE);
        progressCircle.setVisibility(View.GONE);
        movieHolder.setVisibility(View.GONE);
        fabRating.setVisibility(View.GONE);
        fabRekomendasi.setVisibility(View.GONE);
        if (calonMustahiq.id_user_perekomendasi.equalsIgnoreCase(Prefs.getIdUser(getActivity()))) {
            fabAction.setVisibility(View.GONE);
        }
        toolbarTextHolder.setVisibility(View.GONE);
        toolbar.setTitle("");
    }

    @OnClick(R.id.try_again)
    public void onTryAgainClicked() {
        errorMessage.setVisibility(View.GONE);
        progressCircle.setVisibility(View.VISIBLE);
        downloadLokasiDetails(id);
    }


    @Override
    public void onVolleyStart(String TAG) {
        if (TAG.equals(TAG_DETAIL)) {
        }
    }

    @Override
    public void onVolleyEnd(String TAG) {
        if (TAG.equals(TAG_DETAIL)) {
        }
    }

    @Override
    public void onVolleySuccessResponse(String TAG, String response) {
        if (TAG.equals(TAG_DETAIL)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                String isSuccess = jsonObject.getString(Zakat.isSuccess);
                String message = jsonObject.getString(Zakat.message);
                JSONObject jsDetail = new JSONObject(jsonObject.getString(Zakat.calon_mustahiq));
                String id_calon_mustahiq = jsDetail.getString(Zakat.id_calon_mustahiq);
                String nama_calon_mustahiq = jsDetail.getString(Zakat.nama_calon_mustahiq);
                String alamat_calon_mustahiq = jsDetail.getString(Zakat.alamat_calon_mustahiq);
                String latitude_calon_mustahiq = jsDetail.getString(Zakat.latitude_calon_mustahiq);
                String longitude_calon_mustahiq = jsDetail.getString(Zakat.longitude_calon_mustahiq);
                String no_identitas_calon_mustahiq = jsDetail.getString(Zakat.no_identitas_calon_mustahiq);
                String no_telp_calon_mustahiq = jsDetail.getString(Zakat.no_telp_calon_mustahiq);
                String jumlah_anak_calon_mustahiq = jsDetail.getString(Zakat.jumlah_anak_calon_mustahiq);
                String status_pernikahan_calon_mustahiq = jsDetail.getString(Zakat.status_pernikahan_calon_mustahiq);

                String status_tempat_tinggal_calon_mustahiq = jsDetail.getString(Zakat.status_tempat_tinggal_calon_mustahiq);
                String status_pekerjaan_calon_mustahiq = jsDetail.getString(Zakat.status_pekerjaan_calon_mustahiq);
                String id_user_perekomendasi = jsDetail.getString(Zakat.id_user_perekomendasi);
                String nama_perekomendasi_calon_mustahiq = jsDetail
                        .getString(Zakat.nama_perekomendasi_calon_mustahiq);
                String alasan_perekomendasi_calon_mustahiq = jsDetail
                        .getString(Zakat.alasan_perekomendasi_calon_mustahiq);
                String photo_1 = jsDetail
                        .getString(Zakat.photo_1);
                String photo_2 = jsDetail
                        .getString(Zakat.photo_2);
                String photo_3 = jsDetail
                        .getString(Zakat.photo_3);
                String caption_photo_1 = jsDetail
                        .getString(Zakat.caption_photo_1);
                String caption_photo_2 = jsDetail
                        .getString(Zakat.caption_photo_2);
                String caption_photo_3 = jsDetail
                        .getString(Zakat.caption_photo_3);
                String status_calon_mustahiq = jsDetail.getString(Zakat.status_calon_mustahiq);
                String jumlah_rating = jsDetail.getString(Zakat.jumlah_rating);
                String jumlah_rating_amil_zakat = jsDetail.getString(Zakat.jumlah_rating_amil_zakat);

                calonMustahiq = new CalonMustahiq(id_calon_mustahiq, nama_calon_mustahiq, alamat_calon_mustahiq, latitude_calon_mustahiq, longitude_calon_mustahiq, no_identitas_calon_mustahiq, no_telp_calon_mustahiq,
                        jumlah_anak_calon_mustahiq,
                        status_pernikahan_calon_mustahiq,
                        status_tempat_tinggal_calon_mustahiq,
                        status_pekerjaan_calon_mustahiq, id_user_perekomendasi,
                        nama_perekomendasi_calon_mustahiq,
                        alasan_perekomendasi_calon_mustahiq,
                        photo_1, photo_2, photo_3, caption_photo_1, caption_photo_2,
                        caption_photo_3, status_calon_mustahiq, jumlah_rating,jumlah_rating_amil_zakat);

                if (Boolean.parseBoolean(isSuccess))
                    onDownloadSuccessful();
                else
                    onNotAvailable(message);

            } catch (Exception ex) {
                // Parsing error
                onDownloadFailed();
                Log.d("Parse Error", ex.getMessage(), ex);
            }
        }
    }

    @Override
    public void onVolleyErrorResponse(String TAG, String response) {
        if (TAG.equals(TAG_DETAIL)) {
            TastyToast.makeText(getActivity(), "Error ..", TastyToast.LENGTH_LONG, TastyToast.ERROR);
        }
    }

    @Override
    public void onFinishEditCalonMustahiq(CalonMustahiq calon_mustahiq) {
        this.calonMustahiq = calon_mustahiq;
        onDownloadSuccessful();

    }

    @Override
    public void onFinishAddCalonMustahiq(CalonMustahiq calon_mustahiq) {

    }

    @Override
    public void onFinishDeleteCalonMustahiq(CalonMustahiq calon_mustahiq) {

        onNotAvailable("Mustahiq ini tidak ada/dihapus");
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.getUiSettings().setMapToolbarEnabled(false);

        LatLng Posisi = new LatLng(Double.parseDouble(calonMustahiq.latitude_calon_mustahiq.equalsIgnoreCase("null") ? "0.0" : calonMustahiq.latitude_calon_mustahiq), Double.parseDouble(calonMustahiq.longitude_calon_mustahiq.equalsIgnoreCase("null") ? "0.0" : calonMustahiq.longitude_calon_mustahiq));
        MarkerOptions marker = new MarkerOptions()
                .position(Posisi)
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_mustahiq));
        mMap.clear();
        Marker m = mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(Posisi, 14));


    }

    @Override
    public void onFinishRating(Mustahiq mustahiq) {

    }

    @Override
    public void onFinishRating(CalonMustahiq calonMustahiq) {
        this.calonMustahiq = calonMustahiq;
        onDownloadSuccessful();

    }

    @Override
    public void onFinishValidasi(Mustahiq mustahiq) {

    }

    @Override
    public void onFinishValidasi(CalonMustahiq mustahiq) {
        EventBus.getDefault().postSticky(new Refresh(true));
        getActivity().finish();
    }

    @Override
    public void onActionClick(View v, int position) {

    }

    @Override
    public void onRootClick(View v, int position) {
        FragmentManager ft = getChildFragmentManager();
        DialogViewSinggleImageFragment newFragment = DialogViewSinggleImageFragment.newInstance(ApiHelper.getBaseUrl(getActivity()) + adapterPhoto.data.get(position).getPhoto(), adapterPhoto.data.get(position).getCaption_photo());
        newFragment.setTargetFragment(this, 0);
        newFragment.show(ft, "slideshow");
    }

    @Override
    public void onFinishRekomendasi(Mustahiq mustahiq) {

    }

    @Override
    public void onFinishRekomendasi(CalonMustahiq calonMustahiq) {
       /* EventBus.getDefault().postSticky(new Refresh(true));
        getActivity().finish();*/
        this.calonMustahiq = calonMustahiq;

    }
}