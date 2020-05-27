package com.soundcloud.lightcycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ActivityLightCycle<T> {
    void onCreate(@NotNull T host, @Nullable Bundle bundle);
    void onPostCreate(@NotNull T host, @Nullable Bundle bundle);
    void onNewIntent(@NotNull T host, Intent intent);
    void onStart(@NotNull T host);
    void onResume(@NotNull T host);
    boolean onOptionsItemSelected(@NotNull T host, @NotNull MenuItem item);
    void onPause(@NotNull T host);
    void onStop(@NotNull T host);
    void onSaveInstanceState(@NotNull T host, @NotNull Bundle bundle);
    void onRestoreInstanceState(@NotNull T host, @NotNull Bundle bundle);
    void onWindowFocusChanged(@NotNull T host, boolean hasFocus);
    void onActivityResult(@NotNull T host, int requestCode, int resultCode, @Nullable Intent data);
    void onConfigurationChanged(@NotNull T host, @NotNull Configuration newConfig);
    void onMultiWindowModeChanged(@NotNull T host, boolean isInMultiWindowMode);
    void onDestroy(@NotNull T host);
    void onBackPressed(@NotNull T host);
}
