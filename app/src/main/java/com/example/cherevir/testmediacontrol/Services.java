package com.example.cherevir.testmediacontrol;

import android.app.Service;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

import com.cere.media.control.MediaMetedata;
import com.cere.media.control.PlayControlled;

import java.util.ArrayList;

import androidx.annotation.Nullable;

/**
 * Created by CeRe on 2018/6/19.
 */
public class Services extends Service {
    private String TAG = "media_control";

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return mPlayControlled.getBinder();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, intent.getClass().getName());
        return super.onUnbind(intent);
    }

    private PlayControlled mPlayControlled = new PlayControlled() {
        @Override
        public void onPlay() {
            super.onPlay();
            new ServiceThread().start();
        }

        @Override
        public void setPlayList(ArrayList<MediaMetedata> list) {
            super.setPlayList(list);
            Log.e(TAG, list.get(0).getTitle());
            Log.e(TAG, list.get(0).getArtist());
            Log.e(TAG, list.get(0).getAlbum());
            Log.e(TAG, list.get(0).getData());
        }

        @Override
        public void sendAction(String action, Bundle bundle) {
            super.sendAction(action, bundle);
            Log.e(TAG, bundle.getString(action));
        }
    };

    private class ServiceThread extends Thread {
        public ServiceThread() {
            this.setName("ServiceThread");
        }

        @Override
        public void run() {
            super.run();
            for (int n = 0; n < 5; n++) {
                Log.e(TAG, this.getName() + n);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mPlayControlled.getCallback().setPlay(true);
            }
        }
    }
}
