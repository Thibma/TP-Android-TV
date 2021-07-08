package fr.supinternet.androidtv.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity

class SettingsActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, SettingsFragement())
            .commitAllowingStateLoss()
    }
}