package com.soundcloud.lightcycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

public interface ActivityLightCycle<T> {
    void onCreate(T host, Bundle bundle);
    void onPostCreate(T host, Bundle bundle);
    void onNewIntent(T host, Intent intent);
    void onStart(T host);
    void onResume(T host);
    boolean onOptionsItemSelected(T host, MenuItem item);
    void onPause(T host);
    void onStop(T host);
    void onSaveInstanceState(T host, Bundle bundle);
    void onRestoreInstanceState(T host, Bundle bundle);
    void onWindowFocusChanged(T host, boolean hasFocus);
    void onActivityResult(T host, int requestCode, int resultCode, Intent data);
    void onConfigurationChanged(T host, Configuration newConfig);
    void onDestroy(T host);
    void onBackPressed(T host);}
