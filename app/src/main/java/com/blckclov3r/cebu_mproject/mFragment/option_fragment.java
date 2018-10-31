package com.blckclov3r.cebu_mproject.mFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.blckclov3r.cebu_mproject.mMisc.Shared_Pref;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mSplashscreen.SplashScreen;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

import in.codeshuffle.typewriterview.TypeWriterView;

/**
 * Created by Abrenica, Aljun
 */

public class option_fragment extends Fragment {
    public static final String MY_PREF = "MyPref";
    public static final String BACKGROUNDTHEME = "MyBackground";
    public static final String HYBRID = "hybrid";
    private static final String TAG = option_fragment.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    public static SharedPreferences sharedPreferences;
    SwitchCompat hybrid;
//    boolean lState = false;
    static boolean dState = false;
    SwitchCompat darkTheme;
    LinearLayout optionLayout,five,three,one,c_one,c_two,c_three,c_four;
    TextView tv_maptheme, tv_theme;
    TextView map_styleContent,background_themeContent;
    Shared_Pref opt;
    SharedPreferences.Editor editor;
    ScrollView scrollView;
    TypeWriterView tv_title;

    LinearLayout mapStyle,background_layout,creditContent,aljun;
//    ImageView eBrain;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.option_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(COMMON_TAG, TAG + " onViewCreated is called");
        sharedPreferences = this.getActivity().getSharedPreferences(MY_PREF, Context.MODE_PRIVATE);
        optionLayout = (LinearLayout) view.findViewById(R.id.optionLayout);
        five = (LinearLayout) view.findViewById(R.id.five);
        three = (LinearLayout) view.findViewById(R.id.three);
        hybrid = (SwitchCompat) view.findViewById(R.id.hybrid);
        tv_maptheme = (TextView) view.findViewById(R.id.tv_maptheme);
        tv_title = (TypeWriterView) view.findViewById(R.id.tv_title);
        map_styleContent = (TextView) view.findViewById(R.id.map_styleContent);
        c_one = (LinearLayout) view.findViewById(R.id.c_one);
        c_two = (LinearLayout) view.findViewById(R.id.c_two);
        c_three = (LinearLayout) view.findViewById(R.id.c_three);
        c_four = (LinearLayout) view.findViewById(R.id.c_four);
        background_themeContent = (TextView) view.findViewById(R.id.background_themeContent);
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);

        mapStyle = (LinearLayout) view.findViewById(R.id.mapStyle);
        background_layout = (LinearLayout) view.findViewById(R.id.background_layout);
        creditContent = (LinearLayout) view.findViewById(R.id.creditContent);
        aljun = (LinearLayout) view.findViewById(R.id.aljun);

