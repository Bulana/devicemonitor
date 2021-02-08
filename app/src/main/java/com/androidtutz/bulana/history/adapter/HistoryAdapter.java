package com.androidtutz.bulana.history.adapter;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.androidtutz.bulana.histories.R;
import com.androidtutz.bulana.history.model.History;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>{

    private Context context;
    private ArrayList<History> historyArrayList;

    public HistoryAdapter(Context context, ArrayList<History> historyArrayList) {
        this.context = context;
        this.historyArrayList = historyArrayList;
    }

    @NonNull
    @Override
    public HistoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.history_list_item,parent,false);
        return new HistoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HistoryViewHolder holder, int position) {
        holder.tvMerchantName.setText(historyArrayList.get(position).getMerchantName());
        holder.tvHistoryDate.setText(historyArrayList.get(position).getHistoryDate());
        holder.amountHistory.setText(historyArrayList.get(position).getHistoryAmount());
        holder.ivHistoryStatus.setImageResource(historyArrayList.get(position).getHistoryStatus());

    }

    @Override
    public int getItemCount() {
        return historyArrayList.size();
    }

    public class HistoryViewHolder extends RecyclerView.ViewHolder {
        public TextView tvMerchantName;
        public TextView tvHistoryDate;
        public TextView amountHistory;
        public ImageView ivHistoryStatus;

        public HistoryViewHolder(View itemView) {
            super(itemView);
            amountHistory = (TextView) itemView.findViewById(R.id.amount_history);
            ivHistoryStatus = (ImageView) itemView.findViewById(R.id.history_status);
            tvHistoryDate = (TextView) itemView.findViewById(R.id.history_date);
            tvMerchantName = (TextView) itemView.findViewById(R.id.merchant_name);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION) {
                        Toast.makeText(context, "Clicked : "+view, Toast.LENGTH_LONG);
                    }
                }
            });
        }
    }
}
