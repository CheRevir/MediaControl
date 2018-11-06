// IPlayControl.aidl
package com.cere.media.control;

// Declare any non-default types here with import statements
import android.os.Bundle;
import com.cere.media.control.MediaMetedata;
import com.cere.media.control.IPlayCallback;

oneway interface IPlayControl {
    void onPlay();
    void onPause();
    void onPrevious();
    void onNext();
    void seekTo(long progress);
    void setData(String path);
    void setPlayList(in List<MediaMetedata> list);
    void setRepeatMode(int repeatMode);
    void setShuffleModeEnabled(boolean shuffleMode);
    void sendAction(String action, in Bundle bundle);
    void registerCallback(in IPlayCallback callback);
    void unregisterCallback(in IPlayCallback callback);
}