//        eBrain = (ImageView) view.findViewById(R.id.eBrain);
        opt = Shared_Pref.getInstance();
        one = (LinearLayout) view.findViewById(R.id.one);
        darkTheme = (SwitchCompat) view.findViewById(R.id.darkTheme);
        tv_theme = (TextView) view.findViewById(R.id.tv_theme);
        Shared_Pref.setHybridState(sharedPreferences.getBoolean(HYBRID, false));
        dState = sharedPreferences.getBoolean(BACKGROUNDTHEME, false);
        hybrid.setChecked(Shared_Pref.isHybridState());

        //*****************************
        darkTheme.setChecked(dState);
        setDarkState();
        setDarkTheme();
        //*****************************
        setHybrid();
        editor =  sharedPreferences.edit();
        Shared_Pref sp = Shared_Pref.getInstance();
        sp.isHybridState();

        tv_title.setWithMusic(false);
        tv_title.setDelay(50);
        tv_title.animateText("Application Options & Credits");
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Sequent.origin(mapStyle).anim(getActivity(), Animation.FADE_IN_RIGHT).duration(1000).
                        delay(500).start();
                Sequent.origin(background_layout).anim(getActivity(), Animation.FADE_IN_RIGHT).duration(1000).
                        delay(500).start();
                Sequent.origin(creditContent).anim(getActivity(), Animation.BOUNCE_IN).duration(800).
                        delay(500).start();
                Sequent.origin(c_one).anim(getActivity(), Animation.FADE_IN_DOWN).duration(500).
                        delay(500).start();
                Sequent.origin(c_two).anim(getActivity(), Animation.FADE_IN_DOWN).duration(500).
                        delay(500).start();
                Sequent.origin(c_three).anim(getActivity(), Animation.FADE_IN_DOWN).duration(500).
                        delay(500).start();
                Sequent.origin(c_four).anim(getActivity(), Animation.FADE_IN_DOWN).duration(500).
                        delay(800).start();
                Sequent.origin(aljun).anim(getActivity(), Animation.FADE_IN_UP).duration(500).
                        delay(1200).start();
            }
        });

    }

    private void setHybrid(){
        hybrid.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Shared_Pref.setHybridState(!isHybridState());
                hybrid.setChecked(Shared_Pref.isHybridState());
                editor.putBoolean(HYBRID,hybrid.isChecked());
                editor.apply();
                Shared_Pref.setHybridState(sharedPreferences.getBoolean(HYBRID, false));
                if(Shared_Pref.isHybridState() ){
                    hybrid.setChecked(true);
                }
            }
        });
    }

    public boolean isHybridState(){
        return Shared_Pref.isHybridState();
    }

    //background theme **************************************************************************
    //background theme **************************************************************************

    public void setDarkTheme() {
        darkTheme.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(COMMON_TAG, TAG + " setDarkTheme switch on, light theme is off");
                dState = !dState;
                darkTheme.setChecked(dState);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean(BACKGROUNDTHEME, darkTheme.isChecked());
                editor.apply();
                setDarkState();
            }
        });
    }
    public void setDarkState() {
        dState = sharedPreferences.getBoolean(BACKGROUNDTHEME, false);
        if (dState) {
            darkTheme.setChecked(dState);
            optionLayout.setBackgroundColor(getResources().getColor(R.color.black));
            scrollView.setBackgroundColor(Color.rgb(33,33,33));
            five.setBackgroundColor(Color.rgb(72, 72, 72));
            three.setBackgroundColor(Color.rgb(72, 72, 72));
            one.setBackgroundColor(Color.rgb(72, 72, 72));
            c_one.setBackgroundColor(Color.rgb(72, 72, 72));
            c_two.setBackgroundColor(Color.rgb(72, 72, 72));
            c_three.setBackgroundColor(Color.rgb(72, 72, 72));
            c_four.setBackgroundColor(Color.rgb(72, 72, 72));
            tv_title.setTextColor(getResources().getColor(R.color.whiteSmoke));
            hybrid.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_maptheme.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_title.setTextColor(getResources().getColor(R.color.whiteSmoke));
            darkTheme.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_theme.setTextColor(getResources().getColor(R.color.whiteSmoke));
            map_styleContent.setTextColor(getResources().getColor(R.color.whiteSmoke));
            background_themeContent.setTextColor(getResources().getColor(R.color.whiteSmoke));
//            eBrain.setImageDrawable(getResources().getDrawable(R.drawable.ebrain_white));
        } else {
            darkTheme.setChecked(dState);
            optionLayout.setBackgroundColor(getResources().getColor(R.color.whiteSmoke));
            scrollView.setBackgroundColor(getResources().getColor(R.color.darkBlue));
            five.setBackgroundColor(getResources().getColor(R.color.gray));
            three.setBackgroundColor(getResources().getColor(R.color.gray));
            c_one.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            c_two.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            c_three.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            c_four.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            tv_title.setTextColor(getResources().getColor(R.color.black));
            hybrid.setTextColor(getResources().getColor(R.color.black));
            tv_maptheme.setTextColor(getResources().getColor(R.color.black));
            tv_title.setTextColor(getResources().getColor(R.color.black));
            darkTheme.setTextColor(getResources().getColor(R.color.black));
            tv_theme.setTextColor(getResources().getColor(R.color.black));
            one.setBackgroundColor(getResources().getColor(R.color.gray));
            map_styleContent.setTextColor(getResources().getColor(R.color.black));
            background_themeContent.setTextColor(getResources().getColor(R.color.black));
//            eBrain.setImageDrawable(getResources().getDrawable(R.drawable.ebrain_blue));
        }
    }
}
