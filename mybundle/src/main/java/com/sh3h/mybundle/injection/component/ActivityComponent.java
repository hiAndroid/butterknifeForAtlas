package com.sh3h.mybundle.injection.component;

import com.sh3h.mybundle.injection.annotation.PerActivity;
import com.sh3h.mybundle.injection.module.ActivityModule;
import com.sh3h.mybundle.ui.FirstActivity;

import dagger.Component;

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {
    void inject(FirstActivity firstActivity);
}
