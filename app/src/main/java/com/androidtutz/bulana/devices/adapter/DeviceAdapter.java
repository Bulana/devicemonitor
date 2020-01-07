package com.androidtutz.bulana.devices.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.androidtutz.bulana.devices.R;
import com.androidtutz.bulana.devices.model.Device;
import com.androidtutz.bulana.devices.view.DeviceActivity;
import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class DeviceAdapter extends RecyclerView.Adapter<DeviceAdapter.DeviceViewHolder>{

    private Context context;
    private ArrayList<Device> deviceArrayList;

    public DeviceAdapter(Context context, ArrayList<Device> deviceArrayList) {
        this.context = context;
        this.deviceArrayList = deviceArrayList;
    }

    @NonNull
    @Override
    public DeviceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_list_item,parent,false);
        return new DeviceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DeviceViewHolder holder, int position) {
        holder.movieTitle.setText(deviceArrayList.get(position).getOriginalTitle());
        holder.rate.setText(Double.toString(deviceArrayList.get(position).getVoteAverage()));
        String imagePath="https://3bcb7e78.ngrok.io/"+ deviceArrayList.get(position).getPosterPath();
        Glide.with(context)
                .load(imagePath)
                .placeholder(R.drawable.loading)
                .into(holder.movieImage);
    }

    @Override
    public int getItemCount() {
        return deviceArrayList.size();
    }

    public class DeviceViewHolder extends RecyclerView.ViewHolder {
        public TextView movieTitle, rate;
        public ImageView movieImage;

        public DeviceViewHolder(View itemView) {
            super(itemView);
            movieImage = (ImageView) itemView.findViewById(R.id.ivDevice);
            rate = (TextView) itemView.findViewById(R.id.tvRating);
            movieTitle = (TextView) itemView.findViewById(R.id.tvTitle);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    if(position!=RecyclerView.NO_POSITION) {
                        Device selctedDevice = deviceArrayList.get(position);
                        Intent intent = new Intent(context, DeviceActivity.class);
                        intent.putExtra("device", selctedDevice);
                        context.startActivity(intent);
                    }
                }
            });
        }
    }
}
