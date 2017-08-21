package com.ad.zakatrizki.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;
import android.widget.Toast;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.model.CalonMustahiq;
import com.ad.zakatrizki.model.Mustahiq;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.Prefs;
import com.ad.zakatrizki.utils.SnackBar;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialIcons;
import com.joanzapata.iconify.fonts.MaterialModule;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class AddRekomendasiFragment extends DialogFragment implements CustomVolley.OnCallbackResponse {
    private static final String TAG_RATING = "TAG_RATING";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rekomendasi)
    Button rekomendasi;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private SnackBar snackbar;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private ProgressDialog dialogProgress;
    private Unbinder butterKnife;


    private RekomendasiListener callback;
    private Mustahiq mustahiq;
    private Dialog alertDialog;
    private CalonMustahiq calonMustahiq;

    public AddRekomendasiFragment() {

    }

    public void setData(Mustahiq mustahiq) {
        this.mustahiq = mustahiq;
    }


    @OnClick(R.id.rekomendasi)
    void Rekomendasi() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage("Anda yakin akan memberikan rekomendasi pada " + (mustahiq != null ? "" : "Calon") + " ini?");

        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                Map<String, String> jsonParams = new HashMap<>();
                jsonParams.put(Zakat.id_calon_mustahiq,
                        String.valueOf(mustahiq != null ? mustahiq.id_calon_mustahiq : calonMustahiq.id_calon_mustahiq));
                jsonParams.put(Zakat.id_user, Prefs.getIdUser(getActivity()));

                queue = customVolley.Rest(Request.Method.POST, ApiHelper.getAddRekomendasiLink(getActivity()), jsonParams, TAG_RATING);

            }
        });

        alertDialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                alertDialog.dismiss();
            }
        });

        alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        if (queue != null) {
            queue.cancelAll(TAG_RATING);
        }

    }

    @Override
    public void onVolleyStart(String TAG) {
        progress(true);
    }

    @Override
    public void onVolleyEnd(String TAG) {
        progress(false);
    }

    @Override
    public void onVolleySuccessResponse(String TAG, String response) {

        try {

            JSONObject json = new JSONObject(response);
            String res = json.getString(Zakat.isSuccess);
            String message = json.getString(Zakat.message);
            if (Boolean.valueOf(res)) {
                if (mustahiq != null) {
                    JSONObject obj = new JSONObject(json.getString(Zakat.mustahiq));
                    String id_mustahiq = obj.getString(Zakat.id_mustahiq);
                    String id_calon_mustahiq = obj.getString(Zakat.id_calon_mustahiq);
                    String nama_calon_mustahiq = obj.getString(Zakat.nama_calon_mustahiq);
                    String alamat_calon_mustahiq = obj.getString(Zakat.alamat_calon_mustahiq);
                    String latitude_calon_mustahiq = obj.getString(Zakat.latitude_calon_mustahiq);
                    String longitude_calon_mustahiq = obj.getString(Zakat.longitude_calon_mustahiq);
                    String no_identitas_calon_mustahiq = obj.getString(Zakat.no_identitas_calon_mustahiq);
                    String no_telp_calon_mustahiq = obj.getString(Zakat.no_telp_calon_mustahiq);
                    String nama_perekomendasi_calon_mustahiq = obj.getString(Zakat.nama_perekomendasi_calon_mustahiq);
                    String alasan_perekomendasi_calon_mustahiq = obj.getString(Zakat.alasan_perekomendasi_calon_mustahiq);

                    String photo_1 = obj
                            .getString(Zakat.photo_1);
                    String photo_2 = obj
                            .getString(Zakat.photo_2);
                    String photo_3 = obj
                            .getString(Zakat.photo_3);
                    String caption_photo_1 = obj
                            .getString(Zakat.caption_photo_1);
                    String caption_photo_2 = obj
                            .getString(Zakat.caption_photo_2);
                    String caption_photo_3 = obj
                            .getString(Zakat.caption_photo_3);
                    String status_mustahiq = obj.getString(Zakat.status_mustahiq);
                    String jumlah_rating = obj.getString(Zakat.jumlah_rating);
                    String id_nama_validasi_amil_zakat = obj.getString(Zakat.id_nama_validasi_amil_zakat);
                    String nama_validasi_amil_zakat = obj.getString(Zakat.nama_validasi_amil_zakat);
                    String waktu_terakhir_donasi = obj.getString(Zakat.waktu_terakhir_donasi);

                    mustahiq = new Mustahiq(id_mustahiq, id_calon_mustahiq, nama_calon_mustahiq, alamat_calon_mustahiq,
                            latitude_calon_mustahiq,
                            longitude_calon_mustahiq,
                            no_identitas_calon_mustahiq,
                            no_telp_calon_mustahiq,
                            nama_perekomendasi_calon_mustahiq,
                            alasan_perekomendasi_calon_mustahiq,
                            photo_1,
                            photo_2,
                            photo_3,
                            caption_photo_1,
                            caption_photo_2,
                            caption_photo_3,
                            status_mustahiq,
                            jumlah_rating,id_nama_validasi_amil_zakat, nama_validasi_amil_zakat, waktu_terakhir_donasi);
                    callback.onFinishRekomendasi(mustahiq);
                } else {
                    callback.onFinishRekomendasi(calonMustahiq);
                }
                dismiss();
                Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
            } else {
                snackbar.show(message);
            }
        } catch (Exception e) {
            snackbar.show("error parsing data");
            Log.v("error", e.getMessage());
        }
    }

    @Override
    public void onVolleyErrorResponse(String TAG, String response) {
        snackbar.show(response);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Iconify
                .with(new FontAwesomeModule())
                .with(new EntypoModule())
                .with(new MaterialModule())
                .with(new MaterialCommunityModule());
        super.onCreate(savedInstanceState);

        try {
            callback = (RekomendasiListener) getTargetFragment();
        } catch (Exception e) {
            throw new ClassCastException("Calling Fragment must implement KonfirmasiPendaftaranPesertaListener");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_rekomendasi, container);

        butterKnife = ButterKnife.bind(this, view);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        snackbar = new SnackBar(getActivity(), coordinatorLayout);
        toolbar.setTitle("Rekomendasi");
        toolbar.setNavigationIcon(
                new IconDrawable(getActivity(), MaterialIcons.md_close)
                        .colorRes(R.color.white)
                        .actionBarSize());
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return view;
    }

    private void progress(boolean status) {
        if (status) {
            dialogProgress = ProgressDialog.show(getActivity(), "Submit",
                    "Harap menunggu...", true);
        } else {

            if (dialogProgress.isShowing())
                dialogProgress.dismiss();
        }
    }

    public void setData(CalonMustahiq calonMustahiq) {
        this.calonMustahiq = calonMustahiq;
    }


    public interface RekomendasiListener {

        void onFinishRekomendasi(Mustahiq mustahiq);

        void onFinishRekomendasi(CalonMustahiq mustahiq);


    }


    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }


}