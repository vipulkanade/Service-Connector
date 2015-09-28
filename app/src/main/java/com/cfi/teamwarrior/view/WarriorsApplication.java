package com.cfi.teamwarrior.view;

import android.app.Application;

/**
 * Created by vipulkanade on 5/12/15.
 */
public class WarriorsApplication extends Application {

    public static final String TAG = WarriorsApplication.class.getSimpleName();

    private static Application mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }

    /**
     *
     * @return Warriors Application context
     */
    public synchronized static Application getInstance() {
        return mInstance;
    }
}
