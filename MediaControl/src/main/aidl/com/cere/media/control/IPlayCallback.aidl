// IPlayCallback.aidl
package com.cere.media.control;

// Declare any non-default types here with import statements
import android.os.Bundle;

oneway interface IPlayCallback {
    void setPlay(boolean isPlay);
    void setData(String path);
    void setMaxTime(int time);
    void setNowTime(int time);
    void setAction(String action, in Bundle bundle);
}
