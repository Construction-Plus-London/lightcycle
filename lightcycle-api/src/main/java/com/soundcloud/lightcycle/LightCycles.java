package com.soundcloud.lightcycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Method;

public final class LightCycles {
    private static final String TAG = LightCycles.class.getSimpleName();
    private static final String ANDROID_PREFIX = "android.";
    private static final String JAVA_PREFIX = "java.";
    private static boolean debugLoggingEnabled = false;

    @SuppressWarnings("PMD.EmptyCatchBlock")
    public static void bind(LightCycleDispatcher<?> target) {
        Method bindingMethod;
        try {
            bindingMethod = findBinderForClass(target.getClass());
            if (bindingMethod != null) {
                bindingMethod.invoke(null, target);
            }
        } catch (Exception e) {
            // no binder found, so ignore.
        }
    }

    public static void enableDebugLogging(boolean enabled) {
        debugLoggingEnabled = enabled;
    }

    private static void debugLog(String message, Object... args) {
        if (debugLoggingEnabled) {
            Log.d(TAG, String.format(message, args));
        }
    }

    private static String getInjectorClassName(String clsName) {
        return clsName + "$LightCycleBinder";
    }

    private static Method findBinderForClass(Class<?> cls)
            throws IllegalAccessException, InstantiationException, NoSuchMethodException {
        Method lightCycleInjectionMethod;
        String clsName = cls.getName();
        if (clsName.startsWith(ANDROID_PREFIX) || clsName.startsWith(JAVA_PREFIX)) {
            debugLog("MISS: Reached framework class. Abandoning search.");
            return null;
        }
        try {
            Class<?> binder = Class.forName(getInjectorClassName(clsName));
            lightCycleInjectionMethod = binder.getMethod("bind", cls);
            debugLog("HIT: Loaded LightCycle binder class.");
        } catch (ClassNotFoundException e) {
            debugLog("Not found. Trying superclass %s", cls.getSuperclass().getName());
            lightCycleInjectionMethod = findBinderForClass(cls.getSuperclass());
        }
        return lightCycleInjectionMethod;
    }

