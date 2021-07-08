package fr.supinternet.androidtv.ui

import android.os.Bundle
import android.os.PersistableBundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.GuidedStepSupportFragment

class PopupActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        GuidedStepSupportFragment.addAsRoot(this, GuideStep(), android.R.id.content)
    }

}