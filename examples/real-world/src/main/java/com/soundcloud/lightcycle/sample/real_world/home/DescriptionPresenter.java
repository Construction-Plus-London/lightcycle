package com.soundcloud.lightcycle.sample.real_world.home;

import com.soundcloud.lightcycle.DefaultActivityLightCycle;

import android.os.Bundle;

import androidx.annotation.Nullable;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

class DescriptionPresenter extends DefaultActivityLightCycle<HomeView> {

    @Inject
    public DescriptionPresenter() {
    }

    @Override
    public void onCreate(@NotNull HomeView homeView, @Nullable Bundle bundle) {
        homeView.showDescription("LightCycle", "https://github.com/soundcloud/lightcycle");
    }

}
