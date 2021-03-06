package com.arao.simpleweather.injection.component;

import com.arao.simpleweather.injection.module.ApplicationModule;
import com.arao.simpleweather.injection.module.NetModule;
import com.arao.simpleweather.injection.scope.PerApplication;

import dagger.Component;

@PerApplication
@Component(modules = {ApplicationModule.class, NetModule.class})
public interface ApplicationComponent {

    ActivityComponent activityComponent();

}
