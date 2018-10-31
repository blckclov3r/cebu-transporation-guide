package com.blckclov3r.cebu_mproject.mModel;

import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Abrenica, Aljun
 */

public class mSingleton {

    private static final String TAG = mSingleton.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private static final String KEY = "AIzaSyDoWzA7Sa2sTwRJ91q-jw5XfOpW5bcRsvg";
    private static final String HTTPS = "https://maps.googleapis.com/maps/api/directions/json?";
    static mSingleton obj;
    private static double latitude = 0.0;
    private static double longitude = 0.0;
    private static double end_latitude = 0.0;
    private static double end_longitude = 0.0;
    private static double cebu_lat = 10.31570;
    private static double cebu_lng = 123.88543;
    private static Marker mLocationMarker;
    private static GoogleMap mMap;

    private mSingleton() {
        Log.d(COMMON_TAG, TAG + " Singleton constructor: Instance created");
    }

    public static String getKey() {
        return KEY;
    }

    public static String getHttps() {
        return HTTPS;
    }

    public static Marker getmLocationMarker() {
        return mLocationMarker;
    }

    public static void setmLocationMarker(Marker mLocationMarker) {
        mSingleton.mLocationMarker = mLocationMarker;
    }

    public static mSingleton getInstance() {
        if (obj == null) {
            synchronized (mSingleton.class) {
                if (obj == null) {
                    obj = new mSingleton();
                }
            }
        }
        return obj;
    }

    public static GoogleMap getmMap() {
        Log.d(COMMON_TAG, TAG + " Googlemap getmMap() is called");
        return mMap;
    }

    public static void setmMap(GoogleMap mMap) {
        mSingleton.mMap = mMap;
    }

    public static double getCebu_lat() {
        return cebu_lat;
    }

    public static double getCebu_lng() {
        return cebu_lng;
    }

    public static double getEnd_latitude() {
        return end_latitude;
    }

    public static void setEnd_latitude(double end_latitude) {
        mSingleton.end_latitude = end_latitude;
    }

    public static double getEnd_longitude() {
        return end_longitude;
    }

    public static void setEnd_longitude(double end_longitude) {
        mSingleton.end_longitude = end_longitude;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        mSingleton.latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        mSingleton.longitude = longitude;
    }
}
