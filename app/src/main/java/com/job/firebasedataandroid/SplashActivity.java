package com.job.firebasedataandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

/**
 * Created by Job on 11/12/2015.
 */
public class SplashActivity extends Activity {
    public static int SPLASH_TIME_OUT = 10000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        // final AnimatedDotsView white =(AnimatedDotsView)findViewById(R.id.splash);
        //   white.startAnimation();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                findViewById(R.id.avloadingIndicatorView).setVisibility(View.VISIBLE);
                Intent data = new Intent(SplashActivity.this,MainActivity.class);
                startActivity(data);
                finish();
            }
        },SPLASH_TIME_OUT);
    }
}
