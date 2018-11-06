package com.example.cherevir.testmediacontrol;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.cere.media.control.PlayCallback;
import com.cere.media.control.PlayControl;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Created by CeRe on 2018/6/19.
 */
public class Activity2 extends AppCompatActivity implements PlayControl.OnConnected {
    private String TAG = "media_control";
    private PlayControl mPlayControl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("sldkfj");
        mPlayControl = new PlayControl(this, Services.class);
        mPlayControl.setOnConnected(this);
        mPlayControl.connect();
    }

    @Override
    public void onConnected(boolean isConnected) {
        if (isConnected) {
            mPlayControl.registerCallback(mPlayCallback);
            mPlayControl.play();
        }
        Log.e(TAG, "activity2 connected:" + String.valueOf(isConnected));
    }

    private PlayCallback mPlayCallback = new PlayCallback() {
        @Override
        public void onPlay(boolean isPlay) {
            super.onPlay(isPlay);
            Log.e(TAG, "activity2 play:" + String.valueOf(isPlay));
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPlayControl.unregisterCallback(mPlayCallback);
        mPlayControl.disconnect();
        Log.e(TAG, "activity2 destroy");
    }
}
