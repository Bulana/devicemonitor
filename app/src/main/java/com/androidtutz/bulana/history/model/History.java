package com.androidtutz.bulana.history.model;


import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History implements Parcelable {
//    @SerializedName("history_status")
//    @Expose
    private int historyStatus;
//    @SerializedName("merchant_name")
//    @Expose
    private String merchantName;
//    @SerializedName("history_date")
//    @Expose
    private String historyDate;
//    @SerializedName("history_amount")
//    @Expose
    private String historyAmount;

    public History(int historyStatus,
                   String merchantName,
                   String historyDate,
                   String historyAmount) {
        this.historyStatus = historyStatus;
        this.merchantName = merchantName;
        this.historyDate = historyDate;
        this.historyAmount = historyAmount;
    }

    protected History(Parcel in) {
        historyStatus = in.readInt();
        merchantName = in.readString();
        historyDate = in.readString();
        historyAmount = in.readString();
    }

    public static final Creator<History> CREATOR = new Creator<History>() {
        @Override
        public History createFromParcel(Parcel in) {
            return new History(in);
        }

        @Override
        public History[] newArray(int size) {
            return new History[size];
        }
    };

    public int getHistoryStatus() {
        return historyStatus;
    }

    public void setHistoryStatus(int historyStatus) {
        this.historyStatus = historyStatus;
    }

    public String getMerchantName() {
        return merchantName;
    }

    public void setMerchantName(String merchantName) {
        this.merchantName = merchantName;
    }

    public String getHistoryDate() {
        return historyDate;
    }

    public void setHistoryDate(String historyDate) {
        this.historyDate = historyDate;
    }

    public String getHistoryAmount() {
        return historyAmount;
    }

    public void setHistoryAmount(String historyAmount) {
        this.historyAmount = historyAmount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(historyStatus);
        parcel.writeString(merchantName);
        parcel.writeString(historyDate);
        parcel.writeString(historyAmount);
    }
}