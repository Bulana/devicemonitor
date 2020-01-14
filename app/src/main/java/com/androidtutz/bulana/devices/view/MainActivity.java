package com.androidtutz.bulana.devices.view;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v4.util.TimeUtils;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.RecyclerView;
<<<<<<< HEAD
import android.support.v7.widget.Toolbar;
=======
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
<<<<<<< HEAD
import android.widget.Toast;

import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.adapter.DeviceAdapter;
import com.androidtutz.bulana.devices.model.Device;
=======
import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.adapter.DeviceAdapter;
import com.androidtutz.bulana.devices.model.DeviceModel;
import com.androidtutz.bulana.devices.service.DevicesDataService;
import com.androidtutz.bulana.devices.service.RetrofitInstance;
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
import com.tomer.fadingtextview.FadingTextView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
<<<<<<< HEAD

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<Device> devices;
    private RecyclerView recyclerView;
    private DeviceAdapter deviceAdapter;
    private FadingTextView fadingTextView;
    private LinearLayout curvedLinearLayout;
    private BottomSheetBehavior sheetBehavior;
    //private LinearLayout layoutBottomSheet;
    private LinearLayout educationLayout;
    private LinearLayout experienceLayout;
    private LinearLayout interestLayout;
    private LinearLayout skillLayout;
    private LinearLayout contactsLayout;
    private LinearLayout referencesLayout;
    private Button submitBtn;

    private ListView mDrawerList;
    private DrawerLayout mDrawerLayout;
    private Toolbar toolbar;
    private ActionBarDrawerToggle mDrawerToggle;

    @SuppressLint("ResourceType")
=======
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ArrayList<DeviceModel> devices;
    private RecyclerView recyclerView;
    private DeviceAdapter deviceAdapter;
    private FadingTextView fadingTextView;
    private TextView tvAllDeviceHeader;
    LinearLayout layoutBottomSheet;
    private View mViewBg;
    LinearLayout llHeading;
    BottomSheetBehavior sheetBehavior;

>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle(" ");
<<<<<<< HEAD
        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this, R.color.blue_sky));

        mDrawerList = findViewById(R.id.main_navigation);
        mDrawerLayout = findViewById(R.id.main_drawer);
        toolbar = findViewById(R.id.main_toolbar);
        //toolbar.getBackground().setAlpha(0);

        fadingTextView = findViewById(R.id.fading_text_view);
        curvedLinearLayout = findViewById(R.id.profile);
       // layoutBottomSheet = findViewById(R.id.bottom_sheet);
        educationLayout = findViewById(R.id.education);
        experienceLayout = findViewById(R.id.experience);
        interestLayout = findViewById(R.id.interests);
        skillLayout = findViewById(R.id.skill);
        //contactsLayout = findViewById(R.id.contacts);
        referencesLayout = findViewById(R.id.references);
        submitBtn = findViewById(R.id.submit_button);

        educationLayout.setOnClickListener(this);
        experienceLayout.setOnClickListener(this);
        interestLayout.setOnClickListener(this);
        skillLayout.setOnClickListener(this);
        //contactsLayout = findViewById(R.id.contacts);
        referencesLayout.setOnClickListener(this);
        //submitBtn.setOnClickListener(this);

        palsateLightAnimation();
        fadeTextAnimation();
        showDevices();
        //sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);

        //setSupportActionBar(toolbar);
        final ActionBar actionBar = getSupportActionBar();

        if (actionBar != null)
        {
            actionBar.setDisplayHomeAsUpEnabled(true);
            mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
            {
                public void onDrawerClosed(View view)
                {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = false;
                }

                public void onDrawerOpened(View drawerView)
                {
                    supportInvalidateOptionsMenu();
                    //drawerOpened = true;
                }
            };
            mDrawerToggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorPrimary));
            mDrawerToggle.setDrawerIndicatorEnabled(true);
            mDrawerLayout.setDrawerListener(mDrawerToggle);
            mDrawerToggle.syncState();
        }
    }

    @Override
    public void onBackPressed() {
        finish();
=======

        Window window = this.getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blue_dark));
        layoutBottomSheet = findViewById(R.id.bottom_sheet);

        mViewBg = findViewById(R.id.bg);
        tvAllDeviceHeader = findViewById(R.id.tvAllDeviceHeader);
        fadingTextView = findViewById(R.id.fading_text_view);
        llHeading = findViewById(R.id.llHeader);
        llHeading.setOnClickListener(this);
        fadeTextAnimation();
        getDevices();
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
    }

    @Override
    protected void onResume() {
        super.onResume();
<<<<<<< HEAD
        //showPersistentBottomSheet();

    }
