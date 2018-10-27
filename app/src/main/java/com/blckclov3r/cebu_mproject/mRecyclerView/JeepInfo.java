package com.blckclov3r.cebu_mproject.mRecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mFragment.option_fragment;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

import cn.pedant.SweetAlert.SweetAlertDialog;
import es.dmoral.toasty.Toasty;
import in.codeshuffle.typewriterview.TypeWriterView;
import spencerstudios.com.bungeelib.Bungee;

public class JeepInfo extends AppCompatActivity {
    TextView jeepCode,jeepDesc,jeepTitle;
    Toolbar mToolbar;
    option_fragment opt_frag;
    SharedPreferences sharedPreferences;
    private boolean dState = false;
    RelativeLayout jeepInfoBackground;
    LinearLayout one,two,head_;
    TypeWriterView tv_title;
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
            Bungee.slideDown(JeepInfo.this);
        } else if(id == R.id.info){
            new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                    .setTitleText("Jeepney History")
                    .setCustomImage(R.drawable.scroll_y)
                    .setContentText((String) getResources().getText(R.string.history))
                    .setConfirmText(" Ok ")
                    .showCancelButton(true)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jeep_info);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        mToolbar.setTitle(getResources().getString(R.string.jeepney_code));
        opt_frag = new option_fragment();
        jeepCode = (TextView) findViewById(R.id.jeepCode);
        jeepDesc = (TextView) findViewById(R.id.jeepDesc);
        jeepTitle = (TextView) findViewById(R.id.jeepTitle);
        jeepInfoBackground = (RelativeLayout) findViewById(R.id.jeepInfoBackground);
        two = (LinearLayout) findViewById(R.id.two);
        one = (LinearLayout) findViewById(R.id.one);
        head_ = (LinearLayout) findViewById(R.id.head_);

        tv_title = (TypeWriterView) findViewById(R.id.tv_title);

        Intent intent = getIntent();
        final String code = intent.getStringExtra("code");
        final String desc = intent.getStringExtra("desc");
        jeepCode.setText(code);
        jeepDesc.setText(desc);
        sharedPreferences = getApplicationContext().getSharedPreferences(option_fragment.MY_PREF,MODE_PRIVATE);
        getBackgroundTheme();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tv_title.setWithMusic(false);
                tv_title.animateText("Jeep Routes Information");
                tv_title.setDelay(50);
                Sequent.origin(one).anim(JeepInfo.this, Animation.BOUNCE_IN).duration(500).
                        delay(500).start();
                Sequent.origin(two).anim(JeepInfo.this, Animation.FADE_IN_DOWN).duration(500).
                        delay(500).start();
            }
        });

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
//                new GlideToast.makeToast(JeepInfo.this,"Jeepney code: "+code,
//                        GlideToast.LENGTHTOOLONG, GlideToast.INFOTOAST).show();
                Toasty.info(getApplicationContext(),"Jeepney code: "+code+"",Toast.LENGTH_LONG).show();
            }
        },300);

    }
    public void getBackgroundTheme(){
        dState = sharedPreferences.getBoolean(option_fragment.BACKGROUNDTHEME,false);
        if(dState == true){
            jeepDesc.setTextColor(getResources().getColor(R.color.whiteSmoke));
            jeepCode.setTextColor(getResources().getColor(R.color.whiteSmoke));
            jeepTitle.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_title.setTextColor(getResources().getColor(R.color.whiteSmoke));
            jeepInfoBackground.setBackgroundColor(getResources().getColor(R.color.black));
            head_.setBackgroundColor(Color.rgb(72, 72, 72));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.info,menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Bungee.slideDown(JeepInfo.this);
    }
}
