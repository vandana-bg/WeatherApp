package com.tutorial.weatherapp.util;

/**
 * Shared Preference class which is used to store String , int , boolean data
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public  class SharedPref {

    Context mContext;

    static SharedPreferences mSettingPrefs;

    static SharedPreferences.Editor mSettingPrefEditor;

    public SharedPref(Context mContext) {
        this.mContext = mContext;

        // Get the xml/configuration_activity.xml preferences
        mSettingPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
    }

    /**
     * Used to store String data
     *
     * @param mKey
     * @param mItem
     */
    public static void setDataInPref(String mKey, String mItem) {
        mSettingPrefEditor = mSettingPrefs.edit();
        mSettingPrefEditor.putString(mKey, mItem);
        mSettingPrefEditor.commit();
    }

    /**
     * Used to get String data
     *
     * @param mKey
     * @return String
     */
    public static String getDataFromPref(String mKey) {
        String mSplashData = mSettingPrefs.getString(mKey, "");
        return mSplashData;
    }

    /**
     * Used to store int data
     *
     * @param mKey
     * @param mItem
     */
    public static void setInt(String mKey, int mItem) {
        mSettingPrefEditor = mSettingPrefs.edit();
        mSettingPrefEditor.putInt(mKey, mItem);
        mSettingPrefEditor.commit();
    }

    /**
     * Used to get int data stored in preference
     *
     * @param mKey
     * @return int
     */
    public static int getInt(String mKey) {
        int mPos = mSettingPrefs.getInt(mKey, 0);
        return mPos;
    }

    // /**
    // * Used to clear Shared Preference
    // */
    public static void clearAllPref() {
        mSettingPrefEditor = mSettingPrefs.edit();
        mSettingPrefEditor.clear();
        mSettingPrefEditor.commit();
    }

    /**
     * Used to store boolean data
     *
     * @param mKey
     * @param mItem
     */
    public static void setBoolean(String mKey, boolean mItem) {
        mSettingPrefEditor = mSettingPrefs.edit();
        mSettingPrefEditor.putBoolean(mKey, mItem);
        mSettingPrefEditor.commit();
    }

    /**
     * Used to get boolean data stored ibn shared preferences
     *
     * @param mKeys
     * @return boolean
     */
    public static boolean getBoolean(String mKeys) {
        boolean mPos = mSettingPrefs.getBoolean(mKeys, false);
        return mPos;
    }


}
