package com.soundcloud.lightcycle.sample.basic;

import com.soundcloud.lightcycle.DefaultActivityLightCycle;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class ActivityLogger extends DefaultActivityLightCycle<AppCompatActivity> {

    private static final String TAG = "ACTIVITY_LOG";

    @Override
    public void onCreate(@NotNull AppCompatActivity activity, @Nullable Bundle bundle) {
        Log.i(TAG, "Creating activity:" + activity);
    }

    @Override
    public void onStart(@NotNull AppCompatActivity activity) {
        Log.i(TAG, "Starting activity:" + activity);
    }

    @Override
    public void onResume(@NotNull AppCompatActivity activity) {
        Log.i(TAG, "Resuming activity:" + activity);
    }

    @Override
    public void onPause(@NotNull AppCompatActivity activity) {
        Log.i(TAG, "Pausing activity:" + activity);
    }

    @Override
    public void onStop(@NotNull AppCompatActivity activity) {
        Log.i(TAG, "Stopping activity:" + activity);
    }

    @Override
    public void onDestroy(@NotNull AppCompatActivity activity) {
        Log.i(TAG, "Destroying activity:" + activity);
    }
}
