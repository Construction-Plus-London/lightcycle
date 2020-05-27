package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public interface ShazamSupportFragmentLightCycle<HostType> {

    void onConfigurationChanged(HostType fragment, Configuration newConfig);
    void onActivityResult(HostType fragment, int requestCode, int resultCode, Intent data);
    void onSelected(HostType fragment);
    void onUnselected(HostType fragment);
    void onWindowFocusChanged(HostType fragment, boolean hasFocus);

    //
    // From SupportFragmentLightCycle
    //
    void onAttach(HostType fragment, Activity activity);
    void onCreate(HostType fragment, Bundle bundle);
    void onViewCreated(HostType fragment, View view, Bundle savedInstanceState);
    void onActivityCreated(HostType fragment, Bundle bundle);
    void onStart(HostType fragment);
    void onResume(HostType fragment);
    boolean onOptionsItemSelected(HostType fragment, MenuItem item);
    void onPause(HostType fragment);
    void onStop(HostType fragment);
    void onSaveInstanceState(HostType fragment, Bundle bundle);
    void onDestroyView(HostType fragment);
    void onDestroy(HostType fragment);
    void onDetach(HostType fragment);
}
