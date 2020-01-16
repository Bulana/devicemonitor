package com.androidtutz.bulana.devices.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.model.Device;
import com.bumptech.glide.Glide;

public class DeviceActivity extends AppCompatActivity {
    private Device device;
    private ImageView deviceImage;
    private String image;
    private TextView deviceTitle, currentDeviceUser, numberOfAvailableDevices, deviceSignOutDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_device);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        deviceImage = (ImageView) findViewById(R.id.ivDeviceLarge);
        deviceTitle = (TextView) findViewById(R.id.tvDeviceName);
        currentDeviceUser = (TextView) findViewById(R.id.tvCurrentDeviceUser);
        numberOfAvailableDevices = (TextView) findViewById(R.id.tvNumberOfAvailableDevices);
        deviceSignOutDate = (TextView) findViewById(R.id.tvSignOutDate);


        Intent intent = getIntent();
        if (intent.hasExtra("device")) {
            device = getIntent().getParcelableExtra("device");
            Toast.makeText(getApplicationContext(), device.getOriginalTitle(), Toast.LENGTH_LONG).show();
            image = device.getPosterPath();
            String path = "https://3bcb7e78.ngrok.io/" + image;
            Glide.with(this)
                    .load(path)
                    .placeholder(R.drawable.loading)
                    .into(deviceImage);
            getSupportActionBar().setTitle(device.getTitle());
            deviceTitle.setText(device.getTitle());
            currentDeviceUser.setText(device.getCurrentDeviceUser());
            numberOfAvailableDevices.setText(Double.toString(device.getAvailableDevices()));
            deviceSignOutDate.setText(device.getSignOutDate());
        }
    }
}
