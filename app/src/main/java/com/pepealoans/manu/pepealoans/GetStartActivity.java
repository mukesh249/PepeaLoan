package com.pepealoans.manu.pepealoans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.pepealoans.manu.pepealoans.Api.Network;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GetStartActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    @Bind(R.id.get_start_btn)
    Button get_start_btn;
    @Bind(R.id.get_start_checkbox)
    CheckBox get_start_checkbox;
    @Bind(R.id.accept_condition_tv)
    TextView accept_condition_tv;

    Boolean tclick = false,s_click=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_start);

        ButterKnife.bind(this,this);

        accept_condition_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                get_start_checkbox.setChecked(true);
                s_click = false;
                tclick = true;
                if (!Network.isConnectingToInternet(GetStartActivity.this)) {
                    startActivity(new Intent(GetStartActivity.this,TermAndCondition.class));
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                    return;
                }else {
                    showInterstitial();
                }
            }
        });

        get_start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (get_start_checkbox.isChecked()){
                    s_click = true;
                    tclick = false;
                    showInterstitial();
                }else {
                    Toast.makeText(GetStartActivity.this,getString(R.string.accept_terms_and_conditions),Toast.LENGTH_SHORT).show();
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }

            }
        });

//        MobileAds.initialize(this,"ca-app-pub-3940256099942544/6300978111");
        MobileAds.initialize(this,getResources().getString(R.string.app_banner));
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        mInterstitialAd = new InterstitialAd(this);
//        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId(getResources().getString(R.string.app_interstitial));
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
                if (tclick){
                    startActivity(new Intent(GetStartActivity.this,TermAndCondition.class));
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }
                if (s_click){
                    startActivity(new Intent(GetStartActivity.this,SignIn_SignUp.class));
                    mInterstitialAd.loadAd(new AdRequest.Builder().build());
                }

            }
        });
    }

    public void showInterstitial(){
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            if (tclick){
                startActivity(new Intent(GetStartActivity.this,TermAndCondition.class));
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
            if (s_click){
                startActivity(new Intent(GetStartActivity.this,SignIn_SignUp.class));
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        }
    }
}
