package com.blckclov3r.cebu_mproject.mPlaces;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Abrenica, Aljun
 */

public class DataParser {
    private static final String TAG = DataParser.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";

    public HashMap<String, String> getDuration(JSONArray googleDirectionsJson) {
        HashMap<String, String> googleDirectionsMap = new HashMap<>();
        String duration = "";
        String distance = "";

        Log.d(COMMON_TAG, TAG + " jsonResponse: " + String.valueOf(googleDirectionsJson.toString()));

        try {
            duration = googleDirectionsJson.getJSONObject(0).getJSONObject("duration").getString("text");
            distance = googleDirectionsJson.getJSONObject(0).getJSONObject("distance").getString("text");

            googleDirectionsMap.put("duration", duration);
            googleDirectionsMap.put("distance", distance);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return googleDirectionsMap;
    }


    private HashMap<String, String> getPlace(JSONObject googlePlaceJson) {
        HashMap<String, String> googlePlacesMap = new HashMap<>();
        String placeName = "-NA-";
        String vicinity = "-NA-";
        String latitude = "";
        String longitude = "";
        String reference = "";

        try {
            if (!googlePlaceJson.isNull("name")) {
                placeName = googlePlaceJson.getString("name");
            }
            if (!googlePlaceJson.isNull("vicinity")) {
                vicinity = googlePlaceJson.getString("vicinity");
            }
            latitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lat");
            longitude = googlePlaceJson.getJSONObject("geometry").getJSONObject("location").getString("lng");
            reference = googlePlaceJson.getString("reference");

            googlePlacesMap.put("place_name", placeName);
            googlePlacesMap.put("vicinity", vicinity);
            googlePlacesMap.put("lat", latitude);
            googlePlacesMap.put("lng", longitude);
            googlePlacesMap.put("reference", reference);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return googlePlacesMap;
    }

    private List<HashMap<String, String>> getPlaces(JSONArray jsonArray) {
        int count = jsonArray.length();
        Log.d(COMMON_TAG, TAG + " GetPlaces HashMap method: count: " + count);
        List<HashMap<String, String>> placesList = new ArrayList<>();
        HashMap<String, String> placeMap = null;
        for (int i = 0; i < count; i++) {
            try {
                placeMap = getPlace((JSONObject) jsonArray.get(i));
                placesList.add(placeMap);
            } catch (JSONException e) {
                e.printStackTrace();
                Log.e(COMMON_TAG, TAG + " getPlaces JSONException: " + e.getMessage());
            }
        }
        return placesList;
    }

    public List<HashMap<String, String>> parse(String jsonData) {
        JSONArray jsonArray = null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(COMMON_TAG, TAG + " parse JSONException: " + e.getMessage());
        }
        return getPlaces(jsonArray);
    }


    //    public HashMap<String,String> parseDirections(String jsonData){
    public String[] parseDirections(String jsonData) {
        JSONArray jsonArray = null;
        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(jsonData);
            jsonArray = jsonObject.getJSONArray("routes").getJSONObject(0).getJSONArray("legs")
                    .getJSONObject(0).getJSONArray("steps");

            Log.d(COMMON_TAG, TAG + " parseDirections jsonArray: " + String.valueOf
                    (jsonArray.toString()));
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(COMMON_TAG, TAG + " parseDirections JSONException: " + e.getMessage());
        }
//        return getDuration(jsonArray);
        return getPaths(jsonArray);
    }

    public String[] getPaths(JSONArray googleStepsJson) {
        int count = googleStepsJson.length();
        String[] polylines = new String[count];
        try {
            for (int i = 0; i < count; i++) {
                polylines[i] = getPath(googleStepsJson.getJSONObject(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(COMMON_TAG, TAG + " getPaths JSONException: " + e.getMessage());
        }
        return polylines;
    }

    public String getPath(JSONObject googlePathJson) {
        String polyline = "";
        try {
            polyline = googlePathJson.getJSONObject("polyline").getString("points");

        } catch (JSONException e) {
            e.printStackTrace();
            Log.e(COMMON_TAG, TAG + " path JSONException: " + e.getMessage());
        }
        return polyline;
    }

}
