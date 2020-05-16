package com.nop.moviecatalogsubmission2.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int img;
    private String title, desc;

    public Movie(){

    }

    private Movie(Parcel in) {
        img = in.readInt();
        title = in.readString();
        desc = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
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
