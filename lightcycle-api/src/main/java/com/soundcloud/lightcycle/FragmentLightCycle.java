package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface FragmentLightCycle<T> {
    void onAttach(@NotNull T host, @NotNull Activity activity);
    void onAttach(@NotNull T host, @NotNull Context context);
    void onCreate(@NotNull T host, @Nullable Bundle bundle);
    void onViewCreated(@NotNull T host, @NotNull View view, @Nullable Bundle savedInstanceState);
    void onActivityCreated(@NotNull T host, @Nullable Bundle bundle);
    void onStart(@NotNull T host);
    void onResume(@NotNull T host);
    boolean onOptionsItemSelected(@NotNull T host, @NotNull MenuItem item);
    void onPause(@NotNull T host);
    void onStop(@NotNull T host);
    void onSaveInstanceState(@NotNull T host, @NotNull Bundle bundle);
    void onDestroyView(@NotNull T host);
    void onDestroy(@NotNull T host);
    void onDetach(@NotNull T host);
}
