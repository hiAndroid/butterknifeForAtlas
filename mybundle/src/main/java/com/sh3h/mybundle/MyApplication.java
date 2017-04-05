package com.sh3h.mybundle;

import android.app.Application;
import android.content.Context;
import android.util.Log;

import com.sh3h.mybundle.injection.component.ApplicationComponent;
import com.sh3h.mybundle.injection.component.DaggerApplicationComponent;
import com.sh3h.mybundle.injection.module.ApplicationModule;


public class MyApplication extends Application {
    private static final String TAG = "MyApplication";

    private ApplicationComponent mApplicationComponent;

    private static MyApplication myApplication = null;

    @Override
    public void onCreate() {
        super.onCreate();

        myApplication = this;
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        mApplicationComponent.inject(this);
        Log.i(TAG, "onCreate");
    }

    public ApplicationComponent getComponent() {
        return mApplicationComponent;
    }

    // Needed to replace the component with a test specific one
    public void setComponent(ApplicationComponent applicationComponent) {
        mApplicationComponent = applicationComponent;
    }

    public static MyApplication get(Context context) {
        return myApplication != null ? myApplication : (MyApplication) context.getApplicationContext();
    }
}
