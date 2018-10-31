package com.blckclov3r.cebu_mproject.mMisc;

import android.util.Log;

/**
 * Created by Abrenica, Aljun
 */

public class Shared_Pref {

    private static final String TAG = Shared_Pref.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private static boolean hybridState = false;
    static Shared_Pref obj;

    public static boolean isHybridState() {
        return hybridState;
    }

    public static void setHybridState(boolean hybridState) {
        Shared_Pref.hybridState = hybridState;
    }

    private Shared_Pref(){
        Log.d(COMMON_TAG,TAG+" Instance of Shared_Pref is invoke");
    }

    public static Shared_Pref getInstance(){
        if(obj == null){
            synchronized (Shared_Pref.class){
                if(obj == null){
                    obj = new Shared_Pref();
                }
            }
        }
        return obj;
    }


}
