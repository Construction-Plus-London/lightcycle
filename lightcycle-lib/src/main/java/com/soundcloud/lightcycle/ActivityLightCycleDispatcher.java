package com.soundcloud.lightcycle;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;

import com.soundcloud.lightcycle.util.Preconditions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

public class ActivityLightCycleDispatcher<HostType>
        implements LightCycleDispatcher<ActivityLightCycle<HostType>>, ActivityLightCycle<HostType> {
    private final Set<ActivityLightCycle<HostType>> activityLightCycles;

    public ActivityLightCycleDispatcher() {
        this.activityLightCycles = new HashSet<>();
    }


    @Override
    public void bind(@NotNull ActivityLightCycle<HostType> lightCycle) {
        Preconditions.checkBindingTarget(lightCycle);
        this.activityLightCycles.add(lightCycle);
    }

    @Override
    public void onCreate(@NotNull HostType host, @Nullable Bundle bundle) {
        LightCycles.bind(this);
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onCreate(host, bundle);
        }
    }

    @Override
    public void onPostCreate(@NotNull HostType host, @Nullable Bundle bundle) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onPostCreate(host, bundle);
        }
    }

    @Override
    public void onNewIntent(@NotNull HostType host, Intent intent) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onNewIntent(host, intent);
        }
    }

    @Override
    public void onStart(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onStart(host);
        }
    }

    @Override
    public void onResume(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onResume(host);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull HostType host, @NotNull MenuItem item) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            if (component.onOptionsItemSelected(host, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onPause(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onPause(host);
        }
    }

    @Override
    public void onStop(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onStop(host);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull HostType host, @NotNull Bundle bundle) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onSaveInstanceState(host, bundle);
        }
    }

    @Override
    public void onRestoreInstanceState(@NotNull HostType host, @NotNull Bundle bundle) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onRestoreInstanceState(host, bundle);
        }
    }

    @Override
    public void onWindowFocusChanged(@NotNull HostType host, boolean hasFocus) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onWindowFocusChanged(host, hasFocus);
        }
    }

    @Override
    public void onActivityResult(@NotNull HostType host, int requestCode, int resultCode, @Nullable Intent data) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onActivityResult(host, requestCode, resultCode, data);
        }
    }

    @Override
    public void onConfigurationChanged(@NotNull HostType host, @NotNull Configuration newConfig) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onConfigurationChanged(host, newConfig);
        }
    }

    @Override
    public void onMultiWindowModeChanged(@NotNull HostType host, boolean isInMultiWindowMode) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onMultiWindowModeChanged(host, isInMultiWindowMode);
        }
    }

    @Override
    public void onDestroy(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onDestroy(host);
        }
    }

    @Override
    public void onBackPressed(@NotNull HostType host) {
        for (ActivityLightCycle<HostType> component : activityLightCycles) {
            component.onBackPressed(host);
        }
    }
}
