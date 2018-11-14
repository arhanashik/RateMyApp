package com.blackspider.ratemyapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.blackspider.ratemyapp.BuildConfig;
import com.blackspider.ratemyapp.R;
import com.blackspider.util.PlayStoreLink;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickRateApp(View view){
        PlayStoreLink.rateMyApp(this, BuildConfig.APPLICATION_ID);
    }

    public void onClickCheckForUpdate(View view){
        PlayStoreLink.checkForUpdate(this, BuildConfig.APPLICATION_ID);
    }

    public void onClickSimilarApp(View view){
        PlayStoreLink.showMoreApps(this, R.string.dev_name);
    }
}
