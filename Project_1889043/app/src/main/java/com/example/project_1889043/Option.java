package com.example.project_1889043;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.preference.SwitchPreference;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class Option extends PreferenceFragment {
    SharedPreferences pref;

    /*
    public static SwitchPreference spPass, spLoc, spCam, spPhone, spEmail, spSsid, spSend, spBg, spTest;

    public SwitchPreference[] switchPreferences = {
            spPass = (SwitchPreference) findPreference("password"),
            spLoc = (SwitchPreference) findPreference("location"),
            spCam = (SwitchPreference) findPreference("camera"),
            spPhone = (SwitchPreference) findPreference("sendPhone"),
            spEmail = (SwitchPreference) findPreference("sendEmail"),
            spSsid = (SwitchPreference) findPreference("ssid"),
            spSend = (SwitchPreference) findPreference("send"),
            spBg = (SwitchPreference) findPreference("background"),
            spTest = (SwitchPreference) findPreference("testValue")
    };
    */

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        addPreferencesFromResource(R.xml.option_setting);

        pref = PreferenceManager.getDefaultSharedPreferences(getActivity());
    }

    /*
    public static SwitchPreference[] getData(){
        return switchPreferences;
    }
    */
}
