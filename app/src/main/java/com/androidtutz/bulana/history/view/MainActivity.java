package com.androidtutz.bulana.history.view;

import android.content.res.Configuration;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Window;
import android.view.WindowManager;

import com.androidtutz.bulana.histories.R;
import com.androidtutz.bulana.history.adapter.HistoryAdapter;
import com.androidtutz.bulana.history.model.History;
import com.androidtutz.bulana.history.model.HistoryDBResponse;
import com.androidtutz.bulana.history.service.HistoriesDataService;
import com.androidtutz.bulana.history.service.RetrofitInstance;
import java.util.ArrayList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private ArrayList<History> histories;
    private RecyclerView recyclerView;
    private HistoryAdapter historyAdapter;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//      getHistories();
        showOnRecyclerView();

    }

//    public void getHistories() {
//        HistoriesDataService historiesDataService = RetrofitInstance.getService();
//        Call<HistoryDBResponse> call = historiesDataService.getHistories();
//        call.enqueue(new Callback<HistoryDBResponse>() {
//            @Override
//            public void onResponse(Call<HistoryDBResponse> call, Response<HistoryDBResponse> response) {
//                HistoryDBResponse historyDBResponse = response.body();
//
//                if (historyDBResponse != null && historyDBResponse.getHistories() != null) {
//                    histories = (ArrayList<History>) historyDBResponse.getHistories();
//                    showOnRecyclerView();
//                }
//            }
//            @Override
//            public void onFailure(Call<HistoryDBResponse> call, Throwable t) {
//            }
//        });
//    }

    private void showOnRecyclerView() {
        histories = new ArrayList<>();

        History history1 = new History( R.drawable.ic_tick,
                "McDonald",
                "21:15",
                "R250.00");

        History history2 = new History( R.drawable.ic_alert_o,
                "KFC",
                "21:15",
                "R450.00");

        History history3 = new History( R.drawable.ic_tick,
                "Rocco Mamas",
                "21:15",
                "R550.00");

        histories.add(history1);
        histories.add(history2);
        histories.add(history3);

        recyclerView = (RecyclerView) findViewById(R.id.payment_history_recycler_view);
        historyAdapter = new HistoryAdapter(this, histories);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(false);
        recyclerView.setNestedScrollingEnabled(true);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(historyAdapter);
        historyAdapter.notifyDataSetChanged();
    }
}
