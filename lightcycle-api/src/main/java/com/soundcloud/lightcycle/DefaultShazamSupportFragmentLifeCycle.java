package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class DefaultShazamSupportFragmentLifeCycle<HostType>
        implements ShazamSupportFragmentLightCycle<HostType> {

    @Override
    public void onConfigurationChanged(HostType fragment, Configuration newConfig) { /* no-op */ }

    @Override
    public void onActivityResult(HostType fragment, int requestCode, int resultCode, Intent data) { /* no-op */ }

    @Override
    public void onSelected(HostType fragment) { /* no-op */ }

    @Override
    public void onUnselected(HostType fragment) { /* no-op */ }

    @Override
    public void onWindowFocusChanged(HostType fragment, boolean hasFocus) { /* no-op */ }

    //
    // From SupportFragmentLightCycle
    //
    @Override
    public void onAttach(HostType fragment, Activity activity) { /* no-op */ }

    @Override
    public void onCreate(HostType fragment, Bundle bundle) { /* no-op */ }

    @Override
    public void onViewCreated(HostType fragment, View view, Bundle savedInstanceState) { /* no-op */ }

    @Override
    public void onActivityCreated(HostType fragment, Bundle bundle) { /* no-op */ }

    @Override
    public void onStart(HostType fragment) { /* no-op */ }

    @Override
    public void onResume(HostType fragment) { /* no-op */ }

    @Override
    public boolean onOptionsItemSelected(HostType fragment, MenuItem item) {
        return false;
    }

    @Override
    public void onPause(HostType fragment) { /* no-op */ }

    @Override
    public void onStop(HostType fragment) { /* no-op */ }

    @Override
    public void onSaveInstanceState(HostType fragment, Bundle bundle) { /* no-op */ }

    @Override
    public void onDestroyView(HostType fragment) { /* no-op */ }

    @Override
    public void onDestroy(HostType fragment) { /* no-op */ }

    @Override
    public void onDetach(HostType fragment) { /* no-op */ }
}
