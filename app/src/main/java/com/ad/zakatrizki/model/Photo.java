package com.ad.zakatrizki.model;

import android.app.Application;
import android.os.Parcel;
import android.os.Parcelable;

import com.ad.zakatrizki.utils.ApiHelper;

public class Photo implements Parcelable {


    // Attributes
    public String photo;
    public String caption_photo;

    public Photo(String photo, String caption_photo) {
        this.photo = photo;
        this.caption_photo = caption_photo;
    }

    protected Photo(Parcel in) {
        photo = in.readString();
        caption_photo = in.readString();
    }

    public static final Creator<Photo> CREATOR = new Creator<Photo>() {
        @Override
        public Photo createFromParcel(Parcel in) {
            return new Photo(in);
        }

        @Override
        public Photo[] newArray(int size) {
            return new Photo[size];
        }
    };

    public String getPhoto() {
        return "/"+photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getCaption_photo() {
        return caption_photo;
    }

    public void setCaption_photo(String caption_photo) {
        this.caption_photo = caption_photo;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(photo);
        dest.writeString(caption_photo);
    }
}
