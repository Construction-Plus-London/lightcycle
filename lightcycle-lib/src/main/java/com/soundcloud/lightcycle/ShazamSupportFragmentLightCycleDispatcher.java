package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

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
    public void onConfigurationChanged(T fragment, Configuration newConfig) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onConfigurationChanged(fragment, newConfig);
        }
    }

    @Override
    public void onActivityResult(T fragment, int requestCode, int resultCode, Intent data) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onActivityResult(fragment, requestCode, resultCode, data);
        }
    }

    @Override
    public void onSelected(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onSelected(fragment);
        }
    }

    @Override
    public void onUnselected(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onUnselected(fragment);
        }
    }

    @Override
    public void onWindowFocusChanged(T fragment, boolean hasFocus) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onWindowFocusChanged(fragment, hasFocus);
        }
    }

    @Override
    public void onAttach(T fragment, Activity activity) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onAttach(fragment, activity);
        }
    }

    @Override
    public void onCreate(T fragment, @Nullable Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onCreate(fragment, bundle);
        }
    }

    @Override
    public void onViewCreated(T fragment, View view, @Nullable Bundle savedInstanceState) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onViewCreated(fragment, view, savedInstanceState);
        }
    }

    @Override
    public void onActivityCreated(T fragment, Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onActivityCreated(fragment, bundle);
        }
    }

    @Override
    public void onStart(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onStart(fragment);
        }
    }

    @Override
    public void onResume(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onResume(fragment);
        }
    }

    @Override
    public boolean onOptionsItemSelected(T fragment, MenuItem item) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            if (component.onOptionsItemSelected(fragment, item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void onPause(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onPause(fragment);
        }
    }

    @Override
    public void onStop(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onStop(fragment);
        }
    }

    @Override
    public void onSaveInstanceState(T fragment, Bundle bundle) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onSaveInstanceState(fragment, bundle);
        }
    }

    @Override
    public void onDestroyView(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDestroyView(fragment);
        }
    }

    @Override
    public void onDestroy(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDestroy(fragment);
        }
    }

    @Override
    public void onDetach(T fragment) {
        for (ShazamSupportFragmentLightCycle<T> component : fragmentLightCycles) {
            component.onDetach(fragment);
        }
    }
}
