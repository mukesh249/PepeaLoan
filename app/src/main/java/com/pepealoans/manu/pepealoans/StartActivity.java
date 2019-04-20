package com.pepealoans.manu.pepealoans;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

import butterknife.Bind;
import butterknife.ButterKnife;

public class StartActivity extends AppCompatActivity {
    @Bind(R.id.start_btn)
    Button start_btn;
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        ButterKnife.bind(this,this);

        start_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showInterstitial();
            }
        });
//        MobileAds.initialize(this,"ca-app-pub-4969343742134029~1926324990");
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
                startActivity(new Intent(StartActivity.this,GetStartActivity.class));
                mInterstitialAd.loadAd(new AdRequest.Builder().build());
            }
        });
    }

    public void showInterstitial(){
        if (mInterstitialAd.isLoaded()){
            mInterstitialAd.show();
        }else {
            startActivity(new Intent(StartActivity.this,GetStartActivity.class));
            mInterstitialAd.loadAd(new AdRequest.Builder().build());
        }
    }
}
