package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ShazamSupportFragmentLightCycle<HostType> {
    void onConfigurationChanged(@NotNull HostType fragment, @NotNull Configuration newConfig);
    void onActivityResult(@NotNull HostType fragment, int requestCode, int resultCode, @Nullable Intent data);
    void onSelected(@NotNull HostType fragment);
    void onUnselected(@NotNull HostType fragment);
    void onWindowFocusChanged(@NotNull HostType fragment, boolean hasFocus);

    //
    // From SupportFragmentLightCycle
    //
    void onAttach(@NotNull HostType host, @NotNull Activity activity);
    void onCreate(@NotNull HostType host, @Nullable Bundle bundle);
    void onViewCreated(@NotNull HostType host, @NotNull View view, @Nullable Bundle savedInstanceState);
    void onActivityCreated(@NotNull HostType host, @Nullable Bundle bundle);
    void onStart(@NotNull HostType host);
    void onResume(@NotNull HostType host);
    boolean onOptionsItemSelected(@NotNull HostType host, @NotNull MenuItem item);
    void onPause(@NotNull HostType host);
    void onStop(@NotNull HostType host);
    void onSaveInstanceState(@NotNull HostType host, @NotNull Bundle bundle);
    void onDestroyView(@NotNull HostType host);
    void onDestroy(@NotNull HostType host);
    void onDetach(@NotNull HostType host);
}
