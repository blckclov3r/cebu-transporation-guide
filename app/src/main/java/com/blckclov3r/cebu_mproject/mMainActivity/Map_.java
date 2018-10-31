package com.blckclov3r.cebu_mproject.mMainActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mFragment.option_fragment;
import com.blckclov3r.cebu_mproject.mModel.mSingleton;
import com.blckclov3r.cebu_mproject.mPlaces.GetDirectionsData;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.toptoche.searchablespinnerlibrary.SearchableSpinner;

import java.util.Formatter;

import es.dmoral.toasty.Toasty;

/**
 * Created by Abrenica, Aljun
 */

public class Map_ extends Fragment implements OnMapReadyCallback,
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener,
        LocationListener,
        GoogleMap.OnMarkerClickListener,
        GoogleMap.OnMarkerDragListener {

    private static final int REQUEST_LOCATION_CODE = 99;
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";
    private static final String TAG = Map_.class.getSimpleName();
    private static final String COMMON_TAG = "abrenica_aljun";
    private static final int ZOOM = 13;
    private static int x = 0;
    mSingleton singleton;
    option_fragment opt_frag;
    LinearLayout customLayout;
    private String url = "";
    private String originSP = "", destinationSP = "";
    private String start[] = {"Origin",
            "Saint Paul College, Cebu South Road",
            "Junquera Street, Cebu City",
            "Elizabeth Mall, Natalio B. Bacalso Avenue",
            "Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
            "Pardo, Cebu City",
            "South Bus Terminal, Cebu City",
            "University of San Jose Recoletos"
    };
    private String end[] = {"Destination",
            "Saint Paul College, Cebu South Road",
            "Junquera Street, Cebu City",
            "Elizabeth Mall, Natalio B. Bacalso Avenue",
            "Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
            "Pardo, Cebu City",
            "South Bus Terminal, Cebu City",
            "University of San Jose Recoletos"
    };
    private float results[] = new float[8];
    private String fare = "";
    private SearchableSpinner originSpinner, destinationSpinner;
    private ArrayAdapter<String> adapterStart;
    private ArrayAdapter<String> adapterEnd;
    private Object dataTransfer[];
    private Location mLastLocation;
    private GoogleApiClient mGoogleApiClient;
    private LocationRequest mLocationRequest;
    private Button locateBtn, resetBtn;
    private long mLastClickTime = 0;
    private View view;
    double flat ,flng,elat,elng;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.map_fragment, container, false);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            checkedLocationPermission();
        }
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager()
                .findFragmentById(R.id.mapFragment);
//        MapsInitializer.initialize(getActivity());
        mapFragment.getMapAsync(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        locateBtn = (Button) view.findViewById(R.id.locateBtn);
        originSpinner = (SearchableSpinner) view.findViewById(R.id.originSpinner);
        destinationSpinner = (SearchableSpinner) view.findViewById(R.id.destinationSpinner);
        singleton = mSingleton.getInstance();
        resetBtn = (Button) view.findViewById(R.id.resetBtn);
        opt_frag = new option_fragment();
        adapterStart = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, start);
        adapterEnd = new ArrayAdapter<String>(getActivity(), R.layout.spinner_item, end);
        originSpinner.setFocusableInTouchMode(false);
        originSpinner.setFocusable(false);
        destinationSpinner.setFocusableInTouchMode(false);
        destinationSpinner.setFocusable(false);