    public static <Source, Target extends Source> ActivityLightCycle<Target> lift(final ActivityLightCycle<Source> lightCycle) {
        return new LiftedActivityLightCycle<>(lightCycle);
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static <Source, Target extends Source> FragmentLightCycle<Target> lift(final FragmentLightCycle<Source> lightCycle) {
        return new LiftedFragmentLightCycle<>(lightCycle);
    }


    public static <Source, Target extends Source> SupportFragmentLightCycle<Target> lift(final SupportFragmentLightCycle<Source> lightCycle) {
        return new LiftedSupportFragmentLightCycle<>(lightCycle);
    }

    static final class LiftedActivityLightCycle<Source, Target extends Source> implements ActivityLightCycle<Target> {

        private final ActivityLightCycle<Source> lightCycle;

        LiftedActivityLightCycle(ActivityLightCycle<Source> lightCycle) {
            this.lightCycle = lightCycle;
        }

        @Override
        public void onCreate(@NotNull Target activity, @Nullable Bundle bundle) {
            lightCycle.onCreate(activity, bundle);
        }

        @Override
        public void onPostCreate(@NotNull Target activity, @Nullable Bundle bundle) {
            lightCycle.onPostCreate(activity, bundle);
        }

        @Override
        public void onNewIntent(@NotNull Target activity, Intent intent) {
            lightCycle.onNewIntent(activity, intent);
        }

        @Override
        public void onStart(@NotNull Target activity) {
            lightCycle.onStart(activity);
        }

        @Override
        public void onResume(@NotNull Target activity) {
            lightCycle.onResume(activity);
        }

        @Override
        public boolean onOptionsItemSelected(@NotNull Target activity, @NotNull MenuItem item) {
            return lightCycle.onOptionsItemSelected(activity, item);
        }

        @Override
        public void onPause(@NotNull Target activity) {
            lightCycle.onPause(activity);
        }

        @Override
        public void onStop(@NotNull Target activity) {
            lightCycle.onStop(activity);
        }

        @Override
        public void onSaveInstanceState(@NotNull Target activity, @NotNull Bundle bundle) {
            lightCycle.onSaveInstanceState(activity, bundle);
        }

        @Override
        public void onRestoreInstanceState(@NotNull Target activity, @NotNull Bundle bundle) {
            lightCycle.onRestoreInstanceState(activity, bundle);
        }

        @Override
        public void onWindowFocusChanged(@NotNull Target activity, boolean hasFocus) {
            lightCycle.onWindowFocusChanged(activity, hasFocus);
        }

        @Override
        public void onActivityResult(@NotNull Target activity, int requestCode, int resultCode, @Nullable Intent data) {
            lightCycle.onActivityResult(activity, requestCode, resultCode, data);
        }

        @Override
        public void onConfigurationChanged(@NotNull Target activity, @NotNull Configuration newConfig) {
            lightCycle.onConfigurationChanged(activity, newConfig);
        }

        @Override
        public void onMultiWindowModeChanged(@NotNull Target host, boolean isInMultiWindowMode) {
            lightCycle.onMultiWindowModeChanged(host, isInMultiWindowMode);
        }

        @Override
        public void onDestroy(@NotNull Target activity) {
            lightCycle.onDestroy(activity);
        }

        @Override
        public void onBackPressed(@NotNull Target activity) {
            lightCycle.onBackPressed(activity);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LiftedActivityLightCycle<?, ?> that = (LiftedActivityLightCycle<?, ?>) o;

            return lightCycle != null ? lightCycle.equals(that.lightCycle) : that.lightCycle == null;
        }

        @Override
        public int hashCode() {
            return lightCycle != null ? lightCycle.hashCode() : 0;
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    static final class LiftedFragmentLightCycle<Source, Target extends Source> implements FragmentLightCycle<Target> {
        private final FragmentLightCycle<Source> lightCycle;

        LiftedFragmentLightCycle(FragmentLightCycle<Source> lightCycle) {
            this.lightCycle = lightCycle;
        }

        @Override
        public void onAttach(@NotNull Target fragment, @NotNull Activity activity) {
            lightCycle.onAttach(fragment, activity);
        }

        @Override
        public void onAttach(@NotNull Target fragment, @NotNull Context context) {
            lightCycle.onAttach(fragment, context);
        }

        @Override
        public void onCreate(@NotNull Target fragment, @Nullable Bundle bundle) {
            lightCycle.onCreate(fragment, bundle);
        }

        @Override
        public void onViewCreated(@NotNull Target fragment, @NotNull View view, @Nullable Bundle savedInstanceState) {
            lightCycle.onViewCreated(fragment, view, savedInstanceState);
        }

        @Override
        public void onActivityCreated(@NotNull Target fragment, @Nullable Bundle bundle) {
            lightCycle.onActivityCreated(fragment, bundle);
        }

        @Override
        public void onStart(@NotNull Target fragment) {
            lightCycle.onStart(fragment);
        }

        @Override
        public void onResume(@NotNull Target fragment) {
            lightCycle.onResume(fragment);
        }

        @Override
        public boolean onOptionsItemSelected(@NotNull Target fragment, @NotNull MenuItem item) {
            return lightCycle.onOptionsItemSelected(fragment, item);
        }

        @Override
        public void onPause(@NotNull Target fragment) {
            lightCycle.onPause(fragment);
        }

        @Override
        public void onStop(@NotNull Target fragment) {
            lightCycle.onStop(fragment);
        }

        @Override
        public void onSaveInstanceState(@NotNull Target fragment, @NotNull Bundle bundle) {
            lightCycle.onSaveInstanceState(fragment, bundle);
        }

        @Override
        public void onDestroyView(@NotNull Target fragment) {
            lightCycle.onDestroyView(fragment);
        }

        @Override
        public void onDestroy(@NotNull Target fragment) {
            lightCycle.onDestroy(fragment);
        }

        @Override
        public void onDetach(@NotNull Target fragment) {
            lightCycle.onDetach(fragment);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LiftedFragmentLightCycle<?, ?> that = (LiftedFragmentLightCycle<?, ?>) o;

            return lightCycle != null ? lightCycle.equals(that.lightCycle) : that.lightCycle == null;

        }

        @Override
        public int hashCode() {
            return lightCycle != null ? lightCycle.hashCode() : 0;
        }
    }

    static final class LiftedSupportFragmentLightCycle<Source, Target extends Source> implements SupportFragmentLightCycle<Target> {

        private final SupportFragmentLightCycle<Source> lightCycle;

        LiftedSupportFragmentLightCycle(SupportFragmentLightCycle<Source> lightCycle) {
            this.lightCycle = lightCycle;
        }

        @Override
        public void onAttach(@NotNull Target fragment, @NotNull Activity activity) {
            lightCycle.onAttach(fragment, activity);
        }

        @Override
        public void onCreate(@NotNull Target fragment, @Nullable Bundle bundle) {
            lightCycle.onCreate(fragment, bundle);
        }

        @Override
        public void onViewCreated(@NotNull Target fragment, @NotNull View view, @Nullable Bundle savedInstanceState) {
            lightCycle.onViewCreated(fragment, view, savedInstanceState);
        }

        @Override
        public void onActivityCreated(@NotNull Target fragment, @Nullable Bundle bundle) {
            lightCycle.onActivityCreated(fragment, bundle);
        }

        @Override
        public void onStart(@NotNull Target fragment) {
            lightCycle.onStart(fragment);
        }

        @Override
        public void onResume(@NotNull Target fragment) {
            lightCycle.onResume(fragment);
        }

        @Override
        public boolean onOptionsItemSelected(@NotNull Target fragment, @NotNull MenuItem item) {
            return lightCycle.onOptionsItemSelected(fragment, item);
        }

        @Override
        public void onPause(@NotNull Target fragment) {
            lightCycle.onPause(fragment);
        }

        @Override
        public void onStop(@NotNull Target fragment) {
            lightCycle.onStop(fragment);
        }

        @Override
        public void onSaveInstanceState(@NotNull Target fragment, @NotNull Bundle bundle) {
            lightCycle.onSaveInstanceState(fragment, bundle);
        }

        @Override
        public void onDestroyView(@NotNull Target fragment) {
            lightCycle.onDestroyView(fragment);
        }

        @Override
        public void onDestroy(@NotNull Target fragment) {
            lightCycle.onDestroy(fragment);
        }

        @Override
        public void onDetach(@NotNull Target fragment) {
            lightCycle.onDetach(fragment);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            LiftedSupportFragmentLightCycle<?, ?> that = (LiftedSupportFragmentLightCycle<?, ?>) o;

            return lightCycle != null ? lightCycle.equals(that.lightCycle) : that.lightCycle == null;

        }

        @Override
        public int hashCode() {
            return lightCycle != null ? lightCycle.hashCode() : 0;
        }
    }

    public static <Source, Target extends Source> ShazamSupportFragmentLightCycle<Target> lift(final ShazamSupportFragmentLightCycle<Source> lightCycle) {
        return new ShazamSupportFragmentLightCycle<Target>() {

            @Override
            public void onConfigurationChanged(@NotNull Target fragment, @NotNull Configuration newConfig) {
                lightCycle.onConfigurationChanged(fragment, newConfig);
            }

            @Override
            public void onActivityResult(@NotNull Target fragment, int requestCode, int resultCode, @Nullable Intent data) {
                lightCycle.onActivityResult(fragment, requestCode, resultCode, data);
            }

            @Override
            public void onSelected(@NotNull Target fragment) {
                lightCycle.onSelected(fragment);
            }

            @Override
            public void onUnselected(@NotNull Target fragment) {
                lightCycle.onUnselected(fragment);
            }

            @Override
            public void onWindowFocusChanged(@NotNull Target fragment, boolean hasFocus) {
                lightCycle.onWindowFocusChanged(fragment, hasFocus);
            }

            @Override
            public void onAttach(@NotNull Target fragment, @NotNull Activity activity) {
                lightCycle.onAttach(fragment, activity);
            }

            @Override
            public void onCreate(@NotNull Target fragment, @Nullable Bundle bundle) {
                lightCycle.onCreate(fragment, bundle);
            }

            @Override
            public void onViewCreated(@NotNull Target fragment, @NotNull View view, @Nullable Bundle savedInstanceState) {
                lightCycle.onViewCreated(fragment, view, savedInstanceState);
            }

            @Override
            public void onActivityCreated(@NotNull Target fragment, @Nullable Bundle bundle) {
                lightCycle.onActivityCreated(fragment, bundle);
            }

            @Override
            public void onStart(@NotNull Target fragment) {
                lightCycle.onStart(fragment);
            }

            @Override
            public void onResume(@NotNull Target fragment) {
                lightCycle.onResume(fragment);
            }

            @Override
            public boolean onOptionsItemSelected(@NotNull Target fragment, @NotNull MenuItem item) {
                return lightCycle.onOptionsItemSelected(fragment, item);
            }

            @Override
            public void onPause(@NotNull Target fragment) {
                lightCycle.onPause(fragment);
            }

            @Override
            public void onStop(@NotNull Target fragment) {
                lightCycle.onStop(fragment);
            }

            @Override
            public void onSaveInstanceState(@NotNull Target fragment, @NotNull Bundle bundle) {
                lightCycle.onSaveInstanceState(fragment, bundle);
            }

            @Override
            public void onDestroyView(@NotNull Target fragment) {
                lightCycle.onDestroyView(fragment);
            }

            @Override
            public void onDestroy(@NotNull Target fragment) {
                lightCycle.onDestroy(fragment);
            }

            @Override
            public void onDetach(@NotNull Target fragment) {
                lightCycle.onDetach(fragment);
            }
        };
    }
}
