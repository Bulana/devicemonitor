package com.androidtutz.bulana.history.service;

import com.androidtutz.bulana.history.model.HistoryDBResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HistoriesDataService {

    @GET("/history")
    Call<HistoryDBResponse> getHistories();
}
