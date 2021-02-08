package com.androidtutz.bulana.history.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutz.bulana.histories.R;
import com.androidtutz.bulana.history.model.History;
import com.bumptech.glide.Glide;

public class HistoryDetailsActivity extends AppCompatActivity {
    private History history;
    private ImageView deviceImage;
    private String image;
    private TextView deviceTitle, currentDeviceUser, numberOfAvailableDevices, deviceSignOutDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_history);
    }
}
