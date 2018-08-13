package com.android.mvpdemo;

import android.app.Application;

public class MvpApplication  extends Application {
    /**
     * The instance of the application
     */
    protected static MvpApplication sApplication;

    /**
     * Gets the app instance.
     *
     * @return the app instance
     */
    public static MvpApplication getApplication() {
        return sApplication;
    }

    @Override
    public final void onCreate() {
        sApplication = this;
        super.onCreate();
    }
}