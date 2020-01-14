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
import android.support.v7.widget.Toolbar;
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
import android.widget.Toast;

import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.adapter.DeviceAdapter;
import com.androidtutz.bulana.devices.model.Device;
import com.tomer.fadingtextview.FadingTextView;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

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
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        getSupportActionBar().hide();
        getSupportActionBar().setTitle(" ");
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
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        fadingTextView.setTexts(questionString);
        fadingTextView.setTimeout(4000, TimeUnit.MILLISECONDS);
        fadingTextView.forceRefresh();
    }

    private void palsateLightAnimation() {
        AlphaAnimation animation = new AlphaAnimation(0.2f, 1.0f);
        animation.setDuration(1000);
        animation.setStartOffset(5000);
        curvedLinearLayout.startAnimation(animation);
    }

    private void showDevices() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        ViewGroup hiddenPanel = (ViewGroup)findViewById(R.id.profile);
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
        //add delay here
        //layoutBottomSheet.setVisibility(View.VISIBLE);
    }

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
    }
}