//        Arrays.sort(start);
//        Arrays.sort(end);
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(COMMON_TAG, TAG + " onStart method is invoked");
        x = 0;
        originSpinner.setAdapter(adapterStart);
        originSpinner.setTitle("Select Origin");
        originSpinner.setPositiveButton("Ok");
        destinationSpinner.setAdapter(adapterEnd);
        destinationSpinner.setTitle("Select Destination");
        destinationSpinner.setPositiveButton("Ok");
        originSpinner.setSelection(0);
        destinationSpinner.setSelection(0);
        setLocateBtn();
        setResetBtn();
    }

    private void setResetBtn() {
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                x = 0;
                mLastClickTime = SystemClock.elapsedRealtime();
                originSpinner.setSelection(0);
                destinationSpinner.setSelection(0);
                mapClear();
            }
        });
    }

    private void setLocateBtn() {
        locateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
                    return;
                }
                mLastClickTime = SystemClock.elapsedRealtime();
                destinationRoute();
            }
        });
    }


    protected void buildGoogleApiClient() {
        mGoogleApiClient = new GoogleApiClient.Builder(getActivity())
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .addApi(LocationServices.API)
                .build();
        mGoogleApiClient.connect();
    }


    private void returnPlaces(String x, String y) {
        if (x == y) {
            Toasty.error(getActivity(), "Unable to route, the same origin and destination", Toast.LENGTH_SHORT).show();
            Log.d(COMMON_TAG,TAG+" Unable to route the same origin and destination");
            return;
        }else{
            Log.d(COMMON_TAG,TAG+"Route √√√ +------------ CHECKING ----------+");
        }
    }


    private void routePlaces(String origin,String destination,
                              double fLatitude, double fLongitude,
                             double lLatitude,double lLongitude) {

        originSP = originSpinner.getSelectedItem().toString().trim();
        destinationSP = destinationSpinner.getSelectedItem().toString().trim();
        if(originSP.equals(origin) && destinationSP.equals(destination) ||
                originSP.equals(destination) && destinationSP.equals(origin)){
            dataTransfer = new Object[3];
            singleton.setLatitude(fLatitude);
            singleton.setLongitude(fLongitude);
            singleton.setEnd_latitude(lLatitude);
            singleton.setEnd_longitude(lLongitude);
            flat = singleton.getLatitude();
            flng = singleton.getLongitude();
            elat = singleton.getEnd_latitude();
            elng = singleton.getEnd_longitude();
            url = getDirectionUrl();
            setMarkerStart(origin, singleton.getLatitude(), singleton.getLongitude());
            setMarkerEnd(destination, singleton.getEnd_latitude(), singleton.getEnd_longitude());
            Log.d(COMMON_TAG, TAG + " getDirectionUrl(): url: " + url);
            GetDirectionsData getDirectionsData = new GetDirectionsData();
            dataTransfer[0] = singleton.getmMap();
            dataTransfer[1] = url;
            dataTransfer[2] = new LatLng(singleton.getEnd_latitude(), singleton.getEnd_longitude());
            getDirectionsData.execute(dataTransfer);
            LatLngZoom(singleton.getEnd_latitude(), singleton.getEnd_longitude(), ZOOM);


            url = "";
        }
    }

    private void destinationRoute() {
        mapClear();
        originSP = originSpinner.getSelectedItem().toString().trim();
        destinationSP = destinationSpinner.getSelectedItem().toString().trim();
        mapClear();
        returnPlaces(originSP,destinationSP);
        routePlaces("Saint Paul College, Cebu South Road", "Elizabeth Mall, Natalio B. Bacalso Avenue"
                , 10.271950, 123.84819,10.298661 ,123.895093);
        routePlaces("Saint Paul College, Cebu South Road", "Cebu Institute of Technology - University, Natalio B. Bacalso Avenue"
                , 10.271950, 123.84819,10.294125 ,123.88152);
        routePlaces("Saint Paul College, Cebu South Road", "Junquera Street, Cebu City"
                , 10.271950, 123.84819,10.300172 ,123.89918);
        routePlaces("Saint Paul College, Cebu South Road", "Pardo, Cebu City"
                , 10.271950, 123.84819,10.279425 ,123.85522);
        routePlaces("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
                "Elizabeth Mall, Natalio B. Bacalso Avenue"
                , 10.294125, 123.88152,10.298661 ,123.895093);
        routePlaces("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
                "South Bus Terminal, Cebu City"
                , 10.294125, 123.88152,10.298367 ,123.89301);
        routePlaces("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
                "Junquera Street, Cebu City"
                , 10.294125, 123.88152,10.300172 ,123.89918);
        routePlaces("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
                "Pardo, Cebu City"
                , 10.294125, 123.88152,10.279425 ,123.85522);
        routePlaces("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue",
                "University of San Jose Recoletos"
                , 10.294125, 123.88152,10.28737839 ,123.86258379);
        routePlaces("Junquera Street, Cebu City",
                "Pardo, Cebu City"
                , 10.300172, 123.89918,10.279425 ,123.85522);
        routePlaces("Junquera Street, Cebu City",
                "South Bus Terminal, Cebu City"
                , 10.300172, 123.89918,10.298367 ,123.89301);
        routePlaces("Junquera Street, Cebu City",
                "Elizabeth Mall, Natalio B. Bacalso Avenue"
                , 10.300172, 123.89918,10.298661 ,123.895093);
        routePlaces("Saint Paul College, Cebu South Road",
                "South Bus Terminal, Cebu City"
                , 10.271950, 123.84819,10.298367 ,123.89301);
        routePlaces("Elizabeth Mall, Natalio B. Bacalso Avenue",
                "Pardo, Cebu City"
                , 10.298661, 123.895093,10.279425 ,123.85522);
        routePlaces("Elizabeth Mall, Natalio B. Bacalso Avenue",
                "South Bus Terminal, Cebu City"
                , 10.298610706662352, 123.894801735878,10.298367 ,123.89301);
        routePlaces("Pardo, Cebu City",
                "South Bus Terminal, Cebu City"
                , 10.279425, 123.85522,10.298367 ,123.89301);
        routePlaces("University of San Jose Recoletos",
                "Saint Paul College, Cebu South Road"
                , 10.28737839, 123.86258379,10.27243391 ,123.84810926);
        routePlaces("University of San Jose Recoletos",
                "Elizabeth Mall, Natalio B. Bacalso Avenue"
                , 10.28737839, 123.86258379,10.298661 ,123.895093);
        routePlaces("University of San Jose Recoletos",
                "Junquera Street, Cebu City"
                , 10.28737839, 123.86258379,10.300172 ,123.89918);
        routePlaces("University of San Jose Recoletos",
                "Pardo, Cebu City"
                , 10.28737839, 123.86258379,10.27941145 ,123.85521825);
        routePlaces("University of San Jose Recoletos",
                "South Bus Terminal, Cebu City"
                , 10.28737839, 123.86258379,10.298367 ,123.89301);
    }//eof destination method

    private void mapClear() {
        x = 0;
        if (singleton.getmLocationMarker() != null) {
            synchronized (Map_.class) {
                if (singleton.getmLocationMarker() != null) {
                    singleton.getmLocationMarker().remove();
                    singleton.getmMap().clear();
                }
            }
        }
    }

    private void Toast(final String s) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Toasty.info(getActivity(), s, Toast.LENGTH_LONG).show();
            }
        });
    }

    private void setMarkerStart(String locality, double lat, double lng) {
        Log.d(COMMON_TAG, TAG + " setMarkerStart method is called");
        MarkerOptions options = new MarkerOptions()
                .title(locality)
                .snippet(fare)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))
                .position(new LatLng(lat, lng));
        singleton.setmLocationMarker(singleton.getmMap().addMarker(options));
    }

    private void setMarkerEnd(String locality, double lat, double lng) {
        Log.d(COMMON_TAG, TAG + " setMarkerEnd method is called");
        MarkerOptions options = new MarkerOptions()
                .title(locality)
                .snippet(fare)
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
                .position(new LatLng(lat, lng));
        singleton.setmLocationMarker(singleton.getmMap().addMarker(options));
    }

    private void setMarkerInvi(double lat, double lng) {
        MarkerOptions options = new MarkerOptions()
                .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                .position(new LatLng(lat, lng));
        singleton.setmLocationMarker(singleton.getmMap().addMarker(options));
        singleton.getmLocationMarker().setVisible(false);
    }

    private void LatLngZoom(double lat, double lng, float zoom) {
        Log.d(COMMON_TAG, TAG + " LatLngZoom method is called");
        LatLng ll = new LatLng(lat, lng);
        singleton.setLatitude(ll.latitude);
        singleton.setLongitude(ll.longitude);
        CameraUpdate cameraUpdate = CameraUpdateFactory.newLatLngZoom(ll, zoom);
//        singleton.getmMap().getProjection().getVisibleRegion().latLngBounds.getCenter();
        singleton.getmMap().animateCamera(cameraUpdate);
    }

    private String getDirectionUrl() {
        Log.d(COMMON_TAG, TAG + " getDirection Method is called");
        StringBuilder googleDirectionsUrl = new StringBuilder(mSingleton.getHttps());
        googleDirectionsUrl.append("origin=" + singleton.getLatitude() + "," + singleton.getLongitude());
        googleDirectionsUrl.append("&destination=" + singleton.getEnd_latitude() + "," + singleton.getEnd_longitude());
        googleDirectionsUrl.append("&key=" + mSingleton.getKey());
        googleDirectionsUrl.append("&sensor=true");
        return String.valueOf(googleDirectionsUrl);
    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {
        Log.i(COMMON_TAG, TAG + " onConnected: Device successfully connected.");
        mLocationRequest = new LocationRequest();
        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000);
        mLocationRequest.setFastestInterval(1000);
        if (ActivityCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(getActivity(),
                        Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Log.d(COMMON_TAG, TAG + " onConnected: Permission denied!");
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient,
                mLocationRequest, (LocationListener) Map_.this);
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_LOCATION_CODE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    if (ContextCompat.checkSelfPermission(getActivity(),
                            Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
                        if (mGoogleApiClient == null) {
                            buildGoogleApiClient();
                        }
                        singleton.getmMap().setMyLocationEnabled(true);
                    }
                } else {
                    Toasty.warning(getActivity(), "Permission Denied", Toast.LENGTH_SHORT).show();
                }
                return;
        }
    }

    public boolean checkedLocationPermission() {
        if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION)) {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION_CODE);
            } else {
                ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_LOCATION_CODE);
            }
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (singleton.getmMap() != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, singleton.getmMap().getCameraPosition());
            outState.putParcelable(KEY_LOCATION, mLastLocation);
            super.onSaveInstanceState(outState);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        singleton.setmMap(googleMap);

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(singleton.getCebu_lat(),
                        singleton.getCebu_lng()))      // Sets the center of the map to Mountain View
                .zoom(15)                   // Sets the zoom
                .bearing(70)                // Sets the orientation of the camera to east
                .tilt(30)
                .build();                   // Creates a CameraPosition from the builder
        singleton.getmMap().moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
        googleMap.getUiSettings().setZoomControlsEnabled(true);
        googleMap.getUiSettings().setCompassEnabled(true);
        googleMap.getUiSettings().setMyLocationButtonEnabled(true);
        googleMap.getUiSettings().setMapToolbarEnabled(true);
        googleMap.getUiSettings().setZoomGesturesEnabled(true);
        googleMap.getUiSettings().setScrollGesturesEnabled(true);
        googleMap.getUiSettings().setTiltGesturesEnabled(true);
        googleMap.getUiSettings().setRotateGesturesEnabled(true);

        if (opt_frag.isHybridState()) {
            originSpinner.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.transparent_btn));
            destinationSpinner.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.transparent_btn));
            locateBtn.setTextColor(getResources().getColor(R.color.whiteSmoke));
            resetBtn.setTextColor(getResources().getColor(R.color.whiteSmoke));
            locateBtn.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.transparent_btn));
            resetBtn.setBackground(ContextCompat.getDrawable(getActivity(), R.drawable.transparent_btn));
            try {
                Log.d(COMMON_TAG, TAG + " onMapReady: try block invoked, setMapStyle");
                boolean success = googleMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                getActivity(), R.raw.map_darkblue));
                if (!success) {
                    Log.e(COMMON_TAG, TAG + "Style parsing failed.");
                }
            } catch (Resources.NotFoundException e) {
                Log.e(COMMON_TAG, TAG + "Can't find style. Error: ", e);
            }
        } else {
            try {
                Log.d(COMMON_TAG, TAG + " onMapReady: try block invoked, setMapStyle");
                boolean success = googleMap.setMapStyle(
                        MapStyleOptions.loadRawResourceStyle(
                                getActivity(), R.raw.night_map));
                if (!success) {
                    Log.e(COMMON_TAG, TAG + "Style parsing failed.");
                }
            } catch (Resources.NotFoundException e) {
                Log.e(COMMON_TAG, TAG + "Can't find style. Error: ", e);
            }
        }

        singleton.getmMap().setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.custom_information, null);
                TextView tLocality = (TextView) view.findViewById(R.id.tLocality);
                TextView tLatitude = (TextView) view.findViewById(R.id.tLatitude);
                TextView tLongitude = (TextView) view.findViewById(R.id.tLongitude);
                TextView tDistance = (TextView) view.findViewById(R.id.tDistance);
                TextView tFare = (TextView) view.findViewById(R.id.tFare);
                LatLng ll = marker.getPosition();
                tLocality.setText(marker.getTitle());
                tLatitude.setText("Latitude: " + String.valueOf(ll.latitude));
                tLongitude.setText("Longitude: " + String.valueOf(ll.longitude));
                if (opt_frag.isHybridState()) {
                    customLayout = (LinearLayout) view.findViewById(R.id.customLayout);
                    customLayout.setBackgroundColor(getResources().getColor(R.color.darkBlue));
                    tLocality.setTextColor(getResources().getColor(R.color.whiteSmoke));
                    tLatitude.setTextColor(getResources().getColor(R.color.whiteSmoke));
                    tLongitude.setTextColor(getResources().getColor(R.color.whiteSmoke));
                    tDistance.setTextColor(getResources().getColor(R.color.whiteSmoke));
                    tFare.setTextColor(getResources().getColor(R.color.whiteSmoke));
                }
                if (originSP.equals("Saint Paul College, Cebu South Road") &&
                        destinationSP.equals("Elizabeth Mall, Natalio B. Bacalso Avenue") ||
                        originSP.equals("Elizabeth Mall, Natalio B. Bacalso Avenue") &&
                                destinationSP.equals("Saint Paul College, Cebu South Road")) {
                    tFare.setText("Jeep Fare: 8 php.");
                }else if(originSP.equals("Saint Paul College, Cebu South Road") &&
                        destinationSP.equals("Junquera Street, Cebu City") ||
                        originSP.equals("Junquera Street, Cebu City") &&
                                destinationSP.equals("Saint Paul College, Cebu South Road")){
                    tFare.setText("Jeep Fare: 9php.");
                }
                else if (originSP.equals("Saint Paul College, Cebu South Road") &&
                        destinationSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue")
                        || destinationSP.equals("Saint Paul College, Cebu South Road") &&
                        originSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue")) {
                    tFare.setText("Jeep Fare: 7 php.");
                }
                else if (originSP.equals("Junquera Street, Cebu City") &&
                        destinationSP.equals("Pardo, Cebu City") ||
                        destinationSP.equals("Junquera Street, Cebu City")
                                && originSP.equals("Pardo, Cebu City")) {
                    tFare.setText("Jeep Fare: 8 php.");
                }
                else if (originSP.equals("Saint Paul College, Cebu South Road") &&
                        destinationSP.equals("South Bus Terminal, Cebu City") ||
                        destinationSP.equals("Saint Paul College, Cebu South Road") &&
                         originSP.equals("South Bus Terminal, Cebu City")) {
                    tFare.setText("Jeep Fare: 8 php.");
                }
                else if (originSP.equals("Saint Paul College, Cebu South Road") &&
                        destinationSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue") ||
                        originSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue") &&
                                destinationSP.equals("Saint Paul College, Cebu South Road")) {
                    tFare.setText("Jeep Fare: 7 php.");
                }
                else if (originSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue") &&
                        destinationSP.equals("Junquera Street, Cebu City") ||
                        originSP.equals("Junquera Street, Cebu City") &&
                                destinationSP.equals("Cebu Institute of Technology - University, Natalio B. Bacalso Avenue")) {
                    tFare.setText("Jeep Fare: 8 php");
                }
                else if (originSP.equals("University of San Jose Recoletos") &&
                        destinationSP.equals("Elizabeth Mall, Natalio B. Bacalso Avenue") ||
                        originSP.equals("Elizabeth Mall, Natalio B. Bacalso Avenue") &&
                                destinationSP.equals("University of San Jose Recoletos")) {
                    tFare.setText("Jeep Fare: 7 php");
                }
                else if (originSP.equals("University of San Jose Recoletos") &&
                        destinationSP.equals("Junquera Street, Cebu City") ||
                        originSP.equals("Junquera Street, Cebu City") &&
                                destinationSP.equals("University of San Jose Recoletos")) {
                    tFare.setText("Jeep Fare: 8 php");
                }else{
                    tFare.setText("Jeep Fare: 7 php");
                }

                Location.distanceBetween(flat, flng, elat, elng, results);