//
//    public void showPersistentBottomSheet() {
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
//            @Override
//            public void onSlide(View bottomSheet, float slideOffset) {
//
//            }
//        });
//    }

    public void toggleBottomSheet() {
        if (sheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
            sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            //btnBottomSheet.setText("Close sheet");
        } else {
            sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            //btnBottomSheet.setText("Expand sheet");
        }
    }

    private void fadeTextAnimation() {
        String[] questionString = {"Looking For A Native Android Developer?", "Look No Further."};
=======
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
                        WindowManager.LayoutParams layoutParams = getWindow().getAttributes();
                        layoutParams.dimAmount = 0.75f;
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
                        mViewBg.setVisibility(View.GONE);
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        mViewBg.setVisibility(View.GONE);
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        mViewBg.setVisibility(View.GONE);
                        break;
                }
            }
            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
            }
        });
    }

    private void fadeTextAnimation() {
        String[] questionString = {"Looking For A Zapper Device?", "Look No Further."};
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
        fadingTextView.setTexts(questionString);
        fadingTextView.setTimeout(4000, TimeUnit.MILLISECONDS);
        fadingTextView.forceRefresh();
    }

<<<<<<< HEAD
    private void palsateLightAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(5000);
        curvedLinearLayout.startAnimation(animation);
    }

    private void showDevices() {
=======
    private void showDevicesAnimation() {
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        ViewGroup hiddenPanel = (ViewGroup)findViewById(R.id.profile);
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
        //add delay here
        //layoutBottomSheet.setVisibility(View.VISIBLE);
    }

<<<<<<< HEAD
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.education:
                Intent intent = new Intent(this, DeviceActivity.class);
                startActivity(intent);
                break;
            case R.id.experience:
                Log.d("KKK","exp");
                break;
            case R.id.skill:
                Log.d("KKK","skill");
                break;
            case R.id.references:
                Log.d("KKK","ref");
                break;
            case R.id.interests:
                Log.d("KKK","interest");
                break;
        }
=======
    public void getDevices() {
        DevicesDataService devicesDataService = RetrofitInstance.getService();
        Call<DeviceModel> call = devicesDataService.getDevices();
        call.enqueue(new Callback<DeviceModel>() {
            @Override
            public void onResponse(Call<DeviceModel> call, Response<DeviceModel> response) {
                DeviceModel deviceDBResponse = response.body();

                if (deviceDBResponse != null && deviceDBResponse.getDevices() != null) {
                    devices = (ArrayList<DeviceModel>) deviceDBResponse.getDevices();
                    showOnRecyclerView();
                    showDevicesAnimation();
                }
            }
            @Override
            public void onFailure(Call<DeviceModel> call, Throwable t) {
            }
        });
    }

    private void showOnRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.rvDevices);
        deviceAdapter = new DeviceAdapter(this, devices);

        if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        } else {
            recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        }

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(deviceAdapter);
        deviceAdapter.notifyDataSetChanged();
        tvAllDeviceHeader.setText("All Devices"); //move to strings
    }

    @Override
    public void onClick(View view) {
       switch (view.getId()) {
           case R.id.llHeader:
               if (sheetBehavior.getState() == BottomSheetBehavior.STATE_COLLAPSED) {
                   sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
               }
               if (sheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
                   sheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
               }
               break;
       }
>>>>>>> 450d9a102adb673e5180545702b1a8117f72a61d
    }
}
