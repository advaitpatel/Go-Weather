package com.advaitpatel.goweather.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ScrollView;

import com.advaitpatel.goweather.R;

/**
 * Created by Tomas on 31.05.2015.
 * Class for testing new desings, debug only
 */
public class DesignTest extends AppCompatActivity {

    Toolbar mToolbar;
    ScrollView ScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_places);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(" " + getResources().getString(R.string.places));
        mToolbar.setBackgroundColor(getResources().getColor(R.color.translucent_actionbar_background_dark));
        setSupportActionBar(mToolbar);
        mToolbar.setLogo(R.drawable.ic_place);
        ScrollView = (ScrollView) findViewById(R.id.scroll_view);
        ScrollView.setOverScrollMode(View.OVER_SCROLL_NEVER);
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }


}
