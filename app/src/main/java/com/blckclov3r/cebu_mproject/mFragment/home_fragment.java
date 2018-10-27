package com.blckclov3r.cebu_mproject.mFragment;

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
import android.widget.LinearLayout;
import android.widget.TextView;

import com.blckclov3r.cebu_mproject.R;
import com.fujiyuu75.sequent.Animation;
import com.fujiyuu75.sequent.Sequent;

import in.codeshuffle.typewriterview.TypeWriterView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by admin on 7/25/2018.
 */

public class home_fragment extends Fragment {

    private static final String TAG = home_fragment.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    SharedPreferences sharedPreferences;
    boolean dState = false;
    LinearLayout homeFrag,one;
    LinearLayout home_imageView, three, bitcoin, litecoin, ethereum, four,head_;
    private TextView tv_home1, tv_home2, tv_home3, tv_home4;
    private TextView vc_bitcoin, vc_litecoin, vc_ethereum;
    private TextView tv_home,bCoffee;
    TypeWriterView tv_title;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.home_fragment, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(COMMON_TAG, TAG + " onViewCreated invoked");
        homeFrag = (LinearLayout) view.findViewById(R.id.homeFrag);
        tv_home = (TextView) view.findViewById(R.id.tv_home);
        tv_home1 = (TextView) view.findViewById(R.id.tv_home1);
        tv_home2 = (TextView) view.findViewById(R.id.tv_home2);
        tv_home3 = (TextView) view.findViewById(R.id.tv_home3);
        tv_home4 = (TextView) view.findViewById(R.id.tv_home4);

        vc_bitcoin = (TextView) view.findViewById(R.id.vc_bitcoin);
        vc_litecoin = (TextView) view.findViewById(R.id.vc_litecoin);
        vc_ethereum = (TextView) view.findViewById(R.id.vc_ethereum);
        bCoffee = (TextView) view.findViewById(R.id.bCoffee);
        tv_title = (TypeWriterView) view.findViewById(R.id.tv_title);

        home_imageView = (LinearLayout) view.findViewById(R.id.home_imageView);
        three = (LinearLayout) view.findViewById(R.id.three);
        bitcoin = (LinearLayout) view.findViewById(R.id.bitcoin);
        litecoin = (LinearLayout) view.findViewById(R.id.litecoin);
        ethereum = (LinearLayout) view.findViewById(R.id.ethereum);
        four = (LinearLayout) view.findViewById(R.id.four);
        one = (LinearLayout) view.findViewById(R.id.one);
        head_ = (LinearLayout) view.findViewById(R.id.head_);

        sharedPreferences = this.getActivity().getSharedPreferences(option_fragment.MY_PREF, MODE_PRIVATE);
        getBackgroundTheme();

        new Handler().post(new Runnable() {
            @Override
            public void run() {
                tv_title.setWithMusic(false);
                tv_title.animateText("Welcome Screen");
                tv_title.setDelay(50);
                Sequent.origin(one).anim(getActivity(), Animation.FADE_IN_LEFT).duration(800).
                        delay(500).start();
                Sequent.origin(home_imageView).anim(getActivity(), Animation.FADE_IN_RIGHT).duration(1200).
                        delay(500).start();
                Sequent.origin(three).anim(getActivity(), Animation.FADE_IN_DOWN).duration(800).
                        delay(1200).start();
                Sequent.origin(bitcoin).anim(getActivity(), Animation.FADE_IN_LEFT).duration(1200).
                        delay(500).start();
                Sequent.origin(litecoin).anim(getActivity(), Animation.FADE_IN_RIGHT).duration(1200).
                        delay(1000).start();
                Sequent.origin(ethereum).anim(getActivity(), Animation.FADE_IN_LEFT).duration(1200).
                        delay(500).start();
                Sequent.origin(four).anim(getActivity(), Animation.FADE_IN_UP).duration(1200).
                        delay(500).start();
            }
        });

    }

    public void getBackgroundTheme() {
        dState = sharedPreferences.getBoolean(option_fragment.BACKGROUNDTHEME, false);
        if (dState == true) {
            homeFrag.setBackgroundColor(getResources().getColor(R.color.black));
            head_.setBackgroundColor(Color.rgb(72, 72, 72));
            tv_home.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_home1.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_home2.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_home3.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_home4.setTextColor(getResources().getColor(R.color.whiteSmoke));
            vc_bitcoin.setTextColor(getResources().getColor(R.color.whiteSmoke));
            vc_litecoin.setTextColor(getResources().getColor(R.color.whiteSmoke));
            vc_ethereum.setTextColor(getResources().getColor(R.color.whiteSmoke));
            bCoffee.setTextColor(getResources().getColor(R.color.whiteSmoke));
            tv_title.setTextColor(getResources().getColor(R.color.whiteSmoke));

//         }else{
//             homeFrag.setBackgroundColor(getResources().getColor(R.color.whiteSmoke));
//             tv_home.setTextColor(getResources().getColor(R.color.darkBlue));
//             tv_home1.setTextColor(getResources().getColor(R.color.darkBlue));
//             tv_home2.setTextColor(getResources().getColor(R.color.darkBlue));
//             tv_home3.setTextColor(getResources().getColor(R.color.darkBlue));
//             tv_home4.setTextColor(getResources().getColor(R.color.darkBlue));
//             vc_bitcoin.setTextColor(getResources().getColor(R.color.darkBlue));
//             vc_litecoin.setTextColor(getResources().getColor(R.color.darkBlue));
//             vc_ethereum.setTextColor(getResources().getColor(R.color.darkBlue));
//         }
        }
    }
}
