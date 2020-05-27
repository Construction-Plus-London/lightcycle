package com.soundcloud.lightcycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultActivityLightCycle<HostType> implements ActivityLightCycle<HostType> {
    @Override
    public void onCreate(@NotNull HostType host, @Nullable Bundle bundle) { /* no-op */ }

    @Override
    public void onPostCreate(@NotNull HostType host, @Nullable Bundle bundle) { /* no-op */ }

    @Override
    public void onNewIntent(@NotNull HostType host, Intent intent) { /* no-op */ }

    @Override
    public void onStart(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onResume(@NotNull HostType host) { /* no-op */ }

    @Override
    public boolean onOptionsItemSelected(@NotNull HostType host, @NotNull MenuItem item) {
        return false;
    }

    @Override
    public void onPause(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onStop(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onSaveInstanceState(@NotNull HostType host, @NotNull Bundle bundle) { /* no-op */ }

    @Override
    public void onRestoreInstanceState(@NotNull HostType host, @NotNull Bundle bundle) { /* no-op */ }

    @Override
    public void onWindowFocusChanged(@NotNull HostType host, boolean hasFocus) { /* no-op */ }

    @Override
    public void onActivityResult(@NotNull HostType host, int requestCode, int resultCode, @Nullable Intent data) { /* no-op */ }

    @Override
    public void onConfigurationChanged(@NotNull HostType host, @NotNull Configuration newConfig) { /* no-op */ }

    @Override
    public void onMultiWindowModeChanged(@NotNull HostType host, boolean isInMultiWindowMode) { /* no-op */ }

    @Override
    public void onDestroy(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onBackPressed(@NotNull HostType host) { /* no-op */ }
}
