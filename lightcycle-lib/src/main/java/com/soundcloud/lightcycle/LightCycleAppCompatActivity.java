package com.soundcloud.lightcycle;

import com.soundcloud.lightcycle.util.Preconditions;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.support.annotation.Nullable;
import android.view.MenuItem;

public abstract class LightCycleAppCompatActivity<HostType>
        extends AppCompatActivity
        implements LightCycleDispatcher<ActivityLightCycle<HostType>> {

    private final ActivityLightCycleDispatcher<HostType> lightCycleDispatcher;

    public LightCycleAppCompatActivity() {
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
        lightCycleDispatcher.onCreate(activity(), savedInstanceState);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        lightCycleDispatcher.onPostCreate(activity(), savedInstanceState);
    }

    protected abstract void setActivityContentView();

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        lightCycleDispatcher.onNewIntent(activity(), intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        lightCycleDispatcher.onStart(activity());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return lightCycleDispatcher.onOptionsItemSelected(activity(), item);
    }

    @Override
    protected void onStop() {
        lightCycleDispatcher.onStop(activity());
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        lightCycleDispatcher.onResume(activity());
    }

    @Override
    protected void onPause() {
        lightCycleDispatcher.onPause(activity());
        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        lightCycleDispatcher.onSaveInstanceState(activity(), outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        lightCycleDispatcher.onRestoreInstanceState(activity(), savedInstanceState);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        lightCycleDispatcher.onWindowFocusChanged(activity(), hasFocus);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        lightCycleDispatcher.onActivityResult(activity(), requestCode, resultCode, data);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        lightCycleDispatcher.onConfigurationChanged(activity(), newConfig);
    }

    @Override
    public void onMultiWindowModeChanged(boolean isInMultiWindowMode) {
        super.onMultiWindowModeChanged(isInMultiWindowMode);
        lightCycleDispatcher.onMultiWindowModeChanged(activity(), isInMultiWindowMode);
    }

    @Override
    protected void onDestroy() {
        lightCycleDispatcher.onDestroy(activity());
        super.onDestroy();
    }

    @Override
    public void onBackPressed() {
        lightCycleDispatcher.onBackPressed(activity());
        super.onBackPressed();
    }

    @SuppressWarnings("unchecked")
    private HostType activity() {
        return (HostType) this;
    }
}
