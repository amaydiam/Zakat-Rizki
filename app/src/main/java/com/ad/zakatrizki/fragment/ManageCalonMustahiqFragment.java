package com.ad.zakatrizki.fragment;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.model.CalonMustahiq;
import com.ad.zakatrizki.model.PickLocation;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.Menus;
import com.ad.zakatrizki.utils.Prefs;
import com.ad.zakatrizki.utils.SnackBar;
import com.ad.zakatrizki.utils.Utils;
import com.ad.zakatrizki.widget.RobotoRegularEditText;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialIcons;
import com.joanzapata.iconify.fonts.MaterialModule;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class ManageCalonMustahiqFragment extends DialogFragment implements CustomVolley.OnCallbackResponse {
    private static final String TAG_ADD = "TAG_ADD";
    private static final String TAG_EDIT = "TAG_EDIT";
    private static final String TAG_DELETE = "TAG_DELETE";
    String title;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nama_calon_mustahiq)
    RobotoRegularEditText namaCalonMustahiq;
    @BindView(R.id.alamat_calon_mustahiq)
    RobotoRegularEditText alamatCalonMustahiq;
    @BindView(R.id.no_identitas_calon_mustahiq)
    RobotoRegularEditText noIdentitasCalonMustahiq;
    @BindView(R.id.no_telp_calon_mustahiq)
    RobotoRegularEditText noTelpCalonMustahiq;
    @BindView(R.id.alasan_perekomendasi_calon_mustahiq)
    RobotoRegularEditText alasanPerekomendasiCalonMustahiq;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    @OnClick(R.id.pick_location)
    void pickLocation() {
        PlacePicker.IntentBuilder builder = new PlacePicker.IntentBuilder();
        try {
            getActivity().startActivityForResult(builder.build(getActivity()), Zakat.PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException e) {
            e.printStackTrace();
        } catch (GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
    }

    private SnackBar snackbar;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private ProgressDialog dialogProgress;
    private Unbinder butterKnife;

    private String val_id_calon_mustahiq;
    private String val_nama_calon_mustahiq = "";
    private String val_alamat_calon_mustahiq = "";
    private String val_no_identitas_calon_mustahiq = "";
    private String val_no_telp_calon_mustahiq = "";
    private String val_alasan_perekomendasi_calon_mustahiq = "";
    private Double val_latitude_calon_mustahiq;
    private Double val_longitude_calon_mustahiq;


    private CalonMustahiq calonMustahiq;
    private Dialog alertDialog;
    private AddEditCalonMustahiqListener callback;
    private String action;

    public ManageCalonMustahiqFragment() {

    }

    void Action(int id) {
        Utils.HideKeyboard(getActivity(), namaCalonMustahiq);
        Utils.HideKeyboard(getActivity(), alamatCalonMustahiq);
        Utils.HideKeyboard(getActivity(), noIdentitasCalonMustahiq);
        Utils.HideKeyboard(getActivity(), noTelpCalonMustahiq);
        Utils.HideKeyboard(getActivity(), alasanPerekomendasiCalonMustahiq);
        switch (id) {

            case Menus.SEND:
                getData();

                if (val_nama_calon_mustahiq.length() == 0
                        || val_alamat_calon_mustahiq.length() == 0
                        || val_no_identitas_calon_mustahiq.length() == 0
                        || val_no_telp_calon_mustahiq.length() == 0
                        || val_alasan_perekomendasi_calon_mustahiq.length() == 0) {
                    snackbar.show("Harap isi semua form...");
                    return;
                }
                if (val_latitude_calon_mustahiq == null
                        || val_longitude_calon_mustahiq == null) {
                    snackbar.show("Harap masukan kordinat lokasi...");
                    return;
                }

            /*    if (val_foto_1== null
                        || val_foto_2 == null
                        || val_foto_3 == null) {
                    snackbar.show("Harap lampirkan 3 foto calon mustahiq...");
                    return;
                }
*/
                Map<String, String> jsonParams = new HashMap<>();

                jsonParams.put(Zakat.nama_calon_mustahiq,
                        val_nama_calon_mustahiq);
                jsonParams.put(Zakat.alamat_calon_mustahiq,
                        val_alamat_calon_mustahiq);
                jsonParams.put(Zakat.latitude_calon_mustahiq,
                        String.valueOf(val_latitude_calon_mustahiq));
                jsonParams.put(Zakat.longitude_calon_mustahiq,
                        String.valueOf(val_longitude_calon_mustahiq));
                jsonParams.put(Zakat.no_identitas_calon_mustahiq,
                        val_no_identitas_calon_mustahiq);
                jsonParams.put(Zakat.no_telp_calon_mustahiq,
                        val_no_telp_calon_mustahiq);
                jsonParams.put(Zakat.alasan_perekomendasi_calon_mustahiq,
                        val_alasan_perekomendasi_calon_mustahiq);
                jsonParams.put(Zakat.id_user_perekomendasi,
                        Prefs.getIdUser(getActivity()));

                String TAG = null;
                if (action.equals("add")) {
                    TAG = TAG_ADD;
                } else if (action.equals("edit")) {
                    TAG = TAG_EDIT;
                    jsonParams.put(Zakat.id_calon_mustahiq,
                            val_id_calon_mustahiq);

                }

                queue = customVolley.Rest(Request.Method.POST, ApiHelper.getCalonMustahiqAddEditLink(getActivity()), jsonParams, TAG);

                //  dismiss();
                break;
            case Menus.DELETE:
                ConfirmDelete();
                break;
        }
    }

    private void getData() {

        val_nama_calon_mustahiq = namaCalonMustahiq.getText().toString().trim();
        val_alamat_calon_mustahiq = alamatCalonMustahiq.getText().toString().trim();
        val_no_identitas_calon_mustahiq = noIdentitasCalonMustahiq.getText().toString().trim();
        val_no_telp_calon_mustahiq = noTelpCalonMustahiq.getText().toString().trim();
        val_alasan_perekomendasi_calon_mustahiq = alasanPerekomendasiCalonMustahiq.getText().toString().trim();


    }

    private void ConfirmDelete() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
        alertDialogBuilder.setMessage("Anda yakin akan menghapus calon mustahiq ini?");

        alertDialogBuilder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                queue = customVolley.Rest(Request.Method.GET, ApiHelper.getCalonMustahiqDeleteLink(getActivity(), val_id_calon_mustahiq), null, TAG_DELETE);

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
            queue.cancelAll(TAG_ADD);
            queue.cancelAll(TAG_DELETE);
            queue.cancelAll(TAG_EDIT);
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
                if (!TAG.equals(TAG_DELETE)) {
                    JSONObject obj = new JSONObject(json.getString(Zakat.calon_mustahiq));
                    String id_calon_mustahiq = obj.getString(Zakat.id_calon_mustahiq);
                    String nama_calon_mustahiq = obj.getString(Zakat.nama_calon_mustahiq);
                    String alamat_calon_mustahiq = obj.getString(Zakat.alamat_calon_mustahiq);
                    String latitude_calon_mustahiq = obj.getString(Zakat.latitude_calon_mustahiq);
                    String longitude_calon_mustahiq = obj.getString(Zakat.longitude_calon_mustahiq);
                    String no_identitas_calon_mustahiq = obj.getString(Zakat.no_identitas_calon_mustahiq);
                    String no_telp_calon_mustahiq = obj.getString(Zakat.no_telp_calon_mustahiq);
                    String id_user_perekomendasi = obj
                            .getString(Zakat.id_user_perekomendasi);
                    String alasan_perekomendasi_calon_mustahiq = obj
                            .getString(Zakat.alasan_perekomendasi_calon_mustahiq);
                    String nama_perekomendasi_calon_mustahiq = obj
                            .getString(Zakat.nama_perekomendasi_calon_mustahiq);
                    String status_calon_mustahiq = obj.getString(Zakat.status_calon_mustahiq);

                    calonMustahiq = new CalonMustahiq(id_calon_mustahiq, nama_calon_mustahiq, alamat_calon_mustahiq, latitude_calon_mustahiq, longitude_calon_mustahiq, no_identitas_calon_mustahiq, no_telp_calon_mustahiq, id_user_perekomendasi, alasan_perekomendasi_calon_mustahiq, nama_perekomendasi_calon_mustahiq, status_calon_mustahiq);
                    if (TAG.equals(TAG_ADD)) {
                        callback.onFinishAddCalonMustahiq(calonMustahiq);
                    } else if (TAG.equals(TAG_EDIT)) {
                        callback.onFinishEditCalonMustahiq(calonMustahiq);
                    }
                } else {
                    callback.onFinishDeleteCalonMustahiq(calonMustahiq);
                }
                dismiss();
                snackbar.show(message);
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
            callback = (AddEditCalonMustahiqListener) getTargetFragment();
        } catch (Exception e) {
            throw new ClassCastException("Calling Fragment must implement KonfirmasiPendaftaranPesertaListener");
        }
    }

    public void setDialogTitle(String title) {
        this.title = title;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public void setData(CalonMustahiq calon_mustahiq) {
        this.calonMustahiq = calon_mustahiq;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_manage_calon_mustahiq, container);

        butterKnife = ButterKnife.bind(this, view);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        snackbar = new SnackBar(getActivity(), coordinatorLayout);
        toolbar.setTitle(title);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Action(item.getItemId());
                return true;
            }
        });
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
        toolbar.inflateMenu(R.menu.menu_manage);
        Menu menu = toolbar.getMenu();
        MenuItem _send = menu.findItem(Menus.SEND);
        MenuItem _delete = menu.findItem(Menus.DELETE);
        _send.setIcon(
                new IconDrawable(getActivity(), MaterialIcons.md_send)
                        .colorRes(R.color.white)
                        .actionBarSize());
        _delete.setIcon(
                new IconDrawable(getActivity(), MaterialIcons.md_delete)
                        .colorRes(R.color.white)
                        .actionBarSize());

        // Spinner on item click listener

        if (action.equals("edit")) {
            toolbar.setSubtitle("Ubah");
            _delete.setVisible(true);


            val_id_calon_mustahiq = calonMustahiq.id_calon_mustahiq;
            val_nama_calon_mustahiq = calonMustahiq.nama_calon_mustahiq;
            val_alamat_calon_mustahiq = calonMustahiq.alamat_calon_mustahiq;
            val_no_identitas_calon_mustahiq = calonMustahiq.no_identitas_calon_mustahiq;
            val_no_telp_calon_mustahiq = calonMustahiq.no_telp_calon_mustahiq;
            val_alasan_perekomendasi_calon_mustahiq = calonMustahiq.alasan_perekomendasi_calon_mustahiq;

            namaCalonMustahiq.setText(val_nama_calon_mustahiq);
            alamatCalonMustahiq.setText(val_alamat_calon_mustahiq);
            noIdentitasCalonMustahiq.setText(val_no_identitas_calon_mustahiq);
            noTelpCalonMustahiq.setText(val_no_telp_calon_mustahiq);
            alasanPerekomendasiCalonMustahiq.setText(val_alasan_perekomendasi_calon_mustahiq);


        } else {
            toolbar.setSubtitle("Tambah");
            _delete.setVisible(false);
        }

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


    public interface AddEditCalonMustahiqListener {
        void onFinishEditCalonMustahiq(CalonMustahiq calon_mustahiq);

        void onFinishAddCalonMustahiq(CalonMustahiq calon_mustahiq);

        void onFinishDeleteCalonMustahiq(CalonMustahiq calon_mustahiq);
    }


    @Subscribe(sticky = true, threadMode = ThreadMode.MAIN)
    public void onPickLocation(PickLocation cp) {
        alamatCalonMustahiq.setText(cp.getAddress());
        val_latitude_calon_mustahiq = cp.getLatitude();
        val_longitude_calon_mustahiq = cp.getLongitude();

        PickLocation stickyEvent = EventBus.getDefault().getStickyEvent(PickLocation.class);
        if (stickyEvent != null) {
            EventBus.getDefault().removeStickyEvent(stickyEvent);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    public void onStop() {
        EventBus.getDefault().unregister(this);
        super.onStop();
    }


}