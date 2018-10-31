package com.blckclov3r.cebu_mproject.mFragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mSplashscreen.SplashScreen;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

import in.codeshuffle.typewriterview.TypeWriterView;

/**
 * Created by Abrenica, Aljun
 */

public class about_fragment extends Fragment {

    private static final String TAG = about_fragment.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private boolean dState = false;
    SharedPreferences sharedPreferences;
    TextView tvDesc,tvFeature,tvFeature_content,tvAdvantage,tvHeader,
            tvAdvantage_content,tvFooter,tvFooter_content,tvDisadvantage,tvDisadvantage_content;
    LinearLayout about_background,two,feature,advantage,disadvantage,one,aljun;
    TypeWriterView app_option;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.about_fragment,container,false);
        Log.d(COMMON_TAG,TAG+" onCreateView invoked");
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(COMMON_TAG,TAG+" onViewCreated invoked");
        sharedPreferences = this.getActivity().getSharedPreferences(option_fragment.MY_PREF, Context.MODE_PRIVATE);
        tvHeader = (TextView) view.findViewById(R.id.tvHeader);
        tvDesc = (TextView) view.findViewById(R.id.tvDesc);
        tvFeature = (TextView) view.findViewById(R.id.tvFeature);
        tvFeature_content = (TextView) view.findViewById(R.id.tvFeature_content);
        tvAdvantage = (TextView) view.findViewById(R.id.tvAdvantage);
        tvAdvantage_content = (TextView) view.findViewById(R.id.tvAdvantage_content);
        tvDisadvantage = (TextView) view.findViewById(R.id.tvDisadvantage);
        tvDisadvantage_content = (TextView) view.findViewById(R.id.tvDisadvantage_content);
        tvFooter = (TextView) view.findViewById(R.id.tvFooter);
        tvFooter_content = (TextView) view.findViewById(R.id.tvFooter_content);
        about_background = (LinearLayout) view.findViewById(R.id.about_background);
        one = (LinearLayout) view.findViewById(R.id.one);
        aljun = (LinearLayout) view.findViewById(R.id.aljun);

        two = (LinearLayout) view.findViewById(R.id.two);
        feature = (LinearLayout) view.findViewById(R.id.feature);
        advantage = (LinearLayout) view.findViewById(R.id.advantage);
        disadvantage = (LinearLayout) view.findViewById(R.id.disadvantage);
        app_option = (TypeWriterView) view.findViewById(R.id.app_option);

        getBackgroundTheme();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                app_option.setWithMusic(false);
                app_option.animateText("About This App.");
                app_option.setDelay(50);
                Sequent.origin(two).anim(getActivity(), Animation.FADE_IN_DOWN).duration(800).
                        delay(500).start();
                Sequent.origin(feature).anim(getActivity(), Animation.FADE_IN_LEFT).duration(1000).
                        delay(500).start();
                Sequent.origin(advantage).anim(getActivity(), Animation.FADE_IN_RIGHT).duration(1000).
                        delay(500).start();
                Sequent.origin(disadvantage).anim(getActivity(), Animation.FADE_IN_LEFT).duration(1000).
                        delay(500).start();
                Sequent.origin(aljun).anim(getActivity(), Animation.FADE_IN_UP).duration(800).
                        delay(500).start();
            }
        });
    }

    private void getBackgroundTheme(){
        dState = sharedPreferences.getBoolean(option_fragment.BACKGROUNDTHEME,false);
        if(dState){
            about_background.setBackgroundColor(getResources().getColor(R.color.black));
            tvHeader.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvDesc.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvFeature.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvFeature_content.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvAdvantage.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvAdvantage_content.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvFooter.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvFooter_content.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvDisadvantage.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tvDisadvantage_content.setTextColor(getResources().getColor(R.color.whiteSmoke));
            app_option.setTextColor(getResources().getColor(R.color.whiteSmoke));
            one.setBackgroundColor(Color.rgb(72, 72, 72));
        }
    }
}
