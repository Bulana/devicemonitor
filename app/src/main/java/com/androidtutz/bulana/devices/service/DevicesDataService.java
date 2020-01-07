package com.androidtutz.bulana.devices.service;

import com.androidtutz.bulana.devices.model.DeviceDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DevicesDataService {

    @GET("db.json")
    Call<DeviceDBResponse> getDevices();
}
