package com.soundcloud.lightcycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.soundcloud.lightcycle.util.LightCycleBinderHelper;
import com.soundcloud.lightcycle.util.Preconditions;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashSet;
import java.util.Set;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
public class FragmentLightCycleDispatcher<HostType>
        implements LightCycleDispatcher<FragmentLightCycle<HostType>>, FragmentLightCycle<HostType> {

    private final Set<FragmentLightCycle<HostType>> fragmentLightCycles;
    private final LightCycleBinderHelper binderHelper;

    public FragmentLightCycleDispatcher() {
        this.fragmentLightCycles = new HashSet<>();
        this.binderHelper = new LightCycleBinderHelper(this);
    }

    @Override
    public void bind(FragmentLightCycle<HostType> lightCycle) {
        Preconditions.checkBindingTarget(lightCycle);
        fragmentLightCycles.add(lightCycle);
    }

    @Override
    public void onAttach(@NotNull HostType host, @NotNull Activity activity) {
        binderHelper.bindIfNecessary();
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onAttach(host, activity);
        }
    }

    @Override
    public void onAttach(@NotNull HostType host, @NotNull Context context) {
        binderHelper.bindIfNecessary();
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onAttach(host, context);
        }
    }

    @Override
    public void onCreate(@NotNull HostType host, @Nullable Bundle bundle) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onCreate(host, bundle);
        }
    }

    @Override
    public void onViewCreated(@NotNull HostType host, @NotNull View view, @Nullable Bundle savedInstanceState) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onViewCreated(host, view, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@NotNull HostType host, @Nullable Bundle bundle) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onActivityCreated(host, bundle);
        }
    }

    @Override
    public void onStart(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onStart(host);
        }
    }

    @Override
    public void onResume(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onResume(host);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull HostType host, @NotNull MenuItem item) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            if (component.onOptionsItemSelected(host, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onPause(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onPause(host);
        }
    }

    @Override
    public void onStop(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onStop(host);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull HostType host, @NotNull Bundle bundle) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onSaveInstanceState(host, bundle);
        }
    }

    @Override
    public void onDestroyView(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onDestroyView(host);
        }
    }

    @Override
    public void onDestroy(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onDestroy(host);
        }
    }

    @Override
    public void onDetach(@NotNull HostType host) {
        for (FragmentLightCycle<HostType> component : fragmentLightCycles) {
            component.onDetach(host);
        }
    }
}
