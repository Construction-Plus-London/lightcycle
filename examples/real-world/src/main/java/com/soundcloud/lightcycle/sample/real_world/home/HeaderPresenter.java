package com.soundcloud.lightcycle.sample.real_world.home;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.soundcloud.lightcycle.DefaultActivityLightCycle;
import com.soundcloud.lightcycle.sample.real_world.R;
import com.soundcloud.lightcycle.sample.real_world.utils.DateProvider;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

class HeaderPresenter extends DefaultActivityLightCycle<HomeView> {
    private final DateProvider dateProvider;

    @Inject
    public HeaderPresenter(DateProvider dateProvider) {
        this.dateProvider = dateProvider;
    }

    @Override
    public void onCreate(@NotNull HomeView homeView, @Nullable Bundle bundle) {
        if (dateProvider.isMorning()) {
            homeView.sayHello(R.string.good_morning);
        } else {
            homeView.sayHello(R.string.hello);
        }
    }

}
