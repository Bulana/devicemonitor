package com.androidtutz.bulana.history.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static Retrofit retrofit = null;
    private static String BASE_URL = "https://zapperhistories/";

    public static HistoriesDataService getService() {

        if (retrofit == null) {
               retrofit = new Retrofit
                       .Builder()
                       .baseUrl(BASE_URL)
                       .addConverterFactory(GsonConverterFactory.create())
                       .build();
        }
        return retrofit.create(HistoriesDataService.class);
    }
}
