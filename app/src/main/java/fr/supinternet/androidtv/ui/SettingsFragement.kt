package fr.supinternet.androidtv.ui

import androidx.leanback.preference.LeanbackSettingsFragmentCompat
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen

class SettingsFragement : LeanbackSettingsFragmentCompat() {
    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat?,
        pref: Preference?
    ): Boolean {
        return true
    }

    override fun onPreferenceStartScreen(
        caller: PreferenceFragmentCompat?,
        pref: PreferenceScreen?
    ): Boolean {
        return true
    }

    override fun onPreferenceStartInitialScreen() {
        startPreferenceFragment(PreferencesFragment())
    }
}