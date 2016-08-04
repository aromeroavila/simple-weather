package com.arao.simpleweather.injection.component;

import com.arao.simpleweather.injection.module.DataModule;

import dagger.Subcomponent;

@Subcomponent(modules = {DataModule.class})
public interface ActivityComponent {


}
