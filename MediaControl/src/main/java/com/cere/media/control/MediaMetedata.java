package com.cere.media.control;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by CeRe on 2018/6/19.
 */
public class MediaMetedata implements Parcelable {
    private String title;
    private String artist;
    private String album;
    private String data;

    public MediaMetedata() {
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getArtist() {
        return artist;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getAlbum() {
        return album;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    protected MediaMetedata(Parcel in) {
        title = in.readString();
        artist = in.readString();
        album = in.readString();
        data = in.readString();
    }

    public static final Creator<MediaMetedata> CREATOR = new Creator<MediaMetedata>() {
        @Override
        public MediaMetedata createFromParcel(Parcel in) {
            return new MediaMetedata(in);
        }

        @Override
        public MediaMetedata[] newArray(int size) {
            return new MediaMetedata[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(artist);
        dest.writeString(album);
        dest.writeString(data);
    }
}
