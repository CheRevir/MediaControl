package com.cere.media.control;

import android.os.Bundle;
import android.os.RemoteCallbackList;
import android.os.RemoteException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by CeRe on 2018/6/19.
 */
public class PlayControlled {
    private Binder mBinder;
    private RemoteCallbackList<IPlayCallback> mCallbackList;
    private PlayCallback mPlayCallback;

    public PlayControlled() {
        mBinder = new Binder();
        mCallbackList = new RemoteCallbackList<>();
        mPlayCallback = new PlayCallback();
    }

    protected void onPlay() {
    }

    protected void onPause() {
    }

    protected void onPrevious() {
    }

    protected void onNext() {
    }

    protected void seekTo(long progress) {
    }

    protected void setData(String path) {
    }

    protected void setPlayList(ArrayList<MediaMetedata> list) {
    }

    protected void setRepeatMode(int repeatMode) {
    }

    protected void setShuffleModeEnabled(boolean shuffleMode) {
    }

    protected void sendAction(String action, Bundle bundle) {
    }

    private void registerCallback(IPlayCallback callback) {
        mCallbackList.register(callback);
    }

    private void unregisterCallback(IPlayCallback callback) {
        mCallbackList.unregister(callback);
    }

    public Binder getBinder() {
        return mBinder;
    }

    public PlayCallback getCallback() {
        return mPlayCallback;
    }

    public class PlayCallback {
        public void setPlay(boolean isPlay) {
            int num = mCallbackList.beginBroadcast();
            for (int n = 0; n < num; n++) {
                try {
                    mCallbackList.getBroadcastItem(n).setPlay(isPlay);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            mCallbackList.finishBroadcast();
        }

        public void setData(String path) {
            int num = mCallbackList.beginBroadcast();
            for (int n = 0; n < num; n++) {
                try {
                    mCallbackList.getBroadcastItem(n).setData(path);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            mCallbackList.finishBroadcast();
        }

        public void setMaxTime(int time) {
            int num = mCallbackList.beginBroadcast();
            for (int n = 0; n < num; n++) {
                try {
                    mCallbackList.getBroadcastItem(n).setMaxTime(time);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            mCallbackList.finishBroadcast();
        }

        public void setNowTime(int time) {
            int num = mCallbackList.beginBroadcast();
            for (int n = 0; n < num; n++) {
                try {
                    mCallbackList.getBroadcastItem(n).setNowTime(time);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            mCallbackList.finishBroadcast();
        }

        public void setAction(String action, Bundle bundle) {
            int num = mCallbackList.beginBroadcast();
            for (int n = 0; n < num; n++) {
                try {
                    mCallbackList.getBroadcastItem(n).setAction(action, bundle);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            mCallbackList.finishBroadcast();
        }
    }

    private class Binder extends IPlayControl.Stub {

        @Override
        public void onPlay() throws RemoteException {
            PlayControlled.this.onPlay();
        }

        @Override
        public void onPause() throws RemoteException {
            PlayControlled.this.onPause();
        }

        @Override
        public void onPrevious() throws RemoteException {
            PlayControlled.this.onPrevious();
        }

        @Override
        public void onNext() throws RemoteException {
            PlayControlled.this.onNext();
        }

        @Override
        public void seekTo(long progress) throws RemoteException {
            PlayControlled.this.seekTo(progress);
        }

        @Override
        public void setData(String path) throws RemoteException {
            PlayControlled.this.setData(path);
        }

        @Override
        public void setPlayList(List<MediaMetedata> list) throws RemoteException {
            PlayControlled.this.setPlayList(new ArrayList<MediaMetedata>(list));
        }

        @Override
        public void setRepeatMode(int repeatMode) throws RemoteException {
            PlayControlled.this.setRepeatMode(repeatMode);
        }

        @Override
        public void setShuffleModeEnabled(boolean shuffleMode) throws RemoteException {
            PlayControlled.this.setShuffleModeEnabled(shuffleMode);
        }

        @Override
        public void sendAction(String action, Bundle bundle) throws RemoteException {
            PlayControlled.this.sendAction(action, bundle);
        }

        @Override
        public void registerCallback(IPlayCallback callback) throws RemoteException {
            PlayControlled.this.registerCallback(callback);
        }

        @Override
        public void unregisterCallback(IPlayCallback callback) throws RemoteException {
            PlayControlled.this.unregisterCallback(callback);
        }
    }
}
