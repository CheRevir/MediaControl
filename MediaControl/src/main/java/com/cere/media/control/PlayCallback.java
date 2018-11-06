package com.cere.media.control;

import android.os.Bundle;
import android.os.RemoteException;

/**
 * Created by CeRe on 2018/6/19.
 */
public class PlayCallback extends IPlayCallback.Stub {
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

    @Override
    public void setPlay(boolean isPlay) throws RemoteException {
        this.onPlay(isPlay);
    }

    @Override
    public void setData(String path) throws RemoteException {
        this.onData(path);
    }

    @Override
    public void setMaxTime(int time) throws RemoteException {
        this.onMaxTime(time);
    }

    @Override
    public void setNowTime(int time) throws RemoteException {
        this.onNowTime(time);
    }

    @Override
    public void setAction(String action, Bundle bundle) throws RemoteException {
        this.setAction(action, bundle);
    }
}
