package com.ad.zakatrizki.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ad.zakatrizki.R;
import com.ad.zakatrizki.Zakat;
import com.ad.zakatrizki.fragment.CalonMustahiqDetailFragment;
import com.ad.zakatrizki.utils.Prefs;

public class CalonMustahiqDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_detail);

        if (savedInstanceState == null) {
            String mustahiqId;
            mustahiqId = getIntent().getStringExtra(Zakat.CALON_MUSTAHIQ_ID);
            loadMustahiqDetailsOf(mustahiqId);
        } else {
            loadMustahiqOfType(Zakat.VIEW_TYPE_CALON_MUSTAHIQ);
        }
    }

    private void loadMustahiqDetailsOf(String mustahiqId) {
        CalonMustahiqDetailFragment fragment = new CalonMustahiqDetailFragment();
        Bundle args = new Bundle();
        args.putString(Zakat.CALON_MUSTAHIQ_ID, mustahiqId);
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_detail_container, fragment).commit();
    }

    @SuppressLint("CommitPrefEdits")
    private void loadMustahiqOfType(int viewType) {
        Prefs.putLastSelected(this, Zakat.VIEW_TYPE_CALON_MUSTAHIQ);
        startActivity(new Intent(this, DrawerActivity.class));
        finish();
    }

}
