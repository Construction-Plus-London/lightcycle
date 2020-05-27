package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import org.jetbrains.annotations.NotNull;

import java.util.HashSet;
import java.util.Set;

public class ShazamSupportFragmentLightCycleDispatcher<T extends Fragment>
        implements LightCycleDispatcher<ShazamSupportFragmentLightCycle<T>>, ShazamSupportFragmentLightCycle<T> {

    private final Set<ShazamSupportFragmentLightCycle<T>> fragmentLightCycles = new HashSet<>();

    @Override
    public void bind(ShazamSupportFragmentLightCycle<T> lightCycle) {
        fragmentLightCycles.add(lightCycle);
    }

    @Override
    public void onConfigurationChanged(@NotNull T fragment, @NotNull Configuration newConfig) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onConfigurationChanged(fragment, newConfig);
        }
    }

    @Override
    public void onActivityResult(@NotNull T fragment, int requestCode, int resultCode, @Nullable Intent data) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    @Override
    public void onSelected(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onSelected(fragment);
        }
    }

    @Override
    public void onUnselected(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onUnselected(fragment);
        }
    }

    @Override
    public void onWindowFocusChanged(@NotNull T fragment, boolean hasFocus) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onWindowFocusChanged(fragment, hasFocus);
        }
    }

    @Override
    public void onAttach(@NotNull T fragment, @NotNull Activity activity) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onAttach(fragment, activity);
        }
    }

    @Override
    public void onCreate(@NotNull T fragment, @Nullable Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onCreate(fragment, bundle);
        }
    }

    @Override
    public void onViewCreated(@NotNull T fragment, @NotNull View view, @Nullable Bundle savedInstanceState) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(@NotNull T fragment, @Nullable Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onActivityCreated(fragment, bundle);
        }
    }

    @Override
    public void onStart(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onStart(fragment);
        }
    }

    @Override
    public void onResume(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onResume(fragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(@NotNull T fragment, @NotNull MenuItem item) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            if (component.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onPause(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onPause(fragment);
        }
    }

    @Override
    public void onStop(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onStop(fragment);
        }
    }

    @Override
    public void onSaveInstanceState(@NotNull T fragment, @NotNull Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onSaveInstanceState(fragment, bundle);
        }
    }

    @Override
    public void onDestroyView(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDestroyView(fragment);
        }
    }

    @Override
    public void onDestroy(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDestroy(fragment);
        }
    }

    @Override
    public void onDetach(@NotNull T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDetach(fragment);
        }
    }
}
