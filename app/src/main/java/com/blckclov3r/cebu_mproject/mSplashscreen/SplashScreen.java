package com.blckclov3r.cebu_mproject.mSplashscreen;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mMainActivity.MainActivity;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;
import spencerstudios.com.bungeelib.Bungee;

import static com.blckclov3r.cebu_mproject.mMainActivity.MainActivity.fa;

/**
 * Created by Abrenica, Aljun on 8/16/2018.
 */

public class SplashScreen extends AppCompatActivity {
    private static final String TAG = SplashScreen.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private LinearLayout jeepLayout, instructor, title, cebuTransGuide;
    public static Activity sp;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        Log.d(COMMON_TAG, TAG + " onCreate invoke");
        jeepLayout = (LinearLayout) findViewById(R.id.jeepLayout);
        instructor = (LinearLayout) findViewById(R.id.instructor);
        title = (LinearLayout) findViewById(R.id.title);
        cebuTransGuide = (LinearLayout) findViewById(R.id.cebuTransGuide);
        sp = this;
        try {
            Log.d(COMMON_TAG, TAG + "onCreate try invoke");
            Sequent.origin(title).anim(SplashScreen.this, Animation.FADE_IN_LEFT).duration(1000).
                    delay(500).start();
            Sequent.origin(jeepLayout).anim(SplashScreen.this, Animation.FADE_IN_UP).duration(1200).
                    delay(500).start();
            Sequent.origin(instructor).anim(SplashScreen.this, Animation.BOUNCE_IN).duration(1400).
                    delay(500).start();
            Sequent.origin(title).anim(SplashScreen.this, Animation.FADE_IN_DOWN).duration(1000).
                    delay(500).start();

        } catch (Exception e) {
            e.printStackTrace();
            Log.d(COMMON_TAG, TAG+" error!" + e.getMessage());
        } finally {
            try{
                Log.d(COMMON_TAG,TAG+" finally try block invoked!");
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                        startActivity(intent);
                        sp.finish();
                        Bungee.slideUp(SplashScreen.this);
                    }
                }, 3200);
            }catch (Exception e) {
                e.printStackTrace();
                Log.d(COMMON_TAG, TAG + " finally catch block invoked!" + e.getMessage());
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        sp.finish();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        sp.finish();
    }

}
