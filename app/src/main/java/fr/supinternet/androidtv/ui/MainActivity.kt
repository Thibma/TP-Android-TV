package fr.supinternet.androidtv.ui

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.GuidedStepSupportFragment

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, BrowseFragment())
            .commitAllowingStateLoss()
    }
}