package com.ad.zakatrizki.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.SnackBar;
import com.ad.zakatrizki.utils.Utils;
import com.ad.zakatrizki.widget.RobotoRegularEditText;
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

public class RegisterFragment extends DialogFragment implements CustomVolley.OnCallbackResponse {
    private static final String TAG_REGISTER = "TAG_REGISTER";
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.nama)
    RobotoRegularEditText nama;
    @BindView(R.id.alamat)
    RobotoRegularEditText alamat;
    @BindView(R.id.no_telp)
    RobotoRegularEditText no_telp;
    @BindView(R.id.no_identitas)
    RobotoRegularEditText no_identitas;

    @BindView(R.id.username)
    RobotoRegularEditText username;
    @BindView(R.id.password)
    RobotoRegularEditText password;
    @BindView(R.id.register)
    Button register;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private SnackBar snackbar;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private ProgressDialog dialogProgress;
    private Unbinder butterKnife;

    private String val_nama = "";
    private String val_alamat = "";
    private String val_no_telp = "";
    private String val_no_identitas = "";

    private String val_username = "";
    private String val_password = "";


    private RegisterListener callback;

    public RegisterFragment() {

    }

    @OnClick(R.id.register)
    void Register() {
        Utils.HideKeyboard(getActivity(), nama);
        Utils.HideKeyboard(getActivity(), alamat);
        Utils.HideKeyboard(getActivity(), no_telp);
        Utils.HideKeyboard(getActivity(), no_identitas);
        Utils.HideKeyboard(getActivity(), username);
        Utils.HideKeyboard(getActivity(), password);
        getData();

        if (val_nama.length() == 0 ||
        val_alamat.length() == 0||
        val_no_telp.length() == 0||
        val_no_identitas.length() == 0||
        val_username.length() == 0
                || val_password.length() == 0) {
            snackbar.show("Harap isi semua form...");
            return;
        }

        Map<String, String> jsonParams = new HashMap<>();

        jsonParams.put(Zakat.nama,
                val_nama);
        jsonParams.put(Zakat.alamat,
                val_alamat);
        jsonParams.put(Zakat.no_identitas,
                val_no_identitas);
        jsonParams.put(Zakat.no_telp,
                val_no_telp);
        jsonParams.put(Zakat.username,
                val_username);
        jsonParams.put(Zakat.password,
                val_password);

        queue = customVolley.Rest(Request.Method.POST, ApiHelper.getRegisterLink(getActivity()), jsonParams, TAG_REGISTER);


    }

    private void getData() {

        val_nama = nama.getText().toString().trim();
        val_alamat = alamat.getText().toString().trim();
        val_no_telp= no_telp.getText().toString().trim();
        val_no_identitas = no_identitas.getText().toString().trim();
        val_username = username.getText().toString().trim();
        val_password = password.getText().toString().trim();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        if (queue != null) {
            queue.cancelAll(TAG_REGISTER);
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
                JSONObject jsUser = new JSONObject(json.getString(Zakat.user));
                String id_user = jsUser.getString(Zakat.id_user);
                String tipe_user = jsUser.getString(Zakat.tipe_user);
                String nama = jsUser.getString(Zakat.nama);
                String alamat = jsUser.getString(Zakat.alamat);
                String no_telp = jsUser.getString(Zakat.no_telp);
                String no_identitas = jsUser.getString(Zakat.no_identitas);
                callback.onFinishRegister(id_user,tipe_user,nama,alamat,no_telp,no_identitas);
                dismiss();
                snackbar.show(message);
            } else {
                password.setText("");
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
            callback = (RegisterListener) getTargetFragment();
        } catch (Exception e) {
            throw new ClassCastException("Calling Fragment must implement KonfirmasiPendaftaranPesertaListener");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_register, container);

        butterKnife = ButterKnife.bind(this, view);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        snackbar = new SnackBar(getActivity(), coordinatorLayout);
        toolbar.setTitle("Register");
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


    public interface RegisterListener {

        void onFinishRegister(String id_user, String tipe_user, String nama, String alamat, String no_telp, String no_identitas);
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