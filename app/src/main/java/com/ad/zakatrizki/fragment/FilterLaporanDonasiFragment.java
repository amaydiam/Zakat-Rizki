package com.ad.zakatrizki.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.ad.zakatrizki.R;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.Iconify;
import com.joanzapata.iconify.fonts.EntypoModule;
import com.joanzapata.iconify.fonts.FontAwesomeModule;
import com.joanzapata.iconify.fonts.MaterialCommunityModule;
import com.joanzapata.iconify.fonts.MaterialIcons;
import com.joanzapata.iconify.fonts.MaterialModule;

import java.util.ArrayList;
import java.util.Calendar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnItemSelected;
import butterknife.Unbinder;

public class FilterLaporanDonasiFragment extends DialogFragment {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tahun)
    Spinner tahun;
    @BindView(R.id.bulan)
    Spinner bulan;
    @BindView(R.id.layout_bulan)
    LinearLayout layoutBulan;
    @BindView(R.id.coordinatorLayout)
    CoordinatorLayout coordinatorLayout;
    @BindView(R.id.btn_set)
    Button btnSet;
    @BindView(R.id.btn_clear)
    Button btnClear;
    private AddEditCalonMustahiqListener callback;
    private String s_tahun = "ALL";
    private String s_bulan = "ALL";
    private String s_index_bulan = "ALL";
    private Unbinder butterKnife;

    public FilterLaporanDonasiFragment() {

    }

    @OnItemSelected(R.id.tahun)
    public void spinnerItemSelected(Spinner spinner, int position) {
        getData();
        if (!s_tahun.equalsIgnoreCase("ALL")) {
            layoutBulan.setVisibility(View.VISIBLE);
        } else {
            layoutBulan.setVisibility(View.GONE);
        }
    }

    @OnClick(R.id.btn_set)
    void Send() {
        getData();
        callback.onFinishFilter(s_tahun, s_bulan, s_index_bulan);
        dismiss();
    }

    @OnClick(R.id.btn_clear)
    void RESET() {
        s_tahun = "ALL";
        s_bulan = "ALL";
        s_index_bulan = "ALL";
        callback.onFinishFilter(s_tahun, s_bulan, s_index_bulan);
        dismiss();
    }

    private void getData() {
        s_tahun = tahun.getSelectedItem().toString();
        if (!s_tahun.equalsIgnoreCase("ALL")) {
            s_bulan = bulan.getSelectedItem().toString();
            s_index_bulan = IndexBulan[bulan.getSelectedItemPosition()];
        } else {
            s_bulan = "ALL";
            s_index_bulan = "ALL";
        }
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        butterKnife.unbind();

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


    public void setTahun(String tahun) {
        this.s_tahun = tahun;
    }

    public void setBulan(String bulan) {
        this.s_bulan = bulan;
    }

    public void setIndexBulan(String index_bulan) {
        this.s_index_bulan = index_bulan;
    }

    String IndexBulan[] = {"ALL", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12"};


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {

        View view = inflater.inflate(
                R.layout.content_filter_laporan_donasi, container);

        butterKnife = ButterKnife.bind(this, view);
        toolbar.setTitle("Filter");
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

        ArrayList<String> stringArrayList = new ArrayList<>();

        stringArrayList.add("ALL");
        for (int i = 0; i <= 30; i++) {
            stringArrayList.add(String.valueOf((Calendar.getInstance().get(Calendar.YEAR)) - i));
        }
        ArrayAdapter<String> adapterTahun = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, stringArrayList);
        adapterTahun.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        tahun.setAdapter(adapterTahun);

        String arrBulan[] = {"ALL", "Januari", "Februari", "Maret", "April", "Mei", "Juni", "Juli", "Agustus", "September", "Oktober", "November", "Desember"};

        ArrayAdapter<String> adapterBulan = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, arrBulan);
        adapterBulan.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item); // The drop down view
        bulan.setAdapter(adapterBulan);


        if (!s_tahun.equalsIgnoreCase("ALL")) {
            for (int ii = 0; ii < stringArrayList.size(); ii++) {
                if (stringArrayList.get(ii).equalsIgnoreCase(s_tahun)) {
                    tahun.setSelection(ii);
                }
            }
            layoutBulan.setVisibility(View.VISIBLE);
            btnClear.setVisibility(View.VISIBLE);

            if (!s_bulan.equalsIgnoreCase("ALL")) {
                for (int iii = 0; iii < arrBulan.length; iii++) {
                    if (arrBulan[iii].equalsIgnoreCase(s_bulan)) {
                        bulan.setSelection(iii);
                    }
                }
            }


        } else {
            layoutBulan.setVisibility(View.GONE);
            btnClear.setVisibility(View.GONE);
        }

        getDialog().getWindow().setSoftInputMode(
                LayoutParams.SOFT_INPUT_STATE_HIDDEN);

        getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);

        return view;
    }


    public interface AddEditCalonMustahiqListener {
        void onFinishFilter(String s_tahun, String s_bulan, String s_index_bulan);
    }

}