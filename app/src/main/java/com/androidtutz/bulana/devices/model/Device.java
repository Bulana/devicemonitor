package com.androidtutz.bulana.devices.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Device implements Parcelable
{
    @SerializedName("available_devices")
    @Expose
    private Double availableDevices;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("poster_path")
    @Expose
    private String posterPath;
    @SerializedName("original_title")
    @Expose
    private String originalTitle;
    @SerializedName("backdrop_path")
    @Expose
    private String backdropPath;
    @SerializedName("taken_by")
    @Expose
    private String currentDeviceUser;
    @SerializedName("sign_out_date")
    @Expose
    private String signOutDate;
    public final static Parcelable.Creator<Device> CREATOR = new Creator<Device>() {

        @SuppressWarnings({
                "unchecked"
        })
        public Device createFromParcel(Parcel in) {
            return new Device(in);
        }

        public Device[] newArray(int size) {
            return (new Device[size]);
        }

    };

    protected Device(Parcel in) {
        this.availableDevices = ((Double) in.readValue((Double.class.getClassLoader())));
        this.title = ((String) in.readValue((String.class.getClassLoader())));
        this.posterPath = ((String) in.readValue((String.class.getClassLoader())));
        this.originalTitle = ((String) in.readValue((String.class.getClassLoader())));
        this.backdropPath = ((String) in.readValue((String.class.getClassLoader())));
        this.currentDeviceUser = ((String) in.readValue((String.class.getClassLoader())));
        this.signOutDate = ((String) in.readValue((String.class.getClassLoader())));
    }

    public Double getAvailableDevices() {
        return availableDevices;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public String getCurrentDeviceUser() {
        return currentDeviceUser;
    }

    public void setCurrentDeviceUser(String currentDeviceUser) {
        this.currentDeviceUser = currentDeviceUser;
    }

    public String getSignOutDate() {
        return signOutDate;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(availableDevices);
        dest.writeValue(title);
        dest.writeValue(posterPath);
        dest.writeValue(originalTitle);
        dest.writeValue(backdropPath);
        dest.writeValue(currentDeviceUser);
        dest.writeValue(signOutDate);
    }

    public int describeContents() {
        return 0;
    }

}