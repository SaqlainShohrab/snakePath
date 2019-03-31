package com.saqqu.snakepath;

import android.app.Application;

public class App extends Application {

    public static Prefs prefs;

    @Override
    public void onCreate() {
        super.onCreate();
        prefs = new Prefs(getApplicationContext());

    }
}
