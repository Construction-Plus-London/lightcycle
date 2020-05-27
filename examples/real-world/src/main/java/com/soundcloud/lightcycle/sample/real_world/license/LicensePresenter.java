package com.soundcloud.lightcycle.sample.real_world.license;

import com.soundcloud.lightcycle.DefaultSupportFragmentLightCycle;

import android.os.Bundle;
import android.view.View;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.inject.Inject;

class LicensePresenter extends DefaultSupportFragmentLightCycle<LicenseView> {

    @Inject
    public LicensePresenter() {
    }

    @Override
    public void onViewCreated(@NotNull LicenseView licenseView, @NotNull View view, @Nullable Bundle savedInstanceState) {
        licenseView.showLicense("Apache License 2.0");
    }
}
