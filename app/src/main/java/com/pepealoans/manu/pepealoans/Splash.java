package com.pepealoans.manu.pepealoans;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;


public class Splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;
    Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_splash);

//        SharedPreferences shared = getSharedPreferences("LANGUAGE", MODE_PRIVATE);
//        Boolean channel = (shared.getBoolean("selectLanguage", false));

//        if (channel) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(Splash.this, StartActivity.class);
                    startActivity(intent);
                    finish();
                }
            }, SPLASH_TIME_OUT);

//        } else {
////            selectLanguage();
//        }

    }

//    private void selectLanguage() {
//        try {
//            dialog = new Dialog(SpleshScreen.this);
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.getWindow().getDecorView().setBackgroundResource(android.R.color.transparent);
//            dialog.setContentView(R.layout.popup_select_language);
//            dialog.setCanceledOnTouchOutside(false);
//            dialog.setCancelable(false);
//            final RadioGroup radioGroup = (RadioGroup) dialog.findViewById(R.id.radioGroup);
//            dialog.show();
//            radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//                @Override
//                public void onCheckedChanged(RadioGroup group, int checkedId) {
//                    int selectedId = radioGroup.getCheckedRadioButtonId();
//                    RadioButton radioHome = (RadioButton) dialog.findViewById(selectedId);
//
//                    String strUsertType = radioHome.getText().toString().trim();
//                    editor = getSharedPreferences("LANGUAGE", MODE_PRIVATE).edit();
//                    if (strUsertType.equals("English") || strUsertType.equals("Anh")) {
//                        dialog.dismiss();
//                        updateLanguage("en");
//                        Intent intent = new Intent(SpleshScreen.this, Login.class);
//                        startActivity(intent);
//                        finish();
//
//                        editor.putBoolean("selectLanguage", true);
//                        editor.apply();
//                        editor.commit();
//                    }
//                    if (strUsertType.equals("Vietnamese") || strUsertType.equals("Tiếng Việt")) {
//
//                        // dialog.dismiss();
//                        updateLanguage("en");
//                        /*Intent intent = new Intent(SpleshScreen.this, Login.class);
//                        startActivity(intent);
//                        finish();
//*/
//                        editor.putBoolean("selectLanguage", true);
//                        editor.apply();
//                        editor.commit();
//
//                        showToast(SpleshScreen.this,"Still We don't have content");
//
//                    }
//
//                }
//            });
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

//    private void updateLanguage(String languageCode) {
//        Locale locale = new Locale(languageCode);
//        Locale.setDefault(locale);
//
//        Resources res = getResources();
//        Configuration config = new Configuration(res.getConfiguration());
//        config.locale = locale;
//        res.updateConfiguration(config, res.getDisplayMetrics());
//        SharedPrefManager.setLangId(SpleshScreen.this, Constrants.UserLang,languageCode);
//    }
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        finish();
//    }
}
