package com.androidtutz.bulana.devices.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://3bcb7e78.ngrok.io/";

    public static DevicesDataService getService() {

        if (retrofit == null) {
               retrofit = new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
        }
        return retrofit.create(DevicesDataService.class);
    }
}
