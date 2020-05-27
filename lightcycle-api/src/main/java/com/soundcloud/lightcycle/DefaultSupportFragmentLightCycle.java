package com.soundcloud.lightcycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class DefaultSupportFragmentLightCycle<HostType> implements SupportFragmentLightCycle<HostType> {
    @Override
    public void onAttach(@NotNull HostType host, @NotNull Activity activity) { /* no-op */ }

    @Override
    public void onCreate(@NotNull HostType host, @Nullable Bundle bundle) { /* no-op */ }

    @Override
    public void onViewCreated(@NotNull HostType host, @NotNull View view, @Nullable Bundle savedInstanceState) { /* no-op */ }

    @Override
    public void onActivityCreated(@NotNull HostType host, @Nullable Bundle bundle) { /* no-op */ }

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
    public void onDestroyView(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onDestroy(@NotNull HostType host) { /* no-op */ }

    @Override
    public void onDetach(@NotNull HostType host) { /* no-op */ }
}
