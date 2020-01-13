package com.androidtutz.bulana.devices.view;

import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.adapter.DeviceAdapter;
import com.androidtutz.bulana.devices.model.DeviceModel;
import com.androidtutz.bulana.devices.service.DevicesDataService;
import com.androidtutz.bulana.devices.service.RetrofitInstance;
import com.tomer.fadingtextview.FadingTextView;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
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
        window.setStatusBarColor(ContextCompat.getColor(this,R.color.blue_dark));
        layoutBottomSheet = findViewById(R.id.bottom_sheet);

        mViewBg = findViewById(R.id.bg);
        tvAllDeviceHeader = findViewById(R.id.tvAllDeviceHeader);
        fadingTextView = findViewById(R.id.fading_text_view);
        llHeading = findViewById(R.id.llHeader);
        llHeading.setOnClickListener(this);
        fadeTextAnimation();
        getDevices();
    }

    @Override
    protected void onResume() {
        super.onResume();
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
        fadingTextView.setTexts(questionString);
        fadingTextView.setTimeout(2000, TimeUnit.MILLISECONDS);
        fadingTextView.forceRefresh();
    }

    private void showDevicesAnimation() {
        Animation bottomUp = AnimationUtils.loadAnimation(this, R.anim.bottom_up);
        ViewGroup hiddenPanel = (ViewGroup)findViewById(R.id.llDevices);
        hiddenPanel.startAnimation(bottomUp);
        hiddenPanel.setVisibility(View.VISIBLE);
    }

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
    }
}
