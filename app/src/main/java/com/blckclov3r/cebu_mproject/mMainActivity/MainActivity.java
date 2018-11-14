package com.blckclov3r.cebu_mproject.mMainActivity;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.os.SystemClock;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.Toast;
import com.blckclov3r.cebu_mproject.R;
import com.blckclov3r.cebu_mproject.mDatabase.DBHelper;
import com.blckclov3r.cebu_mproject.mFragment.about_fragment;
import com.blckclov3r.cebu_mproject.mFragment.home_fragment;
import com.blckclov3r.cebu_mproject.mFragment.jeep_fragment;
import com.blckclov3r.cebu_mproject.mFragment.option_fragment;
import com.blckclov3r.cebu_mproject.mModel.Jeepcode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import java.io.File;
import java.util.ArrayList;
import cn.pedant.SweetAlert.SweetAlertDialog;
import es.dmoral.toasty.Toasty;

/*
 * Created by Abrenica, Aljun
 * Software Engineering Project
 * Instructor: Stephanie Grace Villarubia
 */

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener,jeep_fragment.mListener {
    private static final String COMMON_TAG = "abrenica_aljun";
    private static final String TAG = MainActivity.class.getSimpleName();
    private static final int ERROR_DIALOG_REQUEST = 9001;
    public boolean dState = false;
    boolean doubleBackToExitPressedOnce = false;
    DBHelper dbHelper;
    SQLiteDatabase db;
    SharedPreferences sharedPreferences;
    NavigationView navigationView;
    private long mLastClickTime = 0;
    public static Activity fa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbHelper = new DBHelper(MainActivity.this);
        db = dbHelper.getWritableDatabase();
        fa = this;
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setItemTextColor(ColorStateList.valueOf(Color.rgb(240, 240, 240)));
        sharedPreferences = MainActivity.this.getSharedPreferences(option_fragment.MY_PREF, MODE_PRIVATE);
        dState = sharedPreferences.getBoolean(option_fragment.BACKGROUNDTHEME, false);
        navigationView.setItemIconTintList(null);
        navigationView.setNavigationItemSelectedListener(this);
//        nav_background();
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, new option_fragment()).commit();

            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                    .replace(R.id.fragment_container, new home_fragment())
                    .commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(COMMON_TAG, TAG + " onStart");
        Cursor cursor = dbHelper.getAllItems();
        if (cursor.moveToFirst()) {
            dbHelper.deleteList();
        }
        cursor.close();

        dbJeepList();
        dbHelper.close();
    }

//    public void nav_background() {
//        if (dState) {
//            navigationView.setBackgroundColor(Color.rgb(230, 230, 230));
//            navigationView.setItemTextColor(ColorStateList.valueOf(Color.rgb(33, 33, 33)));
//        }
//    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(COMMON_TAG, TAG + " onRestart");
    }

    @Override
    public void onBackPressed() {
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed();
        }
        if (doubleBackToExitPressedOnce == false) {
            Toast("Click back again to exit");
        }
        this.doubleBackToExitPressedOnce = true;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBackToExitPressedOnce = false;
            }
        }, 2000);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    drawer.closeDrawer(GravityCompat.START);
                }
            });
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public boolean isServiceOk() {
        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(MainActivity.this);
        if (available == ConnectionResult.SUCCESS) {
            Log.d(COMMON_TAG, TAG + " isServiceOk: GooglePlay services is working");
            return true;
        } else if (GoogleApiAvailability.getInstance().isUserResolvableError(available)) {
            Log.d(COMMON_TAG, TAG + " isServiceOk: an error occured but we cant fix it!");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(MainActivity.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        } else {
            Toast("You can't make map request for this application, sorry");
        }
        return false;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.exitBtn) {
            sweetPopup();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void sweetPopup() {
        if (SystemClock.elapsedRealtime() - mLastClickTime < 1000) {
            return;
        }
        mLastClickTime = SystemClock.elapsedRealtime();
        new SweetAlertDialog(this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                .setTitleText("Are you sure?")
                .setCustomImage(R.drawable.logout)
                .setContentText("Do you want to exit this app?")
                .setConfirmText(" Yes ")
                .setCancelText(" No ")
                .showCancelButton(true)
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.cancel();
                        return;
                    }
                })
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        Toasty.info(getApplicationContext(), "" +
                                "This program created by: Aljun Abrenica " +
                                "\nSource code: bitbucket.com/blckclov3r", Toast.LENGTH_LONG).show();
                        finish();
                    }
                })
                .show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if (id == R.id.nav_home) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.fragment_container, new home_fragment()).commit();
                }
            }, 300);

        } else if (id == R.id.nav_about) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.fragment_container, new about_fragment()).commit();
                }
            }, 300);

        } else if (id == R.id.nav_jeep) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.fragment_container, new jeep_fragment()).commit();
                }
            }, 300);
        } else if (id == R.id.nav_setting) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.fragment_container, new option_fragment()).commit();
                }
            }, 300);

        } else if (id == R.id.nav_send) {
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
                    StrictMode.setVmPolicy(builder.build());
                    try {
                        ArrayList<Uri> uris = new ArrayList<Uri>();
                        Intent sendIntent = new Intent(Intent.ACTION_SEND_MULTIPLE);
                        sendIntent.setType("*/*");
                        uris.add(Uri.fromFile(new File(getApplicationInfo().publicSourceDir)));
                        sendIntent.putParcelableArrayListExtra(Intent.EXTRA_STREAM, uris);
                        startActivity(Intent.createChooser(sendIntent, null));
                    } catch (Exception e) {
                        Log.d(COMMON_TAG,TAG+" ShareApp: "+e.getMessage());
                    }

                }
            });
        } else if (id == R.id.nav_mapTest) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    getSupportFragmentManager().beginTransaction()
                            .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                            .replace(R.id.fragment_container, new Map_()).commit();
                }
            }, 420);

        }
//        } else if (id == R.id.nav_messenger) {
//            new Handler().post(new Runnable() {
//                @Override
//                public void run() {
//                    Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.me/blckclov3r"));
//                    startActivity(browse);
//                }
//            });
//        } else if (id == R.id.nav_facebook) {
//            new Handler().post(new Runnable() {
//                @Override
//                public void run() {
//                    Toasty.info(getApplicationContext(), "facebook.com/blckclov3r", Toast.LENGTH_LONG).show();
//                    Intent browse = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.facebook.com/blckclov3r"));
//                    startActivity(browse);
//                }
//            });
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void Toast(final String s) {
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                Toasty.normal(getApplication(), s, Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void dbJeepList() {
        //forbidden singleton technique :D
        RouteList.getInstance().display(MainActivity.this);
    }

    //forbidden interface technique by: acinerba nujla = aljun abrenica :D
    public static String code;
    public static String desc;
    @Override
    public void sendInfo(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
}
