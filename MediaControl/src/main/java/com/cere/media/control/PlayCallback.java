package com.cere.media.control;

import android.os.Bundle;
import android.os.RemoteException;

/**
 * Created by CeRe on 2018/6/19.
 */
public class PlayCallback {
    private Callback mCallback;

    public PlayCallback(){
        mCallback = new Callback();
    }

    public void onPlay(boolean isPlay) {
    }

    public void onData(String path) {
    }

    public void onMaxTime(int time) {
    }

    public void onNowTime(int time) {
    }

    public void onAction(String action, Bundle bundle) {
    }

    public Callback getCallback() {
        return mCallback;
    }

    private class Callback extends IPlayCallback.Stub {
        @Override
        public void setPlay(boolean isPlay) throws RemoteException {
            PlayCallback.this.onPlay(isPlay);
        }

        @Override
        public void setData(String path) throws RemoteException {
            PlayCallback.this.onData(path);
        }

        @Override
        public void setMaxTime(int time) throws RemoteException {
            PlayCallback.this.onMaxTime(time);
        }

        @Override
        public void setNowTime(int time) throws RemoteException {
            PlayCallback.this.onNowTime(time);
        }

        @Override
        public void setAction(String action, Bundle bundle) throws RemoteException {
            PlayCallback.this.onAction(action, bundle);
        }
    }
}
