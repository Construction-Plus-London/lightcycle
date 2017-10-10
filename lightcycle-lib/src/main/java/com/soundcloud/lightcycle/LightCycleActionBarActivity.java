package com.soundcloud.lightcycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBarActivity;
import android.view.MenuItem;

import com.soundcloud.lightcycle.util.Preconditions;

@Deprecated
public abstract class LightCycleActionBarActivity<HostType>
        extends ActionBarActivity
        implements LightCycleDispatcher<ActivityLightCycle<HostType>> {

    private final ActivityLightCycleDispatcher<HostType> lightCycleDispatcher;

    public LightCycleActionBarActivity() {
        lightCycleDispatcher = new ActivityLightCycleDispatcher<>();
    }

    @Override
    public void bind(ActivityLightCycle<HostType> lightCycle) {
        Preconditions.checkBindingTarget(lightCycle);
        lightCycleDispatcher.bind(lightCycle);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setActivityContentView();
        LightCycles.bind(this);
        lightCycleDispatcher.onCreate(host(), savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        lightCycleDispatcher.onPostCreate(host(), savedInstanceState);
    }

    protected abstract void setActivityContentView();

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        lightCycleDispatcher.onNewIntent(host(), intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lightCycleDispatcher.onStart(host());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return lightCycleDispatcher.onOptionsItemSelected(host(), item);
    }

    @Override
    protected void onStop() {
        lightCycleDispatcher.onStop(host());
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lightCycleDispatcher.onResume(host());
    }

    @Override
    protected void onPause() {
        lightCycleDispatcher.onPause(host());
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lightCycleDispatcher.onSaveInstanceState(host(), outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lightCycleDispatcher.onRestoreInstanceState(host(), savedInstanceState);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        lightCycleDispatcher.onWindowFocusChanged(host(), hasFocus);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lightCycleDispatcher.onActivityResult(host(), requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lightCycleDispatcher.onConfigurationChanged(host(), newConfig);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        lightCycleDispatcher.onMultiWindowModeChanged(host(), isInMultiWindowMode);
    }

    @Override
    protected void onDestroy() {
        lightCycleDispatcher.onDestroy(host());
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        lightCycleDispatcher.onBackPressed(host());
        super.onBackPressed();
    }

    @SuppressWarnings("unchecked")
    private HostType host() {
        return (HostType) this;
    }
}
