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

    protected void onPlay(boolean isPlay) {
    }

    protected void onData(String path) {
    }

    protected void onMaxTime(int time) {
    }

    protected void onNowTime(int time) {
    }

    protected void onAction(String action, Bundle bundle) {
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
