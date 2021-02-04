package com.androidtutz.bulana.devices.view;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.androidtutz.bulana.devices.R;
import com.tomer.fadingtextview.FadingTextView;

import java.util.concurrent.TimeUnit;

//fade in and scale up animator

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BottomSheetBehavior sheetBehavior;
    private FadingTextView fadingTextView;
    private LinearLayout layoutBottomSheet;
    private LinearLayout curvedLinearLayout;
    private LinearLayout interestLayout;
    private LinearLayout skillLayout;
    private LinearLayout referencesLayout;
    private LinearLayout educationLayout;
    private LinearLayout experienceLayout;
    //private LinearLayout llBottomSheetHeading;

    //private ListView mDrawerList;
    private Toolbar toolbar;
    private ActionBar actionBar;
    private ActionBarDrawerToggle mDrawerToggle;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        getSupportActionBar().hide();

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.secondary_blue));

        //mDrawerList = findViewById(R.id.main_navigation);
        toolbar = findViewById(R.id.main_toolbar);

        fadingTextView = findViewById(R.id.fading_text_view);
        curvedLinearLayout = findViewById(R.id.profile);
        layoutBottomSheet = findViewById(R.id.bottom_sheet);
        educationLayout = findViewById(R.id.education);
        experienceLayout = findViewById(R.id.experience);
        interestLayout = findViewById(R.id.interests);
        skillLayout = findViewById(R.id.skill);
        referencesLayout = findViewById(R.id.references);
        //llBottomSheetHeading = findViewById(R.id.llBottomSheetHeader);

        //llBottomSheetHeading.setOnClickListener(this);
        educationLayout.setOnClickListener(this);
        experienceLayout.setOnClickListener(this);
        interestLayout.setOnClickListener(this);
        skillLayout.setOnClickListener(this);
        referencesLayout.setOnClickListener(this);

//        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
//        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
//            @Override
//            public void onStateChanged(View bottomSheet, int newState) {
//                switch (newState) {
//                    case BottomSheetBehavior.STATE_HIDDEN:
//                        break;
//                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        //  btnBottomSheet.setText("Close Sheet");
//                    }
//                    break;
//                    case BottomSheetBehavior.STATE_COLLAPSED: {
//                        //btnBottomSheet.setText("Expand Sheet");
//                    }
//                    break;
//                    case BottomSheetBehavior.STATE_DRAGGING:
//                        break;
//                    case BottomSheetBehavior.STATE_SETTLING:
//                        break;
//                }
//            }
//
//            @Override
//            public void onSlide(View bottomSheet, float slideOffset) {
//
//            }
//        });

        //palsateLightAnimation();
        fadeTextAnimation();
        //showDevices();

        //setSupportActionBar(toolbar);
//        final ActionBar actionBar = getSupportActionBar();
//        if (actionBar != null) {
//            actionBar.setDisplayHomeAsUpEnabled(true);
//            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar,
//                    R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
//
//                public void onDrawerClosed(View view) {
//                    supportInvalidateOptionsMenu();
//                    //drawerOpened = false;
//                }
//
//                public void onDrawerOpened(View drawerView) {
//                    supportInvalidateOptionsMenu();
//                    //drawerOpened = true;
//                }
//            };
//            mDrawerToggle.getDrawerArrowDrawable().setColor(
//                    getResources().getColor(R.color.colorPrimary));
//            mDrawerToggle.setDrawerIndicatorEnabled(true);
//            mDrawerLayout.setDrawerListener(mDrawerToggle);
//            mDrawerToggle.syncState();
//        }
        NavigationView nav_view = (NavigationView) findViewById(R.id.nav_view);
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        // open drawer at start
        drawer.openDrawer(GravityCompat.START);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public void onBackPressed() {
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue_dark));
        finish();
    }

    @Override
    protected void onResume() {
        super.onResume();
        fadeTextAnimation();
        curvedLinearLayout.setVisibility(View.VISIBLE);
        //showPersistentBottomSheet();
    }

