package com.saqqu.snakepath;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Prefs {

    private SharedPreferences pref;

    public Prefs(Context context) {

        pref = PreferenceManager.getDefaultSharedPreferences(context);
        pref = context.getSharedPreferences("DEFAULTS", 0);

    }


    public void putStringExtra(String key, String value) {
        pref.edit().putString(key, value).apply();
    }

    public String getStringExtra(String key) {
        return pref.getString(key, "");
    }

}
