package fr.supinternet.androidtv.ui

import android.os.Bundle
import androidx.fragment.app.FragmentActivity

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        supportFragmentManager
            .beginTransaction()
            .replace(android.R.id.content, BrowseFragment())
            .commitAllowingStateLoss()
    }
}