//    public void showPersistentBottomSheet() {
//
//    }

    //    public void toggleBottomSheet() {
    //        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
    //            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    //            //btnBottomSheet.setText("Close sheet");
    //        } else {
    //            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
    //            //btnBottomSheet.setText("Expand sheet");
    //        }
    //    }
    //String[] questionString = {"Looking For A Native Android Developer?", "Look No Further."};
    //sheetBehavior =BottomSheetBehavior.from(layoutBottomSheet);

    //        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
    //        @Override
    //        public void onStateChanged (@NonNull View bottomSheet,int newState){
    //        switch (newState) {
    //            case BottomSheetBehavior.STATE_HIDDEN:
    //                break;
    //            case BottomSheetBehavior.STATE_EXPANDED: {
    //                WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
    //                layoutParams.dimAmount = 0.75f;
    //            }
    //            break;
    //            case BottomSheetBehavior.STATE_COLLAPSED: {
    //                mViewBg.setVisibility(View.GONE);
    //            }
    //            break;
    //            case BottomSheetBehavior.STATE_DRAGGING:
    //                mViewBg.setVisibility(View.GONE);
    //                break;
    //            case BottomSheetBehavior.STATE_SETTLING:
    //                mViewBg.setVisibility(View.GONE);
    //                break;
    //        }
    //    }
    //        @Override
    //        public void onSlide (@NonNull View bottomSheet,float slideOffset) {
    //    }
    //    });

    private void fadeTextAnimation() {
        String[] questionString = {"Looking For A Native Android?", "Look No Further."};
        fadingTextView.setTexts(questionString);
        fadingTextView.setTimeout(4000, TimeUnit.MILLISECONDS);
        fadingTextView.forceRefresh();
    }

    private void palsateLightAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(1000);
        //curvedLinearLayout.startAnimation(animation);
    }

    private void showDevicesAnimation() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        ViewGroup hiddenPanel = (ViewGroup) findViewById(R.id.profile);
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
        //add delay here
        //
        // layoutBottomSheet.setVisibility(View.VISIBLE);
    }

//    public void getDevices() {
//        DevicesDataService devicesDataService = RetrofitInstance.getService();
//        Call<DeviceModel> call = devicesDataService.getDevices();
//        call.enqueue(new Callback<DeviceModel>() {
//
//            @Override
//            public void onResponse(Call<DeviceModel> call, Response<DeviceModel> response) {
//                DeviceModel deviceDBResponse = response.body();
//
//                if (deviceDBResponse != null && deviceDBResponse.getDevices() != null) {
//                    devices = (ArrayList<DeviceModel>) deviceDBResponse.getDevices();
//                    //showOnRecyclerView();
//                    showDevicesAnimation();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<DeviceModel> call, Throwable t) {
//            }
//        });
//    }

    //    private void showOnRecyclerView() {
    //        //recyclerView = (RecyclerView) findViewById(R.id.rvDevices);
    //        deviceAdapter = new DeviceAdapter(this, devices);
    //
    //        if (this.getResources().getConfiguration().orientation == Configuration
    //        .ORIENTATION_PORTRAIT) {
    //            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    //        } else {
    //            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
    //        }
    //
    //        recyclerView.setItemAnimator(new DefaultItemAnimator());
    //        recyclerView.setAdapter(deviceAdapter);
    //        deviceAdapter.notifyDataSetChanged();
    //        //tvAllDeviceHeader.setText("All Devices"); //move to strings
    //    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
//            case R.id.llBottomSheetHeader:
//                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
//                }
//                if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
//                    sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
//                }
//                break;
            case R.id.education:
                Intent intent = new Intent(this, DeviceActivity.class);
                startActivity(intent);
                break;
            case R.id.experience:
                Log.d("KKK", "exp");
                break;
            case R.id.skill:
                Log.d("KKK", "skill");
                break;
            case R.id.references:
                Log.d("KKK", "ref");
                break;
            case R.id.interests:
                Log.d("KKK", "interest");
                break;
        }
    }
}
