package com.arao.simpleweather.injection.component;

import com.arao.simpleweather.injection.module.ActivityModule;
import com.arao.simpleweather.injection.module.DataModule;
import com.arao.simpleweather.presentation.view.activity.HomeActivity;

import dagger.Subcomponent;

@Subcomponent(modules = {DataModule.class, ActivityModule.class})
public interface ActivityComponent {

    void resolveDependenciesFor(HomeActivity homeActivity);

}
