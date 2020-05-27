package com.soundcloud.lightcycle.integration_test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.soundcloud.lightcycle.DefaultSupportFragmentLightCycle;
import com.soundcloud.lightcycle.integration_test.callback.FragmentLifecycleCallback;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class SupportFragmentLogger extends DefaultSupportFragmentLightCycle<SampleSupportFragment> {

    private Map<FragmentLifecycleCallback, Boolean> lifecycleCallbackCallState;

    SupportFragmentLogger() {
        initializeLifecycleCallbackCallStateMap();
    }

    @Override
    public void onAttach(@NotNull SampleSupportFragment fragment, @NotNull Activity activity) {
        super.onAttach(fragment, activity);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onAttach, true);
    }

    @Override
    public void onCreate(@NotNull SampleSupportFragment fragment, @Nullable Bundle bundle) {
        super.onCreate(fragment, bundle);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onCreate, true);
    }

    @Override
    public void onViewCreated(@NotNull SampleSupportFragment fragment, @NotNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(fragment, view, savedInstanceState);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onViewCreated, true);
    }

    @Override
    public void onActivityCreated(@NotNull SampleSupportFragment fragment, @Nullable Bundle bundle) {
        super.onActivityCreated(fragment, bundle);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onActivityCreated, true);
    }

    @Override
    public void onStart(@NotNull SampleSupportFragment fragment) {
        super.onStart(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onStart, true);
    }

    @Override
    public void onResume(@NotNull SampleSupportFragment fragment) {
        super.onResume(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onResume, true);
    }

    @Override
    public void onPause(@NotNull SampleSupportFragment fragment) {
        super.onPause(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onPause, true);
    }

    @Override
    public void onStop(@NotNull SampleSupportFragment fragment) {
        super.onStop(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onStop, true);
    }

    @Override
    public void onDestroyView(@NotNull SampleSupportFragment fragment) {
        super.onDestroyView(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDestroyView, true);
    }

    @Override
    public void onDestroy(@NotNull SampleSupportFragment fragment) {
        super.onDestroy(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDestroy, true);
    }

    @Override
    public void onDetach(@NotNull SampleSupportFragment fragment) {
        super.onDetach(fragment);
        lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDetach, true);
    }

    boolean isFragmentLifecycleCallbackCalled(FragmentLifecycleCallback callback) {
        return lifecycleCallbackCallState.get(callback);
    }

    private void initializeLifecycleCallbackCallStateMap() {
        this.lifecycleCallbackCallState = new HashMap<>();
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onAttach, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onCreate, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onViewCreated, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onActivityCreated, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onStart, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onResume, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onPause, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onStop, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onSaveInstanceState, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDestroyView, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDestroy, false);
        this.lifecycleCallbackCallState.put(FragmentLifecycleCallback.onDetach, false);
    }
}
