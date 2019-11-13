package com.example.ex_2_layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    final int SPLASH_DELAY = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /*try {
            this.getSupportActionBar().hide();
        }catch (NullPointerException e){}*/
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent s = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(s);
                finish();
            }
        },SPLASH_DELAY);
    }


}
