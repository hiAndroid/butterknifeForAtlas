package com.sh3h.mybundle.injection.module;

import android.app.Application;
import android.content.Context;

import com.sh3h.mybundle.injection.annotation.ApplicationContext;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    protected final Application mApplication;

    public ApplicationModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application provideApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    @ApplicationContext
    Context provideContext() {
        return mApplication;
    }
}
