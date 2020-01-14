package com.androidtutz.bulana.devices.service;

//import com.androidtutz.bulana.devices.model.DeviceDBResponse;
import com.androidtutz.bulana.devices.model.DeviceModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DevicesDataService {

    @GET("db.json")
    Call<DeviceModel> getDevices();
}
