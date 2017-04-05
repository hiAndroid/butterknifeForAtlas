package com.sh3h.mybundle.injection.component;

import android.content.Context;

import com.sh3h.mybundle.MyApplication;
import com.sh3h.mybundle.injection.annotation.ApplicationContext;
import com.sh3h.mybundle.injection.module.ApplicationModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    void inject(MyApplication myApplication);

    @ApplicationContext
    Context context();
}
