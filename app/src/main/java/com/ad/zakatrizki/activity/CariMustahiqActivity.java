package com.ad.zakatrizki.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.fragment.MustahiqDetailFragment;
import com.ad.zakatrizki.fragment.MustahiqListFragment;
import com.joanzapata.iconify.IconDrawable;
import com.joanzapata.iconify.fonts.MaterialIcons;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CariMustahiqActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(
                new IconDrawable(this, MaterialIcons.md_arrow_back)
                        .colorRes(R.color.white)
                        .actionBarSize());
        ActionBar actionbar = getSupportActionBar();
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        if (savedInstanceState == null) {
            String keyword;
            Intent intent = getIntent();
            keyword = intent.getStringExtra(Zakat.KEYWORD);
            if (actionbar != null) {
                actionbar.setTitle(keyword);
            }
            loadListMustahiq(keyword);
        }

    }

    private void loadListMustahiq(String keyword) {
        MustahiqListFragment fragment = new MustahiqListFragment();
        Bundle args = new Bundle();
        args.putString(Zakat.KEYWORD, keyword);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.main_fragment, fragment).commit();
    }

    public void loadDetailMustahiqFragmentWith(String id_mustahiq) {
        MustahiqDetailFragment fragment = new MustahiqDetailFragment();
        Bundle args = new Bundle();
        args.putString(Zakat.MUSTAHIQ_ID, id_mustahiq);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.detail_fragment, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
