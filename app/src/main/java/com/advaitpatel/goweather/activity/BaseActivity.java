package com.advaitpatel.goweather.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.advaitpatel.goweather.R;
import com.advaitpatel.goweather.helper.NotificationHelper;
import com.advaitpatel.goweather.helper.WeatherHelper;

public class BaseActivity extends AppCompatActivity {


    // ==============================================
    /**
     * IMPORTANT: ADD YOUR OPENWEATHERMAPS API KEY HERE
     */
    public String ApiKey = "XXXXXXXXXXXXXXXXXXXXXXXXXXXXXX";

    // ==============================================
    public Toolbar mToolbar;
    public TextView currloc;
    public DrawerLayout drawerLayout;
    public NavigationView navView;
    public static final String PREFS_NAME = "Go Weather";

    public AlertDialog.Builder changelog;
    public SharedPreferences SharedPreferences;
    public NotificationHelper NotificationHelper;
    public WeatherHelper WeatherHelper;
    public int Theme;

    public void setupTheme(){
        SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        switch (Integer.parseInt(SharedPreferences.getString("theme", "1"))){
            case 1:
                Theme = R.style.BlueTheme;
                break;
        }
    }

    public void setupToolbar(){
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
    }

    public void setToolbarBackIcon(){
        mToolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    public void setupNavigationDrawer(){
        if (mToolbar != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            mToolbar.setNavigationIcon(R.drawable.ic_menu);
            mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    drawerLayout.openDrawer(GravityCompat.START);
                }
            });
        }
        currloc = (TextView)findViewById(R.id.current_location);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                int id = menuItem.getItemId();
                switch (id) {
                    case R.id.home:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            }
                        }, 250);
                        return true;
                    case R.id.place:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), DailyForecastActivity.class));
                            }
                        }, 250);
                        return true;
                    case R.id.about:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                            }
                        }, 250);
                        return true;
                    case R.id.settings:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                            }
                        }, 250);
                        return true;
                    case R.id.dev_linkedin:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                            }
                        }, 250);
                        return true;
                    case R.id.dev_github:
                        drawerLayout.closeDrawer(GravityCompat.START);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                            }
                        }, 250);
                        return true;
                }
                return true;
            }
        });
    }
}
