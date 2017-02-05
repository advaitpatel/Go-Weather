package com.advaitpatel.goweather.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

import com.advaitpatel.goweather.R;

/**
 * Created by Tomas on 31.05.2015
 */
public class AboutActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private TextView linkedin, github;
    Spanned Text1, Text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        TextView tx = (TextView) findViewById(R.id.appdesc);
        tx.setText(Html.fromHtml(getResources().getString(R.string.versionDesc)));

        linkedin = (TextView) findViewById(R.id.dev_linkedin);
        Text1 = Html.fromHtml("Click on this link to visit my LinkedIn Profile <br />" +
                "<a href='https://www.linkedin.com/in/AdvaitPatel93'>Linkedin/Advait Patel</a>");

        linkedin.setMovementMethod(LinkMovementMethod.getInstance());
        linkedin.setText(Text1);


        github = (TextView) findViewById(R.id.dev_github);
        Text2 = Html.fromHtml("Click on this link to visit my Github Profile <br />" +
                "<a href='https://github.com/advaitpatel'>Github/Advait Patel</a>");

        github.setMovementMethod(LinkMovementMethod.getInstance());
        github.setText(Text2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cancel, menu);
        return true;
    }

    @Override
    public void onResume() {
        super.onResume();

        // Shows the debug warning, if this is a debug build and the warning has not been shown yet

    }
}
