package com.soundcloud.lightcycle;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ShazamSupportFragmentLightCycleDispatcherTest {
    @Mock private ShazamSupportFragmentLightCycle<Fragment> lifeCycleComponent1;
    @Mock private ShazamSupportFragmentLightCycle<Fragment> lifeCycleComponent2;
    @Mock private Fragment fragment;
    @Mock private Activity activity;
    private ShazamSupportFragmentLightCycleDispatcher<Fragment> dispatcher;

    @Before
    public void setUp() throws Exception {
        dispatcher = new ShazamSupportFragmentLightCycleDispatcher<>();
        dispatcher.bind(lifeCycleComponent1);
        dispatcher.bind(lifeCycleComponent2);
    }

    @Test
    public void shouldNotifyOnConfigurationChanged() {
        final Configuration configuration = new Configuration();

        dispatcher.onConfigurationChanged(fragment, configuration);

        verify(lifeCycleComponent1).onConfigurationChanged(fragment, configuration);
        verify(lifeCycleComponent2).onConfigurationChanged(fragment, configuration);
    }

    @Test
    public void shouldNotifyOnActivityResult() {
        final int requestCode = 1;
        final int resultCode = 2;
        final Intent data = new Intent();

        dispatcher.onActivityResult(fragment, requestCode, resultCode, data);

        verify(lifeCycleComponent1).onActivityResult(fragment, requestCode, resultCode, data);
        verify(lifeCycleComponent2).onActivityResult(fragment, requestCode, resultCode, data);
    }

    @Test
    public void shouldNotifyOnSelected() {
        dispatcher.onSelected(fragment);

        verify(lifeCycleComponent1).onSelected(fragment);
        verify(lifeCycleComponent2).onSelected(fragment);
    }

    @Test
    public void shouldNotifyOnUnselected() {
        dispatcher.onUnselected(fragment);

        verify(lifeCycleComponent1).onUnselected(fragment);
        verify(lifeCycleComponent2).onUnselected(fragment);
    }

    @Test
    public void shouldNotifyOnWindowFocusChanged() {
        final boolean hasFocus = true;

        dispatcher.onWindowFocusChanged(fragment, hasFocus);

        verify(lifeCycleComponent1).onWindowFocusChanged(fragment, hasFocus);
        verify(lifeCycleComponent2).onWindowFocusChanged(fragment, hasFocus);
    }

    @Test
    public void shouldNotifyOnAttach() {
        dispatcher.onAttach(fragment, activity);

        verify(lifeCycleComponent1).onAttach(fragment, activity);
        verify(lifeCycleComponent2).onAttach(fragment, activity);
    }

    @Test
    public void shouldNotifyOnCreate() {
        final Bundle bundle = Bundle.EMPTY;

        dispatcher.onCreate(fragment, bundle);

        verify(lifeCycleComponent1).onCreate(fragment, bundle);
        verify(lifeCycleComponent2).onCreate(fragment, bundle);
    }

    @Test
    public void shouldNotifyOnStart() {
        dispatcher.onStart(fragment);

        verify(lifeCycleComponent1).onStart(fragment);
        verify(lifeCycleComponent2).onStart(fragment);
    }

    @Test
    public void shouldNotifyOnResume() {
        dispatcher.onResume(fragment);

        verify(lifeCycleComponent1).onResume(fragment);
        verify(lifeCycleComponent2).onResume(fragment);
    }

    @Test
    public void shouldNotifyOnPause() {
        dispatcher.onPause(fragment);

        verify(lifeCycleComponent1).onPause(fragment);
        verify(lifeCycleComponent2).onPause(fragment);
    }

    @Test
    public void shouldNotifyOnStop() {
        dispatcher.onStop(fragment);

        verify(lifeCycleComponent1).onStop(fragment);
        verify(lifeCycleComponent2).onStop(fragment);
    }

    @Test
    public void shouldNotifyOnSaveInstanceState() {
        final Bundle bundle = Bundle.EMPTY;

        dispatcher.onSaveInstanceState(fragment, bundle);

        verify(lifeCycleComponent1).onSaveInstanceState(fragment, bundle);
        verify(lifeCycleComponent2).onSaveInstanceState(fragment, bundle);
    }

    @Test
    public void shouldNotifyOnActivityCreated() {
        final Bundle bundle = Bundle.EMPTY;

        dispatcher.onActivityCreated(fragment, bundle);

        verify(lifeCycleComponent1).onActivityCreated(fragment, bundle);
        verify(lifeCycleComponent2).onActivityCreated(fragment, bundle);
    }

    @Test
    public void shouldNotifyOnDestroy() {
        dispatcher.onDestroy(fragment);

        verify(lifeCycleComponent1).onDestroy(fragment);
        verify(lifeCycleComponent2).onDestroy(fragment);
    }

    @Test
    public void shouldNotifyOnDetach() {
        dispatcher.onDetach(fragment);

        verify(lifeCycleComponent1).onDetach(fragment);
        verify(lifeCycleComponent2).onDetach(fragment);
    }

    @Test
    public void shouldNotifyOnViewCreated() {
        final Bundle bundle = Bundle.EMPTY;
        final View view = mock(View.class);

        dispatcher.onViewCreated(fragment, view, bundle);

        verify(lifeCycleComponent1).onViewCreated(fragment, view, bundle);
        verify(lifeCycleComponent2).onViewCreated(fragment, view, bundle);
    }

    @Test
    public void shouldNotifyOnDestroyView() {
        dispatcher.onDestroyView(fragment);

        verify(lifeCycleComponent1).onDestroyView(fragment);
        verify(lifeCycleComponent2).onDestroyView(fragment);
    }
}
