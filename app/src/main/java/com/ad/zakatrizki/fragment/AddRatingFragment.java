package com.ad.zakatrizki.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatRatingBar;
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

public class AddRatingFragment extends DialogFragment implements CustomVolley.OnCallbackResponse{
    private static final String TAG_RATING= "TAG_RATING";
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.addrating)
    AppCompatRatingBar addrating;
    @BindView(R.id.rating)
    Button rating;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;

    private SnackBar snackbar;
    private CustomVolley customVolley;
    private RequestQueue queue;
    private ProgressDialog dialogProgress;
    private Unbinder butterKnife;

    private int val_addrating = 0;


    private RatingListener callback;
    private Mustahiq mustahiq;

    private CalonMustahiq calonMustahiq;

    public AddRatingFragment() {

    }

    public void setData(Mustahiq mustahiq) {
        this.mustahiq = mustahiq;
    }
    public void setData(CalonMustahiq calonMustahiq) {
        this.calonMustahiq = calonMustahiq;
    }


    @OnClick(R.id.rating)
    void Rating() {
        getData();

        if (val_addrating == 0) {
            snackbar.show("Harap beri rating");
            return;
        }

        Map<String, String> jsonParams = new HashMap<>();
        if(mustahiq!=null)
        jsonParams.put(Zakat.id_calon_mustahiq,
                String.valueOf(mustahiq.id_calon_mustahiq));
        else
            jsonParams.put(Zakat.id_calon_mustahiq,
                    String.valueOf(calonMustahiq.id_calon_mustahiq));

        jsonParams.put(Zakat.rating,
                String.valueOf(val_addrating));
        if(Prefs.getLogin(getActivity()))
            jsonParams.put(Zakat.id_user,
                    String.valueOf(Prefs.getIdUser(getActivity())));

        queue = customVolley.Rest(Request.Method.POST, ApiHelper.getAddRatingLink(getActivity()), jsonParams, TAG_RATING);


    }

    private void getData() {

        val_addrating = (int) addrating.getRating();

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

                JSONObject obj = new JSONObject(json.getString(Zakat.calon_mustahiq));
                String jumlah_rating = obj.getString(Zakat.jumlah_rating);
                String jumlah_rating_amil_zakat = obj.getString(Zakat.jumlah_rating_amil_zakat);
                if(mustahiq!=null) {
                    mustahiq.jumlah_rating = jumlah_rating;
                    mustahiq.jumlah_rating_amil_zakat = jumlah_rating_amil_zakat;
                    callback.onFinishRating(mustahiq);
                }
                else
                if(calonMustahiq!=null) {
                    calonMustahiq.jumlah_rating = jumlah_rating;
                    calonMustahiq.jumlah_rating_amil_zakat = jumlah_rating_amil_zakat;
                    callback.onFinishRating(calonMustahiq);
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
            callback = (RatingListener) getTargetFragment();
        } catch (Exception e) {
            throw new ClassCastException("Calling Fragment must implement AddRatingFragment");
        }
    }


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_rating, container);

        butterKnife = ButterKnife.bind(this, view);
        customVolley = new CustomVolley(getActivity());
        customVolley.setOnCallbackResponse(this);
        snackbar = new SnackBar(getActivity(), coordinatorLayout);
        toolbar.setTitle("Rating");
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




    public interface RatingListener {

        void onFinishRating(Mustahiq mustahiq);

        void onFinishRating(CalonMustahiq calonMustahiq);
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