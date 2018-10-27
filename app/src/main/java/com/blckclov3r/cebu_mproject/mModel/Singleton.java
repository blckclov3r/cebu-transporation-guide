package com.blckclov3r.cebu_mproject.mModel;

import android.util.Log;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by Abrenica, Aljun on 8/15/2018.
 */

public class Singleton {

    private static final String TAG = Singleton.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private static final String KEY = "AIzaSyDoWzA7Sa2sTwRJ91q-jw5XfOpW5bcRsvg";
    private static final String HTTPS = "https://maps.googleapis.com/maps/api/directions/json?";
    static Singleton obj;
    private static double latitude = 0.0;
    private static double longitude = 0.0;
    private static double end_latitude = 0.0;
    private static double end_longitude = 0.0;
    private static double cebu_lat = 10.31570;
    private static double cebu_lng = 123.88543;
    private static Marker mLocationMarker;
    private static GoogleMap mMap;

    private Singleton() {
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
        Singleton.mLocationMarker = mLocationMarker;
    }

    public static Singleton getInstance() {
        if (obj == null) {
            synchronized (Singleton.class) {
                if (obj == null) {
                    obj = new Singleton();
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
        Singleton.mMap = mMap;
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
        Singleton.end_latitude = end_latitude;
    }

    public static double getEnd_longitude() {
        return end_longitude;
    }

    public static void setEnd_longitude(double end_longitude) {
        Singleton.end_longitude = end_longitude;
    }

    public static double getLatitude() {
        return latitude;
    }

    public static void setLatitude(double latitude) {
        Singleton.latitude = latitude;
    }

    public static double getLongitude() {
        return longitude;
    }

    public static void setLongitude(double longitude) {
        Singleton.longitude = longitude;
    }
}
