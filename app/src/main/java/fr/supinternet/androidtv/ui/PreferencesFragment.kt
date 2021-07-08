package fr.supinternet.androidtv.ui

import android.os.Bundle
import androidx.leanback.preference.LeanbackPreferenceDialogFragmentCompat
import androidx.leanback.preference.LeanbackPreferenceFragmentCompat
import fr.supinternet.androidtv.R

class PreferencesFragment : LeanbackPreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preferences)
    }
}