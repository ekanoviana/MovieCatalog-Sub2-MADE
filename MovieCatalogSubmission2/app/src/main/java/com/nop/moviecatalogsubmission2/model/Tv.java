package com.nop.moviecatalogsubmission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Tv implements Parcelable {
    private int img;
    private String title, desc;

    public Tv(){

    }

    private Tv(Parcel in) {
        img = in.readInt();
        title = in.readString();
        desc = in.readString();
    }

    public static final Creator<Tv> CREATOR = new Creator<Tv>() {
        @Override
        public Tv createFromParcel(Parcel in) {
            return new Tv(in);
        }

        @Override
        public Tv[] newArray(int size) {
            return new Tv[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(img);
        parcel.writeString(title);
        parcel.writeString(desc);
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