//                tDistance.setText("Distance: " + results[0] + "m");
                StringBuilder builder = new StringBuilder();
                StringBuilder builder2 = new StringBuilder();
                Formatter fmt = new Formatter(builder);
                Formatter fmt2 = new Formatter(builder2);
                fmt.format("Distance: %.2f",results[0]);
//                Log.d(COMMON_TAG,TAG+" distance: "+results[0]);

                if (results[0] >= 1000) {
                    fmt2.format("Distance: %.2f",results[0]/1000);
                    tDistance.setText("Distance: " + builder2.toString()+ "km");
                } else{
                    tDistance.setText("Distance: " + builder.toString() + "m");
                }
                return view;
            }
        });

        Log.i(COMMON_TAG, TAG + " onMapReady: Map is ready override method is called.");
        if (ContextCompat.checkSelfPermission(getActivity(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            singleton.getmMap().setMyLocationEnabled(true);
            return;
        } else {

            singleton.getmMap().setMyLocationEnabled(true);
            buildGoogleApiClient();
        }
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {
        Log.d(COMMON_TAG, TAG + " onConnection failed invoked");
    }

    @Override
    public void onLocationChanged(Location location) {
        mLastLocation = location;
        Log.i(COMMON_TAG, TAG + " onLocationChanged: onLastLocation method is called.");
        if (location == null) {
            Log.d(COMMON_TAG, TAG + " onLocationChanged: Location == null, can't get the current location");
        } else {
            LatLng latLng = new LatLng(location.getLatitude(), location.getLongitude());
            singleton.setLatitude(latLng.latitude);
            singleton.setLongitude(latLng.longitude);
            ;
            singleton.getmMap().animateCamera(CameraUpdateFactory.newLatLng(latLng));

            if (mGoogleApiClient != null) {
                LocationServices.FusedLocationApi.removeLocationUpdates(mGoogleApiClient, this);
            }
        }
    }

    @Override
    public boolean onMarkerClick(final Marker marker) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                marker.setDraggable(false);
            }
        });
        return false;
    }

    @Override
    public void onMarkerDragStart(Marker marker) {

    }

    @Override
    public void onMarkerDrag(Marker marker) {

    }

    @Override
    public void onMarkerDragEnd(final Marker marker) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                singleton.setEnd_latitude(marker.getPosition().latitude);
                singleton.setEnd_longitude(marker.getPosition().longitude);
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(COMMON_TAG, TAG + " onDestroy() is called.");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(COMMON_TAG, TAG + " onPause() is called.");
    }

}
