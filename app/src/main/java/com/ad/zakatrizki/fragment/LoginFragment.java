package com.ad.zakatrizki.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.Button;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.utils.ApiHelper;
import com.ad.zakatrizki.utils.CustomVolley;
import com.ad.zakatrizki.utils.Menus;
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

public class LoginFragment extends DialogFragment implements CustomVolley.OnCallbackResponse {
    private static final String TAG_LOGIN = "TAG_LOGIN";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.username)
    RobotoRegularEditText username;
    @BindView(R.id.password)
    RobotoRegularEditText password;
    @BindView(R.id.login)
    Button login;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private SnackBar snackbar;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private ProgressDialog dialogProgress;
    private Unbinder butterKnife;

    private String val_username = "";
    private String val_password = "";


    private LoginListener callback;

    public LoginFragment() {

    }

    @OnClick(R.id.login)
    void Login() {
        Utils.HideKeyboard(getActivity(), username);
        Utils.HideKeyboard(getActivity(), password);
        getData();

        if (val_username.length() == 0
                || val_password.length() == 0) {
            snackbar.show("Harap isi semua form...");
            return;
        }

        Map<String, String> jsonParams = new HashMap<>();

        jsonParams.put(Zakat.username,
                val_username);
        jsonParams.put(Zakat.password,
                val_password);

        queue = customVolley.Rest(Request.Method.POST, ApiHelper.getLoginLink(getActivity()), jsonParams, TAG_LOGIN);


    }

    private void getData() {

        val_username = username.getText().toString().trim();
        val_password = password.getText().toString().trim();

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();
        if (queue != null) {
            queue.cancelAll(TAG_LOGIN);
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
                callback.onFinishLogin();
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
            callback = (LoginListener) getTargetFragment();
        } catch (Exception e) {
            throw new ClassCastException("Calling Fragment must implement KonfirmasiPendaftaranPesertaListener");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_login, container);

        butterKnife = ButterKnife.bind(this, view);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        snackbar = new SnackBar(getActivity(), coordinatorLayout);
        toolbar.setTitle("Login");
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


    public interface LoginListener {

        void onFinishLogin();
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