package com.blckclov3r.cebu_mproject.mPlaces;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;

import com.blckclov3r.cebu_mproject.mModel.mSingleton;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.Dash;
import com.google.android.gms.maps.model.Dot;
import com.google.android.gms.maps.model.Gap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PatternItem;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.maps.android.PolyUtil;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 7/27/2018.
 */

public class GetDirectionsData extends AsyncTask<Object, String, String> {

    public static final int PATTERN_DASH_LENGTH_PX = 20;
    public static final int PATTERN_GAP_LENGTH_PX = 20;
    public static final PatternItem DOT = new Dot();
    public static final PatternItem DASH = new Dash(PATTERN_DASH_LENGTH_PX);
    public static final PatternItem GAP = new Gap(PATTERN_GAP_LENGTH_PX);
    public static final List<PatternItem> PATTERN_POLYGON_ALPHA = Arrays.asList(GAP, DASH);
    private static final String TAG = GetDirectionsData.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    String url;
    String googleDirectionsData;
    String duration, distance;
    LatLng latLng;
    public static int count;
    @Override
    protected String doInBackground(Object... objects) {
        mSingleton.setmMap((GoogleMap) objects[0]);
        url = (String) objects[1];
        latLng = (LatLng) objects[2];
        DownloadUrl downloadUrl = new DownloadUrl();
        try {
            googleDirectionsData = downloadUrl.readUrl(url);
            Log.d(COMMON_TAG,TAG+" GetDirectionsData: doInBackground, "+googleDirectionsData);
        } catch (IOException e) {
            e.printStackTrace();
            Log.e(COMMON_TAG,TAG+"GetDirectionsData: IOException "+e.getMessage());
        }
        return googleDirectionsData;
    }

    public static void displayDirections(String[] directionsList) {
        count = directionsList.length;
        PolylineOptions options = null;
        for (int i = 0; i < count; i++) {
                options = new PolylineOptions();
                options.color(Color.GREEN);
                options.width(9);
                options.getZIndex();
                options.getJointType();
                options.getEndCap();
                options.getPattern();
                options.getColor();
                options.getStartCap();
                options.getWidth();
                options.getPoints();
                options.getClass();
                options.geodesic(true);
                options.pattern(PATTERN_POLYGON_ALPHA);
                options.addAll(PolyUtil.decode(directionsList[i]));
                mSingleton.getmMap().addPolyline(options);
        }
    }


    @Override
    protected void onPostExecute(String s) {
        try {
            String[] directionsList;
            DataParser parser = new DataParser();
            directionsList = parser.parseDirections(s);
            displayDirections(directionsList);
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(COMMON_TAG, TAG + " GetDirectionsData: onPostExecute Exception error: " + e.getMessage());
        }


//
//        duration = directionsList.get("duration");
//        distance = directionsList.get("distance");
//
//        mMap.clear();
//        MarkerOptions markerOptions = new MarkerOptions();
//        markerOptions.position(latLng);
//        markerOptions.draggable(true);
//        markerOptions.title("Duration: "+duration);
//        markerOptions.snippet("Distance: "+distance);
//        mMap.addMarker(markerOptions);

    }

}
