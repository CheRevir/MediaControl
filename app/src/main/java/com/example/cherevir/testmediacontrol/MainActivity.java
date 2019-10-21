package com.example.cherevir.testmediacontrol;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cere.media.control.MediaMetedata;
import com.cere.media.control.PlayCallback;
import com.cere.media.control.PlayControl;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PlayControl.OnConnected {
    private String TAG = "media_control";
    private PlayControl mPlayControl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Thread.currentThread().setName("activity thrread");
        mPlayControl = new PlayControl(this, Services.class);
        mPlayControl.setOnConnected(this);
        mPlayControl.connect();
        Button textView = (Button) findViewById(R.id.action_text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Activity2.class));
                //mPlayControl.disconnect();
                /*Log.e(TAG, String.valueOf(mPlayControl.isConnected()));
                if (mPlayControl.isConnected()) {
                    String action = "aa";
                    Bundle bundle = new Bundle();
                    bundle.putString(action, "abcdef");
                    mPlayControl.sendAction(action, bundle);
                }*/
            }
        });
        ((Button)findViewById(R.id.action_button)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mPlayControl.isConnected()) {
                    mPlayControl.play();
                    //mPlayControl.disconnect();
                }
            }
        });
    }

    @Override
    public void onConnected(boolean isConnected) {
        if (isConnected) {
            mPlayControl.registerCallback(mPlayCallback.getCallback());
            new MainThread().start();
            mPlayControl.play();
            List<MediaMetedata> list = new ArrayList<>();
            MediaMetedata mediaMetedata = new MediaMetedata();
            mediaMetedata.setTitle("title");
            mediaMetedata.setAlbum("album");
            mediaMetedata.setArtist("artist");
            mediaMetedata.setData("data");
            list.add(mediaMetedata);
            //mPlayControl.setPlayList(list);
        }
    }

    private PlayCallback mPlayCallback = new PlayCallback() {
        @Override
        public void onPlay(boolean isPlay) {
            super.onPlay(isPlay);
            Log.e(TAG, "main: " +String.valueOf(isPlay) + ": " + System.currentTimeMillis());
        }
    };

    private class MainThread extends Thread {
        public MainThread() {
            this.setName("MainThread");
        }

        @Override
        public void run() {
            super.run();
            for(int n=0;n<5;n++) {
                Log.e(TAG, this.getName() + n);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
