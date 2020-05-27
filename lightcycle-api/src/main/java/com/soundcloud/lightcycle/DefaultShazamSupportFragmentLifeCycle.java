package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultShazamSupportFragmentLifeCycle<HostType>
        implements ShazamSupportFragmentLightCycle<HostType> {
    @Override
    public void onConfigurationChanged(@NotNull HostType fragment, @NotNull Configuration newConfig) { /* no-op */ }

    @Override
    public void onActivityResult(@NotNull HostType fragment, int requestCode, int resultCode, @Nullable Intent data) { /* no-op */ }

    @Override
    public void onSelected(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onUnselected(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onWindowFocusChanged(@NotNull HostType fragment, boolean hasFocus) { /* no-op */ }

    @Override
    public void onAttach(@NotNull HostType fragment, @NotNull Activity activity) { /* no-op */ }

    @Override
    public void onCreate(@NotNull HostType fragment, @Nullable Bundle bundle) { /* no-op */ }

    @Override
    public void onViewCreated(@NotNull HostType fragment, @NotNull View view, @Nullable Bundle savedInstanceState) { /* no-op */ }

    @Override
    public void onActivityCreated(@NotNull HostType fragment, @Nullable Bundle bundle) { /* no-op */ }

    @Override
    public void onStart(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onResume(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public boolean onOptionsItemSelected(@NotNull HostType fragment, @NotNull MenuItem item) {
        return false;
    }

    @Override
    public void onPause(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onStop(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onSaveInstanceState(@NotNull HostType fragment, @NotNull Bundle bundle) { /* no-op */ }

    @Override
    public void onDestroyView(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onDestroy(@NotNull HostType fragment) { /* no-op */ }

    @Override
    public void onDetach(@NotNull HostType fragment) { /* no-op */ }
}
